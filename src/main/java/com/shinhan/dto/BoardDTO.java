package com.shinhan.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class BoardDTO {
	 int bno;
	 String title;
	 String content;
	 String writer;
	 String pic;
	 Date create_date;
	 
}
