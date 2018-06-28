<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="lableList"  
       data-options="singleSelect:false,pagination:true,url:'<%=request.getContextPath()%>/lable/list.action',method:'get',pageSize:30,toolbar:'#dlg-toolbar'">
    <thead>
        <tr>
        	<th data-options="field:'id',checkbox:true,width:'40px'"></th>
            <th data-options="field:'name',width:'56%'">标签名称</th>
        </tr>
    </thead>
</table>
<div id="dlg-toolbar">
		<table cellpadding="0" cellspacing="0" style="width:100%">
			<tr>
				<td>
					<input type="button" value="确定选择" class="btn1" onclick="select22();"/>
					<input type="button" value="取消" class="btn1" onclick="closeMe();"/>
				</td>
			</tr>
		</table>
	</div>
<script>
function select22(){
	var ids=getSelectionsIds();
	var names=getSelectionsNames();
	if(ids==''){
		$.messager.alert('提示','至少选择一个标签!');
		return;
	}
	
	window.parent.window.fun1(ids,names);
	$('#dd').dialog('close');
	
}
function closeMe(){
	$('#dd').dialog('close');
}


    function getSelectionsIds(){
    	var lableList = $("#lableList");
    	var sels = lableList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    function getSelectionsNames(){
    	var lableList = $("#lableList");
    	var sels = lableList.datagrid("getSelections");
    	var names = [];
    	for(var i in sels){
    		names.push(sels[i].name);
    	}
    	names = names.join(",");
    	return names;
    }
    var toolbar = [{
        text:'新增',
        handler:function(){
        	$("#lableAddWindow").window("open");
        }
    },{
        text:'编辑',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#lableList").datagrid("getSelections")[0];
        			$("#itemeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    }];
</script>