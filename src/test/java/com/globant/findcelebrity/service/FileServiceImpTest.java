package com.globant.findcelebrity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Deque;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.globant.findcelebrity.ConstantTest;
import com.globant.findcelebrity.dto.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImpTest {
	
	
	@Autowired
	private FileService fileService;
	
	@Test
	public void testProcessFileToDeque() {
		InputStream inputStream = new ByteArrayInputStream(ConstantTest.INPUT1.getBytes());
		Deque<Person> deque = fileService.processFileToDeque(inputStream);
		assertNotNull(deque);
		assertEquals(deque.size(), 3);
	}
	
	@Test
	public void testProcessFileToList() {
		InputStream inputStream = new ByteArrayInputStream(ConstantTest.INPUT2.getBytes());
		List<String> list = fileService.processFileToList(inputStream);
		assertNotNull(list);
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testValidationFileWithNullObject() {
		MultipartFile file = null;
		assertFalse(fileService.validateFile(file));
	}

}
