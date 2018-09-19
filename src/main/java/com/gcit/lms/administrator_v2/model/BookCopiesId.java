package com.gcit.lms.administrator_v2.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookCopiesId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "bookId")
    private Long bookId;
 
    @Column(name = "branchId")
    private Long branchId;
 
    public BookCopiesId() {
    }
 
    public BookCopiesId(Long bookId, Long branchId) {
        this.bookId = bookId;
        this.branchId = branchId;
    }
 
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookCopiesId)) return false;
        BookCopiesId that = (BookCopiesId) o;
        return Objects.equals(getBookId(), that.getBookId()) &&
                Objects.equals(getBranchId(), that.getBranchId());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBranchId());
    }
}
