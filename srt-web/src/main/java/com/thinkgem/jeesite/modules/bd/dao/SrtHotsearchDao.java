/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.bd.entity.SrtHotsearch;

/**
 * 热门搜索生成DAO接口
 * @author LiangYouKu
 * @version 2017-09-13
 */
@MyBatisDao
public interface SrtHotsearchDao extends CrudDao<SrtHotsearch> {
	
}