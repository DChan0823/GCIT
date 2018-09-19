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
import com.gcit.lms.administrator_v2.dao.LibraryBranchDao;
import com.gcit.lms.administrator_v2.model.LibraryBranch;

@CrossOrigin
@RestController
//@RequestMapping("/lms/admin")
public class AdminLibraryBranchController {
	
	@Autowired
	private LibraryBranchDao branchDao;
	
	@GetMapping("/branches")
	public List<LibraryBranch> getBranches(){
		return branchDao.findAll();
	}
	
	@GetMapping("/branch/{branchId}")
	public Optional<LibraryBranch> getTheBranch(@PathVariable Long branchId) {
		
		return branchDao.findById(branchId);
	}
	
	//@RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@PostMapping("/branch")
	public ResponseEntity<LibraryBranch> newBranch(@RequestBody LibraryBranch branch) {//throws JsonParseException, JsonMappingException, IOException {
		
		branchDao.save(branch);
		
		return new ResponseEntity<LibraryBranch>(branch, HttpStatus.CREATED); 
	}
	
	@PutMapping("/branch/{branchId}")
	public ResponseEntity<LibraryBranch> editTheBorrower(@PathVariable Long branchId, @Valid @RequestBody LibraryBranch branch) {
		branch.setBranchId(branchId);
		
		branchDao.save(branch);
		
		return new ResponseEntity<LibraryBranch>(branch, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/branch/{branchId}")
	public ResponseEntity<LibraryBranch> deleteTheBorrower(@PathVariable Long branchId) {
		//Optional<LibraryBranch> temp = branchDao.findById(branchId);
		
		branchDao.deleteById(branchId);
		
		return new ResponseEntity<LibraryBranch>(HttpStatus.NO_CONTENT);
	}
}
