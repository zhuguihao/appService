<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>热门搜索管理</title>
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
		function findtemplate(code){
			alert(code);
			/* var list = ${fns:getDictList("kindCode")};
			alert(list) */
			return;
			$.ajax({
		        type : "post",
		        async : false,
		        url : "getDictList",
		        data : {
		            'type' : code
		        },
		        dataType : "json",
		        success : function(msg) {
		            $("#kindCode").empty();
		            alert(msg);
		            if (msg.length > 0) {
		                for (var i = 0; i < msg.length; i++) {
		                        var partId = msg[i].value;
		                        var partName = msg[i].label;
		                        var $option = $("<option>").attr({
		                            "value" : partId
		                        }).text(partName);
		                        $("#kindCode").append($option);
		                }
		                //$("#template option:first").prop("selected", 'selected');
		                $("#kindCode").change();

		            }
		        },
		        error : function(json) {
		            $.jBox.alert("网络异常！");
		        }
		    });
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/bd/srtHotsearch/">热门搜索列表</a></li>
		<shiro:hasPermission name="bd:srtHotsearch:edit"><li><a href="${ctx}/bd/srtHotsearch/form">热门搜索添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="srtHotsearch" action="${ctx}/bd/srtHotsearch/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>分类：</label>
				<form:select path="classCode"
				onchange="findtemplate(this.options[this.options.selectedIndex].value)"
				 class="input-medium">
					<form:options items="${fns:getDictList('classCode')}" 
					itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>小类：</label>
				<form:select id="kindCode" path="kindCode" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getDictList('kindCode')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>类型：</label>
				<form:select path="textType" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getDictList('textType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>关键字：</label>
				<form:input id="keyword" path="keyword" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>级别：</label>
				<form:select path="level" class="input-medium">
					<form:option value="" label="全部"/>
					<form:options items="${fns:getDictList('level')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtHotsearch.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtHotsearch.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtHotsearch.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${srtHotsearch.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>分类</th>
				<th>小类</th>
				<th>类型</th>
				<th>关键字</th>
				<th>序号（用于排序）</th>
				<th>渠道（App、Web）</th>
				<th>级别</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>更新人</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="bd:srtHotsearch:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="srtHotsearch">
			<tr>
				<td><a href="${ctx}/bd/srtHotsearch/form?id=${srtHotsearch.id}">
					${fns:getDictLabel(srtHotsearch.classCode, 'classCode', '')}
				</a></td>
				<td>
					${fns:getDictLabel(srtHotsearch.kindCode, 'kindCode', '')}
				</td>
				<td>
					${fns:getDictLabel(srtHotsearch.textType, 'textType', '')}
				</td>
				<td>
					${srtHotsearch.keyword}
				</td>
				<td>
					${srtHotsearch.sort}
				</td>
				<td>
					${fns:getDictLabel(srtHotsearch.channel, 'channel', '')}
				</td>
				<td>
					${fns:getDictLabel(srtHotsearch.level, 'level', '')}
				</td>
				<td>
					${srtHotsearch.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtHotsearch.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtHotsearch.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${srtHotsearch.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${srtHotsearch.remarks}
				</td>
				<shiro:hasPermission name="bd:srtHotsearch:edit"><td>
    				<a href="${ctx}/bd/srtHotsearch/form?id=${srtHotsearch.id}">修改</a>
					<a href="${ctx}/bd/srtHotsearch/delete?id=${srtHotsearch.id}" onclick="return confirmx('确认要删除该热门搜索吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>