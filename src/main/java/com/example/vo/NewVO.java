package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewVO {
	private int n_num;
	private String n_name;
	private int n_price;
	private String n_product1;
	private String n_product2;
	private String n_thumbnail;
	private String n_img;
	private String n_store;
	private String n_detail;
	private Date n_registerDate;
	
	
}
