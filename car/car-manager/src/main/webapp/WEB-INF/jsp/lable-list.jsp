<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<table class="easyui-datagrid" id="lableList" title="标签列表" 
       data-options="singleSelect:false,collapsible:true,fitColumns:true,pagination:true,url:'<%=request.getContextPath()%>/lable/list.action',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'id',checkbox:true"></th>
        	<th data-options="field:'name',width:'120px'">标签ID</th>
            <th data-options="field:'name',width:'120px'">标签名称</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑标签" data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=request.getContextPath()%>/lable/edit.action'" style="width:30%;height:30%;padding:10px;">
</div>
<div id="lableAddWindow" class="easyui-window" title="添加标签" data-options="modal:true,closed:true,iconCls:'icon-save',href:'<%=request.getContextPath()%>/lable/add.action'" style="width:30%;height:30%;padding:10px;">
</div>
<script>
$(function(){
	　　//初始加载，表格宽度自适应
	    $(document).ready(function(){
	        fitCoulms();
	    });
	　　//浏览器窗口大小变化后，表格宽度自适应
	    $(window).resize(function(){
	        fitCoulms();
	    });
	});

	//表格宽度自适应，这里的#dg是datagrid表格生成的div标签
	function fitCoulms(){
	    $('#lableList').datagrid({
	        fitColumns:true
	    });
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
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#lableAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
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
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
   	    	var params = {"ids":ids};
           	$.post("<%=request.getContextPath()%>/lable/delete.action",params, function(data){
       			if(data.code == 0000){
       				$.messager.alert('提示','删除成功!',undefined,function(){
       					$("#lableList").datagrid("reload");
       				});
       			}
       		});
        }
    }];
</script>