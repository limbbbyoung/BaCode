package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SOSInsert
 */
@WebServlet("/SOSInsertForm")
public class SOSInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SOSInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strpostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strpostNum);
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("s_id");
		request.setAttribute("uId", uId);
		request.setAttribute("postNum", postNum);
		RequestDispatcher dp = request.getRequestDispatcher("/SOS/SOSInsertForm.jsp");
		dp.forward(request, response);
	}

}
