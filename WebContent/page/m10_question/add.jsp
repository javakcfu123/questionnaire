<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
	<div class="x-body">
		<form class="layui-form"
			action="<%=request.getContextPath()%>/question.do" method="post"
			target="_parent">
			<input type="hidden" name="kc" value="insert">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷标题
				</label>
				<div class="layui-input-inline">
					<input type="text" id="qu_title" name="qu_title" required
						lay-verify="qu_title" autocomplete="off" class="layui-input" value="问卷标题11">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷类型
				</label>
				<div class="layui-input-inline">
					<select id="shipping" name="type_id" class="valid">
						<c:forEach var="map" items="${applicationScope.typeList }">
							<option value="${map.type_id }">${map.type_name }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>开始日期
				</label>
				<div class="layui-input-inline">
					<input type="text" id="start" name="begin_date" required value="2019-3-4"
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>结束日期
				</label>
				<div class="layui-input-inline">
					<input type="text" id="end" name="end_date" required value="2019-4-4"
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>发布范围
				</label>
				<div class="layui-input-inline">
					<select id="shipping" name="pub_scope" class="valid">
						<option value="海淀">海淀</option>
						<option value="延庆">延庆</option>
						<option value="昌平">昌平</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷样式
				</label>
				<div class="layui-input-inline">
					<select id="qu_style" name="qu_style" class="valid">
						<option value="网页">网页</option>
						<option value="小程序">小程序</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 描述 </label>
				<div class="layui-input-block">
					<textarea placeholder="请输入注释" id="desc" name="memo"
						class="layui-textarea">描述1122</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					增加</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="./js/add.js"></script>
</body>
</html>