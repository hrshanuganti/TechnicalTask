package com.example.expertisetestoutline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.expertisetestoutline.model.BookStore;

public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
	
	@Query(value = "select a from BookStore a where id = :id")
	BookStore findById(@Param(value = "id") Long id);

	@Query(value = "select a from BookStore a where category = :category")
	BookStore findByCategory(@Param(value = "category")String category);

	

}
