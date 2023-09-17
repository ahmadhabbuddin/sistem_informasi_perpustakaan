package id.sip.books.entity.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.sip.books.dto.BaseResponse;
import id.sip.books.dto.GetAllBookResponse;
import id.sip.books.dto.GetBookByIdResponse;
import id.sip.books.dto.NewBookRequest;
import id.sip.books.entity.Book;
import id.sip.books.entity.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
//	@Autowired
	private Logger logger = LogManager.getLogger(BookService.class);
	
	public GetAllBookResponse findAllBook(String transactionId){
		logger.info("transactionId: "+transactionId+" text: Find All Book");

		GetAllBookResponse resp = new GetAllBookResponse();
		List<Book> books = bookRepo.findAll();
		if( books.isEmpty() ) {
			resp.setResponseCode("404");
			resp.setResponseMessage("Book Not Found");
			resp.setResponseReferenceNo(transactionId);
		}else {
			resp.setResponseCode("200");
			resp.setResponseMessage("Success");
			resp.setResponseReferenceNo(transactionId);
			resp.setBooks(books);
		}
		logger.info(books);
		return resp;
	}
	
	public GetBookByIdResponse findBookById(String transactionId, String id) {
		logger.info("transactionId: "+transactionId+" text: Find Book by Id");

		GetBookByIdResponse resp = new GetBookByIdResponse();
		Book book = bookRepo.findById(id).get();
		if( book == null ) {
			resp.setResponseCode("404");
			resp.setResponseMessage("Book Not Found");
			resp.setResponseReferenceNo(transactionId);
		}else {
			resp.setResponseCode("200");
			resp.setResponseMessage("Success");
			resp.setResponseReferenceNo(transactionId);
			resp.setBook(book);
		}
		
		logger.info(book);
		return resp;
	}
	
	public BaseResponse addNewBook(String transactionId, NewBookRequest newBook, String email) {
		BaseResponse resp = new BaseResponse();
		try {
			logger.info("transactionId: "+transactionId+" text: Add new Book");
			Book book = new Book();
			book.setAuthor(newBook.getAuthor());
			book.setBookNo(newBook.getBookNo());
			book.setPublishedDate(newBook.getPublishedDate());
			book.setIsbn(newBook.getIsbn());
			book.setTitle(newBook.getTitle());
			book.setSubtitle(newBook.getSubtitle());
			book.setSubject(newBook.getSubject());
			book.setPages(newBook.getPages());
			book.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new Date().toString()));
			book.setCreatedBy(email);
			bookRepo.save(book);
			logger.info("Success");
			resp.setResponseCode("201");
			resp.setResponseMessage("Success");
			resp.setResponseReferenceNo(transactionId);
		} catch (Exception e) {
			resp.setResponseCode("500");
			resp.setResponseMessage("Internal Server Error. An error occured while save book.");
			resp.setResponseReferenceNo(transactionId);
			logger.error(e.getCause());
			e.printStackTrace();
		}
		return resp;
	}
	
	public BaseResponse updateBook(String transactionId, Book book) {
		BaseResponse resp = new BaseResponse();
		try {
			logger.info("transactionId: "+transactionId+" text: Update Book");
			bookRepo.save(book);
			logger.info("Success");
			resp.setResponseCode("200");
			resp.setResponseMessage("Success");
			resp.setResponseReferenceNo(transactionId);
		} catch (Exception e) {
			resp.setResponseCode("500");
			resp.setResponseMessage("Internal Server Error. An error occured while update book.");
			resp.setResponseReferenceNo(transactionId);
			logger.error(e.getCause());
			e.printStackTrace();
		}
		return resp;
	}
	
	public BaseResponse deleteBook(String transactionId, String id) {
		BaseResponse resp = new BaseResponse();
		try {
			logger.info("transactionId: "+transactionId+" text: Delete Book");
			bookRepo.delete(bookRepo.findById(id).get());
			logger.info("Delete Success");
			resp.setResponseCode("200");
			resp.setResponseMessage("Success");
			resp.setResponseReferenceNo(transactionId);
		} catch (Exception e) {
			resp.setResponseCode("500");
			resp.setResponseMessage("Internal Server Error. An error occured while delete book.");
			resp.setResponseReferenceNo(transactionId);
			logger.error(e.getCause());
			e.printStackTrace();
		}
		
		return resp;
	}
	
}
