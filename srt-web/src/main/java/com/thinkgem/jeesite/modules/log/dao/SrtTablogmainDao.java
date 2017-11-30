/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.log.entity.SrtTablogmain;

/**
 * 操作日志生成DAO接口
 * @author LiangYouKu
 * @version 2017-09-13
 */
@MyBatisDao
public interface SrtTablogmainDao extends CrudDao<SrtTablogmain> {
	
}