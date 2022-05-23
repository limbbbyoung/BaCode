package kr.co.bacode.SOSService;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.SOSDAO;
import kr.co.bacode.domain.SOSVO;

public class GetSOSDetailService implements ISOSService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strStNum = request.getParameter("stNum");
		int stNum = Integer.parseInt(strStNum);
		System.out.println("조회된 번호 : " + stNum);  
		SOSDAO sdao = SOSDAO.getInstance();
		
		SOSVO SOS = sdao.getSOSDetail(stNum);
		request.setAttribute("SOS" , SOS);
	}

}
