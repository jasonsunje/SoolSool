package controller.cart;

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
import org.springframework.web.bind.annotation.RequestParam;

import common.ViewPath;
import service.cart.CartService;
import vo.cart.CartVO;
import vo.uuser.UuserVO;

	@Controller
	@RequestMapping("/cart/*")
	public class CartController {
		
		CartService cartService;
		
		
		public CartController(CartService cartService) {
			this.cartService = cartService;
		}
		
		
		@RequestMapping("insert")
		public String insert(Model model, HttpSession session, CartVO vo) {
			System.out.println("cart insert");
			System.out.println("product : " + vo.getProductNo());
			Integer no = (Integer)session.getAttribute("login");
			
			if(no == null) {
				return "redirect:/login/loginform";
			}
			
			vo.setUuserNo(no);
			
			int count= cartService.checkCart(vo.getProductNo(),vo.getUuserNo());
			
			if(count == 0) {
				cartService.insertCart(vo);
			} else {
				cartService.updateCart(vo);
			}
			
			return "redirect:/cart/list";
			
		}
		
		@RequestMapping("list")
		public String list(HttpSession session, Model model) {
			
			System.out.println("Cartlist");
			
			Integer uuserNo = (Integer)session.getAttribute("login");
			if(uuserNo == null) {
				return "redirect:/login/loginform";
			}
			Map<String, Object> map = new HashMap<String,Object>();
			List<Map<String, Object>> list = cartService.listCart(uuserNo);
			System.out.println(uuserNo);
			System.out.println(list.size());
			int sumMoney = cartService.sumMoney(uuserNo);
			System.out.println(sumMoney);
			int fee = sumMoney >=100000 ? 0 : 2500;
			map.put("list", list);
			map.put("count", list.size());
			map.put("sumMoney", sumMoney);
			map.put("fee", fee);
			map.put("allSum", sumMoney+fee);
			map.put("map",map);

			model.addAttribute("map", map);
			
			return ViewPath.CART + "list.jsp";
		}
		
		
		
		@RequestMapping("delete")
		public String delete(@RequestParam int CartNo) {
			
			System.out.println("delete");
			
			CartService.deleteCart(CartNo);
			return ViewPath.CART + "list.jsp";
		}
		
		/*
		 * @RequestMapping("update") public String update(@RequestParam int[]
		 * cartCnt, @RequestParam int[] productNo, HttpSession session) { int uuserNo =
		 * (int)session.getAttribute("uuserNo");
		 * 
		 * for(int i =0; i<productNo.length; i++) { CartVO vo = new CartVO();
		 * vo.setUuserNo(uuserNo); vo.setCartCnt(cartCnt[i]);
		 * vo.setProductNo(productNo[i]); cartService.updateCart(vo); }
		 * 
		 * return ViewPath.CART + "list.jsp"; }
		 */
		
		@RequestMapping("update")
		public String update(@RequestParam("cartCnt") int[] cartCnt, @RequestParam("productNo") int[] productNo, HttpSession session) {
		    int uuserNo = (int) session.getAttribute("uuserNo");

		    for (int i = 0; i < productNo.length; i++) {
		        CartVO vo = new CartVO();
		        vo.setUuserNo(uuserNo);
		        vo.setCartCnt(cartCnt[i]);
		        vo.setProductNo(productNo[i]);
		        cartService.updateCart(vo);
		    }

		    return "redirect:/cart/list"; // 수정된 부분
		}

		
	}