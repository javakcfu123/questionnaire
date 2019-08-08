<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改用户信息</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="x-body">
		<form class="layui-form"
			action="<%=request.getContextPath()%>/user.do" method="post"
			target="_parent">
			<input type="hidden" name="kc" value="update">
			 <input
				type="hidden" name="user_id" value="${map.user_id}">

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>用户名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="user_name" name="user_name" required
						lay-verify="user_name" autocomplete="off" class="layui-input"
						value="${map.user_name}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>登录名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="login_name" name="login_name" required
						lay-verify="login_name" autocomplete="off" class="layui-input"
						value="${map.login_name}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>登陆密码
				</label>
				<div class="layui-input-inline">
					<input type="text" id="login_pass" name="login_pass" required
						lay-verify="login_pass" autocomplete="off" class="layui-input"
						value="${map.login_pass}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="start" class="layui-form-label"> <span
					class="x-red">*</span>邮箱
				</label>
				<div class="layui-input-inline">
					<input type="text" id="user_email" name="user_email" required
						lay-verify="user_email" autocomplete="off" class="layui-input"
						value="${map.user_email}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="start" class="layui-form-label"> <span
					class="x-red">*</span>电话
				</label>
				<div class="layui-input-inline">
					<input type="text" id="user_phone" name="user_phone" required
						lay-verify="user_phone" autocomplete="off" class="layui-input"
						value="${map.user_phone}">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					更新</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/page/m01_user/js/update.js?v=<%=v%>"></script>
</body>
</html>