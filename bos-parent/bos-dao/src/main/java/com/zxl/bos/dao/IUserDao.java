package com.zxl.bos.dao;

import com.zxl.bos.dao.base.IBaseDao;
import com.zxl.bos.domain.User;

public interface IUserDao extends IBaseDao<User> {

	public User findUserByUsernameAndPassword(String username, String password);

	public User findUserByUsername(String username);

}
