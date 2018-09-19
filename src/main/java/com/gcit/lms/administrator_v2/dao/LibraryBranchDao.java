package com.gcit.lms.administrator_v2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.administrator_v2.model.LibraryBranch;

@Repository
public interface LibraryBranchDao extends JpaRepository<LibraryBranch, Long> {

}
