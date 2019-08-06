<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增问卷类型</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
	<div class="x-body">
		<form class="layui-form"
			action="<%=request.getContextPath()%>/type.do" method="post"
			target="_parent">
			<input type="hidden" name="kc" value="insert">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷类型
				</label>
				<div class="layui-input-inline">
					<input type="text" id="type_name" name="type_name" required
						lay-verify="type_name" autocomplete="off" class="layui-input" value="生活">
				</div>
			</div>

			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="./js/add.js?v=<%=v%>"></script>
</body>
</html>