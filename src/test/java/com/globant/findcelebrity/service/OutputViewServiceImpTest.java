package com.globant.findcelebrity.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globant.findcelebrity.ConstantTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputViewServiceImpTest {
	
	@Autowired
	private OutputViewService outputViewService;

	@Test
	public void testPrintMatrixWithList() {
		int[][] matrix = {{0,0,0},{1,1,0},{1,0,1}};
		List<String> listToPrint = new ArrayList<>();
		listToPrint.add(ConstantTest.PERSON1);
		listToPrint.add(ConstantTest.PERSON2);
		listToPrint.add(ConstantTest.PERSON3);
		String htmlCode = outputViewService.printMatrixWithList(matrix, listToPrint);
		assertTrue(htmlCode.contains(ConstantTest.TABLE_I) && htmlCode.contains(ConstantTest.TABLE_E));
	}
	
}
