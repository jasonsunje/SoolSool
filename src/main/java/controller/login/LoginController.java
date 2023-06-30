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
		
		//  븫 샇 솕
		String salt = loginService.getSaltById(vo.getUuserId());
		String password = vo.getUuserPassword();
		
		password = Encry.encry(password, salt);
		vo.setUuserPassword(password);
		
		UuserVO checkVo = loginService.getUuser(vo);
		System.out.println("checkVo : " + checkVo);
		
//		//  쑀   쓽  긽 깭( 0,1,2 )
		int st = checkVo.getUuserStatus();
		if(st == 2) {
			return "redirect:/uuser/joinform";
		}
		
		int no = checkVo.getUuserNo();
		String nickName = checkVo.getUuserNickname();
		
		
//		//  쑀   쓽  긽 깭( 0,1,2 )
//		int st = loginService.checkStatus(vo);
//		if(st == 2) {
//			return "redirect:/uuser/joinform";
//		}
//		
//		int no = loginService.checkLogin(vo);
//

		String msg = null;
		boolean check = false;
		
	
		if(no != 0) {
			msg = vo.getUuserId() + "으로 로그인 하셨습니다.";
			check = true;
			
			request.getSession().setAttribute("login", no);
			request.getSession().setAttribute("nickName", nickName);
			// 븘 씠 뵒 湲곗뼲 븯湲  泥댄겕  쑀臾 
			String ckid = request.getParameter("ckid");
			
			Cookie ck = null;
			
			//荑좏궎 뙆 씪  씫 뼱  삤湲 ...
			Cookie[] cks = request.getCookies();
			
			//湲곗〈 荑좏궎 뙆 씪 寃  깋
			if(cks != null){
				for(Cookie c : cks){
					if(c.getName().equals("ckid")){
						ck = c;
						break;
					}
				}
			}
			
			if(ckid != null){ //泥댄겕  릺 뼱  엳 쓣 븣
				if(ck == null){ // 荑좏궎 뙆 씪  뾾 쓣 븣
					ck = new Cookie("ckid",vo.getUuserId());
					
					//root濡  寃쎈줈  꽕 젙
					ck.setPath("/");
				
					// 쑀 슚 떆媛   꽕 젙
					ck.setMaxAge(60*60*24);
				
					// 겢 씪 씠 뼵 듃 뿉寃  荑좏궎 뙆 씪  깮 꽦
					response.addCookie(ck);
				}else{ // 엳 쓣 븣
					if(!ck.getValue().equals(vo.getUuserId())){
						ck.setValue(vo.getUuserId());
						ck.setPath("/");
						response.addCookie(ck);
					}
				}
			}else{ // 泥댄겕  븞 릺 뼱  엳 쓣 븣
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
	
	
	// 鍮꾨 踰덊샇  옱 꽕 젙
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
