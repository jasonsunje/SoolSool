package controller.review;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import common.Paging;
import common.ViewPath;
import service.login.LoginService;
import service.review.ReviewService;
import service.uuser.UuserService;
import vo.review.ReviewVO;
import vo.uuser.UuserVO;

@Controller
public class ReviewController {


	private ReviewService reviewService;

	
	@Autowired
	private ServletContext application;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	

	@RequestMapping("/uuser/reviewList")
	public String list(Model model, Integer page , String type, String word,HttpSession session) {
		
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		UuserVO vo = reviewService.selectNo(no);
		model.addAttribute("vo", vo);
	
		if(page == null) {
			page = 1;
		}
		
		if(type != null && type.equals("")) {
			type = null;
			word = null;
		}

		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("uuserNo", no);
		
		
		int reviewCount = reviewService.getTotal(map);
		
		
		Paging paging  = new Paging(page, reviewCount);
		
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		
		List<Map<String,Object>> list = reviewService.selectList(map);
		

		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		return ViewPath.UUSER + "reviewList.jsp";
	}
	
	@RequestMapping("/uuser/reviewform")
	public String reviewPage(Model model,HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		
		UuserVO vo = reviewService.selectNo(no);
		model.addAttribute("vo", vo);
	
		
		
		return ViewPath.UUSER + "review.jsp";
	}
	
	@RequestMapping("/uuser/review") //form
	public String write(Model model,HttpSession session, ReviewVO vo, MultipartFile photo) {//파일첨부 이름과 동일하게
		
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
//		UuserVO uVo = reviewService.selectNo(no);
//		model.addAttribute("vo", uVo);
//		
//		vo.setReviewNo(no);
//	
//		int su = reviewService.insert(vo);
//		
//		// --------------파일 업로드
//		
//		String savePath = application.getRealPath("/resources/upload/");
//		
//		String filename = null;
		
		
		String savePath = "C:\\server\\upload";
		vo.setUuserNo(no);
		vo.setProductNo(1);
		String filename = null;
		int su = 0;
	
		
		
		if(photo != null && !photo.isEmpty()) {
			
			filename = photo.getOriginalFilename(); // 업로드된 파일명
			
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")),time,
						filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath,filename);
			}
			
			
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			vo.setReviewPhoto(filename);
			
		}else {
			vo.setReviewPhoto("no_file");
		}
		
		su = reviewService.insert(vo);
		model.addAttribute("vo", vo);

		
		//--------------
		model.addAttribute("su", su);
		model.addAttribute("status","write");
		model.addAttribute("url","/sool/uuser/reviewList");
		
		return ViewPath.UUSER + "reviewResult.jsp";
		
	}
	
	
	@RequestMapping("/uuser/content") // 리뷰 상세
	public String content(Model model, int seq) {
		Map<String, Object> map = reviewService.getContent(seq);
		
		
		try {
			map.put("REVIEW_CONTENT", clobToString((Clob)map.get("REVIEW_CONTENT")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(map.get("REVIEW_CONTENT"));
		map.put("uuserNo", seq);
		model.addAttribute("vo",map);
		
		return ViewPath.UUSER + "content.jsp";
	}
	
	
	@RequestMapping("/uuser/rUpdateform")
	public String updateForm(Model model, int seq) {
		ReviewVO vo = reviewService.selectOne(seq);
		
		
		System.out.println(vo.getReviewPhoto()+"리뷰 vovovovo");
		model.addAttribute("vo" , vo);
		
		return ViewPath.UUSER + "rUpdate.jsp";
	}
	
	@RequestMapping("/uuser/rUpdate")
	public String rUpdate(Model model, ReviewVO vo, MultipartFile photo) {
		String content = vo.getReviewContent();
		
		vo.setReviewContent(content.replaceAll("\r\n", "<br>"));
		
		
		String savePath = "C:\\server\\upload";
		String filename = null;

		
		if(photo != null && !photo.isEmpty()) {
			
			filename = photo.getOriginalFilename(); // 업로드된 파일명
			
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")),time,
						filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath,filename);
			}
			
			
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			vo.setReviewPhoto(filename);
			
		}else {
			vo.setReviewPhoto("no_file");
		}
		
		System.out.println(filename+"파일 이름2222222222222");
		
		int su = reviewService.update(vo);
		

		model.addAttribute("su", su);
		model.addAttribute("status","update");
		model.addAttribute("url","/sool/uuser/content?seq=" + vo.getReviewNo());
		
		
		return ViewPath.UUSER + "reviewResult.jsp";
	}
	
	
	@RequestMapping("/uuser/rDelete")
	public String rDelete(Model model, int seq) {
		int su = reviewService.delete(seq);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/sool/uuser/reviewList");
		
		return ViewPath.UUSER + "reviewResult.jsp";
	}
	
	
	@RequestMapping("/uuser/reply/{seq}")
	public String reply(Model model,@PathVariable("seq") int seq) {
		model.addAttribute("seq", seq);
		
		return ViewPath.UUSER + "review.jsp";
	}
	
	
	// clob  string으로 변환 메소드
	public static String clobToString( Clob clob ) throws SQLException {

	    String result = null;
	    Reader reader = null;
	    try {
	        reader = clob.getCharacterStream();
	        result = IOUtils.toString( reader );
	    }
	    catch( IOException e ) {
	        e.printStackTrace();
	    }
	    finally {
	        IOUtils.closeQuietly( reader );
	    }

	    return result;
	}
	
}




