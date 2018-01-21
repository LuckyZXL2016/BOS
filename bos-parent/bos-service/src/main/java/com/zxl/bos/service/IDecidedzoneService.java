package com.zxl.bos.service;

import com.zxl.bos.domain.Decidedzone;
import com.zxl.bos.utils.PageBean;

public interface IDecidedzoneService {

	void save(Decidedzone model, String[] subareaid);

	void pageQuery(PageBean pageBean);

}
