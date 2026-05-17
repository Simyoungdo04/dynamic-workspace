package com.kh.web.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.web.common.model.dto.NoticePageInfo;
import com.kh.web.notice.model.dto.NoticeDto;
import com.kh.web.notice.model.service.NoticeService;

@WebServlet("/notice.do")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int noticeLimit;
		int maxPage = 0;
		int startPage; 
		int endPage;
		
		listCount = new NoticeService().selectNoticeCount();
		
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			response.sendRedirect("http://localhost:8088/kh/notice.do?page=1");
			return;
		}
		if(currentPage <= 0) {
			response.sendRedirect("http://localhost:8088/kh/notice.do?page=1");
			return;
		}
		
		pageLimit = 3;
		noticeLimit = 3;
		maxPage = (int)Math.ceil((double)listCount / noticeLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		int offset = (currentPage - 1) * noticeLimit;
		
		NoticePageInfo pi = new NoticePageInfo(listCount, currentPage, pageLimit, noticeLimit, startPage, endPage, maxPage, offset);
		// System.out.println(pi);
		
		List<NoticeDto> notices = new NoticeService().selectNoticeList(pi);
		
		// System.out.println(notices);
		
		request.setAttribute("pi", pi);
		request.setAttribute("notices", notices);
		
		request.getRequestDispatcher("/WEB-INF/views/notice/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
