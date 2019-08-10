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
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">问卷管理</a>
			<a> <cite>问卷列表</cite></a>
		</span> <a class="layui-btn layui-btn-primary layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:window.location.reload()" title="刷新"> <i
			class="layui-icon" style="line-height: 38px">ဂ</i></a>
	</div>
	<form class="layui-form layui-col-md12 x-so">
	<div class="x-body">
		<div class="layui-row">
			
				<input type="text" name="qu_title" placeholder="请输入问卷标题"
					autocomplete="off" class="layui-input" value="${param.qu_title }">
				<div class="layui-input-inline">
					<select name="type_id">
						<option value="">问卷类型</option>
						<c:forEach var="map" items="${applicationScope.typeList }">
							<option value="${map.type_id }" ${map.type_id==param.type_id?"selected":null }>${map.type_name }</option>
						</c:forEach>
					</select>
				</div>
				<input class="layui-input" placeholder="发布开始日期" name="begin_date"
					id="start"> <input class="layui-input" placeholder="发布结束日期"
					name="end_date" id="end">
				<div class="layui-input-inline">
					<select name="pub_scope">
						<option value="">发布范围</option>
						<option value="海淀">海淀</option>
						<option value="西二旗">西二旗</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="qu_style">
						<option value="">问卷样式</option>
						<option value="0">网页</option>
						<option value="1">小程序</option>
					</select>
				</div>

				<input type="text" name="creator_id" placeholder="创建人"
					autocomplete="off" class="layui-input"> <input
					class="layui-input" placeholder="创建日期" name="start" id="start">

				<div class="layui-input-inline">
					<select name="state">
						<option value="1" ${param.state==1?"selected":null }>未发布</option>
						<option value="2" ${param.state==2?"selected":null }>已发布</option>
						<option value="3" ${param.state==3?"selected":null }>已结束</option>
					</select>
				</div>
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			
		</div>
		<xblock>
		<a class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="icon iconfont">&#xe69d;</i> 批量删除
		</a>
		<a class="layui-btn"
			onclick="x_admin_show('添加问卷','./page/m10_question/add.jsp')">
			<i class="icon iconfont">&#xe6b9;</i> 添加
		</a>
		<a class="layui-btn layui-btn-warm"
			onclick="publish()">
			<i class="icon iconfont">&#xe6c0;</i> 发布
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
					<th>问卷标题</th>
					<th>问卷类型</th>
					<th>发布日期</th>
					<th>发布范围</th>
					<th>问卷样式</th>
					<th>创建人</th>
					<th>创建日期</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- c jstl标签  $ EL表达式 -->
				<c:forEach var="map" items="${requestScope.list}" >
				<tr>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary"
							data-id='${map.qu_id }'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					
					<td>
						<a href="javascript:x_admin_show('预览问卷','<%=request.getContextPath() %>/questionQuery.do?kc=viewQuestion&qu_id=${map.qu_id }')">
							${map.qu_title}
						</a>
					</td>
					<td>${map.type_name}</td>
					<td>${map.begin_date}-${map.end_date}</td>
					<td>${map.pub_scope}</td>
					<td>${map.qu_style}</td>
					<td>${map.creator_id}</td>
					<td>${map.create_date}</td>
					<td>${map.state}</td>
					<td class="td-manage"><a title="修改"
						onclick="x_admin_show('修改问卷','<%=request.getContextPath()%>/question.do?kc=toUpdate&qu_id=${map.qu_id }')"
						href="#"> <i class="layui-icon">&#xe63c;</i>
					</a> 
					<!-- a标签 href属性的 #表示空，就是不跳转页面的意思 -->
					<a title="删除" onclick="delQuestion(this,'${map.qu_id }');"href="#"> 
						<i class="layui-icon">&#xe640;</i>
					</a>
					
					<a title="编辑题目"
						onclick="editSubject('<%=request.getContextPath()%>/subject.do?kc=toQuery&qu_id=${map.qu_id }')"
						href="#"> <i class="layui-icon">&#xe642;</i>
					</a> 
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<%@include file="../common/page.jsp" %>

	</div>
	</form>
	<script type="text/javascript" src="./page/m10_question/js/list.js?v=<%=v %>"></script>
</body>

</html>