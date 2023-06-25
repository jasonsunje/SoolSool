package controller.uuser;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ViewPath;
import service.uuser.UuserService;
import vo.uuser.UuserVO;
import vo.withdrawal.WithdrawalVO;


@Controller
public class UuserController {

	private UuserService uuserService;
	
	public UuserController(UuserService uuserService) {
		this.uuserService = uuserService;
	}
	
	// 회원가입
	@RequestMapping("/uuser/joinform")
	public String joinForm() {
		return ViewPath.UUSER + "joinForm.jsp";
	}
	
	@RequestMapping(value = "/uuser/join")
	public String join(Model model, UuserVO vo) {
		System.out.println("JOIN");
		vo.setUuserType(0);
		vo.setUuserImg(null);
		vo.setUuserIntro(null);
		vo.setUuserJoindate(null);
		vo.setUuserUpdate(null);
		vo.setUuserAddress(null);
		vo.setUuserStatus(1);			
		vo.setUuserAgree(null);
		vo.setUuserBirth(null);
		vo.setUuserAuthdate(null);
		vo.setUuserSnsid(null);
		vo.setUuserSnscode1(null);
		vo.setUuserSnscode2(null);
		vo.setUuserLastdate(null);
		vo.setGradeNo(1);
		int su = uuserService.insert(vo);
		
		String url = null;
		String msg = null;
	

		
		
		
		if(su != 0) {
			msg = "회원 가입 성공!";
			url = "/sool/login/loginform?id=" + vo.getUuserId();
		}else {
			msg = "회원 가입 실패!";
			url = "history.back()";
		}
		
		model.addAttribute("url",url);
		model.addAttribute("msg",msg);
		
		return ViewPath.UUSER + "result.jsp";
	}
	
	// 마이페이지 ( 메인 )
	
	@RequestMapping("/uuser/mypage")
	public String myPage(Model model, HttpSession session) {
		
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		Integer count = uuserService.couponCount(no);
		
		session.setAttribute("count", count);
		
		return ViewPath.UUSER + "mypage.jsp";
	}
	
	
	// 마이페이지( 회원 정보 )
	
	@RequestMapping("/uuser/uuserInfo")
	public String myPageDetail(Model model, HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		UuserVO vo = uuserService.selectOne(no);
		
		model.addAttribute("vo",vo);
		
		return ViewPath.UUSER + "uuserInfo.jsp";
	}
	
	// 회원 수정
	
	@RequestMapping("/uuser/updateform")
	public String updateForm(Model model, HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		UuserVO vo = uuserService.selectOne(no);
		
		model.addAttribute("vo", vo);
		
		return ViewPath.UUSER + "updateForm.jsp";
	}
	
	
	@RequestMapping("/uuser/update")
	public String update(Model model,HttpSession session,UuserVO vo) { 
		
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		vo.setUuserNo(no);
		
		int su = uuserService.update(vo);
		
		String msg = null;
		String url = null;
		
		if(su != 0){
			msg = "수정완료!!MyPage로...";
			url = "/sool/uuser/mypage";
		}else{
			msg = "수정실패!!이전페이지로...";
			url = "/sool/uuser/updateform";
		}
		
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.UUSER + "result.jsp";

	}
	
	
	
	// 회원 탈퇴 -----------------------
	
	@RequestMapping("/uuser/deleteform")
	public String deleteForm() {
		return ViewPath.UUSER + "deleteForm.jsp";
	}
	
	@RequestMapping("/uuser/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, WithdrawalVO vo) {
		
		Integer no = (Integer)request.getSession().getAttribute("login");
		System.out.println("no : " + no);
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
	
		
		String msg = null;
		String url = null;
		
			UuserVO uVo = uuserService.selectOne(no);
			vo.setUuserNo(no);
			
			int su = uuserService.withdrawal(no);
			
		
				if(su != 0) {
					
					int in = uuserService.insertWith(vo);
					
					if(in != 0) {
						msg = "탈퇴 성공";
						url = "/sool/login/logout";
						Cookie[] cks = request.getCookies();
						
						if(cks != null) {
							for(Cookie ck:cks) {
								if(ck.getName().equals("ckid")) {
									if(ck.getValue().equals(uVo.getUuserId())) {
										ck.setMaxAge(0);
										ck.setPath("/");
										response.addCookie(ck);
										break;
									}
								}
							}
						}
					}else {
						msg = "탈퇴 실패. 이전페이지로...";
						url = "/sool/uuser/deleteform";
					}
					
				}
			
			
		
		
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return ViewPath.LOGIN + "login.jsp";
		
	}
	
	
	// 아이디 중복 체크
	
	
	@RequestMapping(value = "/uuser/checkId" ,produces = "application/text;charset=utf8" )
	@ResponseBody
	public String checkId(String id) {
		if(uuserService.checkId(id)) {
			return "이미 사용중인 ID입니다.";
		}else {
			return "사용 가능한 ID입니다";
		}
	}
	
	@RequestMapping("/ususer/coupons")
	public String coupon(Model model, UuserVO vo, HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		Integer count = uuserService.couponCount(no);
		
		model.addAttribute("count", count);
		
		return ViewPath.COUPON+"couponform.jsp";
	}
	
	@RequestMapping("/ususer/orderList")
	public String orderList(Model model, HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		List<Map<String, Object>> list = uuserService.listPorderUno(no);
		
		model.addAttribute("list", list);
		
		return ViewPath.UUSER + "orderList.jsp";
	}
	
}




























