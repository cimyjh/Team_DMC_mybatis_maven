package com.example.service;

import java.util.Map;

import com.example.vo.EventVO;

public interface EventService {
	void selectAllEvent(Map map);

	void selectAllEvent_store(Map map);

	void select_Event_form(Map map);

	void select_Textbox(Map map);
}
