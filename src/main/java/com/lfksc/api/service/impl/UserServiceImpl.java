package com.lfksc.api.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lfksc.api.dao.IUserDao;
import com.lfksc.api.model.User;
import com.lfksc.api.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService
{
	@Resource(name = "userDao")
	private IUserDao userDao;

	@Override
	public void saveUser(User user)
	{
		userDao.saveUser(user);
	}
	
	
}
