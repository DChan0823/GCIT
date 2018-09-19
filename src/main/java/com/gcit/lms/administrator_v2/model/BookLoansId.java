package com.gcit.lms.administrator_v2.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookLoansId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "bookId")
    private Long bookId;
 
    @Column(name = "branchId")
    private Long branchId;
    
    @Column(name = "cardNo")
    private Long cardNo;
    
    public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getCardNo() {
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public BookLoansId() {
    }
 
    public BookLoansId(Long bookId, Long branchId, Long cardNo) {
        this.bookId = bookId;
        this.branchId = branchId;
        this.cardNo = cardNo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookLoansId)) return false;
        BookLoansId that = (BookLoansId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId()) &&
                Objects.equals(getCardNo(), that.getCardNo());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId(), getCardNo());
    }
}
