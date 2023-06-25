package controller.mngdelivery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.mngdelivery.MngdeliveryService;
import vo.mngdelivery.MngdeliveryVO;
import vo.uuser.UuserVO;

@Controller
@RequestMapping("/delivery/**")
public class MngdeliveryController {

	private MngdeliveryService mngdeliveryService;

	public MngdeliveryController(MngdeliveryService mngdeliveryService) {
		this.mngdeliveryService = mngdeliveryService;
	}

	@RequestMapping("insertform")
	public String mngdeliveryForm() {
		
		return ViewPath.DELIVERY + "adress.jsp";
	}

	@RequestMapping("form")
	public String insertMngdelivery(Model model, HttpSession session) {
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			return "redirect:/login/loginform";
		}
		
		List<MngdeliveryVO> list = mngdeliveryService.getNoMngdelivery(no);
		System.out.println(list);
		
		model.addAttribute("list", list);
		
		return ViewPath.DELIVERY+"form.jsp";
	}
	
	@RequestMapping("insert")
	public String addMngdelivery(Model model,HttpSession session, MngdeliveryVO vo, String check) {
		if(check != null) {
			mngdeliveryService.basicUpdate();
			vo.setMngdeliveryBasic(1);
		}
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		vo.setUuserNo(no);
		System.out.println(vo.getMngdeliveryDname());
//		vo.setUuserNo(2);
		int su = mngdeliveryService.insertMngdelivery(vo);
		if(su != 0) {
			return "redirect:/delivery/form";
		}else {
			return "redirect:/delivery/insertform";
		}
		
//		if(no == null) {
//			return "redirect/login/loginform";
//		}else {
//			vo.setUuserNo(no);
//			int su = mngdeliveryService.insertMngdelivery(vo);
//			if(su == 0) {
//				return "redirect/mngdelivery/form";
//			}else {
//				return "redirect/mngdelivery/insertform";
//			}
//		}
		
	}

	@RequestMapping("list")
	public String getAllMngdelivery(Model model) {
		model.addAttribute("mngdeliveryList", mngdeliveryService.getAllMngdelivery());
		return "mngdelivery/list";
	}

	@RequestMapping("updateform")
	public String selectMngdelivery(Model model ,int seq) {
		MngdeliveryVO vo = mngdeliveryService.selectMngdelivery(seq);
		
		model.addAttribute("vo", vo);
		
		return ViewPath.DELIVERY+"/update.jsp";
	}
	
	@RequestMapping("update")
	public String updateMngdelivery(Model model, MngdeliveryVO vo, HttpSession session, String check) {
//		Integer no = (Integer)session.getAttribute("login");
		if(check != null) {
			mngdeliveryService.basicUpdate();
			vo.setMngdeliveryBasic(1);
		}
		Integer no = (Integer)session.getAttribute("login");
		if(no == null) {
			return "redirect:/login/loginform";
		}
		vo.setUuserNo(no);
//		vo.setUuserNo(2);
		int su = mngdeliveryService.updateMngdelivery(vo);
		
		if(su==0) {
			return "redirect:/delievery/updateform?seq=" + vo.getMngdeliveryNo();
		}else {
			return "redirect:/delivery/form";
		}
	}

	@RequestMapping("/delivery/delete")
	public String deleteMngdelivery(Model model ,int seq) {
		
		int su = mngdeliveryService.deleteMngdelivery(seq);
		
		model.addAttribute("su", su);
		model.addAttribute("status", "delete");
		model.addAttribute("url", "/delivery/form");
		
		return "redirect:/delivery/form";
	}

}
