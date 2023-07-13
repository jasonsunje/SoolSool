package controller.uuser;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@RequestMapping("/uuser/joincheck")
	public String joinCheck() {
		return ViewPath.UUSER + "joinCheck.jsp";
	}
	
	
	
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
	
	

	
	// 이메일인증 ------------------------------------------------
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int authNumber;
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	public String joinEmail(String email) {
		makeRandomNumber();
		String setFrom = ".com";
		String toMail = email;
		String title = "회원 가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + 
				"<br><br>" + 
				"인증 번호는" + authNumber + "입니다." + 
				"<br>" + "해당 인증번호를 인증버호 확인란에 기입하여 주세요.";
		mailSend(setFrom, toMail,title,content);
		return Integer.toString(authNumber);
	}
	
	public void mailSend(String setFrom, String toMail, String title, String content) {
		System.out.println(mailSender + "123213213213");
		MimeMessage message = mailSender.createMimeMessage();
		// true 매개값을 전달하면 multpart 형식의 메세지 전달이 가능, 문자 인코딩 설정도 가능
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping("/uuser/mailCheck")
	@ResponseBody
	public String mailCheck(String email) {	
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		return joinEmail(email);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}




























