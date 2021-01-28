package com.gura.spring04;

import org.springframework.stereotype.Controller;
/*
 *  컨트롤러에서 JSON 문자열을 응답하는 여러가지 방법을 알아보자 
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.member.dto.MemberDto;
@Controller
public class JsonTestController {
	
	@RequestMapping("/json01")
	public ModelAndView json01(ModelAndView mView) {
		//응답할 데이터라고 가정 
		int num=1;
		String name="김구라";
		String addr="노량진";
		/*
		 * 위의 데이터를 이용해서 아래와 같은 JSON 문자열을 클라이언트에게 응답하는게 목적이다.
		 * {"num":1, "name":"김구라", "addr":"노량진"}
		 */
		MemberDto dto=new MemberDto(num, name, addr);
		mView.addObject("dto", dto);
		mView.setViewName("json01");
		return mView;
	}
}