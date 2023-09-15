package controller.porder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.cart.CartService;
import service.porder.PorderService;
import vo.mngdelivery.MngdeliveryVO;
import vo.porder.PorderVO;
import vo.uuser.UuserVO;

@Controller
@RequestMapping("/order/*")
public class PorderController {

	private PorderService porderService;

	public PorderController(PorderService porderService) {
		this.porderService = porderService;
	}

	private CartService cartService;

	@RequestMapping("/order/create")
	public String createOrder(Model model, HttpSession session) {

		Integer uuserNo = (Integer) session.getAttribute("login");

		if (uuserNo == null) {
			return "redirect:/login/loginform";
		} 
		
		UuserVO vo = porderService.selectNo(uuserNo);
		model.addAttribute("vo", vo);
		
		MngdeliveryVO list = porderService.selectDelivery(uuserNo);
		model.addAttribute("list", list);
		
		Map<String, Object>porder = new HashMap<String, Object>();
		List<Map<String, Object>>list1 = porderService.listOrder(uuserNo);
		
		porder.put("porder", porder);
		//porder.put("list1", list1);

		int sumMoney = porderService.sumMoney(uuserNo);
		int fee = sumMoney >= 100000 ? 0 : 2500;
		porder.put("sumMoney", sumMoney);
		porder.put("fee", fee);
		porder.put("allSum", sumMoney+fee);
		
		model.addAttribute("list1", list1);
		model.addAttribute("porder", porder);
		return ViewPath.ORDER + "order.jsp";
	}


	@RequestMapping("/order/cplastorder")
	public String order(Model model, HttpSession session) {
		Integer uuserNo = (Integer) session.getAttribute("login");

		if (uuserNo == null) {
			return "redirect:/login/loginform";
		} 
		
		UuserVO vo = porderService.selectNo(uuserNo);
		model.addAttribute("vo", vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = porderService.listCart(uuserNo);
		int sumMoney = porderService.sumMoney(uuserNo);
		int fee = sumMoney >= 100000 ? 0 : 2500;
		map.put("list", list);
		map.put("count", list.size());
		map.put("sumMoney", sumMoney);
		map.put("fee", fee);
		map.put("allSum", sumMoney + fee);
		map.put("map", map);
		
		Map<String, Object>porder = new HashMap<String, Object>();
		porder.put("porder", porder);
		porder.put("sumMoney", sumMoney);
		porder.put("fee", fee);
		
		model.addAttribute("porder", porder);

		model.addAttribute("map", map);
		
		return ViewPath.ORDER+"cplastorder.jsp";
		
	}
}
