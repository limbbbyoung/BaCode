package kr.co.bacode;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;
import kr.co.bacode.domain.userDAO;
import kr.co.bacode.domain.userVO;

/**
 * Servlet implementation class getUserDetail
 */
@WebServlet("/getUserDetail")
public class GetUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("s_id");
		String uId = request.getParameter("uId");
		userDAO dao = userDAO .getInstance();
		userVO user = dao.getUserDetail(id);
		System.out.println(user);
		request.setAttribute("user", user);
		request.setAttribute("id", id);
		RequestDispatcher dp = request.getRequestDispatcher("/user/getUserDetail.jsp");
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
