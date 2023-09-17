package id.sip.books.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.sip.books.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	
}
