<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>操作日志管理</title>
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
		<li class="active"><a href="${ctx}/log/srtTablogmain/">操作日志列表</a></li>
		<shiro:hasPermission name="log:srtTablogmain:edit"><li><a href="${ctx}/log/srtTablogmain/form">操作日志添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srtTablogmain" action="${ctx}/log/srtTablogmain/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>操作类型：</label>
				<form:select path="opType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('opType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>表：</label>
				<form:input path="tabmainKey" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>表说明：</label>
				<form:input path="tabmainName" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTablogmain.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTablogmain.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTablogmain.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtTablogmain.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>操作类型</th>
				<th>表</th>
				<th>表说明</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>更新人</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="log:srtTablogmain:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srtTablogmain">
			<tr>
				<td><a href="${ctx}/log/srtTablogmain/form?id=${srtTablogmain.id}">
					${fns:getDictLabel(srtTablogmain.opType, 'opType', '')}
				</a></td>
				<td>
					${srtTablogmain.tabmainKey}
				</td>
				<td>
					${srtTablogmain.tabmainName}
				</td>
				<td>
					${srtTablogmain.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtTablogmain.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtTablogmain.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtTablogmain.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtTablogmain.remarks}
				</td>
				<shiro:hasPermission name="log:srtTablogmain:edit"><td>
    				<a href="${ctx}/log/srtTablogmain/form?id=${srtTablogmain.id}">修改</a>
					<a href="${ctx}/log/srtTablogmain/delete?id=${srtTablogmain.id}" onclick="return confirmx('确认要删除该操作日志吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>