package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

public class UserDeleteCheckService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uId = request.getParameter("uId");
		userDAO dao = userDAO.getInstance();
		userVO user  = dao.getUserDetail(uId);
		System.out.println(user);
		request.setAttribute("user", user);
		
		
	}
}
