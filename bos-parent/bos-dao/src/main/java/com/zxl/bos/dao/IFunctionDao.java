package com.zxl.bos.dao;

import java.util.List;

import com.zxl.bos.dao.base.IBaseDao;
import com.zxl.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {

	public List<Function> findFunctionListByUserId(String id);

	public List<Function> findAllMenu();

	public List<Function> findMenuByUserId(String id);

}
