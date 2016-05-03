package com.lfksc.api.service;

import com.lfksc.api.model.User;

public interface IUserService {

	/**
	 * 登录
	 * 
	 * @param loginName
	 *            账号
	 * @param password
	 *            密码
	 * @param clientId
	 *            设备唯一编号
	 * @param platform
	 *            平台（ios/android）
	 * @return token
	 */
	public String login(String loginName, String password, String clientId, String platform);


}
