<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
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
		<legend>${requestScope.questionMap.qu_title }</legend>
	</fieldset>
	<p class="layui-table-cell">${requestScope.questionMap.memo }</p>

	<form class="layui-form"
		action='<%=request.getContextPath()%>/answer.kc?kc=insert'
		method="post">


		姓名：<input type="text" name="name" lay-verify="required" placeholder="" autocomplete="off" value="张三"></br> 
		电话：<input type="text" name="phone"lay-verify="phone" placeholder="" autocomplete="off" value="13611199828"> 
		<input type="hidden" name="qu_id" value=${param.qu_id}>
			
		<div style="padding: 20px; background-color: #F2F2F2;">

			<div class="layui-row layui-col-space15">

				<c:forEach var="subject" items="${requestScope.list }"
					varStatus="abc">

					<div class="layui-col-md12">
						<div class="layui-card layui-form">
							<div class="layui-card-header">Q${abc.count}：${subject.subject_title }【${subject.subject_type }】</div>

							<c:forEach var="item" items="${subject.items }">

								<div class="layui-card-body">

									<c:if test="${subject.subject_type=='单选'}">
										<input type="radio" name="${subject.subject_id }" value="${item.item_id }">
									</c:if>
									<c:if test="${subject.subject_type=='多选'}">
										<input type="checkbox" name="${subject.subject_id }" lay-skin="primary" value="${item.item_id }">
									</c:if>
									${item.item_content }
								</div>
							</c:forEach>
							<c:if test="${subject.subject_type=='简答'}">
								<textarea class="layui-textarea" name="${subject.subject_id }" ></textarea>
							</c:if>
						</div>
					</div>

				</c:forEach>



			</div>
		</div>

		<div class="layui-form-item">
			<label for="add" class="layui-form-label"> </label>
			<button class="layui-btn" lay-filter="add" lay-submit="">提交</button>

		</div>
	</form>

	<script type="text/javascript"
		src="./page/m30_answer/js/answer.js?v=<%=v%> charset="utf-8"></script>
</body>
</html>
