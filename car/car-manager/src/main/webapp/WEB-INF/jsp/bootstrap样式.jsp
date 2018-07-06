<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
	</head>

	<body>
	
	<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="content">
						
	                        <form class="form-horizontal" action="${urls}/business/templateNew/queryByPage.jspa" id="from1" method="post">
							<div class="form-group">
	                            	<label class="col-md-1 control-label">消息类型：</label>
									<div class="col-md-2">
										<select name="type" id="type2" class="form-control default-select">
									  	<option value="">请选择消息类型</option>
									  	<option value="1">短信</option>
									  	<option value="2">站内信</option>
									  	<option value="3">邮件</option>
									  	<option value="4">通知</option>
									  </select>
		                            </div>
		                            
		                            <label class="col-md-1 control-label">名称：</label>
									<div class="col-md-2">
										<input name="name" id="name" value="${page.query['name']}" type="text" class="form-control" />
		                            </div>
		                            
		                            <div class="col-md-2">
		                                <input type="button" value="重置" class="btn btn-primary btn-fill btn-wd btn-search" onclick="reset2();"/>
		                           </div>
		                           
		                           <div class="col-md-2">
		                         		<input type="submit" value="查询" class="btn btn-primary btn-fill btn-wd btn-search"  />
		                           </div>
		                            
							</div>
	                     </form>
					</div>
				</div>
			</div>
		</div>
	
	
           <div class="row">
               <div class="col-md-12">
                   <div class="card">
                   		<!-- 列表表头显示 -->
						<div class="header">
							<div class="col-sm-6">
								<div class="dataTables_length" id="datatables_length">
									<h4 class="title">查询结果</h4>
								</div>
							</div>
							<div class="col-sm-6 text-right">
							<div id="datatables_filter" class="dataTables_filter">
				                 <input type="button" value="添加" class="btn btn-primary btn-fill" onclick="addAction();"/>
							</div>
						</div>
						</div>	
						<div class="content table-responsive table-full-width">
						    <table class="table table-hover table-striped">
						        <thead >
						        <tr>
									<th>消息类型</th>
									<th>名称</th>
									<th>状态</th>
									<th>更新时间</th>	
									<th>最后更新人</th>											
									<th>操作</th>
		                        </tr>
						        </thead>
						        <tbody align="center">
						        <c:forEach items="${page.items }" var="items">
						            <tr>
						            	<td>
											<c:if test="${items.type==1}">
												短信
											</c:if>
											<c:if test="${items.type==2}">
												站内信
											</c:if>
											<c:if test="${items.type==3}">
												邮件
											</c:if>
											<c:if test="${items.type==4}">
												通知
											</c:if>
										</td>
										<td>
											${items.name }
										</td>
										<td>
											<c:if test="${items.status==1}">
												草稿
											</c:if>
											<c:if test="${items.status==2}">
												正常
											</c:if>
											<c:if test="${items.status==3}">
												停用
											</c:if>
										</td>
										<td>
											<fmt:formatDate type="both" value="${items.updateTime}"/>
										</td>
										<td>
											${items.updateUser}
										</td>
																																			
										<td>
											<c:if test="${items.status==2}">
												<a href="#"  onclick="updateStatus('${items.id}',3);">
								              		停用
											  	</a>
											</c:if>
											<c:if test="${items.status==1}">
												<a href="#"  onclick="editAction('${items.id}');">
								              		编辑
											  	</a>
											  	<a href="#"  onclick="updateStatus('${items.id}',2);">
								              		启用
											  	</a>
											</c:if>
											<c:if test="${items.status==3}">
												<a href="#"  onclick="editAction('${items.id}');">
								              		编辑
											  	</a>
											  	<a href="#"  onclick="updateStatus('${items.id}',2);">
								              		恢复
											  	</a>
											</c:if>
										</td>
						            </tr>
						            </c:forEach>
						        </tbody>
						    </table>
						</div>
				</div>
			</div>
		</div>
</body>

</html>
