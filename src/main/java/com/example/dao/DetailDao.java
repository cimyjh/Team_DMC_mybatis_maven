package com.example.dao;

import com.example.vo.ReviewVO;

import java.util.Map;

public interface DetailDao {
	void Detail_Read_New(Map map);
	void Detail_Read_Review(Map map);

	//void Review_insert(Map map);

	void Review_insert(int n_num, String nickname, String r_comment, String r_like);
}
