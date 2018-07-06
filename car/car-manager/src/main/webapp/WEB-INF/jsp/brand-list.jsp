<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<div style="margin:20px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="edit()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancel()">取消编辑</a>
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



<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
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
		$.post('<%=request.getContextPath()%>/item/brandModel/updateDo.action',
			data:{
				  itemId:row.id,
				  name:row.name
			  },
			}
			success:(function (data){
				if(data.code==0000){
					$.messager.alert("更新成功");
				}
			})	
		);
		alert(row.name);
	}
}
function cancel(){
	if (editingId != undefined){
		$('#tg').treegrid('cancelEdit', editingId);
		editingId = undefined;
	}
}

</script>