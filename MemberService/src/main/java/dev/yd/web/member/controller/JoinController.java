package dev.yd.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.yd.web.member.model.dto.MemberDto;
import dev.yd.web.member.model.service.MemberService;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
	    String userPwd = request.getParameter("userPwd");
	    String userName = request.getParameter("userName");
	    String email = request.getParameter("email");
	    
	    MemberDto member = new MemberDto(userId, userPwd, userName, email);
	    
	    int result = new MemberService().insertMember(member);
	    
	    if(result > 0) {
	    		response.sendRedirect("/0do");
	    } else {
	    		request.setAttribute("errorMsg", "회원가입 실패");
	    		request.getRequestDispatcher("/enroll.do").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
