package com.kh.web.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.board.model.dao.BoardDao;
import com.kh.web.board.model.dto.AttachmentDto;
import com.kh.web.board.model.dto.BoardDto;
import com.kh.web.board.model.dto.BoardResponse;
import com.kh.web.common.Template;
import com.kh.web.common.model.dto.PageInfo;

public class BoardService {
	
	private BoardDao bd = new BoardDao();

	public int selectBoardCount() {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = bd.selectBoardCount(sqlSession);
		
		sqlSession.close();
			
		return listCount;
	}

	public List<BoardDto> selectBoardList(PageInfo pi) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		List<BoardDto> boards = bd.selectBoardList(sqlSession, pi);
		
		sqlSession.close();
		
		return boards;
	}

	public int insertBoard(BoardDto board, AttachmentDto at) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		String newTitle = board.getBoardTitle().replaceAll("<", "&lt;");
		board.setBoardTitle(newTitle);
		// INSERT를 두 번
		// BOARD테이블에 한 번 => 무조건
		
		int result = bd.insertBoard(sqlSession, board);
		int atResult = 1;
		// ATTACHMENT테이블에 한 번 => 파일이 존재할때만
		if(at != null) {
			at.setRefBno(board.getBoardNo());
			atResult = bd.insertAttachment(sqlSession, at);
		}
		
		// 트랜잭션 처리 => 두 개의DML구문을 하나의 트랜잭션으로 묶어서 처리
		if(result * atResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		
		return (result * atResult);
	}

	public BoardResponse selectBoard(Long boardNo) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		// DB에 3번 가야함
		// UPDATE => 조회수 증가 => commit
		// SELECT => BOARD
		// SELECT => ATTACHMENT
		
		int result = bd.increaseCount(sqlSession, boardNo);
		
		BoardResponse br = null;
		if(result > 0) {
			sqlSession.commit();
			BoardDto board = bd.selectBoard(sqlSession, boardNo);
			AttachmentDto attachment = bd.selectAttchment(sqlSession, boardNo);
			
			br = new BoardResponse();
			br.setBoard(board);
			br.setAttachment(attachment);
		}
		sqlSession.close();
		return br;
	}

	public int deleteBoard(BoardDto board) {
		SqlSession sqlSession = Template.getSqlSession();
		
		// 삭제요청을 보낸 사용자가 로그인도 안 하고 요청을 함 => Servlet에서 처리함
		// 삭제요청을 보낸 사용자가 BOARD의 작성자랑 다르다 => 요청보낸 사용자의 유저NO가 게시글의 작성자의 유저NO와 동일한가
		BoardDto boardResult = bd.selectBoard(sqlSession, board.getBoardNo());
		
		if(boardResult.getUserNo().longValue() != board.getUserNo().longValue()) {
			return 0;
		}
		// 1. BOARD한행 STATUS를 Y로 UPDATE해야함
		int result = bd.deleteBoard(sqlSession, board);
		
		AttachmentDto attachment = bd.selectAttchment(sqlSession, board.getBoardNo());
		if(attachment != null) {
			result *= bd.deleteAttachment(sqlSession, board.getBoardNo());
		}
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}
	
	

}
