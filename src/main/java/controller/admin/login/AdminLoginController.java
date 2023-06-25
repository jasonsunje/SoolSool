package controller.admin.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import common.ViewPath;
import service.admin.login.AdminLoginService;
import vo.admin.AdminVO;

	@Controller
	@RequestMapping("/admin/login/*")
	public class AdminLoginController {
		
		private AdminLoginService adminLoginService;
		
		public AdminLoginController(AdminLoginService adminLoginService) {
			super();
			System.out.println("adminLoginService");
			this.adminLoginService = adminLoginService;
		}
		
		@RequestMapping("loginForm")
		public String loginForm(HttpServletRequest request,String adminId) {
			
			boolean check = false;
			
			if(adminId == null) {
				Cookie[] cks = request.getCookies();
				
				if(cks != null) {
					for(Cookie ck : cks) {
						if(ck.getName().equals("ckid")) {
							adminId = ck.getValue();
							check = true;
							break;
						}
					}
				}
			}
			
			request.setAttribute("adminId", adminId);
			request.setAttribute("check", check);
			
			return ViewPath.ADMINLOGIN + "login.jsp";
		}
		
		@RequestMapping("checkLogin")
		public String checkLogin(HttpServletRequest request,HttpServletResponse response,AdminVO vo) {
			
			System.out.println("checkLogin");
			
			int no = adminLoginService.checkLogin(vo);
			
			String msg = null;
			boolean check = false;
			
			if(no != 0) {
				msg = vo.getAdminId() + "으로 로그인 하셨습니다.";
				check = true;
				
				request.getSession().setAttribute("login", no);
				
				//�븘�씠�뵒 湲곗뼲�븯湲� 泥댄겕 �쑀臾�
				String ckid = request.getParameter("ckid");
				
				Cookie ck = null;
				
				//荑좏궎�뙆�씪 �씫�뼱 �삤湲�...
				Cookie[] cks = request.getCookies();
				
				//湲곗〈 荑좏궎�뙆�씪 寃��깋
				if(cks != null){
					for(Cookie c : cks){
						if(c.getName().equals("ckid")){
							ck = c;
							break;
						}
					}
				}
				
				if(ckid != null){ //泥댄겕 �릺�뼱 �엳�쓣�븣
					if(ck == null){ // 荑좏궎�뙆�씪 �뾾�쓣�븣
						ck = new Cookie("ckid",vo.getAdminId());
						
						//root濡� 寃쎈줈 �꽕�젙
						ck.setPath("/");
					
						//�쑀�슚�떆媛� �꽕�젙
						ck.setMaxAge(60*60*24);
					
						//�겢�씪�씠�뼵�듃�뿉寃� 荑좏궎�뙆�씪 �깮�꽦
						response.addCookie(ck);
					}else{ //�엳�쓣�븣
						if(!ck.getValue().equals(vo.getAdminId())){
							ck.setValue(vo.getAdminId());
							ck.setPath("/");
							response.addCookie(ck);
						}
					}
				}else{ // 泥댄겕 �븞�릺�뼱 �엳�쓣�븣
					if(ck != null){
						if(ck.getValue().equals(vo.getAdminId())){
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
			
			return ViewPath.ADMINLOGIN + "result.jsp";
		}
	
		@RequestMapping("logout")
		public String logout(HttpSession session) {
			session.invalidate();
			
			return ViewPath.ADMINLOGIN + "logout.jsp";
		}
		
	}
