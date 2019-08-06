<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改问卷类型</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="x-body">

		
		<form class="layui-form"
			action="<%=request.getContextPath()%>/type.do" method="post"
			target="_parent">
			<input type="hidden" name="kc" value="update"> <input
				type="hidden" name="type_id" value="${requestScope.map.type_id }">

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>类型
				</label>
				<div class="layui-input-inline">
					<input type="text" id="type_name" name="type_name" required
						lay-verify="type_name" autocomplete="off" class="layui-input"
						value="${requestScope.map.type_name }">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					更新</button>
			</div>
		</form>
	</div>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/page/m02_type/js/update.js?v=<%=v%>"></script>
</body>
</html>