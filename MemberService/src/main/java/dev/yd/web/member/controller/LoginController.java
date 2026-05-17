package dev.yd.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.yd.web.member.model.dto.MemberDto;
import dev.yd.web.member.model.service.MemberService;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/login-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		MemberDto member = new MemberDto();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		MemberDto loginMember = new MemberService().selectMember(member);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", loginMember);
			response.sendRedirect(request.getContextPath());
			return;
		} else {
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("/WEB-INF/views/member/login-page.jsp").forward(request, response);
		}
	}
}
