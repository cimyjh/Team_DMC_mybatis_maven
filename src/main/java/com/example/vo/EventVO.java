package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class EventVO {
    private int e_num;
    private String e_name;
    private int e_price;
    private String e_evt;
    private String e_product1;
    private String e_store;
    private String e_product2;
    private String e_img;
    private Date e_registerDate;
    private Date e_expireDate;

}