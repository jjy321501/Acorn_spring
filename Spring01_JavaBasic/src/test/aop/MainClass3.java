package test.aop;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.util.WritingUtil;

public class MainClass3 {
	
	public static void main(String[] args) {
		//init.xml 문서를 로딩한다 (spring bean container 를 만든다)
		ApplicationContext context=
				new ClassPathXmlApplicationContext("/test/aop/init.xml");
		//spring bean container 에서 WritingUtil type 의 참조값 얻어오기
		WritingUtil util=context.getBean(WritingUtil.class);
		
		util.sendGreet("안녕하세요");
		util.sendGreet("좋은아침");
		util.sendGreet("안녕바보");
		util.sendGreet("똥개야");
	
		String str="하나 바보 두울";
		boolean result=str.contains("바보");
		System.out.println("main 메소드가 종료됩니다");
		
	}
}
