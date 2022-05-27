package kr.co.bacode.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.ManagerDAO;
import kr.co.bacode.domain.ManagerVO;
import kr.co.bacode.domain.userDAO;
import kr.co.bacode.service.AnswerRightService;
import kr.co.bacode.service.DvCheckService;
import kr.co.bacode.service.GetUserDetailService;
import kr.co.bacode.service.IUserService;
import kr.co.bacode.service.MainSearchService;
import kr.co.bacode.service.UserDeleteCheckService;
import kr.co.bacode.service.UserDeleteService;
import kr.co.bacode.service.UserIdFormService;
import kr.co.bacode.service.UserIdPwService;
import kr.co.bacode.service.UserInsertService;
import kr.co.bacode.service.UserLoginCheckService;
import kr.co.bacode.service.UserLoginService;
import kr.co.bacode.service.UserLogoutService;
import kr.co.bacode.service.UserUpdateFormService;
import kr.co.bacode.service.UserUpdateService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("*.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ui = null;
		userDAO dao = userDAO.getInstance();
		IUserService sv = null;
		int ran = (int)(Math.random() * 3) + 1;
		
		if(uri.equals("/BaCode/userLogin.do")) {
			sv = new UserLoginService();
			sv.execute(request, response);
			ui = "/user/userLoginForm.jsp";
		} else if(uri.equals("/BaCode/userLoginCheck.do")) {
			sv = new UserLoginCheckService();
			sv.execute(request, response);
			ui = "/mainSearch.do";
		} else if(uri.equals("/BaCode/dvCheck.do")) {
			sv = new DvCheckService();
			sv.execute(request, response);
			ui = "/user/" + ran + ".jsp";
		} else if(uri.equals("/BaCode/answerRight.do")) {
			sv = new AnswerRightService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("UI");
		} else if(uri.equals("/BaCode/userLogout.do")) {
			sv = new UserLogoutService();
			sv.execute(request, response);
			ui = "/userLogin.do";
		} else if(uri.equals("/BaCode/userInsert.do")) {
			sv = new UserInsertService();
			sv.execute(request, response);
			ui = "/user/userWelcome.jsp";
		} else if(uri.equals("/BaCode/getUserDetail.do")) {
			sv = new GetUserDetailService();
			sv.execute(request, response);
			ui = "/user/getUserDetail.jsp";
		} else if(uri.equals("/BaCode/userUpdateForm.do")) {
			sv = new UserUpdateFormService();
			sv.execute(request, response);
			ui = "/user/userUpdateForm.jsp";
		} else if(uri.equals("/BaCode/userUpdate.do")) {
			sv = new UserUpdateService();
			sv.execute(request, response);
			ui = "getUserDetail.do?uId=" + request.getParameter("uId");
		} else if(uri.equals("/BaCode/userIdPw.do")) {
			sv = new UserIdPwService();
			sv.execute(request, response);
			ui = "/user/userIdPwOk.jsp";
		} else if(uri.equals("/BaCode/userIdForm.do")) {
			sv = new UserIdFormService();
			sv.execute(request, response);
			ui = "/user/userIdsearch.jsp";
		} else if(uri.equals("/BaCode/mainSearch.do")) {
			sv = new MainSearchService();
			sv.execute(request, response);
			ui = "/user/mainSearch.jsp";
		} else if(uri.equals("/BaCode/mainSearchManagerVer.do")) {
			sv = new MainSearchService();
			sv.execute(request, response);
			ui = "/user/mainSearchManagerVer.jsp";
		} else if(uri.equals("/BaCode/userDeleteCheck.do")) {
			sv = new UserDeleteCheckService();
			sv.execute(request, response);
			ui = "/user/userDeleteCheck.jsp";
		} else if(uri.equals("/BaCode/userDelete.do")) {
			sv = new UserDeleteService();
			sv.execute(request, response);
			ui = "userLogin.do";
		}
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		System.out.println("받아온 주소 값 : " + ui);
		dp.forward(request, response);
	}

}
