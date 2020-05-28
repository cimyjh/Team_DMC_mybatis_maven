package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("newDao")
public class NewDaoImpl implements NewDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("new_selectAll_store", map);
	}

	@Override
	public void readAll(Map map) {
		this.sqlSession.selectList("new_selectAll", map);
	}

	@Override
	public void select_new_form(Map map) {
		this.sqlSession.selectList("new_select_form", map);

	}

	@Override
	public void search_new_name(Map map) {
		this.sqlSession.selectList("search_new_name", map);

	}

}
