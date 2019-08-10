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
		<legend>${requestScope.questionMap.qu_title }</legend>
	</fieldset>
	<p class="layui-table-cell">
		${requestScope.questionMap.memo }
	</p>
                
                
	<div style="padding: 20px; background-color: #F2F2F2;">

		<div class="layui-row layui-col-space15">

			<c:forEach var="subject" items="${requestScope.list }" varStatus="abc">

				<div class="layui-col-md12">
					<div class="layui-card layui-form">
						<div class="layui-card-header">Q${abc.count}：${subject.subject_title }【${subject.subject_type }】</div>
						
						<c:forEach var="item" items="${subject.items }" >
						
							<div class="layui-card-body">
							
								<c:if test="${subject.subject_type=='单选'}">
								<input type="radio" name="${subject.subject_id }">
								</c:if>
								<c:if test="${subject.subject_type=='多选'}">
								<input type="checkbox" lay-skin="primary">
								</c:if>
								${item.item_content }
							</div>
						</c:forEach>
						<c:if test="${subject.subject_type=='简答'}">
						<textarea class="layui-textarea"></textarea>
						</c:if>
					</div>
				</div>
			
			</c:forEach>
			

			
		</div>
	</div>
	
    <script type="text/javascript" src="./page/m11_subject/js/preview.js?v=<%=v %>" charset="utf-8"></script>
</body>
</html>
