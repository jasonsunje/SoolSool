package controller.admin.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import common.Paging;
import common.ViewPath;
import service.admin.product.AdminProductService;
import vo.product.ProductVO;

@Controller
@RequestMapping("/admin/product/*")
public class AdminProductController {

	@Autowired
	private ServletContext application;
	
	private AdminProductService adminProductService;
	
	public AdminProductController(AdminProductService adminProductService) {
		this.adminProductService = adminProductService;
	}
	
	private ProductVO productVO;
	
	@RequestMapping("insertForm")
	public String insertForm() {
		
		System.out.println("insertForm");
		return ViewPath.ADMINPRODUCT + "insertForm.jsp";
	}
	
	@RequestMapping("insert")
	public String insert(Model model,ProductVO vo, @RequestParam(value = "file", required = false) MultipartFile file) {
		
		String savePath = "C:\\server\\upload\\";
		System.out.println(savePath);
		String filename = null;
		if(file != null) {
			filename = file.getOriginalFilename();
			
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				long time = System.currentTimeMillis();
				
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")),time,filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath,filename);
			}
			
			//업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시 저장소에 저장되어 있다...
			//파일이 일정한 시간이 지나면 사라지기 때문에 내가 지정한 경로로 복사해주면 된다...
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			vo.setProductImg(filename);
		}
		/*
		 * Integer no = (Integer)session.getAttribute("login");
		 * 
		 * if(no == null) {
		 * 
		 * return ViewPath.ADMINLOGIN + "loginForm.jsp"; }
		 */
		
		System.out.println(vo.getProductImg());
		System.out.println("insert");
		
		int su = adminProductService.insertProduct(vo);
		
		String imgurl = null;
		String msg = null;
		
		if(su != 0){
			msg = "상품 등록 성공";
		}
		
		model.addAttribute("msg", msg);
		
		return ViewPath.ADMINPRODUCT + "result.jsp";
	}
	
	
	@RequestMapping("list")
	public String list(Model model) {
		
		/*
		 * List<BoardVO> list = boardService.selectList(map);
		 * 
		 * model.addAttribute("list", list); model.addAttribute("paging", paging);
		 */
		model.addAttribute("list", adminProductService.listProduct());
		
		return ViewPath.ADMINPRODUCT + "list.jsp";
	}
	
	

	
	@RequestMapping("updateForm/{productNo}")
	public String updateForm(@PathVariable("productNo")int productNo, Model model) {
		System.out.println("updateForm");
		ProductVO vo = adminProductService.selectOne(productNo);
		
		model.addAttribute("vo", vo);
		
		return ViewPath.ADMINPRODUCT + "updateForm.jsp";
	}

	@RequestMapping("deleteform")
	public String deleteform(HttpSession session) {
		
		Integer no = (Integer)session.getAttribute("login");
		
		if(no == null) {
			
			return "redirect:admin/login/loginform";
		}
		
		return ViewPath.ADMINPRODUCT + "deleteForm.jsp";
	}
	
	@RequestMapping("update")
	public String update(Model model,ProductVO vo) {
		System.out.println("update");
		int su = adminProductService.updateProduct(vo);
		
		String msg = null;
		String url = null;
		
		if(su != 0){
			msg = "수정완료!!상품 페이지로...";
			url = "/admin/product/list";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		return ViewPath.ADMINPRODUCT + "result.jsp";
	}
	
	@RequestMapping("delete/{productNo}")
	public String delete(@PathVariable("productNo")int productNo, Model model) {
		
		
		
		ProductVO vo = adminProductService.selectOne(productNo);
		
		int su = adminProductService.deleteProduct(productNo);
		
		String url = null;
		String msg = null;
		
		if(su != 0) {
			msg = "삭제 완료";
			url = "/admin/product/list";
		}	
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		
		
		
		return ViewPath.ADMINPRODUCT + "result.jsp";
	}

}










