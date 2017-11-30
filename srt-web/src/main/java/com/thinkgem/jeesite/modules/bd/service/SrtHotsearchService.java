/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bd.entity.SrtHotsearch;
import com.thinkgem.jeesite.modules.bd.dao.SrtHotsearchDao;

/**
 * 热门搜索生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtHotsearchService extends CrudService<SrtHotsearchDao, SrtHotsearch> {

	public SrtHotsearch get(String id) {
		return super.get(id);
	}
	
	public List<SrtHotsearch> findList(SrtHotsearch srtHotsearch) {
		return super.findList(srtHotsearch);
	}
	
	public Page<SrtHotsearch> findPage(Page<SrtHotsearch> page, SrtHotsearch srtHotsearch) {
		return super.findPage(page, srtHotsearch);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtHotsearch srtHotsearch) {
		super.save(srtHotsearch);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtHotsearch srtHotsearch) {
		super.delete(srtHotsearch);
	}
	
}