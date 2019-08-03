<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>修改问卷</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="x-body">
		<form class="layui-form"
			action="<%=request.getContextPath()%>/question.do" method="post"
			target="_parent">
			<input type="hidden" name="kc" value="update"> <input
				type="hidden" name="qu_id" value="${map.qu_id}">

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷标题
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="qu_title" required
						lay-verify="required" autocomplete="off" class="layui-input"
						value="${map.qu_title}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷类型
				</label>
				<div class="layui-input-inline">
					<select id="username" name="type_id" class="valid">
						<c:forEach var="typeMap" items="${applicationScope.typeList }">
							<option value="${typeMap.type_id}" ${map.type_id==typeMap.type_name?"selected":null }>${typeMap.type_name }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>开始日期
				</label>
				<div class="layui-input-inline">
					<input id="start" name="begin_date" required lay-verify="required"
						autocomplete="off" class="layui-input"
						value="${map.begin_date}">
				</div>
			</div>

			<div class="layui-form-item">
				<label for="start" class="layui-form-label"> <span
					class="x-red">*</span>结束日期
				</label>
				<div class="layui-input-inline">
					<input id="end" name="end_date" required lay-verify="required"
						autocomplete="off" class="layui-input"
						value="${map.end_date}">

				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>发布范围
				</label>
				<div class="layui-input-inline">
					<select id="username" name="pub_scope" class="valid">
						<option value="海淀" ${map.pub_scope=="海淀"?"selected":null }>海淀</option>
						<option value="西二旗" ${map.pub_scope=="西二旗"?"selected":null }>西二旗</option>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>问卷样式
				</label>
				<div class="layui-input-inline">
					<select id="username" name="qu_style" class="valid">
						<option value="网页" ${map.qu_style=="网页"?"selected":null }>网页</option>
						<option value="小程序" ${map.qu_style=="小程序"?"selected":null }>小程序</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 注释 </label>
				<div class="layui-input-block">
					<textarea placeholder="注释" id="memo" name="memo"
						class="layui-textarea">${map.memo}</textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">
					更新</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath()%>/page/m10_question/js/update.js?v=<%=v%>"></script>
</body>
</html>