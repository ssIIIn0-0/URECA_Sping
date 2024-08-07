package com.mycom.myapp.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import com.mycom.myapp.dto.CarDto;
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
	public void m4(int book) { // int book != bookId, int => Integer
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

	// parameter => dto mapping
	// primitive type field 가 누락되어도 0 등 초기화된다. (오류 X)
	@PostMapping("/car")
	public void m9(CarDto carDto) {
		System.out.println(carDto);
	}

	// CarDto 의 모든 생성자 삭제 => 결과적으로 기본 생성자만 있는 경우 (O)
	// CarDto 의 setter, getter 삭제 => CarDto [name=null, price=0, brand=null]
	// CarDto 의 getter 만 삭제 => (O) <= setter 이용 값 설정
	// CarDto 의 field name => name2 => (O) <= field name 보다 setter, getter 이름 기인
	// CarDto 의 field name 의 setName(), getName() => setName2(), getName2() 변경하면
	// name 필드 null
	@PostMapping("/car2")
	public void m10(CarDto carDto) {
		System.out.println(carDto);
	}

	// 클라이언트 -> 서버로 복수의 parameter 를 보내는 경우이나 Dto 로 표현하지 않은 것들
	// @RequestParam 필요
	@PostMapping("/map")
	public void m11(@RequestParam Map<String, String> params) {
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("brand"));
		System.out.println(params.get("tire"));
	}

	@GetMapping("/header")
	public void m12(@RequestHeader(value = "Accept") String accept, @RequestHeader(value = "Host") String host,
			@RequestHeader(value = "API-KEY") String apiKey // user defined header
	) {
		System.out.println(accept);
		System.out.println(host);
		System.out.println(apiKey);

	}

}
