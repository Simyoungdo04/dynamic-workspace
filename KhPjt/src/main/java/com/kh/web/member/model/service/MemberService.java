package com.kh.web.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.common.Template;
import com.kh.web.member.model.dao.MemberDao;
import com.kh.web.member.model.dto.MemberDto;
<<<<<<< HEAD
=======
import com.kh.web.member.model.dto.UpdatePwdDto;
>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76

public class MemberService {

    private MemberDao md = new MemberDao();

    public void validate(MemberDto member) {
        if (member.getUserId() == null || member.getUserId().trim().isEmpty()) {
            throw new RuntimeException();
        }
        String pattern = "^[a-zA-Z0-9]{5,30}";
        if (!member.getUserId().matches(pattern)) {

        }
    }

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

<<<<<<< HEAD
    public int updateMember(Map<String, String> map) {
        SqlSession sqlSession = Template.getSqlSession();

        sqlSession.close();

        return 0;
=======
    public MemberDto updateMember(Map<String, String> map) {
    	MemberDto member = null;
        SqlSession sqlSession = Template.getSqlSession();
        
        int result = md.updateMember(sqlSession, map);
        
        if(result > 0) {
        	sqlSession.commit();
        	member = md.selectMember(sqlSession, Long.parseLong(map.get("userNo")));
        }
        sqlSession.close();

        return member;
>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76
    }

    public MemberDto login(MemberDto member) {
        SqlSession sqlSession = Template.getSqlSession();

        MemberDto loginMember = md.login(sqlSession, member);
        
        sqlSession.close();
        
        return loginMember;
    }

<<<<<<< HEAD
=======
	public int updatePassword(UpdatePwdDto upd) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = md.updatePassword(sqlSession, upd);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
	}

	public int deleteMember(MemberDto member) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.deleteMember(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
	}

>>>>>>> 6ed84d0a9c437f70a96faf9686f3ba8d1aa30f76
}