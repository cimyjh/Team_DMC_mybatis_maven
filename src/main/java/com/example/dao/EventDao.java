package com.example.dao;

import java.util.Map;

public interface EventDao {
	void event_readAll(Map map);
	void event_readAll_store(Map map);
	void event_select_form(Map map);
	void event_textbox(Map map);
}
