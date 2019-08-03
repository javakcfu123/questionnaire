<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷列表</title>
<%@include file="../common/head.jsp" %>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">基础数据</a>
			<a> <cite>问卷类型</cite></a>
		</span> <a class="layui-btn layui-btn-primary layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:window.location.reload()" title="刷新"> <i
			class="layui-icon" style="line-height: 38px">ဂ</i></a>
	</div>
	<form class="layui-form layui-col-md12 x-so" >
	<div class="x-body">
		<div class="layui-row">
				<input type="text" name="type_name" placeholder="请输入关键字"
					autocomplete="off" class="layui-input" value="${param.type_name }">
				<input type="text" name="creator_id" placeholder="创建人"
					autocomplete="off" class="layui-input"  value="${param.creator_id }"> 
				<input class="layui-input" placeholder="创建开始日期" name="start" id="start" value="${param.start }">
				<input class="layui-input" placeholder="创建结束日期" name="end" id="end" value="${param.end }">
				
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			
		</div>
		<xblock>
		<a class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="icon iconfont">&#xe69d;</i> 批量删除
		</a>
		<a class="layui-btn"
			onclick="x_admin_show('添加问卷类型','./page/m02_type/add.jsp')">
			<i class="icon iconfont">&#xe6b9;</i> 添加
		</a>
		
		<a class="layui-btn layui-btn-normal" onclick="init_type()">
			<i class="icon iconfont">&#xe6fa;</i> 初始化
		</a>
		<span class="x-right" style="line-height: 40px">共有数据：${requestScope.count }条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>问卷类型</th>
					<th>创建日期</th>
					<th>创建人</th>
					<th>修改日期</th>
					<th>修改人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- jstl 循环标签  + EL表达式   代替Java脚本-->
				<c:forEach var="map" items="${requestScope.list}" >
				<tr>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary"
							data-id='${map.type_id}'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					<td>${map.type_name}</td>
					<td>${map.create_date}</td>
					<td>${map.creator_id}</td>
					<td>${map.update_date}</td>
					<td>${map.update_id}</td>
					<td class="td-manage"><a title="修改"
						onclick="x_admin_show('修改问卷','<%=request.getContextPath()%>/type.do?kc=toUpdate&type_id=${map.type_id}')"
						href="#"> <i class="layui-icon">&#xe63c;</i>
					</a> 
					<a title="删除" onclick="delType(this,'${map.type_id}');"
						href="#"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<%@include file="../common/page.jsp" %>

	</div>
	</form>
	<script type="text/javascript" src="./page/m02_type/js/list.js?v=<%=v %>"></script>
</body>

</html>