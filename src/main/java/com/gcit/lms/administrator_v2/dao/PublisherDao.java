package com.gcit.lms.administrator_v2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.Author;
import com.gcit.lms.administrator_v2.model.Publisher;

@Repository
public interface PublisherDao extends JpaRepository<Publisher, Long> {
	
	@Query("Select p From Publisher p where p.publisherName=?1")
	Publisher findByPublisherName(String publisherName);
}
