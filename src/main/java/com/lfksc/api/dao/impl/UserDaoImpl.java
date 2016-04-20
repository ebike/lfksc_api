package com.lfksc.api.dao.impl;

import org.springframework.stereotype.Component;

import com.lfksc.api.dao.IUserDao;

import cn.jpush.api.report.UsersResult.User;

@Component("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao
{
	@Override
	public void saveUser(User user)
	{
		this.writerSqlSession.insert("", user);
	}
	
}
