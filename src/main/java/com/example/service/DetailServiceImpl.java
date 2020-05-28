package com.example.service;

import java.util.Map;

import com.example.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DetailDao;

@Service("detailService")
public class DetailServiceImpl implements DetailService {
	
	@Autowired
	private DetailDao detailDao;

	
	@Override
	public void selectDetailNew(Map map) {
		this.detailDao.Detail_Read_New(map);

	}


	@Override
	public void selectDetailReview(Map map) {
		this.detailDao.Detail_Read_Review(map);
		
	}

	@Override
	public void insertReview(int n_num, String nickname, String r_comment, String r_like) {
		this.detailDao.Review_insert(n_num, nickname, r_comment, r_like);

	}

}