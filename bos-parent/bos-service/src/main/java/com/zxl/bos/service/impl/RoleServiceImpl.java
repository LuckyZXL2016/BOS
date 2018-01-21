package com.zxl.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IRoleDao;
import com.zxl.bos.domain.Function;
import com.zxl.bos.domain.Role;
import com.zxl.bos.service.IRoleService;
import com.zxl.bos.utils.PageBean;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao dao;
	/**
	 * 保存一个角色，同时还需要关联权限
	 */
	@Override
	public void save(Role role, String functionIds) {
		dao.save(role);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				//手动构造一个权限对象，设置id，对象状态为托管状态
				Function function = new Function(functionId);
				//角色关联权限
				role.getFunctions().add(function);
			}
		}
	}
	
	@Override
	public void pageQuery(PageBean pageBean) {
		dao.pageQuery(pageBean);
	}

	@Override
	public List<Role> findAll() {
		return dao.findAll();
	}
}
