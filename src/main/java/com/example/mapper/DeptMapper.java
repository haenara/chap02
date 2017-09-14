package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Dept;

@Mapper
public interface DeptMapper {
	
	@Select("select * from dept")
	public List<Dept> selectAll();

}