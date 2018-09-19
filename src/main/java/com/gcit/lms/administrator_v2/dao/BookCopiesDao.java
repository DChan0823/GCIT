package com.gcit.lms.administrator_v2.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.BookCopies;
import com.gcit.lms.administrator_v2.model.BookCopiesId;

@Repository
public interface BookCopiesDao extends JpaRepository<BookCopies, BookCopiesId> {
	
	@Query("Select bc From BookCopies bc where bc.bkcpyId.bookId = ?1 and bc.bkcpyId.branchId = ?2")
	Optional<BookCopies> findByBookCopyId(Long bookId, Long branchId);
	
	@Transactional
	@Modifying
	@Query("Delete From BookCopies bc where bc.bkcpyId.bookId = ?1 and bc.bkcpyId.branchId = ?2")
	//Optional<BookLoans> deleteByBookLoansId(Long bookId, Long branchId, Long cardNo);
	void deleteByBookCopyId(Long bookId, Long branchId);
}
