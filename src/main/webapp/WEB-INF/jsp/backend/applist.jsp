<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">

	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					APP 审核列表 <i class="fa fa-user"></i><small>${backendUser.username}
						- 您可以通过搜索或者其他的筛选项对APP的信息进行审核操作。^_^</small>
				</h2>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<form method="post" id="form1"  action="${pageContext.request.contextPath}/noPassAppInfo">
					<!--注意:控制器中接收页码的我名称叫page-->
					<input type="hidden" id="setPage" name="page" value="1" />
			    <ul>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">软件名称</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input name="querySoftwareName" type="text" class="form-control col-md-7 col-xs-12" value="${querySoftwareName }">
							</div>
						</div>
					</li>
					
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="queryFlatformId" name="queryFlatformId"  class="form-control">
									   <option value="">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="queryCategoryLevel1" name="queryCategoryLevel1" class="form-control">
									   <option value="">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
							<input type="hidden" name="categorylevel2list" id="categorylevel2list"/>
        						<select name="queryCategoryLevel2" id="queryCategoryLevel2" class="form-control">
									   <option value="">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
        						<select name="queryCategoryLevel3" id="queryCategoryLevel3" class="form-control">
									   <option value="">--请选择--</option>
        						</select>
							</div>
						</div>
					</li>
					<li><button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button></li>
				</ul>
			</form>
		</div>
	</div>
</div>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_content">
			<p class="text-muted font-13 m-b-30"></p>
			<div id="datatable-responsive_wrapper"
				class="dataTables_wrapper form-inline dt-bootstrap no-footer">
				<div class="row">
					<div class="col-sm-12">
						<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
							cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 70px;" aria-label="First name: activate to sort column descending"
										aria-sort="ascending">软件名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 10px;"
										aria-label="Last name: activate to sort column ascending">
										APK名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 90px;"
										aria-label="Last name: activate to sort column ascending">
										软件大小(单位:M)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 50px;"
										aria-label="Last name: activate to sort column ascending">
										所属平台</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 170px;"
										aria-label="Last name: activate to sort column ascending">
										所属分类(一级分类、二级分类、三级分类)</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 30px;"
										aria-label="Last name: activate to sort column ascending">
										状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 30px;"
										aria-label="Last name: activate to sort column ascending">
										下载次数</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 64px;"
										aria-label="Last name: activate to sort column ascending">
										最新版本号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 30px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="appInfo" items="${pageInfo.list}" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${appInfo.softwarename}</td>
										<td>${appInfo.apkname }</td>
										<td>${appInfo.softwaresize }</td>
										<td>${appInfo.ptname }</td>
										<td>${appInfo.tname1 } -> ${appInfo.tname2 } -> ${appInfo.tname3 }</td>
										<td>${appInfo.sname }</td>
										<td>${appInfo.downloads }</td>
										<td>${appInfo.versionid }</td>
										<td>
										<button name="checkbutton" appid="${appInfo.id}" appversion="${appInfo.versionid}"   type="button" class="btn btn-default checkApp"
											data-toggle="tooltip" data-placement="top" title="" data-original-title="查看并审核APP">审核</button>
										</td>
									</tr>
								</c:forEach>
