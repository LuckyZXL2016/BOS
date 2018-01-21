package com.zxl.bos.web.action;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zxl.bos.domain.User;
import com.zxl.bos.service.IUserService;
import com.zxl.bos.utils.BOSUtils;
import com.zxl.bos.utils.MD5Utils;
import com.zxl.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//属性驱动，接收页面输入的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	@Autowired
	private IUserService userService;
	
	/*
	 * 用户登录，使用shiro框架提供的方式进行认证操作
	 */
	public String login(){
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//校验验证码是否输入正确
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {
			//使用shiro框架提供的方式进行认证操作
			Subject subject = SecurityUtils.getSubject();//获得当前用户对象,状态为“未认证”
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));
			try {
				subject.login(token);
			} catch (Exception e) {
				e.printStackTrace();
				return LOGIN;
			}
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return HOME;
		}else{
			//输入的验证码错误,设置提示信息，跳转到登录页面
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
	
	/*
	 * 用户登录
	 */
	public String login_bak(){
		//从Session中获取生成的验证码
		String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//校验验证码是否输入正确
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)) {
			//输入的验证码正确
			User user = userService.login(model);
			if(user != null) {
				//登录成功,将user对象放入session，跳转到首页
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return HOME;
			}else{
				//登录失败，,设置提示信息，跳转到登录页面
				//输入的验证码错误,设置提示信息，跳转到登录页面
				this.addActionError("用户名或者密码输入错误！");
				return LOGIN;
			}
		}else{
			//输入的验证码错误,设置提示信息，跳转到登录页面
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
	
	/**
	 * 用户注销
	 */
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	
	/**
	 * 修改当前用户密码
	 * @throws IOException 
	 */
	public String editPassword() throws IOException{
		String f = "1";
		//获取当前登录用户
		User user = BOSUtils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());
		} catch (Exception e) {
			f = "0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
	//属性驱动，接收多个角色id
	private String[] roleIds;
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	/**
	 * 添加用户
	 */
	public String add(){
		userService.save(model,roleIds);
		return LIST;
	}
	
	/**
	 * 用户数据分页查询
	 */
	public String pageQuery(){
		userService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"noticebills","roles"});
		return NONE;
	}
}
