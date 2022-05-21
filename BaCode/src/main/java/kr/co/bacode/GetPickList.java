package kr.co.bacode;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;
import kr.co.bacode.domain.PickDAO;
import kr.co.bacode.domain.PickVO;

/**
 * Servlet implementation class GetPickList
 */
@WebServlet("/getPickList")
public class GetPickList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPickList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("s_id");
		String strPostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strPostNum);
		PickDAO dao = PickDAO.getInstance();
		List<PickVO> pickList = dao.getPickList(uId);
		System.out.println(pickList);
		
		BoardDAO boardDao = BoardDAO.getInstance();
		BoardVO board = boardDao.getBoardDetail(postNum);
		request.setAttribute("board" , board);
		request.setAttribute("pickList", pickList);
		RequestDispatcher dp = request.getRequestDispatcher("/pick/getPickList.jsp");
		dp.forward(request, response);
	}



}