<%--								<tr>--%>
<%--									<td colspan="9">--%>
<%--										<div>--%>
<%--											共${pageInfo.total}条  ${pageInfo.pageNum}/${pageInfo.pages}--%>
<%--											<nav>--%>
<%--												<ul class="pagination">--%>
<%--													<c:forEach end="${pageInfo.pages}" var="temp"  begin="1" step="1">--%>
<%--														<li><a href="javascript:page_nav(${temp})">${temp}</a></li>--%>
<%--													</c:forEach>--%>
<%--												</ul>--%>
<%--											</nav>--%>
<%--										</div>--%>
<%--									</td>--%>
<%--								</tr>--%>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-5">
						<div class="dataTables_info" id="datatable-responsive_info"
							 role="status" aria-live="polite">共${pageInfo.total}条记录
							${pageInfo.pageNum }/${pageInfo.pages}页</div>
					</div>
					<div class="col-sm-7">
						<div class="dataTables_paginate paging_simple_numbers"
							 id="datatable-responsive_paginate">
							<ul class="pagination">
								<c:if test="${pageInfo.pageNum > 1}">
									<li class="paginate_button previous"><a
											href="javascript:page_nav(1);"
											aria-controls="datatable-responsive" data-dt-idx="0"
											tabindex="0">首页</a>
									</li>
									<li class="paginate_button "><a
											href="javascript:page_nav(${pageInfo.pageNum-1});"
											aria-controls="datatable-responsive" data-dt-idx="1"
											tabindex="0">上一页</a>
									</li>
								</c:if>
								<c:if test="${pageInfo.pageNum < pageInfo.pages}">
									<li class="paginate_button "><a
											href="javascript:page_nav(${pageInfo.pageNum+1 });"
											aria-controls="datatable-responsive" data-dt-idx="1"
											tabindex="0">下一页</a>
									</li>
									<li class="paginate_button next"><a
											href="javascript:page_nav(${pageInfo.pages});"
											aria-controls="datatable-responsive" data-dt-idx="7"
											tabindex="0">最后一页</a>
									</li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
		</div>
	</div>
</div>
</div>
<%@include file="common/footer.jsp"%>
	<script language="JavaScript">
		$(function (){
			//加载事件
			//1.发送异步请求获取app状态进行展示
			$.get("${pageContext.request.contextPath}/getAppState",null,function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					//创建一个option
					var option = $("<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>");
					$('#queryStatus').append(option)
				}
				$("#queryStatus").val(${condition.queryStatus});
			},"json");

			//1.发送异步请求获取app状态进行展示
			$.get("${pageContext.request.contextPath}/getFlatForm",null,function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					//创建一个option
					var option = $("<option value='"+data[i].valueid+"'>"+data[i].valuename+"</option>");
					$('#queryFlatformId').append(option)
				}
				$("#queryFlatformId").val(${condition.queryFlatformId});
			},"json");

			$.get("${pageContext.request.contextPath}/getCategoryByPid",null,function(data){
				//console.log(data);
				for(var i=0;i<data.length;i++){
					//创建一个option
					var option = $("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
					$('#queryCategoryLevel1').append(option)
				}
				$("#queryCategoryLevel1").val(${condition.queryCategoryLevel1});
				loadTwoType();
			},"json");
			$('#queryCategoryLevel1').change(loadTwoType);
			function loadTwoType(){
				$("#queryCategoryLevel2>option:gt(0)").remove();
				$("#queryCategoryLevel3>option:gt(0)").remove();
				var id = $('#queryCategoryLevel1').val();
				if (id!=""){
					$.get("${pageContext.request.contextPath}/getCategoryByPid",{"id":id},function(data){
						//console.log(data);
						for(var i=0;i<data.length;i++){
							//创建一个option
							var option = $("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
							$('#queryCategoryLevel2').append(option)
						}
						$("#queryCategoryLevel2").val(${condition.queryCategoryLevel2});
						loadThreeType();
					},"json");
				}
			}

			$('#queryCategoryLevel2').change(loadThreeType);
			function loadThreeType(){
				$("#queryCategoryLevel3>option:gt(0)").remove();
				var id = $('#queryCategoryLevel2').val();
				if (id!=""){
					$.get("${pageContext.request.contextPath}/getCategoryByPid",{"id":id},function(data){
						//console.log(data);
						for(var i=0;i<data.length;i++){
							//创建一个option
							var option = $("<option value='"+data[i].id+"'>"+data[i].categoryname+"</option>");
							$('#queryCategoryLevel3').append(option)
						}
						$("#queryCategoryLevel3").val(${condition.queryCategoryLevel3});
					},"json");
				}
			}
		});
		function page_nav(pageNum) {
			$("#setPage").val(pageNum);
			$("#form1").submit();
		}
		$(function(){
			//点击事件
			$("[name='checkbutton']").click(function(){
				//获取当前按钮的属性值
				var appid=$(this).attr("appid");
				var appversion=$(this).attr("appversion");
				if(appversion==""){
					alert("当前app信息没有最新版本..不与审核");
				}else{
					location.href="${pageContext.request.contextPath}/goCheck?appid="+appid;
				}
			});
		});

	</script>