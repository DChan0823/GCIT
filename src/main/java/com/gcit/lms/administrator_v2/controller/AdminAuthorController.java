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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcit.lms.administrator_v2.dao.AuthorDao;
import com.gcit.lms.administrator_v2.model.Author;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminAuthorController {
	
	@Autowired
	private AuthorDao authDao;
	
	@GetMapping("/authors")
	//@GetMapping(value = "/authors", produces = "application/json")
	/*@RequestMapping(
			  value = "/authors", 
			  produces = { "application/json", "application/xml" }, 
			  method = RequestMethod.GET)*/
	public List<Author> getAuthors(){
		return authDao.findAll();
	}
	
	@GetMapping("/author/{authorId}")
	public Optional<Author> getTheAuthor(@PathVariable Long authorId) {
		
		return authDao.findById(authorId);
	}
	
	@PostMapping("/author")
	public ResponseEntity<Author> newAuthor(@RequestBody Author auth) /*throws JsonParseException, JsonMappingException, IOException*/ {
		
		authDao.save(auth);
		
		return new ResponseEntity<Author>(auth, HttpStatus.CREATED);
	}
	
	@PutMapping("/author/{authorId}")
	public ResponseEntity<Author> editTheAuthor(@PathVariable Long authorId, @Valid @RequestBody Author author) {
		
		author.setAuthorId(authorId);
		
		authDao.save(author);
		
		return new ResponseEntity<Author>(author, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/author/{authorId}")
	public ResponseEntity<Author> deleteTheAuthor(@PathVariable Long authorId) {
		//Optional<Author> temp = authDao.findById(authorId);
		
		authDao.deleteById(authorId);
		
		return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
	}
}
