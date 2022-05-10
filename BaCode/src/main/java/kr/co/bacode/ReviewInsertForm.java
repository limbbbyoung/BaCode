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
 * Servlet implementation class ReviewInsertForm
 */
@WebServlet("/reviewInsertForm")
public class ReviewInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		 String uId = (String)session.getAttribute("s_id");
		 String strPostNum = request.getParameter("postNum");
		 int postNum = Integer.parseInt(strPostNum);
		 request.setAttribute("uId", uId);
		 request.setAttribute("postNum", postNum);
		 RequestDispatcher dp = request.getRequestDispatcher("/review/reviewInsertForm.jsp");
	     dp.forward(request, response);
	}

}
