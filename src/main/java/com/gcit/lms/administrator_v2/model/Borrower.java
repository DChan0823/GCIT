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
@Table(name = "tbl_borrower")
public class Borrower {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cardNo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy="borr", cascade = CascadeType.ALL)
    private Set<BookLoans> bookLoans;

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<BookLoans> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(Set<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}
}
