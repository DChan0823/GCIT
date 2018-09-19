package com.gcit.lms.administrator_v2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
	
	@Query("Select a From Author a where a.authorName=?1")
	Author findByAuthorName(String authorName);
}
