package com.gcit.lms.administrator_v2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_library_branch")
public class LibraryBranch {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long branchId;
	
	@Column(name = "branchName")
	private String branchName;
	
	@Column(name = "branchAddress")
	private String branchAddress;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="branch", cascade = CascadeType.ALL)
    private Set<BookCopies> bookCopies;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="branch", cascade = CascadeType.ALL)
    private Set<BookLoans> bookLoans;

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public Set<BookCopies> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(Set<BookCopies> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public Set<BookLoans> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(Set<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}
}
