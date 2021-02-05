package com.gura.spring05.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gura.spring05.exception.NotAllowException;
import com.gura.spring05.file.dao.FileDao;
import com.gura.spring05.file.dto.FileDto;

@Aspect
@Component
public class FileAspect {
	@Autowired
	private FileDao dao;
	/*
	 * com.gura.spring05.file.service 패키지에 있는
	 * 모든 클래스 중에 delete 로 시작하는 모든 메소드에 적용할 aspect
	 */
	@Around("execution(void com.gura.spring05.file.service.*.delete*(..))")
	public void checkDelete(ProceedingJoinPoint joinPoint) throws Throwable {
		//필요한 값을 담을 지역변수 미리 만들기(메소드에 전달된 인자로부터 찾아야한다)
		int num=0;
		HttpServletRequest request=null;
		//메소드의 인자로 전달된 값을 배열로 얻어내기
		Object[] args=joinPoint.getArgs();
		//반복문 돌면서
		for(Object tmp:args) {
			//필요한 type 을 찾아서 casting 한다
			if(tmp instanceof Integer) {
				//자료실 파일번호
				num=(Integer)tmp;
			}else if(tmp instanceof HttpServletRequest) {
				//HttpSession 을 얻어낼 HttpServletRequest 객체
				request=(HttpServletRequest)tmp;
			}
		}
		//파일 번호를 이용해서 파일정보를 불러온다
		FileDto dto=dao.getData(num);
		//로그인된 아이디 읽어오기
		String id=(String)request.getSession().getAttribute("id");
		//로그인된 아이디와 글작성자가 다르면
		if(!id.equals(dto.getWriter())) {
			//예외 발생시키기
			throw new NotAllowException("남의 파일은 삭제할수 없습니다.");
		}
		
		joinPoint.proceed();
	}
}
