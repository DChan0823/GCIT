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
import com.gcit.lms.administrator_v2.dao.BorrowerDao;
import com.gcit.lms.administrator_v2.model.Borrower;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminBorrowerController {
	
	@Autowired
	private BorrowerDao borrDao;
	
	@GetMapping("/borrowers")
	public List<Borrower> getBorrowers(){
		return borrDao.findAll();
	}
	
	@GetMapping("/borrower/{cardNo}")
	public Optional<Borrower> getTheBorrower(@PathVariable Long cardNo) {
		
		return borrDao.findById(cardNo);
	}
	
	@PostMapping("/borrower")
	public ResponseEntity<Borrower> newBorrower(@RequestBody Borrower borr) throws JsonParseException, JsonMappingException, IOException {
		
		borrDao.save(borr);
		
		return new ResponseEntity<Borrower>(borr, HttpStatus.CREATED);
	}
	
	@PutMapping("/borrower/{cardNo}")
	public ResponseEntity<Borrower> editTheBorrower(@PathVariable Long cardNo, @Valid @RequestBody Borrower borr) {
		
		borr.setCardNo(cardNo);
		
		borrDao.save(borr);
		
		return new ResponseEntity<Borrower>(borr, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/borrower/{cardNo}")
	public ResponseEntity<Borrower> deleteTheBorrower(@PathVariable Long cardNo) {
		//Optional<Borrower> temp = borrDao.findById(cardNo);
		
		borrDao.deleteById(cardNo);
		
		return new ResponseEntity<Borrower>(HttpStatus.NO_CONTENT);
	}
}
