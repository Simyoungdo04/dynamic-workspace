package com.kh.web.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.web.member.model.dto.MemberDto;
import com.kh.web.member.model.service.MemberService;

@WebServlet("/update.me")
public class UpdateMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UpdateMemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) GET? POST?
		// POST => 인코딩
		// request.setCharacterEncoding("UTF-8");
		// 앞으로 필터로 대체
		
		// 2) 요청 시 전달값을 뽑아서 가동하기
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		
		/*
		 * UPDATE
		 * 		  WEB_MEMBER
		 *	  SET
		 *	      USER_NAME = #{userName}
		 *		 ,EMAIL = #{email}
		 *  WHERE
		 */
		// 2_2) 현재 요청보낸 사용자의 정보 뽑기
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("userInfo");
		Long userNo = member.getUserNo();
		
		// 3) 가공(DTO 없이)
		// Map,List, Set
		// Mao
		/*
		 * Map<Sring Sring> map = new HashMap(); map.put("userName", userName);
		 * map.put("email", email); map.put("userNo", userNo);
		 */
		
		Map<String, String> map = Map.of("userName", userName
										,"email", email
										,"userNo", String.valueOf(userNo));
		
		// 4) Service단 호출
		MemberDto userInfo = new MemberService().updateMember(map);
		
		if(userInfo != null) {
			// member.setEmail(email);
			// member.setUserName(userName);
			session.setAttribute("userInfo", userInfo);
			
			// request.getRequestDispatcher("/WEB-INF/views/member/my_page.jsp").forward(request, response);
			
			response.sendRedirect("/kh/mypage.do");
		} else {
			request.setAttribute("message", "정보수정에 실패했습니다.");
			// request.getRequestDispatcher("/WEB-INF/views/common/fail_page.jsp").forward(request, response);
			response.sendRedirect("/kh/fail.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
