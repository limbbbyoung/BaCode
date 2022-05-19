package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

public class UserLoginCheckService implements IUserService {
	
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String formId = request.getParameter("userId");
	String formPw = request.getParameter("userPw");
	System.out.println(formId);
	String dbId = null;
	String dbPw = null;
	String reUrl = null;
	userDAO dao = userDAO.getInstance();
	userVO user = dao.userLoginCheck(formId);
	dbId = user.getuId(); 
	System.out.println(dbId);
	dbPw = user.getuPw();
	
	if(dbId != null && formId.equals(dbId)) {
		if(formPw.equals(dbPw)) {
			reUrl = "http://localhost:52525/BaCode/user/mainSearch.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("s_id", formId);
			}
		}
	}
}
