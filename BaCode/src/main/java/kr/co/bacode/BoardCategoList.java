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

import com.mysql.cj.Session;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;

/**
 * Servlet implementation class BoardCategoList
 */
@WebServlet("/boardCategoList")
public class BoardCategoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCategoList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징 처리
		String strPageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String searchWhat = (String)session.getAttribute("searchWhat"); // 카테고리 이름 가져오기
		System.out.println(searchWhat);
		// 2. pageNum이 안 들어왔을때 자동으로 1이 getBoardList에 들어가도록 조치해주세요.
		// 위의 strPageNum이 Null이냐 아니냐에 따라 달라져야 하는데 null인 경우 1로 처리하도록
		// null이 아닌 경우는 그냥 바로 해당 페이지를 보여주도록 처리해주세요.
		int pageNum = 1;
		if(strPageNum != null) {
		    pageNum = Integer.parseInt(strPageNum);
		} 
		// DAO는 다시 생성해줘야 합니다.
		BoardDAO dao = BoardDAO.getInstance();
		int boardCount = dao.getBoardCountCatego(searchWhat);// 글 갯수를 얻어오기.
	    BoardButtonDTO buttons = new BoardButtonDTO(boardCount, pageNum); // 밑에 깔아줘야 하는 버튼에 대한 정보 추가
	    
	    // 바인딩해서 넘겨주신 다음, 결과페이지에서 수치정보도 확인해주세요.
	    request.setAttribute("buttons", buttons);
	    
		if (searchWhat.equals("마우스")) {
			List<BoardVO> categoboardList = dao.getBoardListCatego(searchWhat ,pageNum);
			request.setAttribute("boardList", categoboardList);
			request.setAttribute("searchWhat", searchWhat);
			RequestDispatcher dp = request.getRequestDispatcher("/board/mouseList.jsp");
			dp.forward(request, response);
		} else if(searchWhat.equals("키보드")) {
			List<BoardVO> categoboardList = dao.getBoardListCatego(searchWhat ,pageNum);
			request.setAttribute("boardList", categoboardList);
			request.setAttribute("searchWhat", searchWhat);
			RequestDispatcher dp = request.getRequestDispatcher("/board/keyboardList.jsp");
			dp.forward(request, response);
		} else if(searchWhat.equals("노트북")) {
			List<BoardVO> categoboardList = dao.getBoardListCatego(searchWhat ,pageNum);
			request.setAttribute("boardList", categoboardList);
			request.setAttribute("searchWhat", searchWhat);
			RequestDispatcher dp = request.getRequestDispatcher("/board/notebookList.jsp");
			dp.forward(request, response);
		} else {
			// 해당 검색어는 지원하지 않는다는 Alert 띄우기
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
