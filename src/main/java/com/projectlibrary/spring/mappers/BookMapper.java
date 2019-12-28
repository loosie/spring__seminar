package com.projectlibrary.spring.mappers;


import com.projectlibrary.spring.models.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    public List<Book> getAllBooks();

    public List<Book> getBooksByName(String name);

    public Book getBookById(int bookId);

    public int insertBook(Book book);

    public int updateBook(Book book);

    public int deleteBook(int bookId);
}
