package controller.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.Encry;
import common.ViewPath;
import service.login.LoginService;
import vo.uuser.UuserVO;

@Controller
public class LoginController {

	private LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping("/login/loginform")
	public String LoginForm(HttpServletRequest request,String id) {
		System.out.println("로그인 폼");
		boolean check = false;
		
		if(id == null) {
			Cookie[] cks = request.getCookies();
			
			if(cks != null) {
				for(Cookie ck : cks) {
					if(ck.getName().equals("ckid")) {
						id = ck.getValue();
						check = true;
						break;
					}
				}
			}
		}
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		return ViewPath.LOGIN + "login.jsp";
		
	}
	
	@RequestMapping("/login/check")
	public String checkLogin(HttpServletRequest request,HttpServletResponse response,UuserVO vo) {
		

		String salt = loginService.getSaltById(vo.getUuserId());
		String password = vo.getUuserPassword();
		
		password = Encry.encry(password, salt);
		vo.setUuserPassword(password);
		
		UuserVO checkVo = loginService.getUuser(vo);
		System.out.println("checkVo : " + checkVo);
		int no;
		String nickName = "";

		if(checkVo == null) {
			no = 0;
		}
		else {
			no = checkVo.getUuserNo();	
			nickName = checkVo.getUuserNickname();
		}
		
		
		
		

//		int st = loginService.checkStatus(vo);
//		if(st == 2) {
//			return "redirect:/uuser/joinform";
//		}
//		
//		int no = loginService.checkLogin(vo);


		String msg = null;
		boolean check = false;
		
	
		if(no != 0) {
			
			int st = checkVo.getUuserStatus();
			if(st == 2) {
				return "redirect:/uuser/joinform";
			}
			
			msg = vo.getUuserId() + "으로 로그인 하셨습니다.";
			check = true;
			
			request.getSession().setAttribute("login", no);
			request.getSession().setAttribute("nickName", nickName);
			
			String ckid = request.getParameter("ckid");
			
			Cookie ck = null;
			
			
			Cookie[] cks = request.getCookies();
			
			
			if(cks != null){
				for(Cookie c : cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}
			
			if(ckid != null){ 
				if(ck == null){ 
					ck = new Cookie("ckid",vo.getUuserId());
					
					
					ck.setPath("/");
				
					
					ck.setMaxAge(60*60*24);
				
					
					response.addCookie(ck);
				}else{
					if(!ck.getValue().equals(vo.getUuserId())){
						ck.setValue(vo.getUuserId());
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			}else{ 
				if(ck != null){
					if(ck.getValue().equals(vo.getUuserId())){
						ck.setPath("/");
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}
			
		}else{
			msg = "아이디 혹은 비밀번호가 잘못되었습니다.";	
			check = false;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("check", check);
		
		return ViewPath.LOGIN + "result.jsp";
	}

	@RequestMapping("/login/findform")
	public String findForm() {
		return ViewPath.LOGIN + "findform.jsp";
	}
	
	
	
	@RequestMapping("/login/find")
	public String find(Model model,UuserVO vo,String mode) {
		
		String find = null;
		
		if(vo.getUuserId() == null) {
			find = loginService.findId(vo);
		}
		
		
		boolean check = false;
		if(find != null){
			check = true;
			String re = "";
			for(int i = 0; i < find.length(); i++){
				if(i % 2 == 0){
					re += find.charAt(i);
				}else{
					re += "*";
				}
			}
			
			if(mode.equals("id")){
				model.addAttribute("id", re);
			}
		}
		
		model.addAttribute("check", check);
		
		if(mode.equals("id")) {
			return ViewPath.LOGIN + "findresult.jsp";
		}else {
			return "redirect:/login/updatePw";
		}
		
		
	}
	
	
	@RequestMapping("/login/updatePw")
	public String updatePw(Model model,UuserVO vo) {
		
		UuserVO uVo = loginService.findNo(vo);
		if(uVo != null) {
			model.addAttribute("UuserId",vo.getUuserId());
		}else {
			return "redirect:/login/findform?mode=id";
		}
		
		return ViewPath.LOGIN + "updatePw.jsp";
	}
	
	
	// 비밀번호 재설정
	@RequestMapping("/login/newPw")
	public String newPw(Model model,UuserVO vo,HttpSession session) {
		
		String salt = loginService.getSaltById(vo.getUuserId());
		System.out.println(salt);
		String password = vo.getUuserPassword();
		password = Encry.encry(password, salt);
		System.out.println(password);
		vo.setUuserPassword(password);
		int su = loginService.updatePw(vo);
		UuserVO newVo = new UuserVO();
		newVo.setUuserPassword(vo.getUuserPassword());
		if(su != 0) {
			return "redirect:/login/loginform";
		}
		return ViewPath.LOGIN + "updatePw.jsp";
	}
	
	@RequestMapping("/login/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return ViewPath.LOGIN + "logout.jsp";
	}
}
