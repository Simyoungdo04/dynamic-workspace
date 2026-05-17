package dev.yd.web.member.model.service;

import org.apache.ibatis.session.SqlSession;

import dev.yd.web.common.Template;
import dev.yd.web.member.model.dao.MemberDao;
import dev.yd.web.member.model.dto.MemberDto;

public class MemberService {
	private MemberDao md = new MemberDao();

	public int insertMember(MemberDto member) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = 0;
		
		try {
			result = md.insertMember(sqlSession, member);
			
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}

	public MemberDto selectMember(MemberDto loginMember) {
		SqlSession sqlSession = Template.getSqlSession();
		
		MemberDto member = null;
		
		try {
			member = md.selectMember(sqlSession, loginMember);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return member;
	}
	
}
