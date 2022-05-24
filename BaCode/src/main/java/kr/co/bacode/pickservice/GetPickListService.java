package kr.co.bacode.pickservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.bacode.domain.BoardButtonDTO;
import kr.co.bacode.domain.PickDAO;
import kr.co.bacode.domain.PickVO;

public class GetPickListService implements IPickService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("s_id");
		// String strPostNum = request.getParameter("postNum");
		// int postNum = Integer.parseInt(strPostNum);
		String strPageNum = request.getParameter("pageNum");
		int pageNum = 1;
		if(strPageNum != null) {
		    pageNum = Integer.parseInt(strPageNum);
		} 
		PickDAO dao = PickDAO.getInstance();
		int pickCount = dao.getPickCount(uId);
	    BoardButtonDTO buttons = new BoardButtonDTO(pickCount, pageNum); 
	    request.setAttribute("buttons", buttons);
	    
	    List<PickVO> pickList = dao.getPickList(uId, pageNum);
		System.out.println(pickList);
		request.setAttribute("pickList", pickList);
		
		//BoardDAO boardDao = BoardDAO.getInstance();
		//BoardVO board = boardDao.getBoardDetail(postNum);
		//request.setAttribute("board" , board);
		request.setAttribute("pickList", pickList);
	}

}
