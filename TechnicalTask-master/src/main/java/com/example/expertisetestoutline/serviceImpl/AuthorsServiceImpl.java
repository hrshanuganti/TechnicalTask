package com.example.expertisetestoutline.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expertisetestoutline.model.Authors;
import com.example.expertisetestoutline.repositories.AuthorsRepository;
import com.example.expertisetestoutline.request.AuthorsRequest;
import com.example.expertisetestoutline.service.AuthorsService;

@Service
public class AuthorsServiceImpl implements AuthorsService{
	
	@Autowired
	private AuthorsRepository authorsRepository;

	@Override
	public Authors createAuthor(AuthorsRequest request) {
		
		Authors authors = new Authors();
		authors.setAuthor(request.getAuthor());
		Authors save = authorsRepository.save(authors);
		return save;
	}
	
	

}
