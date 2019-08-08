<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
	<div class="x-body">
	
	<form class="layui-form"
			action="<%=request.getContextPath()%>/user.do" method="post"
			target="_parent">				
			<input type="hidden" name="kc" value="insert">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>用户姓名</label>								
				<div class="layui-input-inline">
					<input type="text" id="user_name" name="user_name" required
						lay-verify="user_name" autocomplete="off" class="layui-input" value="张三">												
				</div>	
																										
			</div>
			
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>登录名
				</label>							
				<div class="layui-input-inline">
					<input type="text" id="login_name" name="login_name" required
						lay-verify="login_name" autocomplete="off" class="layui-input" value="admin">												
				</div>																											
			</div>
			
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>密码
				</label>							
				<div class="layui-input-inline">
					<input type="text" id="login_pass" name="login_pass" required
						lay-verify="login_pass" autocomplete="off" class="layui-input" value="123456">												
				</div>																							
			</div>
			
			
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>密码确认
				</label>							
				<div class="layui-input-inline">
					<input type="text" id="L_repass"  required
						lay-verify="repass" autocomplete="off" class="layui-input" value="123456">												
				</div>																							
			</div>
			
			
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>邮箱
				</label>						
				<div class="layui-input-inline">
					<input type="text" id="user_email" name="user_email" required
						lay-verify="email" autocomplete="off" class="layui-input" value="11@qq.com">												
				</div>																							
			</div>
			
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>电话号码
				</label>						
				<div class="layui-input-inline">
					<input type="text" id="user_phone" name="user_phone" required
						lay-verify="phone" autocomplete="off" class="layui-input" value="13611199828">												
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