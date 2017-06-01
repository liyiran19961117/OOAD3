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
function search(){
	    var url="${pageContext.request.contextPath}/guitar/guitarAction_searchGuitar";
	    var numStrings=$("#numStrings").val();
	    var model=$("#model").val();
	    var backWood=$("#backWood").val();
		var topWood=$("#topWood").val();
	    var builder=$("#builder").val();
		$('#dgGuitar').datagrid('options').url=url;
		$('#dgGuitar').datagrid('reload',{
			 numStrings:numStrings,
			 builder:builder,
			 model:model,
			 backWood:backWood,
			 topWood:topWood
		});
};
$(function(){
	$('#dgGuitar').datagrid({    
	   url:'${pageContext.request.contextPath}/guitar/guitarAction_getAllGuitar',
	   singleSelect:true,
	   fitColumns:true,
	   fit:true,
	   rownumbers:true,
	   striped:true,
	   /*分页*/
// 	   pagination:true,
// 	   pagePosition:'bottom',
// 	   pageNumber:1,
// 	   pageSize:30,
// 	   pageList:[30,60,100,150],
	   /*按钮*/
	   toolbar:[{
	    	id:'add',
	    	text:'添加',
	    	iconCls:'icon-add',
	    	handler:function(){
	    			$('#win').dialog({
		    			width:400,
		    			height:400,
		    			title:'添加吉他',
		    			modal: true,
		    			minimizable:false,
		    			maximizable:false,
		    			resizable:true,
		    			cache:false,
		    			content:'<iframe src="${pageContext.request.contextPath}/add_guitar" frameborder="0" width="100%" height="100%"/>'
		    		});
	    	}
	    },{
			id:'delete',
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){
				var row=$('#dgGuitar').datagrid('getSelected');
				if(row){
					$.messager.confirm('确认对话框','您要删除选中的记录吗？', function(r){
						if (r){
							$.ajax({
					            type: "POST",
					            url: "${pageContext.request.contextPath}/guitar/guitarAction_deleteGuitar",
					            data: {'serialNumber':row.serialNumber,deleted:true},
					            dataType: "json",
					            success: function(data){
					                	if(data.status=="ok"){
					                		$.messager.alert('我的消息','删除成功！','info');
						                }else{
						                	$.messager.alert('我的消息','删除失败！','error');
							            }
					                	$('#dgGuitar').datagrid('reload');         
					            }
					        });
						}
					});
				}else{
					parent.$.messager.show({
						title:'我的消息',
						msg:'请先选择一条记录！',
						showType:'show',
						timeout:500,
						style:{
							right:'',
							top:document.body.scrollTop+document.documentElement.scrollTop+200,
							bottom:''
						}
					});
											
				}
			}
		}],
	   
	    columns:[[ 
			{field:'serialNumber',title:'序列号',width:'15%',align:'center'},
	    	{field:'builder',title:'制造商',width:'15%',align:'center'},  
	        {field:'backWood',title:'背部材料',width:'15%',align:'center'},    
	        {field:'topWood',title:'顶部材料',width:'5%',align:'center'}, 
	        {field:'numStrings',title:'弦数',width:'13%',align:'center'},
	        {field:'model',title:'型号',width:'12%',align:'center'} 
	    ]] 
	}); 
})		
</script>
</head>
<body style="margin: 1px;">
	<center>
		<form id="ff">
			<table cellspacing="10">
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
<!-- 				<tr> -->
<!-- 					<td>价&nbsp;&nbsp;&nbsp;&nbsp;格：</td> -->
<!-- 					<td><input id="price" type="text" name="price" class="easyui-textbox" style="width: 200px" ></td> -->
<!-- 				</tr> -->
				<tr>
					<td>型&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
					<td><input id="model" type="text" name="pwd" class="easyui-textbox" style="width: 200px" ></td>
				</tr>
			</table>
			<div style="margin-top: 20px; text-align: center;">
						<center>
							<div onclick="search()" class="easyui-linkbutton"
								data-options="iconCls:'icon-search'">查询</div>
						</center>
			</div>
		</form>
	</center>
	<table id="dgGuitar"></table>
	<div id="win"> </div>
	</body>
</html>