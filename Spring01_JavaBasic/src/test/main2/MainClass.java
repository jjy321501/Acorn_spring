package test.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Weapon;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main2/init.xml");
		/*
		 * 스프링이 객체를 직접 생성해서 관리하는 공간을 Spring Bean Container 라고 한다.
		 * 
		 * 해당 컨테이너에서 참조값을 가지고 올때 type 으로 찾아서 가지고 올 수도 있다.
		 * 
		 * 그렇게 하기 위해서는 .getBean() 메소드를 호출하면서 Class type 을 
		 * 
		 * 인자로 전달하면 된다.
		 * 
		 * Class type 은 타입.class 와 같은 형태로 참조 할 수 있다.
		 */
		Weapon w=context.getBean(Weapon.class);
	}
}
