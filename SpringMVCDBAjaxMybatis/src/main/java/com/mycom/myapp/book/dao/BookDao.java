package com.mycom.myapp.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.book.dto.BookDto;

// service 에서 bookDao 를 구현한 객체의 메소드를 호출할 것.(BookDaoImpl 삭제)
// BookDaoImpl(JDBC)를 대체할 새로운 BookDao 구현 객체가 필요(Mybatis)

// mybatis 가 @Mapper annotation 이 있는 interface 의 메소드들을 scan 하고 BookDao 를 implements 하는 객체 준비
// 위 객체를 만들기 위해 필요한 파라미터, 리턴, SQL 을 모드 xml 파일(mapper)로 구현
@Mapper
public interface BookDao {
	List<BookDto> listBook();
	BookDto detailBook(int bookId);
	int insertBook(BookDto bookDto);
	int updateBook(BookDto bookDto);
	int deleteBook(int bookId);
	
}
