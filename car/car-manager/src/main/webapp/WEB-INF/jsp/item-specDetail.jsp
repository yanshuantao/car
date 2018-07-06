<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	    <table cellpadding="5">

	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea id="itemDesc" style="width:800px;height:300px;visibility:hidden;" value="${itemDesc.itemDescription}" readonly></textarea>
	            </td>
	        </tr>
	        <tr class="params">
	        	<td>商品规格:</td>
	        </tr>
	        <tr>
	        	<td colspan="5">
		        	<c:forEach items="${specList}" var="specModel">
		        		<c:set value="${ fn:split(specModel.imgStr, ',') }" var="imgArray" />
		        		<ul class="ul1">
							<li>配置名称：<input type="text" class="easyui-textbox" value="${specModel.configurationName}" readonly/></li>
							<li>建议价格：<input type="text" class="easyui-textbox" value="${specModel.fixPrice}" readonly/></li>
							<li>实际价格：<input type="text" class="easyui-textbox" value="${specModel.nowPrice}" readonly/></li>
							<li>油耗：<input type="text" class="easyui-textbox" value="${specModel.oilWear}" readonly/></li>
							<div style="clear:both;"></div>
							<li>排量：<input type="text" class="easyui-textbox" value="${specModel.displacement}" readonly/></li>
							<li>能源类型：<input type="text" class="easyui-textbox" value="${specModel.energy}" readonly/></li>
							<li>座位数：<input type="text" class="easyui-textbox" value="${specModel.seatNumber}" readonly/></li>
							<li>库存数：<input type="text" class="easyui-textbox" value="${specModel.stock}" readonly/></li>
							<li style="width:100%">图片缩略图：</li>
							<c:forEach items="${imgArray}" var="imgUrl">
								<li ><a href='${imgUrl}' target='_blank'><img src='${imgUrl}' width='160' height='100' /></a></li>
							</c:forEach>
							<div style="clear:both;"></div>
						</ul>
		        	</c:forEach>
	        	</td>
	        </tr>
	    </table>
	<div style="padding:5px">
		<input type="button" value="返回" onclick="closeDetail();" class="btn1">
	</div>
</div>
<script type="text/javascript">

	var itemAddEditor ;
	var specIndex=0;
	var basePath = "<%=request.getContextPath()%>";
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemDesc");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}});
		/* TAOTAO.initPicUpload2({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}}); */

	});
	function closeDetail(){
		window.parent.tabsClose();
	}
	
</script>
