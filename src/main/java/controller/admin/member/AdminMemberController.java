package controller.admin.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ViewPath;
import service.admin.member.AdminMemberService;
import vo.admin.AdminVO;

@Controller
@RequestMapping("/admin/member/*")
public class AdminMemberController {

	private AdminMemberService adminMemberService;
	
	public AdminMemberController(AdminMemberService adminMemberService) {
		this.adminMemberService = adminMemberService;
	}
	
	@RequestMapping("joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		return ViewPath.ADMINMEMBER + "joinForm.jsp";
	}
	
	@RequestMapping("join")
	public String join(Model model,AdminVO vo) {
		System.out.println("join");
		int su = adminMemberService.insert(vo);
		
		String url = null;
		String msg = null;
		
		if(su != 0){
			msg = "관리자 등록 성공";
			url = "/";
		}else{
			msg = "관리자 등록 실패";
			url = "/";	
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.ADMINMEMBER + "result.jsp";
	}
}
	
