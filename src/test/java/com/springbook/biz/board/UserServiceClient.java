package com.springbook.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup
		UserService userService =
				(UserService) container.getBean("userService");
		System.out.println("userService"+userService);
		// 3. 로그인 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");
		UserVO user = userService.getUser(vo);
		System.out.println("user="+user);
		
//		if(user != null) {
//			System.out.println(user.getName() + "님 환영합니다.");
//		} else {
//			System.out.println("로그인 실패");
//		}
		
		// 4.Spring 컨테이너 종료
		container.close();
	}
}
