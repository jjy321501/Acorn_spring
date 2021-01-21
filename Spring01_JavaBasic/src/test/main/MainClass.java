package test.main;

import test.mypac.Weapon;
import test.mypac.WeaponImpl;
/*
 * [ 객체 혹은 클래스 사이의 의존관계를 느슨하게 하는 방법 ]
 * 
 * 1. 인터페이스 type 을 적극 활용한다.
 * 2. 필요한 의존 객체를 직접생성(new) 하지 않는다.
 * 3. 필요한 의존 객체를 다른 곳에서 받아서 사용한다.
 */
public class MainClass {
	public static void main(String[] args) {
		//무언가를 공격해야한다. 어떻게 코딩하면될까
		
		//공격하기 위해 필요한객체(의존객체)를 직접 생성(new)해서
		Weapon w1=new WeaponImpl();
		//해당객체의 메소드를 호출함으로써 목적을 달성했다.
		w1.attack();
	}
}
