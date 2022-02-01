package com.api.book.bootrestbook.services;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
	@Autowired
	private BookRepository bookRepository;

  	//get all books
  public List<Book> getAllBooks()
  {
	  List<Book> list=(List<Book>)this.bookRepository.findAll();
	  return list;
  }
  
  //get single book by id
  public Book getBookById(int id)
  {
	 Book book=null;
	 try {

		 book=this.bookRepository.findById(id);
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 return book;
  }
 
  //adding book
  public Book addBook(Book b)
  {
	  Book result=bookRepository.save(b);
	 return result;
  }
  
  //delete book
  public void deleteBook(int bid)
  {

	  bookRepository.deleteById(bid);
  }
  //update the book
  public void updateBook(Book book,int bookId)
  {

	  book.setId(bookId);
	  bookRepository.save(book);
  }
  
}
