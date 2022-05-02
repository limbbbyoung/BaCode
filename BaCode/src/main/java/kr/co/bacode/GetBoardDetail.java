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

/**
 * Servlet implementation class getBoardDetail
 */
@WebServlet("/getBoardDetail")
public class GetBoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strBoardNum = request.getParameter("postnum");
		int boardNum = Integer.parseInt(strBoardNum);
		System.out.println("조회된 번호 : " + boardNum);  
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO board = dao.getBoardDetail(boardNum);
		request.setAttribute("board" , board);
		RequestDispatcher dp = request.getRequestDispatcher("/board/boardDetail.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
