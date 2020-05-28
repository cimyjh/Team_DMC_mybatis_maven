package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EventDao;
import com.example.vo.EventVO;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDao eventDao;

	
	@Override
	public void selectAllEvent(Map map) {
		this.eventDao.event_readAll(map);

	}


	@Override
	public void selectAllEvent_store(Map map) {
		this.eventDao.event_readAll_store(map);
		
	}


	@Override
	public void select_Event_form(Map map) {
		this.eventDao.event_select_form(map);
		
	}
	
	@Override
	public void select_Textbox(Map map) {
		this.eventDao.event_textbox(map);
		
	}
}