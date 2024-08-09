package com.mycom.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.myapp.dao.BookDao;
import com.mycom.myapp.dto.BookDto;

@Service
public class BookServiceImpl implements BookService{

//	@Autowired
//	BookDao bookDao;
	
	// 생성자 주입은 @Autowired 생략 가능
	private final BookDao bookDao;
	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public List<BookDto> listBook() {
		return bookDao.listBook();
	}

	@Override
	public BookDto detailBook(int bookId) {
		return bookDao.detailBook(bookId);
	}

	@Override
	public int insertBook(BookDto bookDto) {
		return bookDao.insertBook(bookDto);
	}

	@Override
	public int updateBook(BookDto bookDto) {
		return bookDao.updateBook(bookDto);
	}

	@Override
	public int deleteBook(int bookId) {
		return bookDao.deleteBook(bookId);
	}

}
