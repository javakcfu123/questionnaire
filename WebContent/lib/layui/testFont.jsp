<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../page/common/head.jsp" %>
</head>
<script type="text/javascript">
for(i=1;i<8;i++){
	document.write("<button style='width:50px' onclick='f("+i+")'>"+i+"</button>");
	
}

function f(n){
	layer.msg('init!'+n, {
		icon : n,
		time : 2000,
	});
}

</script>
<body>
	
</body>
</html>