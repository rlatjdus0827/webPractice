package com.shinhan.dept;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//제일 먼저
//칼럼 이름 같아야 좋음
//run sql 에서 alt + 스크롤해서 우클릭해서 복사
//ctrl shift y로 소문자, ; 붙이기

//VO (Value Object)
//DTO(Data Transfer Object
//JavaBeans기술에서 이용(Jsp, String, Mybatis는 javabeans기술을 이용한다.)


@ToString
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DeptDTO {
	int department_id;
	String department_name;
	int manager_id;
	int location_id;
}
