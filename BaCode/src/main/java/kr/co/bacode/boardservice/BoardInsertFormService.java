package kr.co.bacode.boardservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoardInsertFormService implements IBoardService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 String uId = (String)session.getAttribute("s_id");
		 request.setAttribute("uId", uId);
	}

}
