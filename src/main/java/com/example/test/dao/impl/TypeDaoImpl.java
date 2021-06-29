package com.example.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.test.dao.TypeDao;
import com.example.test.entity.Type;
@Repository
public class TypeDaoImpl extends BaseDaoImpl<Type> implements TypeDao{

	public TypeDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.TypeMapper.");
	}

}
