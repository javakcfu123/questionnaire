<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布成功</title>
<%@include file="../common/head.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/qrcode/jquery.qrcode.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/qrcode/qrcode.js"></script>
</head>
<body>
	<div class="x-body">
		链接：<a href="<%="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath() %>/answer.kc?kc=answer&qu_id=${param.qu_id }" target="_blank">
			
			<%="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath() %>/answer.kc?kc=answer&qu_id=${param.qu_id }
		</a>
	</div>
	<div id="output" class="x-body">
	
	</div>
	<script>
	$(function(){
		$('#output').qrcode("<%="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath() %>/answer.kc?kc=answer&qu_id=${param.qu_id }");
	})
	</script>
</body>
</html>