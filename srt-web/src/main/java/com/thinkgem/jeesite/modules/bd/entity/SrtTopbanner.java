/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 首页banner生成Entity
 * @author LiangYouKu
 * @version 2017-09-13
 */
public class SrtTopbanner extends DataEntity<SrtTopbanner> {
	
	private static final long serialVersionUID = 1L;
	private String bannerType;		// 广告类型
	private String appImg;		// app广告图
	private String webImg;		// web广告图
	private String title;		// 标题
	private String content;		// 说明
	private String url;		// URL地址
	private Long sort;		// 序号（用于排序）
	private String channel;		// 渠道
	private String level;		// 级别
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public SrtTopbanner() {
		super();
	}

	public SrtTopbanner(String id){
		super(id);
	}

	@Length(min=0, max=32, message="广告类型长度必须介于 0 和 32 之间")
	public String getBannerType() {
		return bannerType;
	}

	public void setBannerType(String bannerType) {
		this.bannerType = bannerType;
	}
	
	@Length(min=0, max=128, message="app广告图长度必须介于 0 和 128 之间")
	public String getAppImg() {
		return appImg;
	}

	public void setAppImg(String appImg) {
		this.appImg = appImg;
	}
	
	@Length(min=0, max=128, message="web广告图长度必须介于 0 和 128 之间")
	public String getWebImg() {
		return webImg;
	}

	public void setWebImg(String webImg) {
		this.webImg = webImg;
	}
	
	@Length(min=0, max=512, message="标题长度必须介于 0 和 512 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=128, message="URL地址长度必须介于 0 和 128 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=128, message="渠道长度必须介于 0 和 128 之间")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	@Length(min=0, max=32, message="级别长度必须介于 0 和 32 之间")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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