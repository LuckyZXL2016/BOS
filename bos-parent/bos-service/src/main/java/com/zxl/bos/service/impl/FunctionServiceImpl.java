package com.zxl.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IFunctionDao;
import com.zxl.bos.domain.Function;
import com.zxl.bos.domain.User;
import com.zxl.bos.service.IFunctionService;
import com.zxl.bos.utils.BOSUtils;
import com.zxl.bos.utils.PageBean;

@Service
@Transactional
public class FunctionServiceImpl implements IFunctionService {
	@Autowired
	private IFunctionDao dao;
	
	@Override
	public List<Function> findAll() {
		return dao.findAll();
	}

	//添加权限
	@Override
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")){
			model.setParentFunction(null);
		}
		dao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		dao.pageQuery(pageBean);
	}

	/**
	 * 根据当前登录人查询对应的菜单数据，返回json
	 */
	@Override
	public List<Function> findMenu() {
		List<Function> list = null;
		User user = BOSUtils.getLoginUser();
		if(user.getUsername().equals("admin")){
			//如果是超级管理员内置用户，查询所有菜单
			list = dao.findAllMenu();
		}else{
			//其他用户，根据用户id查询菜单
			list = dao.findMenuByUserId(user.getId());
		}
		return list;
	}
}
