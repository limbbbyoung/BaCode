package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

public class GetUserDetailService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("s_id");
		String uId = request.getParameter("uId");
		userDAO dao = userDAO .getInstance();
		userVO user = dao.getUserDetail(id);
		System.out.println(user);
		request.setAttribute("user", user);
		request.setAttribute("id", id);
		
		
		
	}
}
