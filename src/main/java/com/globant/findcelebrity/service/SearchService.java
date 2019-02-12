package com.globant.findcelebrity.service;

import java.util.Deque;

import com.globant.findcelebrity.dto.Person;

public interface SearchService {

	public Person findTheCelebrity(Deque<Person> peopleList, int[][] peopleResultMatrix);
	
	public int[][] informationAboutPeople(int numberOfPeople);
}
