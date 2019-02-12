package com.globant.findcelebrity.service;

import java.util.Deque;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.globant.findcelebrity.dto.Person;

@Service
public class SearchServiceImp implements SearchService {
	
	private Random myRandom = new Random();

	@Override
	public Person findTheCelebrity(Deque<Person> peopleList, int[][] peopleResultMatrix) {		
		Person person1;			
		Person person2;
		
		while(peopleList.size()>1) {
			person1 = peopleList.pop();
			person2 = peopleList.pop();
			
			if(knowsHimHer(peopleResultMatrix, person1, person2)) {
				peopleList.push(person2);
			}else {
				peopleList.push(person1);
			}
		}		
		return peopleList.pop();
	}
	
	private boolean knowsHimHer(int[][] peopleResultMatrix, Person person1, Person person2) {
		return peopleResultMatrix[person1.getIndex()][person2.getIndex()] == 1? true:false;
	}	
	
	/**
	 * I assume that there is always a celebrity in the group of people
	 */
	public int[][] informationAboutPeople(int numberOfPeople) {
		int [][] peopleMatrix = new int[numberOfPeople][numberOfPeople];		
		int celebrity = myRandom.nextInt(numberOfPeople);
		
		for(int i=0; i<numberOfPeople; i++) {
			if(i!=celebrity) {
				peopleMatrix[i][celebrity] = 1;
			}
		}
		for(int i=0; i<numberOfPeople; i++) {
			for(int j=0; j<numberOfPeople; j++) {
				if(i==j) {
					peopleMatrix[i][j] = 0;
				}else if(i!=celebrity && j!=celebrity) {
					peopleMatrix[i][j] =myRandom.nextInt(2);
				}
			}			
		}
		return peopleMatrix;
	}
}
