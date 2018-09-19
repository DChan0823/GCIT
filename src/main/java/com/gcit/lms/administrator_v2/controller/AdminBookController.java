package com.gcit.lms.administrator_v2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcit.lms.administrator_v2.dao.BookDao;
import com.gcit.lms.administrator_v2.model.Author;
import com.gcit.lms.administrator_v2.model.Book;
import com.gcit.lms.administrator_v2.model.Publisher;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminBookController {
	@Autowired
	private BookDao bkDao;
	
	@GetMapping("/books")
	public List<Book> getPublishers(){
		return bkDao.findAll();
	}
	
	@GetMapping("/book/{bookId}")
	public Optional<Book> getThePublisher(@PathVariable Long bookId) {
		
		return bkDao.findById(bookId);
	}
	
	//@RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@PostMapping("/book")
	public ResponseEntity<Book> newBook(@RequestBody Book bk) throws JsonParseException, JsonMappingException, IOException {
		
		//System.out.println("HEY WE ARE HERE BEFORE THE QUERIES!!!!!");
		
		List<Book> resultAuthor = bkDao.FindAllByAuthorName(bk.getAuthor().getAuthorName());
		List<Book> resultPublisher = bkDao.FindAllByPublisherName(bk.getPublisher().getPublisherName());
		
		if(!resultAuthor.isEmpty() && !resultPublisher.isEmpty()) {
			
			Author au = resultAuthor.get(0).getAuthor();
			Publisher pub = resultPublisher.get(0).getPublisher();
			
			bk.setAuthor(au);
			bk.setPublisher(pub);
		}
		else if(!resultAuthor.isEmpty() && resultPublisher.isEmpty()) {
			
			Author au = resultAuthor.get(0).getAuthor();
			bk.setAuthor(au);
		}
		else if(resultAuthor.isEmpty() && !resultPublisher.isEmpty()) {
			
			Publisher pub = resultPublisher.get(0).getPublisher();
			bk.setPublisher(pub);
		}
		
		bkDao.save(bk);
		
		return new ResponseEntity<Book>(bk, HttpStatus.CREATED);
	}
	
	@PutMapping("/book/{bookId}")
	public ResponseEntity<Book> editTheBook(@PathVariable Long bookId, @Valid @RequestBody Book book) {//@Valid @RequestBody String title, @Valid @RequestBody Author author, @Valid @RequestBody Publisher publisher) {
		
		book.setBookId(bookId);
		
		List<Book> resultAuthor = bkDao.FindAllByAuthorName(book.getAuthor().getAuthorName());
		List<Book> resultPublisher = bkDao.FindAllByPublisherName(book.getPublisher().getPublisherName());
		
		if(!resultAuthor.isEmpty() && !resultPublisher.isEmpty()) {
			
			Author au = resultAuthor.get(0).getAuthor();
			Publisher pub = resultPublisher.get(0).getPublisher();
			
			book.setAuthor(au);
			book.setPublisher(pub);
		}
		else if(!resultAuthor.isEmpty() && resultPublisher.isEmpty()) {
			
			Author au = resultAuthor.get(0).getAuthor();
			book.setAuthor(au);
		}
		else if(resultAuthor.isEmpty() && !resultPublisher.isEmpty()) {
			
			Publisher pub = resultPublisher.get(0).getPublisher();
			book.setPublisher(pub);
		}
		
		bkDao.save(book);
		
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Book> deleteTheBook(@PathVariable Long bookId) {
		
		bkDao.deleteById(bookId);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
}
