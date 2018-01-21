package com.zxl.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zxl.bos.domain.Role;
import com.zxl.bos.service.IRoleService;
import com.zxl.bos.web.action.base.BaseAction;

/**
 * 角色管理
 * @author ZXL
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	//属性驱动，接收权限的id
	private String functionIds;

	@Autowired
	private IRoleService service;
	
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	
	/**
	 * 添加角色
	 */
	public String add(){
		service.save(model,functionIds);
		return LIST;
	}
	
	/**
	 * 分页查询
	 */
	public String pageQuery(){
		service.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"functions","users"});
		return NONE;
	}
	
	/**
	 * 查询所有的角色数据，返回json
	 */
	public String listajax(){
		List<Role> list = service.findAll();
		this.java2Json(list, new String[]{"functions","users"});
		return NONE;
	}
}
