package com.gura.spring04.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dao.MemberDao;
import com.gura.spring04.member.dto.MemberDto;

@Controller
public class MemberController {
	// MemberDao 인터페이스 type 을 주입(DI) 받아서 사용한다.
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		//1. 회원 목록을 얻어온다.
		List<MemberDto> list=dao.getList();
		//2. 회원 목록을 request scope 에 담고 view page 로 forward 이동해서 응답
		mView.addObject("list", list);
		mView.setViewName("member/list");
		return mView;
	}
}