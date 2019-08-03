<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>新增题目</title>
    <%@include file="../common/head.jsp" %>
</head>
<body onload="fun_load();">     
  	<div class="x-body">
        <form id="myForm" class="layui-form"  action="<%=request.getContextPath() %>/subject.do" method="post" target="_parent">
        
        <input type="hidden2" name="qu_id" id="qu_id" value="">
        <input type="hidden" name="kc" value="insert">
        <input type="hidden" name="corrects" id="corrects">
        
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>题目标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="subject_title" required lay-verify="required"
                  autocomplete="off" class="layui-input"  value="题目标题1">
              </div>
          </div>
          
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>题目类型
              </label>
              <div class="layui-input-inline">
                  <select id="shipping" name="subject_type" class="valid">
                    <option value="单选">单选</option>
                    <option value="多选">多选</option>
                    <option value="简答">简答</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>是否必填
              </label>
              <div class="layui-input-inline">
                  <select id="subject_must" name="subject_must" class="valid">
                    <option value="1">是</option>
                    <option value="2" selected>否</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  	分数
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="subject_score"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
          
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                  描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入题目描述" id="desc" name="subject_desc" class="layui-textarea" >描述===================</textarea>
              </div>
          </div>
          
          <div id="items">
       
          
          
          </div>
          
          
          
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="addItem" lay-submit="" >增加选项</button>
              <button  class="layui-btn" lay-filter="add" lay-submit="" >增加</button>
          </div>
      </form>
    </div>
    <script type="text/javascript" src="./js/insert.js?v=<%=v%>"></script>
</body>
</html>