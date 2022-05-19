package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerRightService implements IUserService {

public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String answer = request.getParameter("answer");
		if (answer.equals("helloWorld")) {
			request.setAttribute("answer", answer);
		} 
	}
}
