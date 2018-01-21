package com.zxl.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IWorkordermanageDao;
import com.zxl.bos.domain.Workordermanage;
import com.zxl.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageService implements IWorkordermanageService {
	@Autowired
	private IWorkordermanageDao workordermanageDao;
	@Override
	public void save(Workordermanage model) {
		workordermanageDao.save(model);
	}

}
