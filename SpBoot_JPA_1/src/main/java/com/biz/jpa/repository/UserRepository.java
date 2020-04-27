package com.biz.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.jpa.domain.UserVO;

/*
 * jpa에서 DB CRUD를 쉽게 구현하기 위하여 
 * JPA Repository를 상속받고
 * Generic에 <vo, id의 타입>을 지정
 */
public interface UserRepository extends JpaRepository<UserVO, Long>{


}
