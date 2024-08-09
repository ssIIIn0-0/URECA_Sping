package com.mycom.myapp.book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.book.dto.BookDto;

@Service
public interface BookService {
	List<BookDto> listBook();

	BookDto detailBook(int bookId);

	int insertBook(BookDto bookDto);

	int updateBook(BookDto bookDto);

	int deleteBook(int bookId);
}
