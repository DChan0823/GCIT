package com.gcit.lms.administrator_v2.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.BookLoans;
import com.gcit.lms.administrator_v2.model.BookLoansId;

@Repository
public interface BookLoansDao extends JpaRepository<BookLoans, BookLoansId> {

	@Query("Select bl From BookLoans bl where bl.bklnId.bookId = ?1 and bl.bklnId.branchId = ?2 and bl.bklnId.cardNo = ?3")
	Optional<BookLoans> findByBookLoansId(Long bookId, Long branchId, Long cardNo);
	
	@Transactional
	@Modifying
	@Query("Delete From BookLoans bl where bl.bklnId.bookId = ?1 and bl.bklnId.branchId = ?2 and bl.bklnId.cardNo = ?3")
	//Optional<BookLoans> deleteByBookLoansId(Long bookId, Long branchId, Long cardNo);
	void deleteByBookLoansId(Long bookId, Long branchId, Long cardNo);
}
