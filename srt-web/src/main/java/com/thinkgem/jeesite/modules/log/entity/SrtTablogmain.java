/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 操作日志生成Entity
 * @author LiangYouKu
 * @version 2017-09-13
 */
public class SrtTablogmain extends DataEntity<SrtTablogmain> {
	
	private static final long serialVersionUID = 1L;
	private String opType;		// 操作类型
	private String tabmainKey;		// 表
	private String tabmainName;		// 表说明
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	private List<SrtTablogsub> srtTablogsubList = Lists.newArrayList();		// 子表列表
	
	public SrtTablogmain() {
		super();
	}

	public SrtTablogmain(String id){
		super(id);
	}

	@Length(min=0, max=8, message="操作类型长度必须介于 0 和 8 之间")
	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}
	
	@Length(min=1, max=128, message="表长度必须介于 1 和 128 之间")
	public String getTabmainKey() {
		return tabmainKey;
	}

	public void setTabmainKey(String tabmainKey) {
		this.tabmainKey = tabmainKey;
	}
	
	@Length(min=0, max=256, message="表说明长度必须介于 0 和 256 之间")
	public String getTabmainName() {
		return tabmainName;
	}

	public void setTabmainName(String tabmainName) {
		this.tabmainName = tabmainName;
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
		
	public List<SrtTablogsub> getSrtTablogsubList() {
		return srtTablogsubList;
	}

	public void setSrtTablogsubList(List<SrtTablogsub> srtTablogsubList) {
		this.srtTablogsubList = srtTablogsubList;
	}
}