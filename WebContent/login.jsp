<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
<script type="text/javascript">
if(window != window.top){
	window.top.location=window.location;
}
</script>
</head>
<body>
	<p class="center">登录用户名为：admin，密码为admin</p>
	<p class="center">在用户名和密码错误时，点击登录按钮可以看到表单的摇晃效果。</p>
	<div id="wrapper" class="login-page">
		<div id="login_form" class="form">
			<form class="register-form">
				<input type="text" placeholder="用户名" value="admin" id="r_user_name" />
				<input type="login_pass" placeholder="密码" id="r_password" /> <input
					type="text" placeholder="电子邮件" id="r_emial" />
				<button id="create">创建账户</button>
				<p class="message">
					已经有了一个账户? <a href="#">立刻登录</a>
				</p>
			</form>
			<form class="login-form" action="<%=request.getContextPath()%>/login.kc"
				method="post">
				<h2>管理登录</h2>
				<input type="text" placeholder="用户名" id="login_name" name="login_name" value="admin"/>
				<input type="password" placeholder="密码" id="login_pass" name="login_pass" value="admin"/>
				<button id="login">登 录</button>
				<p class="message">
					还没有账户? <a href="#">立刻创建</a>
				</p>
			</form>
		</div>
	</div>

	<script src="js/jquery.min.js"></script>
	<script type="text/javascript">
		function fun_login() {
			document.forms[1].submit();
		}
		
		function check_login() {
			var name = $("#user_name").val();
			var pass = $("#password").val();
			if (name == "admin" && pass == "admin") {
				alert("登录成功！");
				$("#user_name").val("");
				$("#password").val("");
				$(location).attr('href', 'index.html');
			} else {
				$("#login_form").removeClass('shake_effect');
				setTimeout(function() {
					$("#login_form").addClass('shake_effect')
				}, 1);
			}
		}
		function check_register() {
			var name = $("#r_user_name").val();
			var pass = $("#r_password").val();
			var email = $("r_email").val();
			if (name != "" && pass == "" && email != "") {
				alert("注册成功！");
				$("#user_name").val("");
				$("#password").val("");
			} else {
				$("#login_form").removeClass('shake_effect');
				setTimeout(function() {
					$("#login_form").addClass('shake_effect')
				}, 1);
			}
		}
		$(function() {
			$("#create").click(function() {
				check_register();
				return false;
			})
			$("#login").click(function() {
				fun_login();
				return false;
			})
			$('.message a').click(function() {
				$('form').animate({
					height : 'toggle',
					opacity : 'toggle'
				}, 'slow');
			});
		})
	</script>
</body>
</html>