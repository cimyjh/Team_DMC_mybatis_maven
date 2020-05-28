package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberVO getUserByUserid(String username) {
		String sql = "SELECT * FROM Member WHERE userid = ?";
		return this.jdbcTemplate.queryForObject(sql, new String[] {username}, 
				new RowMapper<MemberVO>() {
					@Override
					public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						MemberVO member = new MemberVO();
						member.setUserid(rs.getString("userid"));
						member.setPasswd(rs.getString("passwd"));
						member.setNickname(rs.getString("nickname"));
						member.setRole(rs.getString("role"));
						member.setEnabled(rs.getInt("enabled"));
						return member;
					}
		});
	}
	
	public int insertMember(MemberVO member) {
		String sql = "INSERT INTO Member(userid, passwd, nickname, role, enabled) VALUES(?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, member.getUserid(),  member.getPasswd(),
				member.getNickname(), "ROLE_MEMBER", 1);
	}
	
	
	
	
	
}
