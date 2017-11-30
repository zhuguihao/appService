/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 标签生成Entity
 * @author LiangYouKu
 * @version 2017-09-13
 */
public class SrtTag extends DataEntity<SrtTag> {
	
	private static final long serialVersionUID = 1L;
	private SrtTag parent;		// 父级节点（指向该表id）
	private String tagName;		// 标签名
	private String tagEname;		// 标签英文名
	private String initial;		// 拼音首字母
	private Long sort;		// 序号（用于排序）
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public SrtTag() {
		super();
	}

	public SrtTag(String id){
		super(id);
	}

	@JsonBackReference
	public SrtTag getParent() {
		return parent;
	}

	public void setParent(SrtTag parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=128, message="标签名长度必须介于 1 和 128 之间")
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	@Length(min=0, max=128, message="标签英文名长度必须介于 0 和 128 之间")
	public String getTagEname() {
		return tagEname;
	}

	public void setTagEname(String tagEname) {
		this.tagEname = tagEname;
	}
	
	@Length(min=0, max=1, message="拼音首字母长度必须介于 0 和 1 之间")
	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}
	
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
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