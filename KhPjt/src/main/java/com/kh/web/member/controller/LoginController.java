package com.kh.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.web.member.model.dto.MemberDto;
import com.kh.web.member.model.service.MemberService;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1
		request.setCharacterEncoding("UTF-8");
		// 2
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		// 3
		MemberDto member = new MemberDto();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		// 4
		MemberDto loginMember = new MemberService().login(member);
		//5
		/*
		 * session : 모든 JSP와 Servlet에서 값을 꺼내서 쓸 수 있는 저장소
		 * 	  		 단, session에 값이 지워지기 전까지
		 * 			 세션종료시점 : 브라우저 종료, 서버 종료, 코드로 지움
		 * 
		 * request : 해당 request를 포워딩한 JSP에서까지만 쓸 수 있음
		 * 			 요청부터 응답 까지만 사용할 수 있음
		 * 
		 */
		if(loginMember != null) {
			
			// request.setAttribute("userInfo", loginMember);
			// response.sendRedirect("/kh");
			// request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);
<<<<<<< HEAD
=======
			session.setAttribute("alertMsg", "로그인 성공");
>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76
			response.sendRedirect("/kh");
			
		} else {
			request.setAttribute("message", "로그인에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp")
				   .forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
