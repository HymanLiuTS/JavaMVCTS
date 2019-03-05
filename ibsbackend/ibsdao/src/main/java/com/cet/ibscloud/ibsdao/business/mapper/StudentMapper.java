package com.cet.ibscloud.ibsdao.business.mapper;

import com.cet.ibscloud.ibsdao.business.model.Student;

public interface StudentMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}