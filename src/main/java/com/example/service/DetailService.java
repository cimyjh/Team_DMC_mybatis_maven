package com.example.service;

import com.example.vo.ReviewVO;

import java.util.Map;

public interface DetailService {
	
	void selectDetailNew(Map map);
	void selectDetailReview(Map map);
	//void insertReview(Map map);

	void insertReview(int n_num, String nickname, String r_comment, String r_like);
}