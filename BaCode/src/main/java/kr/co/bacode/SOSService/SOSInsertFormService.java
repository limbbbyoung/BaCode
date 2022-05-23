package kr.co.bacode.SOSService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SOSInsertFormService implements ISOSService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strpostNum = request.getParameter("postNum");
		int postNum = Integer.parseInt(strpostNum);
		HttpSession session = request.getSession();
		String uId = (String)session.getAttribute("s_id");
		request.setAttribute("uId", uId);
		request.setAttribute("postNum", postNum);
	}

}
