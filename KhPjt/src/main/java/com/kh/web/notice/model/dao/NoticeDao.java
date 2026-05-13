package com.kh.web.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.common.model.dto.NoticePageInfo;
import com.kh.web.notice.model.dto.NoticeDto;

public class NoticeDao {

	public int selectNoticeCount(SqlSession sqlSession) {
		return sqlSession.selectOne("noticeMapper.selectNoticeCount");
	}

	public List<NoticeDto> selectNoticeList(SqlSession sqlSession, NoticePageInfo pi) {
		return sqlSession.selectList("noticeMapper.selectNoticeList", pi);
	}

	public NoticeDto selectNoticeCount(SqlSession sqlSession, Long noticeNo) {
		return sqlSession.selectOne("noticeMapper.selectNotice", noticeNo);
	}

}
