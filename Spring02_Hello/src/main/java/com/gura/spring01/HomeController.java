package com.gura.spring01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	// home.do 경로 요청이 오면
	@RequestMapping("/home.do")
	public String home() {
		//WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답하기
		return "home";
	}
	
}
