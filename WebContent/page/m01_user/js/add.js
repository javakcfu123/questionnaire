layui.use([ 'form', 'layer' ], function() {
	$ = layui.jquery;
	var form = layui.form, layer = layui.layer;

	// 自定义验证规则
    form.verify({
    	user_name: function(value){
	        if(value.length < 2){
	        	return '用户姓名至少得2个字符啊';
	        }
	    },
	    login_name: function(value){
	        if(value.length < 5){
	        	return '登录名至少得5个字符啊';
	        }
	    },
	    login_pass: [/(.+){6,12}$/, '密码必须6到12位'],
	    repass: function(value){
	    	if($('#login_pass').val()!=$('#L_repass').val()){
	    		return '两次密码不一致';
	    	}
	    }
    });
	// 监听提交
	form.on('submit(add)', function(data) {
		console.log("监听提交:"+data);
		// 发异步，把数据提交给servlet
		
		// （url请求的路径,数据，成功后执行的函数）
		$.post(document.forms[0].action, data.field, function() {
			//msg：就是响应的内容
			//alert(msg);			
				layer.alert("增加成功", {
					icon : 6
				}, function() {
					// 父窗口重现加载
					window.parent.location.reload();
				});
			
		});

		return false;
	});

});