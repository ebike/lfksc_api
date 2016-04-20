package com.lfksc.api.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lfksc.api.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Resource
	private IUserService userService;
}
