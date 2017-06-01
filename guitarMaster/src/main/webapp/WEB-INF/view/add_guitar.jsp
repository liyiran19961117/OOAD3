<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<title>吉他管理</title>
<script type="text/javascript">
	$(function() {
			$('#submit').click(function(){
				$('#ff').form('submit', {    
				    url:'${pageContext.request.contextPath}/guitar/guitarAction_addGuitar',    
				    success:function(data){   
				    	if (data.status == "ok") {
				    		$.messager.alert('我的消息','添加成功！','info');
							$("#ff").form("reset");
							parent.$("#dgGuitar").datagrid("reload");
							parent.$('#win').window('close')
						
				    }    
				}});
		})
	});
		
</script>
</head>
<body style="margin: 1px;">
	<center>
		<form id="ff">
			<table cellspacing="10">
				<tr>
					<td>序&nbsp;&nbsp;列&nbsp;&nbsp;号：</td>
					<td><input id="serialNumber" type="text" name="serialNumber" class="easyui-textbox" style="width: 200px" ></td>
				</tr>
				<tr>
					<td>制&nbsp;&nbsp;造&nbsp;&nbsp;商：</td>
					<td><input id="builder" name="builder" class="easyui-textbox"
						style="width: 200px" /></td>
				</tr>
				<tr>
					<td>弦&nbsp;&nbsp;&nbsp;&nbsp;数：</td>
					<td><input id="numStrings" class="easyui-textbox" name="numStrings" style="width: 200px"></td>
				</tr>
				<tr>
					<td>背&nbsp;部&nbsp;材&nbsp;料：</td>
					<td><input id="backWood" class="easyui-textbox" name="backWood" style="width: 200px"></td>
				</tr>
				<tr>
					<td>顶&nbsp;部&nbsp;材&nbsp;料：</td>
					<td>
						<input id="topWood" class="easyui-textbox" name="topWood" style="width: 200px;"   /> 
					</td>
				</tr>

				<tr>
					<td>型&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
					<td><input id="model" type="text" name="model" class="easyui-textbox" style="width: 200px" ></td>
				</tr>
			</table>
			<div style="margin-top: 20px; text-align: center;">
						<center>
							<a id="submit" href="#" class="easyui-linkbutton"
								data-options="iconCls:'icon-add'">添加</a>
						</center>
			</div>
		</form>
	</center>
</body>
</html>