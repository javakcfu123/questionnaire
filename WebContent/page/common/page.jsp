<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="page">
	<div>
		<a href="javascript:fun_prev()">&lt;&lt;</a> <span id="pageInfo"></span>
		<a href="javascript:fun_next()">&gt;&gt;</a>
	</div>
</div>
<input type="hidden" name="page" id="page" value="<%=request.getAttribute("page")%>"/>
<input type="hidden" name="count" id="count" value="${requestScope.count }"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/page.js?v=${v}"></script>
