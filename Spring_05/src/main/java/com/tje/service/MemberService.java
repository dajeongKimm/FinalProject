package com.tje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tje.dao.*;
import com.tje.model.*;
import java.util.*;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	
	public int getRecordCount() {
		return this.dao.getRecordCount();
	}
	
	public List<Member> selectList(){
		return this.dao.selectList();
	}
	
	public Member selectOne(Member member){
		return this.dao.selectOne(member);
	}
	
	public int insert(Member member) {
		return this.dao.insert(member);
	}
	
	public int deleteOne(Member member) {
		return this.dao.deleteOne(member);
	}
	
}
