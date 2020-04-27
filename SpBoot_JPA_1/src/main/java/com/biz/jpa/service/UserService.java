package com.biz.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biz.jpa.domain.UserVO;
import com.biz.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userDao;
	
	/*
	 * JpaRepository를 사용할 경우
	 * insert와 update는 save() method를 사용하여 수행
	 */
	public UserVO save(UserVO userVO) {
		
		/*
		 * repository.save(vo)
		 * JPA 환경에서는 JpaRepositoryfmf extends 함으로서
		 * 자동으로 기본 crud method를 사용할 수 있다.
		 */
		UserVO vo = userDao.save(userVO);
		return vo;
	}

	public List<UserVO> selectAll() {

		List<UserVO> userList = userDao.findAll();
		return userList;
	}

	/*
	 * findById를 실행하고 나면 UserVO를 받을 수 있다.
	 * findById를 실행했을때 결과값이 없으면 null을 return한다.
	 * 이런상황이되면 NPE가 발생할 수 있다.
	 * 
	 * Optional(wrapper class)로 VO 객체를 감싸게 되면
	 * NullPointerException을 회피할 수 있다.
	 * 
	 * 필요한 vo 객체를 추출하려면
	 * optVO.get() method를 사용해야 한다.
	 */
	public Optional<UserVO> findById(long userId) {

		Optional<UserVO> userVO = userDao.findById(userId);
		
		return userVO;
	}

	public void delete(long userId) {
		userDao.deleteById(userId);
		
	}


}
