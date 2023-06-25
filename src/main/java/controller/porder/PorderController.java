package controller.porder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.ViewPath;
import dao.porder.PorderDAO;
import service.cart.CartService;
import service.porder.PorderService;
import vo.cart.CartVO;
import vo.porder.PorderVO;

@Controller
@RequestMapping("/order/*")
public class PorderController {
		
		    @Autowired
		    private PorderService porderService;
		    private PorderDAO porderDao;
		    private CartService cartService;

		    @Autowired
		    public PorderController(PorderService porderService, CartService cartService) {
		        this.porderService = porderService;
		        this.cartService = cartService;
		    }
		    
		    @PostMapping("/create")
		    public String createOrder(Model model, HttpSession session, 
		    		@RequestParam("cartNo")List<Integer> cartNo, 
		    		@RequestParam("cartPrice")List<Integer> cartPrice,
		    		@RequestParam("cartCnt")List<Integer> cartCnt) {

		    	
		    	
		    	PorderVO vo = new PorderVO();
				System.out.println("order insert");
				System.out.println("cartPrice : " + cartPrice);
				System.out.println("cartCnt : " + cartCnt);
				Integer no = (Integer)session.getAttribute("login");
				int pno = porderService.getPno();	
				if(no == null) {
					return "redirect:/login/loginform";
				}
				
				for(int i = 0; i < cartNo.size(); i++) {
					vo.setProductNo(cartNo.get(i));
					vo.setUuserNo(no);
					int totalPrice = cartPrice.get(i) * cartCnt.get(i);
					vo.setpOrderPtotal(totalPrice);
					vo.setpOrderPno(pno);
					porderService.createOrder(vo);
				}
				
				
				
				Map<String, Object> map = new HashMap<String,Object>();
				List<Map<String, Object>> list = porderService.listPorderPno(pno);
				int sumMoney = cartService.sumMoney(no);
				System.out.println("list : " + list);
				System.out.println(sumMoney);
				int fee = sumMoney >= 100000 ? 0 : 2500;
				map.put("list", list);
				map.put("count", list.size());
				map.put("sumMoney", sumMoney);
				map.put("fee", fee);
				map.put("allSum", sumMoney+fee);
				
			    Map<String, Object> orderMap = new HashMap<>();
			    model.addAttribute("map", map);
			    model.addAttribute("orderMap", orderMap);
				System.out.println("pno : " + vo.getProductNo());
				porderService.createOrder(vo);
					
				return ViewPath.ORDER + "create.jsp";
					
		    }
		 
			
		    @GetMapping("detail")
		    public String getOrder( PorderVO porderVO, int pOrderNo, Model model) {
		        // 주문 조회 로직 구현
		    	Map<String, Object> map = new HashMap<String,Object>();
				List<Map<String, Object>> list = porderService.listPorder(pOrderNo);
		        model.addAttribute("porder", porderVO);
		        return "/detail"; // 주문 상세 페이지로 이동
		    }
		    
		    @PostMapping("/{orderId}/cancel")
		    public String cancelOrder(@PathVariable("porderNo") int porderNo) {
		        // 주문 취소 로직 구현
		        porderService.cancelOrder(porderNo);
		        return "/canceled"; // 주문 취소 페이지로 이동
		    }
		    
		}

