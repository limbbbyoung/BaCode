package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;

public class UserInsertService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("가입시작");
		// DAO 생성 및 싱글턴 패턴 
		userDAO dao = userDAO.getInstance();
        // Form에서 데이터 받아오기
		String uId = request.getParameter("uId");
		String uPw = request.getParameter("uPw");
		String uName = request.getParameter("uName");
		String email = request.getParameter("email");
		String pNum = request.getParameter("pNum");
		String addr = request.getParameter("addr");
		String nckName = request.getParameter("uckName");
		// DAO에서 회원가입 메서드 실행
		dao.joinUser(uId, uPw, uName, email, pNum, addr, nckName);
		
	
		
	}

}
