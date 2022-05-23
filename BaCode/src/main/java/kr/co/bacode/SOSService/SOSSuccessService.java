package kr.co.bacode.SOSService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bacode.domain.SOSDAO;

public class SOSSuccessService implements ISOSService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strStNum = request.getParameter("stNum");
		int stNum = Integer.parseInt(strStNum);
		SOSDAO sdao = SOSDAO.getInstance();
		// 여기서 처리 완료되었을 때 일반적인 게시판 기능과 달리 삭제 기능이 아닌 postcheck 여부를 true로 바꿔주는 
		// DAO에서의 메서드가 필요하고 해당 메서드가 실행되어야한다.
		int successNum = sdao.SOSSuccessUpdate(stNum);
	}

}
