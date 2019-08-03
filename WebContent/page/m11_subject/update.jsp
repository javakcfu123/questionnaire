<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入jstl标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>修改题目</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>     
  	<div class="x-body">
        <form id="myForm" class="layui-form"  action="<%=request.getContextPath() %>/subject.do" method="post" target="_parent">
        
        问卷id：<input type="hidden2" name="qu_id" id="qu_id" value="${requestScope.map.qu_id }">
       题目id： <input type="hidden2" name="subject_id" id="subject_id" value="${requestScope.map.subject_id }">
        <input type="hidden" name="kc" value="update">
        
        <div class="layui-form-item">
            <label for="username" class="layui-form-label">
                <span class="x-red">*</span>题目标题
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="subject_title" required lay-verify="required"
                autocomplete="off" class="layui-input"  value="${requestScope.map.subject_title }">
            </div>
        </div>
          
        <div class="layui-form-item">
             <label for="subject_type" class="layui-form-label">
                 <span class="x-red">*</span>题目类型
             </label>
             <div class="layui-input-inline">
                 <select id="subject_type" name="subject_type" class="valid">
                   <option value="单选" ${requestScope.map.subject_type=="单选"?'selected':null }>单选</option>
                   <option value="多选" ${requestScope.map.subject_type=="多选"?'selected':null }>多选</option>
                   <option value="简答" ${requestScope.map.subject_type=="简答"?'selected':null }>简答</option>
                 </select>
             </div>
         </div>
         <div class="layui-form-item">
             <label for="subject_must" class="layui-form-label">
                 <span class="x-red">*</span>是否必填
             </label>
             <div class="layui-input-inline">
                 <select id="subject_must" name="subject_must" class="valid">
                   <option value="1" ${requestScope.map.subject_must=="1"?'selected':null }>是</option>
                   <option value="2" ${requestScope.map.subject_must=="2"?'selected':null }>否</option>
                 </select>
             </div>
         </div>
         <div class="layui-form-item">
             <label for="subject_score" class="layui-form-label">
                 	分数
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="subject_score" name="subject_score"
                 autocomplete="off" class="layui-input" value="${requestScope.map.subject_score }">
             </div>
         </div>
         
          
         <div class="layui-form-item layui-form-text">
             <label for="desc" class="layui-form-label">描述</label>
             <div class="layui-input-block">
                 <textarea placeholder="请输入题目描述" id="subject_desc" name="subject_desc" class="layui-textarea" >${requestScope.map.subject_desc }</textarea>
             </div>
         </div>
          
         <div id="items">  
         	
         	<c:forEach var="e" items="${requestScope.items}">
	         	<div class="layui-form-item">
					 <label for="username" class="layui-form-label">
					 <span class="x-red">*</span>选项
					 </label>
					 <div class="layui-input-inline">
					 <input type="text" name="item_content" class="layui-input"  
					 value="${e.item_content }">
					 </div>
					 <div class="layui-input-inline">
					 <input type="checkbox" lay-skin="switch" lay-filter="correct" lay-text="对|" ${e.correct==1?"checked":null}>
					 <button class="layui-btn layui-btn-danger layui-btn-radius btn_small"
					 onclick="item_del(this);">删除</button> 
					 <input type="hidden" name="correct" value="${e.correct }">
					 </div>
				</div>
         	</c:forEach>
         
         </div>
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="addItem" lay-submit="" >增加选项</button>
              <button  class="layui-btn" lay-filter="add" lay-submit="" >修改</button>
          </div>
      </form>
    </div>
    <script type="text/javascript" src="./page/m11_subject/js/update.js?v=<%=v%>"></script>
</body>
</html>