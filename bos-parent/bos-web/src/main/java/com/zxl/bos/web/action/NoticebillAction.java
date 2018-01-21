package com.zxl.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zxl.bos.domain.Noticebill;
import com.zxl.bos.service.INoticebillService;
import com.zxl.bos.web.action.base.BaseAction;
import com.zxl.crm.Customer;
import com.zxl.crm.ICustomerService;

@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {
	//注入crm客户端代理对象
	@Autowired
	private ICustomerService customerService;
	
	/**
	 * 远程调用crm服务，根据手机号查询客户信息
	 */
	public String findCustomerByTelephone(){
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		this.java2Json(customer, new String[]{});
		return NONE;
	}
	
	@Autowired
	private INoticebillService noticebillService;
	
	/**
	 * 保存一个业务通知单，并尝试自动分单
	 */
	public String add(){
		noticebillService.save(model);
		return "noticebill_add";
	}
}
