package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;

public class UserUpdateService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uId = request.getParameter("uId");
		String uPw = request.getParameter("uPw");
		String uName = request.getParameter("uName");
		String addr = request.getParameter("addr");
		String pNum = request.getParameter("pNum");
		String nckName = request.getParameter("nckName");
		String email = request.getParameter("email");
		userDAO dao = userDAO.getInstance();
		dao.userUpdate(uId, uPw, uName, email, pNum, addr, nckName);
		
	}
}
