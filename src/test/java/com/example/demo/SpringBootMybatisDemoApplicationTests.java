package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SpringBootSecurityDatabaseDemoApplicationTests {
	@Autowired
	private MemberDao memberDao;

//	@Autowired
//	private PasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void test1() {
		MemberVO member = new MemberVO();
		member.setUserid("member");
		member.setPasswd("12345678");
		member.setNickname("정회원");
		member.setRole("ROLE_MEMBER");
		member.setEnabled(1);
		int row = this.memberDao.insertMember(member);
		assertEquals(1, row);
	}

	@Test
	public void test2() {
		MemberVO member = new MemberVO();
		member.setUserid("manager");
		member.setPasswd("12345678");
		member.setNickname("매니저");
		member.setRole("ROLE_MANAGER");
		member.setEnabled(1);
		int row = this.memberDao.insertMember(member);
		assertEquals(1, row);
	}

}