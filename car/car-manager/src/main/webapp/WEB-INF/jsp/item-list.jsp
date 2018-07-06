<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!-- <div class="headDiv">
	 <form name="searchform" method="post" action="" id ="searchform">
	 	<ul class="conditionUl">
	 		<li>专家检索：</li>
	 		<li></li>
	 		<li></li>
	 		<li></li>
	 		<li></li>
	 	</ul>
	    <td width="70" height="30"><strong>专家检索：</strong></td>
	    <td height="30">
	        <input type="text" name="keyword" size=20 >
	        <select name="search_type" id="search_type" >
	            <option value="-1">请选择搜索类型</option>
	            <option value="be_name" >按专家姓名</option>
	            <option value="be_intro">按专家简介</option>
	        </select>
	        <select name="search_dept" id="search_dept">
	            <option value="-1">请选择所属科室</option>
	        </select>
	        <a id="submit_search">搜索</a>
	    </td>
	  </form>
 </div> -->
<table class="easyui-datagrid" id="itemList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'<%=request.getContextPath()%>/item/list.action',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'id',checkbox:true"></th>
            <th data-options="field:'item.name'">商品标题</th>
            <th data-options="field:'brandName'">品牌</th>
            <th data-options="field:'modelName'">型号</th>
            <th data-options="field:'item.propertyType'">车型类别</th>
            <th data-options="field:'item.priceLow',align:'right'">最低价格</th>
            <th data-options="field:'item.priceHigh',align:'right'">最高价格</th>
            <th data-options="field:'item.country'">生产国</th>
            <th data-options="field:'item.stock'">库存数量</th>
            <th data-options="field:'labelName'">标签</th>
            <th data-options="field:'item.priority'">排序优先级</th>
            <th data-options="field:'item.status',align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'item.createTime',align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
            <th data-options="field:'item.id',align:'right',formatter:formatOper">查看规格</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

function formatOper(val,row,index){
	return '<input type="button" value="查看规格" onclick="viewSpec('+val+');"  class="btn1"/>';
}
function viewSpec(itemId){
	//$(".tree-title:contains('商品规格')").parent().click();
	addTab('商品规格','<%=request.getContextPath()%>/item/specDetail/'+itemId+'.action');
}
    function addTab(title, url){
		$('#tabs').tabs('add',{
			title:title,
			href:url,
			closable:true
		});
}

    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].item.id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增商品')").parent().click();
        }
    },'-',{
        text:'禁用',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
   	    	var params = {"ids":ids};
           	$.post("<%=request.getContextPath()%>/item/disable.action",params, function(data){
       			if(data.code == 0000){
       				$.messager.alert('提示','禁用商品成功!',undefined,function(){
       					$("#itemList").datagrid("reload");
       				});
       			}
       		});
        }
    },{
        text:'启用',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
   	    	var params = {"ids":ids};
           	$.post("<%=request.getContextPath()%>/item/enable.action",params, function(data){
       			if(data.code == 0000){
       				$.messager.alert('提示','启用商品成功!',undefined,function(){
       					$("#itemList").datagrid("reload");
       				});
       			}
       		});
        }
    }];
</script>