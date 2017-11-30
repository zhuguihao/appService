<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>首页banner管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/bd/srtTopbanner/">首页banner列表</a></li>
		<shiro:hasPermission name="bd:srtTopbanner:edit"><li><a href="${ctx}/bd/srtTopbanner/form">首页banner添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srtTopbanner" action="${ctx}/bd/srtTopbanner/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="512" class="input-medium"/>
			</li>
			<li><label>说明：</label>
				<form:input path="content" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>URL地址：</label>
				<form:input path="url" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>渠道：</label>
				<form:checkboxes path="channel" items="${fns:getDictList('channel')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li><label>级别：</label>
				<form:select path="level" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('level')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTopbanner.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTopbanner.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTopbanner.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTopbanner.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>app广告图</th>
				<th>web广告图</th>
				<th>标题</th>
				<th>说明</th>
				<th>URL地址</th>
				<th>序号（用于排序）</th>
				<th>渠道</th>
				<th>级别</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>更新人</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="bd:srtTopbanner:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srtTopbanner">
			<tr>
				<td><a href="${ctx}/bd/srtTopbanner/form?id=${srtTopbanner.id}">
					${srtTopbanner.appImg}
				</a></td>
				<td>
					${srtTopbanner.webImg}
				</td>
				<td>
					${srtTopbanner.title}
				</td>
				<td>
					${srtTopbanner.content}
				</td>
				<td>
					${srtTopbanner.url}
				</td>
				<td>
					${srtTopbanner.sort}
				</td>
				<td>
					${fns:getDictLabel(srtTopbanner.channel, 'channel', '')}
				</td>
				<td>
					${fns:getDictLabel(srtTopbanner.level, 'level', '')}
				</td>
				<td>
					${srtTopbanner.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtTopbanner.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtTopbanner.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtTopbanner.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtTopbanner.remarks}
				</td>
				<shiro:hasPermission name="bd:srtTopbanner:edit"><td>
    				<a href="${ctx}/bd/srtTopbanner/form?id=${srtTopbanner.id}">修改</a>
					<a href="${ctx}/bd/srtTopbanner/delete?id=${srtTopbanner.id}" onclick="return confirmx('确认要删除该首页banner吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>