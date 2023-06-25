package controller.product;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import common.ViewPath;
import service.product.ProductService;
import vo.product.ProductVO;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	
	@Autowired
	private ServletContext application;
	
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("detail/{productNo}")
	public String productDetail(@PathVariable("productNo")int productNo, Model model) {
		
		
		ProductVO vo = ProductService.selectOne(productNo);
		
		model.addAttribute("vo", vo);
		
		return ViewPath.PRODUCT + "detail.jsp";
	}
	
	
	@RequestMapping("list")
	public String list(Model model) {
		
		/*
		 * List<BoardVO> list = boardService.selectList(map);
		 * 
		 * model.addAttribute("list", list); model.addAttribute("paging", paging);
		 */
		model.addAttribute("list", productService.listProduct());
		
		return ViewPath.PRODUCT + "list.jsp";
	}
	
}
