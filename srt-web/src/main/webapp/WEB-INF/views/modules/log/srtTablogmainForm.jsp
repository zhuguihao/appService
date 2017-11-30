<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>操作日志管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/log/srtTablogmain/">操作日志列表</a></li>
		<li class="active"><a href="${ctx}/log/srtTablogmain/form?id=${srtTablogmain.id}">操作日志<shiro:hasPermission name="log:srtTablogmain:edit">${not empty srtTablogmain.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="log:srtTablogmain:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="srtTablogmain" action="${ctx}/log/srtTablogmain/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">表：</label>
			<div class="controls">
				<form:input path="tabmainKey" htmlEscape="false" maxlength="128" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">表说明：</label>
			<div class="controls">
				<form:input path="tabmainName" htmlEscape="false" maxlength="256" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="256" class="input-xxlarge "/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">表操作日志记录内容：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>表</th>
								<th>表说明</th>
								<th>表字段</th>
								<th>表字段说明</th>
								<th>旧值</th>
								<th>新值</th>
								<th>备注</th>
								<shiro:hasPermission name="log:srtTablogmain:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="srtTablogsubList">
						</tbody>
						<shiro:hasPermission name="log:srtTablogmain:edit"><tfoot>
							<tr><td colspan="9"><a href="javascript:" onclick="addRow('#srtTablogsubList', srtTablogsubRowIdx, srtTablogsubTpl);srtTablogsubRowIdx = srtTablogsubRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="srtTablogsubTpl">//<!--
						<tr id="srtTablogsubList{{idx}}">
							<td class="hide">
								<input id="srtTablogsubList{{idx}}_id" name="srtTablogsubList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="srtTablogsubList{{idx}}_delFlag" name="srtTablogsubList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_tabKey" name="srtTablogsubList[{{idx}}].tabKey" type="text" value="{{row.tabKey}}" maxlength="128" class="input-small required"/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_tabName" name="srtTablogsubList[{{idx}}].tabName" type="text" value="{{row.tabName}}" maxlength="256" class="input-small "/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_field" name="srtTablogsubList[{{idx}}].field" type="text" value="{{row.field}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_fieldName" name="srtTablogsubList[{{idx}}].fieldName" type="text" value="{{row.fieldName}}" maxlength="256" class="input-small "/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_oldValue" name="srtTablogsubList[{{idx}}].oldValue" type="text" value="{{row.oldValue}}" class="input-small "/>
							</td>
							<td>
								<input id="srtTablogsubList{{idx}}_newValue" name="srtTablogsubList[{{idx}}].newValue" type="text" value="{{row.newValue}}" class="input-small "/>
							</td>
							<td>
								<textarea id="srtTablogsubList{{idx}}_remarks" name="srtTablogsubList[{{idx}}].remarks" rows="4" maxlength="256" class="input-small ">{{row.remarks}}</textarea>
							</td>
							<shiro:hasPermission name="log:srtTablogmain:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#srtTablogsubList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var srtTablogsubRowIdx = 0, srtTablogsubTpl = $("#srtTablogsubTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(srtTablogmain.srtTablogsubList)};
							for (var i=0; i<data.length; i++){
								addRow('#srtTablogsubList', srtTablogsubRowIdx, srtTablogsubTpl, data[i]);
								srtTablogsubRowIdx = srtTablogsubRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="log:srtTablogmain:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>