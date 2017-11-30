/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.bd.entity.SrtHotsearch;
import com.thinkgem.jeesite.modules.bd.service.SrtHotsearchService;

/**
 * 热门搜索生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/bd/srtHotsearch")
public class SrtHotsearchController extends BaseController {

	@Autowired
	private SrtHotsearchService srtHotsearchService;
	
	@ModelAttribute
	public SrtHotsearch get(@RequestParam(required=false) String id) {
		SrtHotsearch entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtHotsearchService.get(id);
		}
		if (entity == null){
			entity = new SrtHotsearch();
		}
		return entity;
	}
	
	@RequiresPermissions("bd:srtHotsearch:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtHotsearch srtHotsearch, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtHotsearch> page = srtHotsearchService.findPage(new Page<SrtHotsearch>(request, response), srtHotsearch); 
		model.addAttribute("page", page);
		return "modules/bd/srtHotsearchList";
	}

	@RequiresPermissions("bd:srtHotsearch:view")
	@RequestMapping(value = "form")
	public String form(SrtHotsearch srtHotsearch, Model model) {
		model.addAttribute("srtHotsearch", srtHotsearch);
		return "modules/bd/srtHotsearchForm";
	}

	@RequiresPermissions("bd:srtHotsearch:edit")
	@RequestMapping(value = "save")
	public String save(SrtHotsearch srtHotsearch, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtHotsearch)){
			return form(srtHotsearch, model);
		}
		
		if(srtHotsearchService.findListByCopy(srtHotsearch)>0){
			addMessage(redirectAttributes, "已存在该关键字");
			return "redirect:"+Global.getAdminPath()+"/bd/srtHotsearch/form?id="+srtHotsearch.getId();
		};
		srtHotsearchService.save(srtHotsearch);
		addMessage(redirectAttributes, "保存热门搜索成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtHotsearch/?repage";
	}
	
	@RequiresPermissions("bd:srtHotsearch:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtHotsearch srtHotsearch, RedirectAttributes redirectAttributes) {
		srtHotsearchService.delete(srtHotsearch);
		addMessage(redirectAttributes, "删除热门搜索成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtHotsearch/?repage";
	}
	

}