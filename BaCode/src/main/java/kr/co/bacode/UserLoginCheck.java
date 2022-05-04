package kr.co.bacode;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

/**
 * Servlet implementation class userLoginCheck
 */
@WebServlet("/userLoginCheck")
public class UserLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			} else { 
				reUrl = "http://localhost:52525/BaCode/user/loginIdPwFail.jsp";
			}
		} else {
			reUrl = "http://localhost:52525/BaCode/user/loginIdPwFail.jsp";
		}
		
		response.sendRedirect(reUrl);
	}

}
