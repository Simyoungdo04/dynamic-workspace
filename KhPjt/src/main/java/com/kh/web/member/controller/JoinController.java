package com.kh.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.web.member.model.dto.MemberDto;
import com.kh.web.member.model.service.MemberService;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
	    String userPwd = request.getParameter("userPwd");
	    String userPwdCheck = request.getParameter("userPwdCheck"); // 비밀번호 확인 파라미터
	    String userName = request.getParameter("userName");
	    String email = request.getParameter("email");
	    
	    // 비밀번호 확인
	    if (userPwd == null || !userPwd.equals(userPwdCheck)) {
	        request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
	        request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp")
	               .forward(request, response);
	        return;
	    }
		
		// 전달값 get
//		String userId = request.getParameter("userId");
//		String userPwd = request.getParameter("userPwd");
//		String userName = request.getParameter("userName");
//		String email = request.getParameter("email");
		
		// 가공
		MemberDto member = new MemberDto(userId, userPwd, userName, email);
		
		// 요청 처리 > 서비스 전달
		int result = new MemberService().insertMember(member);
		
		// 성공 / 실패에 따라 응답 화면 다르게
		if(result > 0) {
			// request.getRequestDispatcher("/index.jsp").forward(request, response);
			response.sendRedirect("/kh");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp")
				   .forward(request, response);			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
