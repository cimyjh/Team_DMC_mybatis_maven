package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.NewDao;

@Service("newService")
public class NewServiceImpl implements NewService {

	@Autowired
	private NewDao newDao;

	@Override
	public void selelctNew(Map map) {
		this.newDao.read(map);
	}

	@Override
	public void selectAllNew(Map map) {
		this.newDao.readAll(map);
	}

	@Override
	public void select_new_form(Map map) {
		this.newDao.select_new_form(map);

	}

	@Override
	public void search_new_name(Map map) {
		this.newDao.search_new_name(map);

	}

}
