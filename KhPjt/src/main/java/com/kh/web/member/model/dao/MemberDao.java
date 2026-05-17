package com.kh.web.member.model.dao;

<<<<<<< HEAD
import org.apache.ibatis.session.SqlSession;

import com.kh.web.member.model.dto.MemberDto;
=======
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.member.model.dto.MemberDto;
import com.kh.web.member.model.dto.UpdatePwdDto;
>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76

public class MemberDao {

	public int insertMember(SqlSession sqlSession, MemberDto member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}

	public MemberDto login(SqlSession sqlSession, MemberDto member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
<<<<<<< HEAD
=======

	public int updateMember(SqlSession sqlSession, Map<String, String> map) {
		return sqlSession.update("memberMapper.updateMember", map);
	}
	
	public MemberDto selectMember(SqlSession sqlSession, Long userNo) {
		return sqlSession.selectOne("memberMapper.selectMember", userNo);	
	}

	public int updatePassword(SqlSession sqlSession, UpdatePwdDto upd) {
		return sqlSession.update("memberMapper.updatePassword", upd);
	}

	public int deleteMember(SqlSession SqlSession, MemberDto member) {
		return SqlSession.update("memberMapper.deleteMember", member);
	}
>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76
	
}
