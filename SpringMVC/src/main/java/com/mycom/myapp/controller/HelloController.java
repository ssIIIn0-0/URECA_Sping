package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 더 이상 extends... 할 필요X
// doGet() overriding 필요X
// Request, Response 객체 파라미터 필요X

// 스프링에게 이 클래스의 객체가 controller 역할(MVC 에서)을 한다.
// 스프링은 HelloController 에게 http request, http response, session 등을 사용할 수 있다.
// url 요청에 대한 mapping, parameter...
@Controller
public class HelloController {

	@GetMapping("/here")
	public void m() {
		System.out.println("request for here");
	}
}
