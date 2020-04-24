package com.example.expertisetestoutline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expertisetestoutline.exceptionhandler.GlobalException;
import com.example.expertisetestoutline.model.Authors;
import com.example.expertisetestoutline.model.BookStore;
import com.example.expertisetestoutline.repositories.AuthorsRepository;
import com.example.expertisetestoutline.repositories.BookStoreRepository;
import com.example.expertisetestoutline.request.AuthorsRequest;
import com.example.expertisetestoutline.request.BookStoreRequest;
import com.example.expertisetestoutline.request.UpdateAuthorRequest;
import com.example.expertisetestoutline.request.UpdateBookStoreRequest;
import com.example.expertisetestoutline.service.AuthorsService;
import com.example.expertisetestoutline.service.BookStoreService;
import com.example.expertisetestoutline.service.CommonService;

@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	CommonService commonService;

	@Autowired
	BookStoreService bookStoreService;

	@Autowired
	BookStoreRepository bookStoreRepo;

	@Autowired
	AuthorsService authorsService;

	@Autowired
	private AuthorsRepository authorsRepository;

	@PostMapping("/createBook")
	public ResponseEntity<?> createBook(@Valid @RequestBody BookStoreRequest request, BindingResult bindingResult)
			throws GlobalException {
		commonService.validate(bindingResult);
		BookStore bookStore = bookStoreService.createBook(request);
		return new ResponseEntity<>(bookStore, HttpStatus.OK);

	}

	@GetMapping("/getBooks/{id}")
	public ResponseEntity<?> bookById(@PathVariable("id") Long id) throws GlobalException {
		BookStore response = bookStoreRepo.findById(id);
		if (response == null) {
			throw new GlobalException("400", "Bad Request", "No Records Found, Please Create BOOK ",
					HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	
	
	

	@GetMapping("/bookSearch/{category}")
	public ResponseEntity<?> search(@PathVariable("category")  String category) throws GlobalException {
		BookStore response = bookStoreRepo.findByCategory(category);
		if (response == null) {
			throw new GlobalException("400", "Bad Request", "No Records Found, Please Create BOOK ",
					HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@GetMapping("/deleteBooks/{id}")
	public void deleteById(@PathVariable("id") Long id) throws GlobalException {
		BookStore response = bookStoreRepo.findById(id);
		if (response == null) {
			throw new GlobalException("400", "Bad Request", "No Records Found, Please Create BOOK  to DELETE",
					HttpStatus.BAD_REQUEST);

		}
		bookStoreRepo.delete(response);

	}

	@PostMapping("/updateBook")
	public ResponseEntity<?> updateBook(@Valid @RequestBody UpdateBookStoreRequest request, BindingResult bindingResult)
			throws GlobalException {
		commonService.validate(bindingResult);
		BookStore bookstore = bookStoreRepo.findById(request.getId());
		bookstore.setYear(request.getYear());
		bookstore.setTitle(request.getTitle());
		bookstore.setPrice(request.getPrice());
		bookstore.setCategory(request.getCategory());
		if (request.getAuthors() != null) {
			Authors authors = new Authors();
			authors.setAuthor(request.getAuthors().getAuthor());
			bookstore.setAuthors(authors);
		}
		BookStore save = bookStoreRepo.save(bookstore);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

	@PostMapping("/createAuthor")
	public ResponseEntity<?> createAuthor(@Valid @RequestBody AuthorsRequest request, BindingResult bindingResult)
			throws GlobalException {
		commonService.validate(bindingResult);
		Authors authors = authorsService.createAuthor(request);
		return new ResponseEntity<>(authors, HttpStatus.OK);

	}

	@GetMapping("/getAuthors/{id}")
	public ResponseEntity<?> authorsById(@PathVariable("id") Long id) throws GlobalException {
		Authors response = authorsRepository.findById(id);
		if (response == null) {
			throw new GlobalException("400", "Bad Request", "No Records Found, Please Create Authors ",
					HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/deleteAuthors/{id}")
	public void deleteAuthorsById(@PathVariable("id") Long id) throws GlobalException {
		Authors response = authorsRepository.findById(id);
		if (response == null) {
			throw new GlobalException("400", "Bad Request", "No Records Found, Please Create Author  to DELETE",
					HttpStatus.BAD_REQUEST);

		}
		authorsRepository.delete(response);

	}

	@PostMapping("/updateAuthors")
	public ResponseEntity<?> updateAuthor(@Valid @RequestBody UpdateAuthorRequest request, BindingResult bindingResult)
			throws GlobalException {
		commonService.validate(bindingResult);
		Authors authors = authorsRepository.findById(request.getId());
		authors.setAuthor(request.getAuthor());
		Authors save = authorsRepository.save(authors);
		return new ResponseEntity<>(save, HttpStatus.OK);

	}

}
