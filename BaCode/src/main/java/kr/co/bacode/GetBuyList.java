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
import kr.co.bacode.domain.BuyDAO;
import kr.co.bacode.domain.BuyVO;

/**
 * Servlet implementation class GetBuyList
 */
@WebServlet("/getBuyList")
public class GetBuyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBuyList() {
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
		BuyDAO dao = BuyDAO.getInstance();
		List<BuyVO> buyList = dao.getBuyList(uId);
		System.out.println(buyList);
		
		BoardDAO boardDao = BoardDAO.getInstance();
		BoardVO board = boardDao.getBoardDetail(postNum);
		request.setAttribute("board" , board);
		request.setAttribute("buyList", buyList);
		RequestDispatcher dp = request.getRequestDispatcher("/buy/getBuyList.jsp");
		dp.forward(request, response);
	}


}

