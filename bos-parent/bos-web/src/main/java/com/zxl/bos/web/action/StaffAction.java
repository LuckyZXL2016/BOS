package com.zxl.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zxl.bos.domain.Staff;
import com.zxl.bos.service.IStaffService;
import com.zxl.bos.web.action.base.BaseAction;

/**
 * 取派员管理
 * @author ZXL
 *
 */
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> { 
	@Autowired
	private IStaffService staffService;
	
	//添加取派员
	public String add(){
		staffService.save(model);
		return LIST;
	}
	
	/**
	 * 分页查询方法
	 * @throws IOException 
	 */
	public String pageQuery() {
		staffService.pageQuery(pageBean);
		
		//使用json-lib将PageBean对象转为json，通过输出流写回页面中
		//JSONObject---将单一对象转为json
		//JSONArray----将数组或集合对象转为json
		//指定哪些属性不需要转json
		this.java2Json(pageBean, 
				new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});
		return NONE;
	}
	
	//属性驱动，接收页面提交的ids参数
	private String ids;
	
	/**
	 * 取派员批量删除
	 */
	@RequiresPermissions("staff-delete")//执行这个方法，需要当前用户具有staff-delete这个权限
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return LIST;
	}
	
	/**
	 * 修改取派员信息 
	 */
	public String edit(){
		//显示查询数据库，根据id查询原始数据
		Staff staff = staffService.findById(model.getId());
		//使用页面提交的数据进行覆盖
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		return LIST;
	}
	
	/**
	 * 查询所有未删除的取派员，返回json
	 */
	public String listajax(){
		List<Staff> list = staffService.findListNotDelete();
		this.java2Json(list, new String[]{"decidedzones"});
		return NONE;
	}
	
	public void setIds(String ids) {
		this.ids = ids;
	}
}
