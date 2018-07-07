<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="edit()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancel()">取消编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="addModel()">添加型号</a>
	</div>
	<table id="tg" class="easyui-treegrid" title="Editable TreeGrid" style="width:700px;height:250px"
			data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: true,
				url: '<%=request.getContextPath()%>/item/brandModel/getList.action',
				method: 'get',
				idField: 'id',
				treeField: 'name',
				showFooter: true
			">
		<thead>
			<tr>
				<th data-options="field:'name',width:180,editor:'text'">名称</th>
			</tr>
		</thead>
	</table>
	<div id="modelAddWindow" class="easyui-window" title="添加型号" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:400px;height:200px;padding:10px;">
		<div style="padding:10px 10px 10px 10px">
			<form id="modelAddForm" class="itemForm" method="post">
			    <table cellpadding="5">
			        <tr>
			            <td>型号名称:</td>
			            <td><input class="easyui-textbox" type="text" name="name" id="modelName" data-options="required:true"/></td>
			        </tr>
			    </table>
			</form>
			<div style="padding:5px">
			    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
			</div>
		</div>
		
	</div>

<script>
var editingId;
var row;
function edit(){
	if (editingId != undefined){
		$('#tg').treegrid('select', editingId);
		return;
	}
	row = $('#tg').treegrid('getSelected');
	if (row){
		editingId = row.id
		$('#tg').treegrid('beginEdit', editingId);
	}
}
function save(){
	if (editingId != undefined){
		var t = $('#tg');
		t.treegrid('endEdit', editingId);
		editingId = undefined;
		var parentId=row._parentId;
		if(parentId==undefined){
			parentId=0;
		}
		$.post(
				'<%=request.getContextPath()%>/item/brandModel/updateDo.action',
				{id:row.id,name:row.name,parentId:row.parentId},
				function (data){
					if(data.code==0000){
						$.messager.alert("提示","更新成功");
					}
				}
			);
		}
	}
function cancel(){
	if (editingId != undefined){
		$('#tg').treegrid('cancelEdit', editingId);
		editingId = undefined;
		row=undefined;
	}
}
function addModel(){
	row = $('#tg').treegrid('getSelected');
	if (row){
		editingId = row.id
		var _parentId=row._parentId;
		if(_parentId==undefined){
			$("#modelAddWindow").window().window("open");
		}else{
			$.messager.alert("提示","不能选择型号，请选择一个汽车品牌！");
			return;
		}
	}else{
		$.messager.alert("提示","请选择一个汽车品牌！");
	}
}
function submitForm(){
	if(!$('#modelAddForm').form('validate')){
		$.messager.alert('提示','表单还未填写完成!');
		return ;
	}
	var name=$("#modelName").val();
	$.post("<%=request.getContextPath()%>/item/brandModel/addDo.action",{parentId:editingId,name:name}, function(data){
		if(data.code == 0000){
			$.messager.alert('提示','添加成功!','info',function(){
				$("#modelAddWindow").window('close');
				$("#tg").treegrid('reload');
			});
		}else{
			$.messager.alert('提示',data.resultStr);
		}
	});
}

</script>