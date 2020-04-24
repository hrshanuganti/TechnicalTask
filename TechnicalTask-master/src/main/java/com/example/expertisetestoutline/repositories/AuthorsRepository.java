package com.example.expertisetestoutline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expertisetestoutline.model.Authors;

public interface AuthorsRepository  extends JpaRepository<Authors, Long> {
	
	@Query(value = "select a from Authors a where id = :id")
	Authors findById(@Param(value = "id") Long id);

}
