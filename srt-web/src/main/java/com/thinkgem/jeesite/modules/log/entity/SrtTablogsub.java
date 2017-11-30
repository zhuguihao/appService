/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 操作日志生成Entity
 * @author LiangYouKu
 * @version 2017-09-13
 */
public class SrtTablogsub extends DataEntity<SrtTablogsub> {
	
	private static final long serialVersionUID = 1L;
	private SrtTablogmain srtTablogMain;		// 父表主键 父类
	private String tabKey;		// 表
	private String tabName;		// 表说明
	private String field;		// 表字段
	private String fieldName;		// 表字段说明
	private String oldValue;		// 旧值
	private String newValue;		// 新值
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public SrtTablogsub() {
		super();
	}

	public SrtTablogsub(String id){
		super(id);
	}

	public SrtTablogsub(SrtTablogmain srtTablogMain){
		this.srtTablogMain = srtTablogMain;
	}

	@Length(min=1, max=32, message="父表主键长度必须介于 1 和 32 之间")
	public SrtTablogmain getSrtTablogMain() {
		return srtTablogMain;
	}

	public void setSrtTablogMain(SrtTablogmain srtTablogMain) {
		this.srtTablogMain = srtTablogMain;
	}
	
	@Length(min=1, max=128, message="表长度必须介于 1 和 128 之间")
	public String getTabKey() {
		return tabKey;
	}

	public void setTabKey(String tabKey) {
		this.tabKey = tabKey;
	}
	
	@Length(min=0, max=256, message="表说明长度必须介于 0 和 256 之间")
	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	
	@Length(min=0, max=128, message="表字段长度必须介于 0 和 128 之间")
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	@Length(min=0, max=256, message="表字段说明长度必须介于 0 和 256 之间")
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	
	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}
		
}