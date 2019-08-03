<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预览题目</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="x-body">
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                	题目标题
            </label>
            <div class="kc_text">
                ${requestScope.map.subject_title}
            </div>
        </div>
          
        <div class="layui-form-item">
             <label for="subject_type" class="layui-form-label">
                	 题目类型
             </label>
             <div class="kc_text">
                   ${requestScope.map.subject_type}
             </div>
         </div>
         <div class="layui-form-item">
             <label for="subject_must" class="layui-form-label">是否必填 </label>
             <div class="kc_text">
                 ${requestScope.map.subject_must=="1"?'必填':'否' }
             </div>
         </div>
         <div class="layui-form-item">
             <label for="subject_score" class="layui-form-label">
                 	分数
             </label>
             <div class="kc_text">
                	${requestScope.map.subject_score }
             </div>
         </div>
         
          
         <div class="layui-form-item layui-form-text">
             <label for="desc" class="layui-form-label">描述</label>
             <div class="kc_text">
                 ${requestScope.map.subject_desc }
             </div>
         </div>
          
         <div id="items" class="layui-form">  
         	<c:forEach var="e" items="${requestScope.items}">
	         	<div class="layui-form-item">
					 <label for="username" class="layui-form-label" style="padding:3px 15px">
						<input type='${requestScope.map.subject_type=="单选"?"radio":"checkbox"}' name="sex" value="nan">
					 </label>
					 <div class="kc_text">
					 	${e.item_content }
					 	<c:if test="${e.correct==1}">
					 		<i class="icon iconfont" style="font-size:25px">&#xe6ad;</i>
					 	</c:if>
					 </div>
					 
				</div>
         	</c:forEach>
         
         </div>
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="close" lay-submit="" >关闭</button>
          </div>
    </div>
    <script type="text/javascript" src="./page/m11_subject/js/preview.js?v=<%=v %>" charset="utf-8"></script>
</body>
</html>
