<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="urls" value="<%=request.getContextPath()%>"></c:set>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>恒划算后台管理系统</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/jquery-easyui-1.3.3/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/taotao.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>


<%-- <!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/createActive/css/bootstrap.min.css" rel="stylesheet" />

<!--  Light Bootstrap Dashboard core CSS    -->
<link href="<%=request.getContextPath()%>/createActive/css/light-bootstrap-dashboard.css" rel="stylesheet"/>

<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<%=request.getContextPath()%>/createActive/css/demo.css" rel="stylesheet" />

<!-- Fonts and icons -->
<link href="<%=request.getContextPath()%>/createActive/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/createActive/css/font-Roboto.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/createActive/css/pe-icon-7-stroke.css" rel="stylesheet" />

<script src="<%=request.getContextPath()%>/createActive/js/jquery.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/createActive/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/createActive/js/base-swal.js" type="text/javascript"></script> --%>




<script type="text/javascript">
	var bathPath="<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
         	<li>
         		<span>商品管理</span>
         		<ul>
         			<li data-options="attributes:{'url':'${urls }/lable/start.action'}">标签管理</li>
	         		<li data-options="attributes:{'url':'${urls }/item/start.action'}">查询商品</li>
	         		<li data-options="attributes:{'url':'${urls }/item/add.action'}">新增商品</li>
	         		<li data-options="attributes:{'url':'${urls }/item/brandModel/start.action'}">商品品牌型号</li>
	         	</ul>
         	</li>
         	<!-- <li>
         		<span>网站内容管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'content-category'}">内容分类管理</li>
	         		<li data-options="attributes:{'url':'content'}">内容管理</li>
	         	</ul>
         	</li>
         	<li>
         		<span>索引库管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'import-index'}">导入索引库</li>
	         	</ul>
         	</li> -->
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        	
		    </div>
		</div>
    </div>
    
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
function tabsClose(){
	var tab=$('#tabs').tabs('getSelected');//获取当前选中tabs
	var index = $('#tabs').tabs('getTabIndex',tab);//获取当前选中tabs的index
	$('#tabs').tabs('close',index);//关闭对应index的tabs
}
</script>
</body>
</html>