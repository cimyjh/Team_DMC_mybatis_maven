package com.example.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memberService")
public class MemberService implements UserDetailsService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = this.memberDao.getUserByUserid(username);
		log.info("검색된 멤버 = {}", member.toString());
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(member.getRole()));
		UserDetails user = new User(member.getUserid(),"{noop}" + member.getPasswd(), roles);
		return user;
	}

	public void insertMember(MemberVO member){
		this.memberDao.insertMember(member);
	}

}
