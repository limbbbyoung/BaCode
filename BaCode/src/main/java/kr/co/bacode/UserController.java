package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.service.AnswerRightService;
import kr.co.bacode.service.DvCheckService;
import kr.co.bacode.service.IUserService;
import kr.co.bacode.service.UserInsertFormService;
import kr.co.bacode.service.UserLoginCheckService;
import kr.co.bacode.service.UserLoginService;

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
		
		if(uri.equals("/BaCode/userLogin.do")) {
			sv = new UserLoginService();
			sv.execute(request, response);
			ui = "/user/userLoginForm.jsp";
		} else if(uri.equals("/BaCode/userLoginCheck.do")) {
			sv = new UserLoginCheckService();
			sv.execute(request, response);
			ui = "/user/mainSearch.jsp";
		} else if(uri.equals("/BaCode/userInsertForm.do")) {
			sv = new UserInsertFormService();
			sv.execute(request, response);
			ui = "/user/userInsertForm.jsp";
		} else if(uri.equals("/BaCode/dvCheck.do")) {
			sv = new DvCheckService();
			sv.execute(request, response);
			ui = "/user/dvCheck.jsp";
		} else if(uri.equals("/BaCode/answerRight.do")) {
			sv = new AnswerRightService();
			sv.execute(request, response);
			ui = "/user/userInsertForm.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}
