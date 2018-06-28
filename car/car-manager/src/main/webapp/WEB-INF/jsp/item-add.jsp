<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>汽车型号:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择型号</a>
	            	<input type="hidden" name="brandModleId" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品标签:</td>
	            <td>
	            	<ul id="lableUl"></ul>
				</td>
	        </tr>
	        <tr>
	        	<td></td>
	            <td><input type="button" value="添加标签" onclick="openNew();" class="btn1"/></td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	        <tr class="params">
	        	<td>商品规格:</td>
	        	<td>
	        		<input type="button" value="添加规格" class="btn1" onclick="addSpec22();"/>
	        	</td>
	        	
	        </tr>
	        <tr>
	        	<td colspan="5">
	        		<div id="specDiv">
			        	<ul class="ul1">
			        		<li>配置名称:<input type="text" class="easyui-textbox"/></li>
			        		<li>建议价格:<input type="text" class="easyui-textbox"/></li>
			        		<li>实际价格：<input type="text" class="easyui-textbox"/></li>
                 			<li>油耗：<input type="text" class="easyui-textbox"/></li>
                 			<li>排量：<input type="text" class="easyui-textbox"/></li>
                 			<li>能源类型：<input type="text" class="easyui-textbox"/></li>
                 			<li>座位数：<input type="text" class="easyui-textbox"/></li>
                 			<li>库存数：<input type="text" class="easyui-textbox"/></li>
			        		<li>
			        			<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 			<input type="hidden" name="image"/>
                 			</li>
			        	</ul>
	        		</div>
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
		<input type="button" value="提交" onclick="submitForm()" class="btn1">
		<input type="reset" value="重置" onclick="clearForm()" class="btn1">
	</div>
	<div id="dd"></div>
</div>
<script type="text/javascript">

	var specStr="<ul><li>商品价格:</li><li>商品价格</li><li>商品价格</li><li>商品价格</li></ul>";
	var itemAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}},'11');

	});
	function addSpec22(){
		$("#specDiv").append(specStr);
	}
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		itemAddEditor.sync();
		$.post("/item/save",$("#itemAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增商品成功!');
			}
		});
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
	//选择标签后父页面回调方法
	function fun1(lableIdStr,lableNameStr){
		var idArray=new Array();
		var nameArray=new Array();
		idArray=lableIdStr.split(',');
		nameArray=lableNameStr.split(',');
		for(var i=0;i<idArray.length;i++){
    		var id = idArray[i];
    		var name="";
    		if(nameArray.length>i){
    			name=nameArray[i];
    		}
    		var oldIds=document.getElementsByName('labelId');
   			var addFlag=true;
   			for(var j=0;j<oldIds.length;j++){
   				var oldId=oldIds[j].value;
				if(oldId==id){
					addFlag=false;
					break;
				}
   			}
   			if(addFlag){
				var str='<li class="proMark_li02 radius3 fl" style="margin-bottom:10px;">'+
					'<span class="proMark_span01 fl" style="margin:0px 10px 0px;">'+name+'</span>'+
					'<input type="hidden" name="labelId" value="'+id+'">'+
					'<input type="hidden" name="labelname" value="'+name+'">'+
					'<img class="proMark_span02 fr" src="<%=request.getContextPath()%>/images/bookMarkCloseBtn.png">'+
					'<div class="clear"></div>'+
					'</li>';
				$("#lableUl").append(str);
   			}
    		
    	}
	}
	//打开选择标签窗口
	function openNew(){
		var basePath = "<%=request.getContextPath()%>";
		$('#dd').dialog({
            width: 1000,
           	height: 550,
           	title:'选择标签',
           	closed: false,
        	cache: false,
          	collapsible:true,
          	href: basePath+'/lable/select.action',
           	modal: true
      });
	}
	//删除标签
	$("#lableUl").on("click",".proMark_span02",function() {
		$(this).parent().remove();
	});
</script>
