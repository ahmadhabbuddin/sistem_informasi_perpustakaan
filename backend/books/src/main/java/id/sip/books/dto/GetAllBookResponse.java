package id.sip.books.dto;

import java.util.List;

import id.sip.books.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookResponse extends BaseResponse{

	private List<Book> books;
	
}
