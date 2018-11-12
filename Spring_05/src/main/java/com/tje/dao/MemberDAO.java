package com.tje.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.tje.model.*;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String strNameSpace = "com.tje.model.MemberMapper";
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int getRecordCount() {
		return sqlSession.selectOne(strNameSpace +".count");
	}
	
	public List<Member> selectList(){
		return sqlSession.selectList(strNameSpace + ".allRecord");
	}
	
	public Member selectOne(Member member){
		return sqlSession.selectOne(strNameSpace + ".oneRecord", member);
	}
	
	public int insert(Member member) {
		return sqlSession.insert(strNameSpace+".insert", member);
	}
	
	public int deleteOne(Member member) {
		return sqlSession.delete(strNameSpace+".deleteOne", member);
	}
	
	
}
