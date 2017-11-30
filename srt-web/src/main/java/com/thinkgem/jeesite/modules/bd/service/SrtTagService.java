/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.bd.entity.SrtTag;
import com.thinkgem.jeesite.modules.bd.dao.SrtTagDao;

/**
 * 标签生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtTagService extends CrudService<SrtTagDao, SrtTag> {

	public SrtTag get(String id) {
		return super.get(id);
	}
	
	public List<SrtTag> findList(SrtTag srtTag) {
		return super.findList(srtTag);
	}
	
	public Page<SrtTag> findPage(Page<SrtTag> page, SrtTag srtTag) {
		return super.findPage(page, srtTag);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtTag srtTag) {
		super.save(srtTag);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtTag srtTag) {
		super.delete(srtTag);
	}
	
}