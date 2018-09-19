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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcit.lms.administrator_v2.dao.PublisherDao;
import com.gcit.lms.administrator_v2.model.Publisher;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminPublisherController {
	
	@Autowired
	private PublisherDao pubDao;
	
	@GetMapping("/publishers")
	public List<Publisher> getPublishers(){
		return pubDao.findAll();
	}
	
	@GetMapping("/publisher/{publisherId}")
	public Optional<Publisher> getThePublisher(@PathVariable Long publisherId) {
		
		return pubDao.findById(publisherId);
	}
	
	//@RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@PostMapping("/publisher")
	public ResponseEntity<Publisher> newPublisher(@RequestBody Publisher pub) throws JsonParseException, JsonMappingException, IOException {
		
		pubDao.save(pub);
		
		return new ResponseEntity<Publisher>(pub, HttpStatus.CREATED);
	}
	
	@PutMapping("/publisher/{publisherId}")
	public ResponseEntity<Publisher> editThePublisher(@PathVariable Long publisherId, @Valid @RequestBody Publisher pub) {
		
		pub.setPublisherId(publisherId);
		
		pubDao.save(pub);
		
		return new ResponseEntity<Publisher>(pub, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/publisher/{publisherId}")
	public ResponseEntity<Publisher> deleteThePublisher(@PathVariable Long publisherId) {
		//Optional<Publisher> temp = pubDao.findById(publisherId);
		
		pubDao.deleteById(publisherId);
		
		return new ResponseEntity<Publisher>(HttpStatus.NO_CONTENT);
	}
}
