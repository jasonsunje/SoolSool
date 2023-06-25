package controller.admin.uuser;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;
import service.admin.uuser.AdminUuserService;
import vo.uuser.UuserVO;

@Controller
@RequestMapping("admin/user/*")
public class AdminUuserController {

	AdminUuserService adminUuserService;
	
	public AdminUuserController(AdminUuserService adminUuserService) {
		this.adminUuserService = adminUuserService;
	}
	
	
	@RequestMapping("list")
	public String uuserList(Model model, UuserVO vo) {
		System.out.println("uuserList");
		List<UuserVO> list = AdminUuserService.uuserList();
		System.out.println("uuserList");
		model.addAttribute("list",list);
		return ViewPath.ADMINUSER + "list.jsp";
	}
	
}
