package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

public class UserIdPwService implements IUserService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nick = request.getParameter("nick");
		String no = "조회되는 아이디와 비밀번호가 없습니다.";
		userDAO dao = userDAO.getInstance();
		userVO user = dao.userIdcheck(nick);
		System.out.println(user);
		if(user.getuId() != null) {
			request.setAttribute("user", user);
		} else {
			request.setAttribute("no", no);
		}
		
	}

}
