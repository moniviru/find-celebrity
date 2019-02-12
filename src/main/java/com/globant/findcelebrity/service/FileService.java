package com.globant.findcelebrity.service;

import java.io.InputStream;
import java.util.Deque;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.globant.findcelebrity.dto.Person;

public interface FileService {
	
	public boolean validateFile(MultipartFile file); 

	public Deque<Person> processFileToDeque(InputStream inputStream);
	
	public List<String> processFileToList(InputStream inputStream);
}
