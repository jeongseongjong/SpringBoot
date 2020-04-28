package com.biz.sec.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biz.sec.domain.UserRole;
import com.biz.sec.domain.UserVO;
import com.biz.sec.repository.UserDao;
import com.biz.sec.repository.UserRoleDao;

import lombok.RequiredArgsConstructor;



/*
 * commandLineRunner 인터페이스를 상속받은 클래스
 * spring boot에서만 사용할 수 있는 특별한 클래스가 되는데
 * 
 * 프로젝트가 시작되는 시점에 어떤 코드를 자동으로 실행하고 싶을 때
 * 작성하는 클래스
 */
@RequiredArgsConstructor
@Component // 사용된 클래스를 자동으로 Bean에 등록
public class AppInit implements CommandLineRunner{

	private final UserDao uDao;
	private final UserRoleDao urDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		UserVO userVO = UserVO.builder()
				.username("jjong")
				.password("12345")
				.build();
		uDao.save(userVO);
		
		UserRole uRole = UserRole.builder()
				.username("jjong")
				.roleName("ADMIN")
				.build();
		urDao.save(uRole);
		
		uRole = UserRole.builder()
				.username("jjong")
				.roleName("USER")
				.build();
		urDao.save(uRole);
	}

	
}
