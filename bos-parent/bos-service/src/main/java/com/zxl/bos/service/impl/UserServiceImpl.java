package com.zxl.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IUserDao;
import com.zxl.bos.domain.Role;
import com.zxl.bos.domain.User;
import com.zxl.bos.service.IUserService;
import com.zxl.bos.utils.MD5Utils;
import com.zxl.bos.utils.PageBean;
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}
	
	/**
	 * 根据用户id修改密码
	 */
	@Override
	public void editPassword(String id, String password) {
		//使用MD5加密密码
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password, id);
	}

	/**
	 * 添加一个用户，同时关联角色
	 */
	@Override
	public void save(User user, String[] roleIds) {
		String password = user.getPassword();
		password = MD5Utils.md5(password);
		user.setPassword(password);
		userDao.save(user);
		if(roleIds != null && roleIds.length > 0){
			for (String roleId : roleIds) {
				//手动构造托管对象
				Role role = new Role(roleId);
				//用户对象关联角色对象
				user.getRoles().add(role);
				
			}
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
}
