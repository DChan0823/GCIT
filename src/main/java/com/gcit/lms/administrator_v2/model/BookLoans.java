package com.gcit.lms.administrator_v2.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.EmbeddedId;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_book_loans")
public class BookLoans {
	
	@EmbeddedId
    private BookLoansId bklnId;
	
	@Column(name = "dateOut")
	private String dateOut;
	
	@Column(name = "dueDate")
	private String dueDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cardNo", insertable = false, updatable = false)
    private Borrower borr;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookId", insertable = false, updatable = false)
    private Book book;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="branchId", insertable = false, updatable = false)
    private LibraryBranch branch;

	public BookLoansId getBklnId() {
		return bklnId;
	}

	public void setBklnId(BookLoansId bklnId) {
		this.bklnId = bklnId;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Borrower getBorr() {
		return borr;
	}

	public void setBorr(Borrower borr) {
		this.borr = borr;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}
}
