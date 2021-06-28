package com.example.test.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.test.dao.TypeDao;
import com.example.test.domain.Type;
@Repository
public class TypeDaoImpl extends BaseDaoImpl<Type> implements TypeDao{

	public TypeDaoImpl() {
		this.setNs("edu.fjnu.online.mapper.TypeMapper.");
	}

}
