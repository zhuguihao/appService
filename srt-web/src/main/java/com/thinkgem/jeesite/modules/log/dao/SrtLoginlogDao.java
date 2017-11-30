/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.log.entity.SrtLoginlog;

/**
 * 登录日志生成DAO接口
 * @author LiangYouKu
 * @version 2017-09-13
 */
@MyBatisDao
public interface SrtLoginlogDao extends CrudDao<SrtLoginlog> {
	
}