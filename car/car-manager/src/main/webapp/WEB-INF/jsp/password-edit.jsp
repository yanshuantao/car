<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="width:400px;height:300px;border:1px solid #95B8E7;">
		<form id="lableAddForm" class="itemForm" method="post">
		    <table cellpadding=3>
	 <tr>
	    <td>新密码：</td>
	    <td><input id="txtNewPass" type="Password" class="txt01 easyui-validatebox" 
	               required="true" data-options="validType:'length[4,8]'" />
	    </td>
	 </tr>
	 <tr>
	    <td>确认密码：</td>
	    <td><input id="txtRePass" type="Password" class="txt01 easyui-validatebox" 
	                                required="true" data-options="validType:'length[4,8]'"/>
	    </td>
	 </tr>
	 </table>
	            <div region="south" border="false" style="text-align: left; height: 30px; line-height: 30px;">
	                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >确定</a> 
	                <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
	            </div>
		</form>

</div>
<script type="text/javascript">
//为“确定”按钮绑定事件
$("#btnEp").click(function(){
    //进行表单校验
    var v = $("#editPasswordForm").form("validate");//对应表单中的所有输入框进行校验
    if(v){//表单校验通过
        //判断两次输入是否一致
        var v1 = $("#txtNewPass").val();
        var v2 = $("#txtRePass").val();
        if(v1 == v2){
            //输入一致，发送ajax请求，修改当前用户的密码
            var url = "${pageContext.request.contextPath}/updatePasswordDo.action";
            $.post(url,{"password":v1},function(data){
                if(data.code == 0000){
                    //修改密码成功
                    $.messager.alert("提示信息","密码修改成功！","info");
                }else{
                    //修改失败
                    $.messager.alert("提示信息",data.resultStr,"warning");
                }
                //关闭修改密码的窗口 
                window.parent.tabsClose();
            });
        }else{
            //输入不一致，提示用户输入不一致
            $.messager.alert("提示信息","两次输入密码不一致！","warning");
        }
    }
});
</script>
