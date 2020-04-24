package com.example.expertisetestoutline.service;

import com.example.expertisetestoutline.model.BookStore;
import com.example.expertisetestoutline.request.BookStoreRequest;

public interface BookStoreService {

	BookStore createBook(BookStoreRequest request);

}
