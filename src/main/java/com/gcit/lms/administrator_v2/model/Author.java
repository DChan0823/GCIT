package com.gcit.lms.administrator_v2.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tbl_author")
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long authorId;
    
    @Column(name = "authorName")
	private String authorName;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book> books;
    
    public Author() {}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authId) {
		this.authorId = authId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authName) {
		this.authorName = authName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
   
}