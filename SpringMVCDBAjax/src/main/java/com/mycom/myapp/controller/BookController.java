package com.mycom.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.BookDto;
import com.mycom.myapp.service.BookService;

// 브라우저 -> 서버 요청할 때 2가지 구분해서 한다.
// 1. page 요청 <html> ~ </html> 요청	<a href="//...> <form action="///"> window.location.href="..///"
// 2. data 요청 json(xml...) 요청		fetch : 데이터에 대한 요청
@Controller
@RequestMapping("/books")
public class BookController {
	// 생성자 DI
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// /books/ => books.jsp 로 이동
	@GetMapping("/") // 이건 page 요청
	public String bookMain() {
		return "books"; // books.jsp 로 forwarding
	}

	@GetMapping("/list") // 이건 데이터 요청 그래서 ResponseBody 필요
	@ResponseBody // view resolver 탐색을 진행하지 않고 바로 응답 (Json으로)
	public List<BookDto> listBook() {
		List<BookDto> bookList = bookService.listBook();
		return bookList; // bookList 객체를 json 문자열로 변경 후에 client에 전송
	}

	@GetMapping("/detail/{bookId}")
	@ResponseBody
	public BookDto detailBook(@PathVariable int bookId) {
		BookDto bookDto = bookService.detailBook(bookId);
		return bookDto;
	}

	@PostMapping("/insert")
	@ResponseBody
	public int insertBook(BookDto bookDto) {
		int ret = bookService.insertBook(bookDto);
		return ret;
	}

	@PostMapping("/update")
	@ResponseBody
	public int updateBook(BookDto bookDto) {
		int ret = bookService.updateBook(bookDto);
		return ret;
	}

	@GetMapping("/delete/{bookId}")
	@ResponseBody
	public int deleteBook(@PathVariable int bookId) {
		int ret = bookService.deleteBook(bookId);
		return ret;
	}
}
