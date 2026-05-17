package dev.yd.web.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import dev.yd.web.member.model.dto.MemberDto;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, MemberDto member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}

	public MemberDto selectMember(SqlSession sqlSession, MemberDto loginMember) {
		return sqlSession.selectOne("memberMapper.selectMember", loginMember);
	}

}
