package com.globant.findcelebrity.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.globant.findcelebrity.constant.Constant;
import com.globant.findcelebrity.dto.Person;

@Service
public class FileServiceImp implements FileService {

	private static Logger logger = Logger.getLogger(FileServiceImp.class.getSimpleName());

	public boolean validateFile(MultipartFile file) {
		return file != null && !file.isEmpty() && Constant.TEXT.equals(file.getContentType()) ? true : false;
	}

	public Deque<Person> processFileToDeque(InputStream inputStream) {
		Deque<Person> peopleList = null;
		BufferedReader buffReader;
		int index = 0;
		String line;
		try {
			peopleList = new ArrayDeque<Person>();
			buffReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = buffReader.readLine()) != null) {
				if (!line.trim().isEmpty() && !(line.trim().length() > 15)) {
					Person person = new Person(line.trim(), index);
					peopleList.push(person);
					index++;
				}
			}

		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
		return peopleList;
	}

	@Override
	public List<String> processFileToList(InputStream inputStream) {
		List<String> peopleList = null;
		BufferedReader buffReader;
		String line;
		try {
			peopleList = new ArrayList<String>();
			buffReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = buffReader.readLine()) != null) {
				if (!line.trim().isEmpty() && !(line.trim().length() > 15)) {
					peopleList.add(line.trim());
				}
			}

		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
		return peopleList;
	}

}
