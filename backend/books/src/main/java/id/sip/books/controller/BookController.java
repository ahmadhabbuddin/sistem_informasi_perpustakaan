package id.sip.books.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.sip.books.dto.BaseResponse;
import id.sip.books.dto.GetAllBookResponse;
import id.sip.books.dto.GetBookByIdResponse;
import id.sip.books.dto.NewBookRequest;
import id.sip.books.entity.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(path = "/all" )
	@ResponseBody
	public ResponseEntity<?> getAllBook(){
		GetAllBookResponse resp = bookService.findAllBook(UUID.randomUUID().toString().replace("-", ""));
		if( resp.getResponseCode().equals("200")){
			return ResponseEntity.ok().body(resp);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
		}
	}
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> getBookById(@RequestParam(name = "id") String id){
		GetBookByIdResponse resp = bookService.findBookById(UUID.randomUUID().toString().replace("-", ""), id);
		if( resp.getResponseCode().equals("200")){
			return ResponseEntity.ok().body(resp);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
		}
	}
	
	@PostMapping("/new")
	@ResponseBody
	public ResponseEntity<?> addBook(@RequestBody NewBookRequest book, @RequestHeader("X-Email") String email) {
		BaseResponse resp = bookService.addNewBook(UUID.randomUUID().toString().replace("-", ""), book, email);
		if( resp.getResponseCode().equals("200")){
			return ResponseEntity.ok().body(resp);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
		}
	}
	
}
