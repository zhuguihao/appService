/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bd.entity.SrtTopbanner;
import com.thinkgem.jeesite.modules.bd.dao.SrtTopbannerDao;

/**
 * 首页banner生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtTopbannerService extends CrudService<SrtTopbannerDao, SrtTopbanner> {

	public SrtTopbanner get(String id) {
		return super.get(id);
	}
	
	public List<SrtTopbanner> findList(SrtTopbanner srtTopbanner) {
		return super.findList(srtTopbanner);
	}
	
	public Page<SrtTopbanner> findPage(Page<SrtTopbanner> page, SrtTopbanner srtTopbanner) {
		return super.findPage(page, srtTopbanner);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtTopbanner srtTopbanner) {
		super.save(srtTopbanner);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtTopbanner srtTopbanner) {
		super.delete(srtTopbanner);
	}
	
}