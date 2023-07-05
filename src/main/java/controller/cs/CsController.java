 package controller.cs;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import common.Paging;
import common.ViewPath;
import service.cs.CsService;
import vo.cs.CsVO;
import vo.file.FileVO;
import vo.uuser.UuserVO;

@Controller
public class CsController {

	@Autowired
	private ServletContext application;
	
	private CsService csService;
	
	public CsController(CsService csService) {
		this.csService = csService;
	}
	
	@RequestMapping("/cs/list")
	public String list(Model model, Integer page , String type, String word,HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		UuserVO vo = csService.selectNo(no);
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
		map.put("type", type);
		map.put("word", word);
		
		int csCount = csService.getTotal(map);
		
		
		Paging paging  = new Paging(page, csCount);
		
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		
		List<Map<String,Object>> list = csService.selectList(map);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
		
		return ViewPath.CS + "list.jsp";
	}
	
	
	
	@RequestMapping("/cs/writeform") // admin만 사용가능
	public String writeForm() {
		return ViewPath.CS + "write.jsp";
	}
	
	@RequestMapping("/cs/write")
	public String write(Model model,HttpSession session, CsVO vo, @RequestParam("csFile")MultipartFile photo) {
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		
		
		
		String savePath = "C:\\server\\upload";
		vo.setUuserNo(no);
		String filename = null;
		int su = 0;
		if(photo != null && !photo.isEmpty()) {
			
			filename = photo.getOriginalFilename(); // 업로드된 파일명
			
			//File 객체 생성
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
				System.out.println(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			vo.setCsFileTitle(filename);
			su = csService.insert(vo);
		}else {
			vo.setCsFileTitle("no_file");
		}
		
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "write");
		model.addAttribute("url", "/sool/cs/list");
		
		return ViewPath.CS + "result.jsp";
	}
	
	
	
	@RequestMapping("/cs/content")
	public String content(Model model,int seq) {
		
		Map<String, Object> map = csService.getContent(seq);
		
		try {
			map.put("CS_CONTENT", clobToString((Clob)map.get("CS_CONTENT")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		map.put("uuserNo", seq);
		model.addAttribute("vo", map);
		
		return ViewPath.CS + "content.jsp";
	}
	
	
	
	@RequestMapping("/cs/updateform")
	public String updateForm(Model model,int seq) {
		CsVO vo = csService.selectOne(seq);
		
		model.addAttribute("vo", vo);
		
		return ViewPath.CS + "update.jsp";
	}
	
	
	
	@RequestMapping("/cs/update")
	public String update(Model model,CsVO vo) {
		
		String content = vo.getCsContent();
		
		vo.setCsContent(content.replaceAll("\r\n", "<br>"));
		
		
		
		int su = csService.update(vo);
		
		
		
		model.addAttribute("su", su);
		model.addAttribute("status", "update");
		model.addAttribute("url", "/sool/cs/content?seq=" + vo.getCsNo());
		
		return ViewPath.CS + "result.jsp";
		
	}
	
	
	
	@RequestMapping("/cs/delete")
	public String delete(Model model,int seq) {
		
		int su = csService.delete(seq);
		
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/sool/cs/list");
		
		return ViewPath.CS + "result.jsp";
	}
	
	
	
	@RequestMapping("/cs/reply/{csNo}")
	public String reply(Model model, @PathVariable("csNo") int csNo) {
		model.addAttribute("seq", csNo);
		
		return ViewPath.CS + "write.jsp";
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
