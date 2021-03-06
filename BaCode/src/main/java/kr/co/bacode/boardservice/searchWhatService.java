package kr.co.bacode.boardservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.BoardDAO;
import kr.co.bacode.domain.BoardVO;

public class searchWhatService implements IBoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ui = " ";
		// 페이징 처리
		String strPageNum = request.getParameter("pageNum");
		String searchWhat = request.getParameter("search_name"); // 카테고리 이름 가져오기
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
			HttpSession session = request.getSession();
			session.setAttribute("searchWhat", searchWhat);
			ui = "/board/mouseList.jsp";
		} else if(searchWhat.equals("키보드")) {
			List<BoardVO> categoboardList = dao.getBoardListCatego(searchWhat ,pageNum);
			request.setAttribute("boardList", categoboardList);
			HttpSession session = request.getSession();
			session.setAttribute("searchWhat", searchWhat);
			ui = "/board/keyboardList.jsp";
		} else if(searchWhat.equals("노트북")) {
			List<BoardVO> categoboardList = dao.getBoardListCatego(searchWhat ,pageNum);
			request.setAttribute("boardList", categoboardList);
			HttpSession session = request.getSession();
			session.setAttribute("searchWhat", searchWhat);
			ui = "/board/notebookList.jsp";
		} else {
			ui = "/board/failSearch.jsp";
		}
		System.out.println("이동할 주소 : " + ui);
		request.setAttribute("UI", ui);
	}

}
