package com.example.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.vo.ReviewVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("detailDao")
public class DetailDaoImpl implements DetailDao {
	
	@Autowired
	private SqlSession sqlSession;


	@Override
	public void Detail_Read_New(Map map) {
		this.sqlSession.selectOne("detail_new_select1", map);
		
	}

		@Override
		public void Detail_Read_Review(Map map) {
			this.sqlSession.selectOne("detail_review_select", map);

		}

		@Override
		public void Review_insert(int n_num, String nickname, String r_comment, String r_like){

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("n_num", n_num);
			map.put("nickname", nickname);
			map.put("r_comment", r_comment);
			map.put("r_like", r_like);

		this.sqlSession.insert("review_insert",map);
	}


}
