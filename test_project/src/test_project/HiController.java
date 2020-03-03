package test_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HiController {
	
	@RequestMapping("/")
	public String home() {
		return "test";
	}
	
	@RequestMapping("/goToTest2")
	public String goTest2() {
		return "test2";
	}

	
	@RequestMapping("/goToTest3")
	public String goTest3(@RequestParam("varName")String vName, Model model) {
		int i= Integer.parseInt(vName);
		i*=i;
		
		model.addAttribute("vSquared",i);
		return"test3";
		
	}
	
}
