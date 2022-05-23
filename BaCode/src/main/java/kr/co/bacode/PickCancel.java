package kr.co.bacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.PickDAO;

/**
 * Servlet implementation class PickCancel
 */
@WebServlet("/pickCancel")
public class PickCancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PickCancel() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String strPkNum = request.getParameter("pkNum");
		String pickTitle = request.getParameter("pickTitle");
		int pkNum = Integer.parseInt(strPkNum);
		PickDAO dao = PickDAO.getInstance();
		dao.pickDelete(pkNum, pickTitle);
		
		
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		BoardDAO dao1 = BoardDAO.getInstance();
		BoardVO board = dao1.getBoardDetail(postNum);
		request.setAttribute("board" , board);
		
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardDetail.jsp");
		dp.forward(request, response);
		
	}

}
