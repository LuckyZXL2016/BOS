package com.zxl.bos.service;

import java.util.List;

import com.zxl.bos.domain.Role;
import com.zxl.bos.utils.PageBean;

public interface IRoleService {

	public void save(Role model, String functionIds);

	public void pageQuery(PageBean pageBean);

	public List<Role> findAll();

}
