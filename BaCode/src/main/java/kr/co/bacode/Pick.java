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
import kr.co.bacode.domain.PickVO;

/**
 * Servlet implementation class Pick
 */
@WebServlet("/pick")
public class Pick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		  
	
		
	
		BoardDAO dao1 = BoardDAO.getInstance();
		
		String pickUid = request.getParameter("pickId");
		String strPickNum = request.getParameter("postNum");
		String title = request.getParameter("title");
		int pickNum = Integer.parseInt(strPickNum);
		PickDAO dao = PickDAO.getInstance();
		dao.insertPick(pickNum, pickUid, title);
		
		BoardVO board = dao1.getBoardDetail(pickNum);
		request.setAttribute("board" , board);
		
		PickVO pick = dao.getPickList(pickNum, pickUid);
		request.setAttribute("pick", pick);
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardDetail.jsp");
		dp.forward(request, response);	
		//response.sendRedirect("http://localhost:52525/BaCode/getBoardDetail?postnum=" + pickNum);
	    
		
		
	}

}
