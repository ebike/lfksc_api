package com.lfksc.api.dao.impl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseDao
{
	@Resource(name = "sqlSession")
	public SqlSessionTemplate readSqlSession;

	@Resource(name = "sqlSession")
	public SqlSessionTemplate writerSqlSession;

}
