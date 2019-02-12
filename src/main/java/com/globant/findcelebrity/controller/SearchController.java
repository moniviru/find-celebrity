package com.globant.findcelebrity.controller;

import java.util.Deque;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.globant.findcelebrity.constant.Constant;
import com.globant.findcelebrity.dto.Person;
import com.globant.findcelebrity.service.FileService;
import com.globant.findcelebrity.service.OutputViewService;
import com.globant.findcelebrity.service.SearchService;

@Controller
@RequestMapping("search")
public class SearchController {
	
	private static Logger logger = Logger.getLogger(SearchController.class.getSimpleName());

	@Autowired
	private SearchService searchService;

	@Autowired
	private FileService fileService;
	
	@Autowired
	private OutputViewService outputViewService;

	@GetMapping("/celebrity")
	public String showView() {
		return Constant.UPLOAD_FORM;
	}

	@PostMapping("/uploadFile")
	public String uploadPeopleFile(@RequestParam("file") MultipartFile file, Model theModel) {
		String output = Constant.ERROR;
		List<String> listToPrint;
		Deque<Person> peopleList;
		Person celebrity;
		int[][] peopleResultMatrix = null;
		if(fileService.validateFile(file)) {
			try {
				peopleList = fileService.processFileToDeque(file.getInputStream());
				if (peopleList != null && !peopleList.isEmpty()) {			
					listToPrint = fileService.processFileToList(file.getInputStream());
					peopleResultMatrix = searchService.informationAboutPeople(peopleList.size());
					celebrity = searchService.findTheCelebrity(peopleList, peopleResultMatrix);
					theModel.addAttribute(Constant.ATTRIBUTE_CELEBRITY, celebrity);
					theModel.addAttribute(Constant.ATTRIBUTE_MATRIX, printMatrix(peopleResultMatrix, listToPrint));
					output = Constant.SUCCESS;
				}
			}catch(Exception e) {
				logger.warning(e.getMessage());
			}			
		}
		return output;
	}

	/**
	 * Print Matrix in the HTML page
	 * 
	 * @param matrix: Results of the question: ¿Do you know him/her? 0:No, 1:Yes
	 * @param listToPrint: Initial list of people
	 * @return HTML code with the table for the matrix
	 */
	private String printMatrix(int[][] matrix, List<String> listToPrint) {
		return outputViewService.printMatrixWithList(matrix, listToPrint);
	}
}
