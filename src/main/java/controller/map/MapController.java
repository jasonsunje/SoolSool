package controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ViewPath;

@Controller
public class MapController {
	
	@RequestMapping("Korean")
	public String Korean() {

		return ViewPath.INDEX + "Korean.jsp";
	}
	
	// 양조장

	@RequestMapping("Yesanapple")
	public String Yesanapple() { 
		return ViewPath.MAP + "/dummy/Yesanapple.jsp";
	}// 예산 사과 와인

	@RequestMapping("Kuksundang")
	public String Kuksundang() { 
		return ViewPath.MAP +"/dummy/Kuksundang.jsp";
	}// 국순당

	@RequestMapping("baesang")
	public String baesang() {
		return ViewPath.MAP + "/dummy/baesang.jsp";
	}// 배상면주가

	@RequestMapping("godori")
	public String godori() { 
		return ViewPath.MAP + "/dummy/godori.jsp";
	}// 고도리 와이너리

	@RequestMapping("Jejusamju")
	public String Jejusamju() { 
		return ViewPath.MAP + "/dummy/Jejusamju.jsp";
	}// 제주샘주

	@RequestMapping("Ominara")
	public String Ominara() { 
		return ViewPath.MAP + "/dummy/Ominara.jsp";
	}// 오미나라

	@RequestMapping("soolAone")
	public String soolAone() { 
		return ViewPath.MAP + "/dummy/soolAone.jsp";
	}// 술아원

	@RequestMapping("soolsamm")
	public String soolsamm() { 
		return ViewPath.MAP + "/dummy/soolsamm.jsp";
	}// 술샘

	@RequestMapping("YangchonBrewing")
	public String YangchonBrewing() { 
		return ViewPath.MAP + "/dummy/YangchonBrewing.jsp";
	}// 양촌 양조장

	@RequestMapping("hansansogokju")
	public String hansansogokju() { 
		return ViewPath.MAP + "/dummy/hansansogokju.jsp";
	}// 한산 소곡주

	@RequestMapping("jungwondang")
	public String jungwondang() { 
		return ViewPath.MAP + "/dummy/jungwondang.jsp";
	}// 중원당

	@RequestMapping("goodsoolsejong")
	public String goodsoolsejong() { 
		return ViewPath.MAP + "/dummy/goodsoolsejong.jsp";
	}// 조은술 세종
	
	@RequestMapping("Yeopo")
	public String Yeopo() { 
		return ViewPath.MAP + "/dummy/Yeopo.jsp";
	}// 여포 와이너리


	@RequestMapping("goodsool")
	public String goodsool() { 
		return ViewPath.MAP + "/dummy/goodsool.jsp";
	}
	
	
}
