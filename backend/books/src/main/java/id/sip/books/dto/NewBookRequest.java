package id.sip.books.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookRequest {

	private String author;
	private String bookNo;
	private Date publishedDate;
	private String isbn;
	private String title;
	private String subtitle;
	private String subject;
	private int pages;
}
