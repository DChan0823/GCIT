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
import com.gcit.lms.administrator_v2.dao.BookLoansDao;
import com.gcit.lms.administrator_v2.model.BookLoans;
import com.gcit.lms.administrator_v2.model.BookLoansId;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminBookLoansController {
	@Autowired
	private BookLoansDao blDao;
	
	@GetMapping("/loans")
	public List<BookLoans> getBookLoans(){
		return blDao.findAll();
	}
	
	@GetMapping("/loan/book/{bookId}/branch/{branchId}/borrower/{cardNo}")
	public Optional<BookLoans> getTheBookLoan(@PathVariable Long bookId, @PathVariable Long branchId, @PathVariable Long cardNo) {
		
		return blDao.findByBookLoansId(bookId, branchId, cardNo);
	}
	
	@PostMapping("/loans")
	public ResponseEntity<BookLoans> newLoan(@RequestBody BookLoans bl) /*throws JsonParseException, JsonMappingException, IOException*/ {
		
		blDao.save(bl);
		
		return new ResponseEntity<BookLoans>(bl, HttpStatus.CREATED);
	}
	
	@PutMapping("/loan/book/{bookId}/branch/{branchId}/borrower/{cardNo}")
	public ResponseEntity<BookLoans> editTheLoan(@PathVariable Long bookId, @PathVariable Long branchId, @PathVariable Long cardNo, @Valid @RequestBody BookLoans loan) {//@Valid @RequestBody String dateOut, @Valid @RequestBody String dueDate) {
		
		BookLoansId blId = new BookLoansId();
		
		blId.setBookId(bookId);
		blId.setBranchId(branchId);
		blId.setCardNo(cardNo);
		
		loan.setBklnId(blId);
		
		blDao.save(loan);
		
		return new ResponseEntity<BookLoans>(loan, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/loan/book/{bookId}/branch/{branchId}/borrower/{cardNo}")
	public ResponseEntity<BookLoans> deleteTheLoan(@PathVariable Long bookId, @PathVariable Long branchId, @PathVariable Long cardNo) {
		
		//Optional<BookLoans> temp = blDao.findByBookLoansId(bookId, branchId, cardNo);
		
		blDao.deleteByBookLoansId(bookId, branchId, cardNo);
		
		return new ResponseEntity<BookLoans>(HttpStatus.NO_CONTENT);
	}
}
