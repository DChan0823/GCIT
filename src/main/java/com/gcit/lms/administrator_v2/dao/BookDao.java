package com.gcit.lms.administrator_v2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
	@Query("Select b From Book b where b.author.authorName=?1")
	List<Book> FindAllByAuthorName(String authorName);
	
	@Query("Select b From Book b where b.publisher.publisherName=?1")
	List<Book> FindAllByPublisherName(String publisherName);
}
