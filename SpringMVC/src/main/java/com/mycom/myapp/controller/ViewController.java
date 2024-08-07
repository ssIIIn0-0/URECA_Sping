package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ViewController {

	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		return "viewTest1";
	}
	
	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		return "sub/viewTest2";
	}
	
	// MVC의 M(model) 처리
	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		// service dao
		// request.setAttribute();
		model.addAttribute("seq", "01234");
		model.addAttribute("carDto", new CarDto("소나타", 2000, "현대"));
		return "viewTest3";  // forwarding
	}
	
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4() {
		// service dao
		// request.setAttribute();
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", "01234");
		mav.addObject("carDto", new CarDto("소나타", 2000, "현대"));
		mav.setViewName("viewTest4");  // setViewName() 대신 생성자 new ModelAndView("viewTest4"); 해도 된다.
		return mav;  // forwarding
	}
	
	// 위는 전부 다 forwarding
	// redirect로 실습
	@GetMapping(value = "/redirect")
	public String redirect() {
		System.out.println("redirect");
		return "redirect:/viewTest1"; // 맨 위 @GetMapping(value = "/viewTest1")가 호출된다. 
	}
	
}