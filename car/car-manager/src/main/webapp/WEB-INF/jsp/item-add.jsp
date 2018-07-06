<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="item.name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>汽车型号:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat" id="+specIndex+">选择型号</a>
	            	<input type="hidden" name="item.brandModleId"/>
	            </td>
	        </tr>
	        <tr>
	        	<td>车型类别：</td>
	        	<td>
	        		<label><input name="item.propertyType" type="radio" value="1" checked="checked"/>小轿车</label>
	        		<label><input name="item.propertyType" type="radio" value="2" />SUV</label>
	        		<label><input name="item.propertyType" type="radio" value="3" />跑车 </label>
	        	</td>
	        </tr>
	        <tr>
	        	<td>是否自动档</td>
	        	<td>
	        		<label><input name="item.isAuto" type="radio" value="1" />是 </label>
	        		<label><input name="item.isAuto" type="radio" value="0" checked="checked"/>否</label>
        		</td>
	        </tr>
	        <tr>
	        	<td>所属国家：</td>
	        	<td>
	        		<select name="item.country" class="easyui-select">
	        			<option value="中国">中国</option>
	        			<option value="美国">美国</option>
	        			<option value="德国">德国</option>
	        			<option value="日本">日本</option>
	        			<option value="韩国">韩国</option>
	        		</select>
	        	</td>
	        </tr>
	        <tr>
	        	<td>变速箱</td>
	        	<td>
	        		<label><input name="item.speedBox" type="radio" value="1" />手动</label>
	        		<label><input name="item.speedBox" type="radio" value="2" checked="checked"/>自动</label>
	        	</td>
	        </tr>

	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc.itemDescription"></textarea>
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
	        </tr>	        <tr class="params">
	        	<td>商品规格:</td>
	        	<td>
	        		<input type="button" value="添加规格" class="btn1" onclick="addSpec22();"/>
	        	</td>
	        	
	        </tr>
	        <tr>
	        	<td colspan="5" id="specDiv">
			        	<!-- <ul class="ul1" id="specDiv">
			        	</ul> -->
			        	
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

	var itemAddEditor ;
	var specIndex=0;
	var basePath = "<%=request.getContextPath()%>";
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc.itemDescription]");
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
	function addSpec22(){
		++specIndex;
		var specStr='<ul class="ul1"><li>配置名称:<input type="text" class="easyui-textbox" name="specModel.configurationName"/></li>'+
					'<li>建议价格:<input type="text" class="easyui-textbox" name="specModel.fixPriceStr"/></li>'+
					'<li>实际价格：<input type="text" class="easyui-textbox" name="specModel.nowPriceStr"/></li>'+
						'<li>油耗：<input type="text" class="easyui-textbox" name="specModel.oilWear"/></li>'+
						'<li>排量：<input type="text" class="easyui-textbox" name="specModel.displacementStr"/></li>'+
						'<li>能源类型：'+
								  '<label><input name="specModel.energyStr" type="radio" value="1" checked="checked"/>汽油 </label>'+
								  '<label><input name="specModel.energyStr" type="radio" value="2" />油电混合</label>'+
								  '<label><input name="specModel.energyStr" type="radio" value="3" />天然气 </label>'+
						'</li>'+
						'<li>座位数：<input type="text" class="easyui-textbox" name="specModel.seatNumberStr"/></li>'+
						'<li>库存数：<input type="text" class="easyui-textbox" name="specModel.stockStr"/></li>'+
					'<li>'+
						'<a href="javascript:void(0)" class="easyui-linkbutton picFileUpload'+specIndex+'">上传图片</a>'+
			 			'<input type="hidden" name="specModel.imgStr"/>'+
					'</li>'+
		 			'<li><input type="button" value="删除该规格" class="btn1 deleteSpec"></li>'+
			 			'<div style="clear:both;"></div></ul>';
		$("#specDiv").append(specStr);
		TAOTAO.initPicUpload({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			//TAOTAO.changeItemParam(node, "itemAddForm");
		}},specIndex);
		$.parser.parse("#specDiv");
	}
	function deleteSpec(){
		$(this).parent(".ul1").remove();
	}
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name*=Price]").val()) * 100);
		//同步文本框中的商品描述
		itemAddEditor.sync();
		$.post(basePath+"/item/addDo.action",$("#itemAddForm").serialize(), function(data){
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
					'<input type="hidden" name="item.labels" value="'+id+'">'+
					/* '<input type="hidden" name="labelname" value="'+name+'">'+ */
					'<img class="proMark_span02 fr" src="<%=request.getContextPath()%>/images/bookMarkCloseBtn.png">'+
					'<div class="clear"></div>'+
					'</li>';
				$("#lableUl").append(str);
   			}
    		
    	}
	}
	//打开选择标签窗口
	function openNew(){
		$('#dd').dialog({
            width: 500,
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
	//删除规格
	$("#specDiv").on("click",".deleteSpec",function() {
		$(this).parent().parent().remove();
	});
</script>
