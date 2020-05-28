package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewVO {
	private int r_num;
	private int n_num;
	private String r_comment;
	private String nickname;
	private String r_like;
	private Date r_date;
}
