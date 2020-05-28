package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("eventDao")
public class EventDaoImpl implements EventDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void event_readAll(Map map) {
		this.sqlSession.selectList("event_selectAll",map);
	}

	@Override
	public void event_readAll_store(Map map) {
		this.sqlSession.selectList("event_selectAll_store",map);
		
	}

	@Override
	public void event_select_form(Map map) {
		this.sqlSession.selectList("event_select_form", map);
		
	}
	
	@Override
	public void event_textbox(Map map) {
		this.sqlSession.selectList("event_textbox", map);
	}

}
