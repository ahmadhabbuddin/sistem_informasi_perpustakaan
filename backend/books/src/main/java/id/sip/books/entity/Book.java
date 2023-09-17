package id.sip.books.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(length = 50)
	private String id;
	
	@Column(length = 100)
	private String author;
	
	@Column(name = "book_no", length = 50)
	private String bookNo;
	
	@Column(name = "publised_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishedDate;
	
	@Column(length = 50)
	private String isbn;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 100)
	private String subtitle;
	
	@Column(length = 100)
	private String subject;
	
	@Column
	private int pages;
	
	@Column(name = "created_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	
	@Column(name = "created_by", length = 50)
	private String createdBy;
	
	@Column(name = "updated_at")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;
	
	@Column(name = "updated_by", length = 50)
	private String updatedBy;
	
}
