package com.gcit.lms.administrator_v2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {
	
	@EmbeddedId
	private BookCopiesId bkcpyId;
	
	@Column(name = "noOfCopies")
	private Long noOfCopies;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="branchId", nullable=false, insertable = false, updatable = false)
    private LibraryBranch branch;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bookId", nullable=false, insertable = false, updatable = false)
    private Book book;

	public BookCopiesId getBkcpyId() {
		return bkcpyId;
	}

	public void setBkcpyId(BookCopiesId bkcpyId) {
		this.bkcpyId = bkcpyId;
	}

	public Long getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(Long noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
