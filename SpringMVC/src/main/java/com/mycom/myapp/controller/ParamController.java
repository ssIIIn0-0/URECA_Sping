package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

// parameter <= request.getParameter("bookId")
@Controller
public class ParamController {
	@GetMapping("/param1")
	public void m1(HttpServletRequest request) {
		System.out.println(request.getParameter("bookId"));
		System.out.println(request.getParameter("bookName"));
	}

	@GetMapping("/param2")
	public void m2(String bookId) { // String bookId
		System.out.println(bookId);
	}

	@GetMapping("/param3")
	public void m3(int bookId, String bookName) { // int bookId
		System.out.println(bookId);
		System.out.println(bookName);
	}

	// Optional int parameter 'book' is present but cannot be translated into a null
	// value due
	// bookId != book 이므로 book -> null 로 바꾸려고 하는데 primitive type 이므로 null X ->
	// warapper class 로 변경해라 가이드
	@GetMapping("/param4")
	public void m4(Integer book) { // int book != bookId, int => Integer
		System.out.println(book);
	}

	// parameter 처리는 대소문자 및 철자 구분하고, 인식안되는 parameter 에 대해서는 null 처리한다.
	@GetMapping("/param5")
	public void m5(String bookname) { // String bookname != bookName
		System.out.println(bookname);
	}

	// @RequestParam 은 required=true 가 default <= 파라미터가 없으면 WARN 발생
	@GetMapping("/param6")
	public void m6(@RequestParam String seq) { //
		System.out.println(seq);
	}

	// parameter 와 받는 변수명이 다를 경우 name 속성으로 처리
	@GetMapping("/param7")
	public void m7(@RequestParam(name = "seq") String seq2) { //
		System.out.println(seq2);
	}

	// @RequestParam 은 required=true 가 default <= 파라미터가 없으면 WARN 발생
	// required=false 로 명시하면 No WARN, 단순 null 처리
	@GetMapping("/param8")
	public void m8(@RequestParam(required = false) String seq) {
		System.out.println(seq);
	}
}
