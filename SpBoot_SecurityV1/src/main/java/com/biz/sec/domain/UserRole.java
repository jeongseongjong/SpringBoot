package com.biz.sec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Entity
@Table(name="tbl_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String roleName;
	
	/*
	 * jpa에서 1:N 관계를 설정하려면
	 * 두 연결된 클래스에 각각 @OneToMany, @ManyToOne을 설정해준다.
	 */
	@ManyToOne
	@JoinColumn(name="username",
			referencedColumnName = "username",
			insertable = false,
			updatable = false)
	private UserVO userVO;
	
}
