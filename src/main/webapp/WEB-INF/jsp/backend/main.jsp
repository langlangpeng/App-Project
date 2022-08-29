<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="page-title">
	<div class="title_left">
		<h3>
			欢迎你：${backendUser.username}<strong> | 角色：${backendUser.usertype}</strong>
		</h3>
	</div>
</div>
<div class="clearfix"></div>
<%@include file="common/footer.jsp" %>  
     