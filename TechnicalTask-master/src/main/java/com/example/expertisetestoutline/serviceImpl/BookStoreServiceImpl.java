package com.example.expertisetestoutline.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expertisetestoutline.model.Authors;
import com.example.expertisetestoutline.model.BookStore;
import com.example.expertisetestoutline.repositories.BookStoreRepository;
import com.example.expertisetestoutline.request.BookStoreRequest;
import com.example.expertisetestoutline.service.BookStoreService;

@Service
public class BookStoreServiceImpl implements BookStoreService {
	
	@Autowired
	BookStoreRepository bookStoreRepo;

	@Transactional
	@Override
	public BookStore createBook(BookStoreRequest request) {
		
		BookStore book = new BookStore();
		book.setYear(request.getYear());
		book.setTitle(request.getTitle());
		book.setPrice(request.getPrice());
		book.setCategory(request.getCategory());
		if (request.getAuthors() != null) {
			Authors authors = new Authors();
			authors.setAuthor(request.getAuthors().getAuthor());
			book.setAuthors(authors);
			}
		BookStore save = bookStoreRepo.save(book);
		return save;
	}
	
	

}
