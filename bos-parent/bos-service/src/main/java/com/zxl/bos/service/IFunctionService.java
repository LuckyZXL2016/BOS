package com.zxl.bos.service;

import java.util.List;

import com.zxl.bos.domain.Function;
import com.zxl.bos.utils.PageBean;

public interface IFunctionService {

	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);

	public List<Function> findMenu();

}
