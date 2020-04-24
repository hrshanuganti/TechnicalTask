package com.example.expertisetestoutline.service;

import com.example.expertisetestoutline.model.Authors;
import com.example.expertisetestoutline.request.AuthorsRequest;

public interface AuthorsService {

	Authors createAuthor(AuthorsRequest request);

}
