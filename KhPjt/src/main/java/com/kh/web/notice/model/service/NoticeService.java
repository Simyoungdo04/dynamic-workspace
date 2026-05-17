package com.kh.web.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.common.Template;
import com.kh.web.common.model.dto.NoticePageInfo;
import com.kh.web.notice.model.dao.NoticeDao;
import com.kh.web.notice.model.dto.NoticeDto;

public class NoticeService {
	
	private NoticeDao nd = new NoticeDao();
	
	public int selectNoticeCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = nd.selectNoticeCount(sqlSession);
		
		sqlSession.close();
			
		return listCount;
	}

	public List<NoticeDto> selectNoticeList(NoticePageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<NoticeDto> notices = nd.selectNoticeList(sqlSession, pi);
		
		sqlSession.close();
		
		return notices;
	}

	public NoticeDto selectNotice(Long noticeNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		NoticeDto notice = nd.selectNoticeCount(sqlSession, noticeNo);
		
		sqlSession.close();
		
		return notice;
	}

}
