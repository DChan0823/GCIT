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

import org.hibernate.annotations.Cascade;
import org.springframework.data.repository.query.parser.Part.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_book")
public class Book {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long bookId;
	    
	 @Column(name = "title")
	 private String title;
	 
	 //@Cascade(org.hibernate.annotations.CascadeType.ALL)
	 //@JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "authId")
	 private Author author;
	 
	 //@Cascade(org.hibernate.annotations.CascadeType.ALL)
	 //@JsonIgnore
	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 @JoinColumn(name = "pubId")
	 private Publisher publisher;
	 
	 //@Cascade(org.hibernate.annotations.CascadeType.ALL)
	 @JsonIgnore
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="book", cascade = CascadeType.ALL)
	 private Set<BookLoans> bookLoans;
	 
	 //@Cascade(org.hibernate.annotations.CascadeType.ALL)
	 @JsonIgnore
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="book", cascade = CascadeType.ALL)
	 private Set<BookCopies> bookCopies;
	 
	 public Book() {}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<BookLoans> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(Set<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public Set<BookCopies> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(Set<BookCopies> bookCopies) {
		this.bookCopies = bookCopies;
	}
}
