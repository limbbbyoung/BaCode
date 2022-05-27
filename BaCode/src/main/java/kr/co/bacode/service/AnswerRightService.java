package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerRightService implements IUserService {

public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String UI = "";
		String answer = request.getParameter("answer");
		if (answer.equals("helloWorld")) {
			request.setAttribute("answer", answer);
			UI = "/user/userInsertForm.jsp";
			request.setAttribute("UI", UI);
		} else if(answer.equalsIgnoreCase("java")) {
			request.setAttribute("answer", answer);
			UI = "/user/userInsertForm.jsp";
			request.setAttribute("UI", UI);
		} else if(answer.equals("제임스 고슬링")) {
			request.setAttribute("answer", answer);
			UI = "/user/userInsertForm.jsp";
			request.setAttribute("UI", UI);
		} else {
			request.setAttribute("answer", answer);
			UI = "/user/noDv.jsp";
			request.setAttribute("UI", UI);
		}
	}
}
