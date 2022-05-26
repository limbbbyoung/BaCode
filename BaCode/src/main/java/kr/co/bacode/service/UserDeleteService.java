package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;

public class UserDeleteService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uId = request.getParameter("uId");
		
		userDAO dao = userDAO.getInstance();
		dao.userDelete(uId);
		
	}
}
