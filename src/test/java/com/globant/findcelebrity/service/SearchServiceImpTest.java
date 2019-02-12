package com.globant.findcelebrity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globant.findcelebrity.ConstantTest;
import com.globant.findcelebrity.dto.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceImpTest {
	
	@Autowired
	private SearchService searchService;

	@Test
	public void testGenerateMatrixInformationAboutPeople() {
		int numberOfPeople = 4;
		int[][] matrix = searchService.informationAboutPeople(numberOfPeople);
		assertNotNull(matrix);
		assertTrue(numberOfPeople==matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			assertEquals(matrix[i][i], 0);
		}		
	}
	
	@Test
	public void testFindTheCelebrityWithRandomMatrix() {	
		Deque<Person> peopleList = new ArrayDeque<Person>();
		peopleList.push(new Person(ConstantTest.PERSON1, 0));
		peopleList.push(new Person(ConstantTest.PERSON2, 1));
		peopleList.push(new Person(ConstantTest.PERSON3, 2));
		
		Person celebrity = searchService.findTheCelebrity(peopleList, searchService.informationAboutPeople(peopleList.size()));
		
		assertNotNull(celebrity);
		assertTrue(celebrity.getName().equals(ConstantTest.PERSON1)||celebrity.getName().equals(ConstantTest.PERSON2)||celebrity.getName().equals(ConstantTest.PERSON3));
	}
	
}
