package com.tje.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tje.model.Member;
import com.tje.service.*;

@Controller
public class MemberConroller {
	
	@Autowired
	private MemberService service;

	public void setService(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/member/count")
	public String count(Model model) {
		model.addAttribute("count",service.getRecordCount());
		return "member/count";
	}
	
	@RequestMapping("/member/selectList")
	public String selectList(Model model) {
		model.addAttribute("list",service.selectList());
		return "member/list";
	}
	
	@RequestMapping("/member/selectOne")
	public String selectOne(Model model, @RequestParam("id") String id) {
		Member member = new Member();
		member.setId(id);
		
		model.addAttribute("one",service.selectOne(member));
		return "member/one";
	}
	
	@RequestMapping("/member/deleteOne")
	public String deleteOne(Model model, @RequestParam("id") String id) {
		Member member = new Member();
		member.setId(id);
		
		model.addAttribute("deleteResult",service.deleteOne(member));
		return "member/deleteOne";
	}
	
	
}
