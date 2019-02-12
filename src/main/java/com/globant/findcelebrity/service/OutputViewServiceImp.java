package com.globant.findcelebrity.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OutputViewServiceImp implements OutputViewService {

	public String printMatrixWithList(int[][] matrix, List<String> listToPrint) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table>");

		builder.append("<tr><td></td>");
		listToPrint.stream().forEach(e -> builder.append("<td>" + e + "</td>"));
		builder.append("</tr>");

		for (int x = 0; x < matrix.length; x++) {
			builder.append("<tr>");
			builder.append("<td>");
			builder.append(listToPrint.get(x));
			builder.append("</td>");
			for (int y = 0; y < matrix[x].length; y++) {
				builder.append("<td>");
				builder.append(matrix[x][y]);
				builder.append("</td>");
			}
			builder.append("</tr>");
		}
		builder.append("</table>");
		return builder.toString();
	}

}
