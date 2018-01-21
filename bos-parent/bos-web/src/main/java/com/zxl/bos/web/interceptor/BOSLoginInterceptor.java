package com.zxl.bos.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zxl.bos.domain.User;
import com.zxl.bos.utils.BOSUtils;

public class BOSLoginInterceptor extends MethodFilterInterceptor {
	//拦截方法
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace + actionName;
//		System.out.println(url);
		//从session中获取用户对象
		User user = BOSUtils.getLoginUser();
		if(user == null){
			//没有登录，跳转到登录页面
			return "login";
		}
		//放行
		return invocation.invoke();
	}

}
