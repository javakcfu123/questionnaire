<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>题目列表</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">题目管理</a>
			<a> <cite>题目列表</cite></a>
		</span> <a class="layui-btn layui-btn-primary layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:window.location.reload()" title="刷新"> <i
			class="layui-icon" style="line-height: 38px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">

			<form class="layui-form layui-col-md12 x-so"
				action="<%=request.getContextPath() %>/subject.do">
				问卷id<input type="hidden2" name="qu_id" id="qu_id" value="${param.qu_id }" ><br>
				
				<input type="text" name="subject_title" placeholder="请输入题目标题"
					autocomplete="off" class="layui-input" value="${param.subject_title}">
				<div class="layui-input-inline">
					<select name="subject_type">
						<option value="">题目类型</option>
						<option value="单选"   ${param.subject_type=="单选"?"selected":""}>单选</option>
						<option value="多选"   ${param.subject_type=="多选"?"selected":""}>多选</option>
						<option value="简答"   ${param.subject_type=="简单"?"selected":""}>简答 </option>
					</select>
				</div>
				<div class="layui-input-inline">
					<input type="text" name="subject_score" placeholder="请输入题目分值"
					autocomplete="off" class="layui-input" value="${param.subject_score}">
				</div>
				
					<div class="layui-input-inline">
					<select name="subject_must">
						<option value="">是否必填</option>
						<option value="1"   ${param.subject_must==1?"selected":""}>是</option>
						<option value="2"   ${param.subject_must==2?"selected":""}>否</option>
					</select>
				</div>
				<!-- <input class="layui-input" placeholder="创建日期" name="create_date"
					id="start">  -->
				
				<input type="text" name="creator_id" placeholder="创建人"
					autocomplete="off" class="layui-input" value="${param.creator_id }"> 

				<button class="layui-btn" lay-submit="" onclick="query()"
					lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<a class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</a>
		<a class="layui-btn"
			onclick="x_admin_show('添加题目','<%=request.getContextPath() %>/page/m11_subject/insert.jsp?qu_id=<%=request.getAttribute("qu_id") %>')">
			<i class="layui-icon"></i>添加
		</a>
		
		<a class="layui-btn"   onclick="x_admin_show('预览问卷','<%=request.getContextPath() %>/page/m11_subject/previewAll.jsp')">
			<i class="layui-icon"></i>预览
		</a>
		
		<span class="x-right" style="line-height: 40px">共有数据：<%=request.getAttribute("count") %></span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>题目标题</th>
					<th>题目类型</th>
					<th>分值</th>
					<th>是否必填</th>
					<th>创建日期</th>
					<th>创建人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- c jstl标签  $ EL表达式 -->
				<c:forEach var="map" items="${requestScope.list}" >
				<tr>
					<td>
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${map.SUBJECT_ID}'>
							<i class="layui-icon">&#xe605;</i>
						</div>
					</td>
					<td><a 
					onclick="x_admin_show('预览题目','<%=request.getContextPath()%>/subject.do?kc=preview&subject_id=${ map.subject_id}')"
					href="#">${map.subject_title} </a></td>
					<td>${map.subject_type}</td>
					<td>${map.subject_score}</td>
					<td>${map.subject_must==1?"必填":"否"}</td>
					<td>${map.create_date}</td>
					<td>${map.creator_id}</td>
					<td class="td-manage">
					<a title="编辑"
						onclick="x_admin_show('编辑题目','<%=request.getContextPath()%>/subject.do?kc=toUpdate&subject_id=${map.subject_id}')"
						href="#"> <i class="layui-icon">&#xe642;</i>
					</a> 
					<a title="删除" onclick="delSubject(this,'${map.subject_id}');"
						href="#"> <i class="layui-icon">&#xe640;</i>
					</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="./page/m11_subject/js/list.js?v=<%=v %>" charset="utf-8"></script>
</body>

</html>