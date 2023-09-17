package id.sip.books.dto;

import id.sip.books.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBookByIdResponse extends BaseResponse{

	private Book book;
}
