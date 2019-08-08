<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览问卷</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 30px;">
		<legend>垃圾分类自测题</legend>
	</fieldset>
	<p class="layui-table-cell">
	文明你我他，分类靠大家。考前提示：“湿垃圾”——猪能吃的“干垃圾”——猪都不要吃的“有害垃圾”——猪吃了能死的“可回收物”——卖了钱可以买猪的
	</p>
                
                
	<div style="padding: 20px; background-color: #F2F2F2;">

		<div class="layui-row layui-col-space15">

			<div class="layui-col-md12">
				<div class="layui-card layui-form">
					<div class="layui-card-header">Q1：以下哪些属于湿垃圾？</div>
					<div class="layui-card-body">
						<input type="radio" name="Q1">奶油
					</div>
					<div class="layui-card-body">
						<input type="radio" name="Q1">番茄酱
					</div>
					<div class="layui-card-body">
						<input type="radio" name="Q1">笋皮
					</div>
					<div class="layui-card-body">
						<input type="radio" name="Q1">大骨头
					</div>
				</div>
			</div>

			<div class="layui-col-md12">
				<div class="layui-card layui-form">
					<div class="layui-card-header">Q2：以下哪些属于可回收物？</div>
					<div class="layui-card-body">
						<input type="checkbox" lay-skin="primary">贝壳
					</div>
					<div class="layui-card-body">
						<input type="checkbox" lay-skin="primary">砧板
					</div>
					<div class="layui-card-body">
						<input type="checkbox" lay-skin="primary">旧玩偶
					</div>
					<div class="layui-card-body">
						<input type="checkbox" lay-skin="primary">挂锁
					</div>

				</div>
			</div>
		</div>
	</div>
	
    <script type="text/javascript" src="./page/m11_subject/js/preview.js?v=<%=v %>" charset="utf-8"></script>
</body>
</html>
