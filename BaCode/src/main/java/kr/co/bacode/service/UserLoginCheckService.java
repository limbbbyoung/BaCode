package kr.co.bacode.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.ManagerDAO;
import kr.co.bacode.domain.ManagerVO;
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
	String loginPwFail = null;
	String loginIdFail = null;
	userDAO dao = userDAO.getInstance();
	userVO user = dao.userLoginCheck(formId);
	dbId = user.getuId(); 
	System.out.println(dbId);
	dbPw = user.getuPw();
	
	if(dbId != null && formId.equals(dbId)) {
		if(formPw.equals(dbPw)) {
			HttpSession session = request.getSession();
			session.setAttribute("s_id", formId);
			
			// 운영자전용 페이지로 접속되는 로직
			ManagerDAO mdao = ManagerDAO.getInstance();
			ManagerVO manager = mdao.getManagerDetail(dbId);
			System.out.println(manager);
			String managerId = manager.getuId();
			String notManager = "운영자가 아님";
			if(managerId == null) {
				managerId = notManager;
			}
			if(!managerId.equals(notManager)) {
				// 운영자 전용 페이지로 넘어가라.
				reUrl = "http://localhost:52525/BaCode/user/mainSearchManagerVer.jsp";
				request.setAttribute("reUrl", reUrl);
			} 
		} else { 
			loginPwFail = "pw";
			request.setAttribute("loginPwFail", loginPwFail);
		}
	} else {
		loginIdFail = "id";
		request.setAttribute("loginIdFail" , loginIdFail);

			
	}

	}
}
