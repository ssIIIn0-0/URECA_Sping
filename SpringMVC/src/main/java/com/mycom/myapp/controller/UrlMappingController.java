package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// client 가 요청한 url 에 대해 누가 (어떤) 처리할 것인가 결정
// servlet 은 1 개당 @WebServlet("/books/*) 한개를 가진다. 다양한 기능을 하나의 서블릿에서 처리하는 것이 매우 불편
@Controller
public class UrlMappingController {
	@RequestMapping("/m1") // get, post, put, delete ...모두 다 처리
	public void m1() {
		System.out.println("/m1");
	}

	// get, post, put, delete ...모두 다 처리,
	// 다른 Controller 에 /hello 에 더 구체적인 mapping 이 존재할 경우(@GetMapping) 더 큰 범위를 가지는
	// @RequestMapping 은 오류가 발생하지 않고 양보
	@RequestMapping("/hello")
	public void m2() {
		System.out.println("/m2");
	}

	@RequestMapping(value = "/m3", method = RequestMethod.GET) // -> @GetMapping
	public void m3() {
		System.out.println("/m3");
	}

	@RequestMapping(value = "/m4", method = RequestMethod.POST) // -> @PostMapping
	public void m4() {
		System.out.println("/m4");
	}

	@GetMapping(value = "/m5")
	public void m5() {
		System.out.println("/m5");
	}

	@PostMapping(value = "/m6")
	public void m6() {
		System.out.println("/m6");
	}

	// path variable
	// client -> server 로 data 전송의 기본적인 방법응 parameter
	// 간단한 value 는 url 포함시켜서 보낼 수 있고 spring은 간단한 value 를 쉽게 처리할 수 있도록 한다.
	// 상세 건 (id value)
	// ...?bookId=123 : parameter 방식
	// .../123 : path variable 방식

	// ...books/123
	@GetMapping(value = "/books/{bookId}")
	public void m7(@PathVariable int bookId) { // String 으로
		System.out.println("/m7");
		System.out.println("bookId : " + bookId);
	}

	// ...list/10/and/5
	@GetMapping(value = "/list/{limit}/and/{offset}")
	public void m8(@PathVariable int limit, @PathVariable int offset) { // String 으로
		System.out.println("/m8");
		System.out.println("limit : " + limit);
		System.out.println("offset : " + offset);
	}

}
