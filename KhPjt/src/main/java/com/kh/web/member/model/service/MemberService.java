package com.kh.web.member.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.web.common.Template;
import com.kh.web.member.model.dao.MemberDao;
import com.kh.web.member.model.dto.MemberDto;

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

    public int updateMember(Map<String, String> map) {
        SqlSession sqlSession = Template.getSqlSession();

        sqlSession.close();

        return 0;
    }

    public MemberDto login(MemberDto member) {
        SqlSession sqlSession = Template.getSqlSession();

        MemberDto loginMember = md.login(sqlSession, member);
        
        sqlSession.close();
        
        return loginMember;
    }

}