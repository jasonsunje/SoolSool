package controller.review;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
		
		System.out.println(no+"controller");
		System.out.println(list + "아무것도 없음");
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
	public String write(Model model,HttpSession session, ReviewVO vo, MultipartFile photo) {
		
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		UuserVO uVo = reviewService.selectNo(no);
		model.addAttribute("vo", uVo);
		
		vo.setReviewNo(no);
		
		int su = reviewService.insert(vo);
		
		// --------------파일 업로드
		
		String savePath = application.getRealPath("/resources/upload/");
		
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
		

		model.addAttribute("vo", vo);

		//--------------
		model.addAttribute("su", su);
		model.addAttribute("status","write");
		model.addAttribute("url","/sool/uuser/reviewList");
		
		return ViewPath.UUSER + "reviewResult.jsp";
		
	}
	
	
	@RequestMapping("/uuser/content") // 리뷰 상세
	public String content(Model model, int no) {
		Map<String, Object> map = reviewService.getContent(no);
		
		
		model.addAttribute("vo",map);
		
		return ViewPath.UUSER + "content.jsp";
	}
	
	
	@RequestMapping("/uuser/rUpdateform")
	public String updateForm(Model model, int no) {
		ReviewVO vo = reviewService.selectOne(no);
		
		model.addAttribute("vo" , vo);
		
		return ViewPath.UUSER + "rUpdate.jsp";
	}
	
	@RequestMapping("/uuser/rUpdate")
	public String rUpdate(Model model, ReviewVO vo) {
		String content = vo.getReviewContent();
		
		vo.setReviewContent(content.replaceAll("\r\n", "<br>"));
		
		int su = reviewService.update(vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status","update");
		model.addAttribute("url","/sool/uuser/content?no=" + vo.getReviewNo());
		
		
		return ViewPath.UUSER + "reviewResult.jsp";
	}
	
	
	@RequestMapping("/uuser/rDelete")
	public String rDelete(Model model, int no) {
		int su = reviewService.delete(no);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/sool/uuser/reviewList");
		
		return ViewPath.UUSER + "reviewResult.jsp";
	}
	
	
	@RequestMapping("/uuser/reply/{no}")
	public String reply(Model model,@PathVariable("no") int no) {
		model.addAttribute("no", no);
		
		return ViewPath.UUSER + "review.jsp";
	}
	
	
	
	
}




