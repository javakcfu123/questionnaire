layui.use([ 'form', 'layer' ], function() {
	$ = layui.jquery;
	var form = layui.form, layer = layui.layer;

	// 自定义验证规则
	form.verify({
		type_name : function(value) {
			if (value.length < 2) {
				return '昵称至少得2个字符啊';
			}
		}
	});
	// 监听提交
	form.on('submit(add)', function(data) {
		console.log("监听提交:"+data.field);
		// 发异步，把数据提交给servlet
		
		// （url请求的路径,数据，成功后执行的函数）
		$.post(document.forms[0].action, data.field, function(msg) {
			//msg：就是响应的内容
			//alert(msg);
			if(msg=="重复"){
				layer.alert("增加失败，名称已存在！", {
					icon : 6,
					time : 2000
				});
			}else{
				layer.alert("增加成功", {
					icon : 6
				}, function() {
					// 父窗口重现加载
					window.parent.location.reload();
				});
			}
			
		});

		return false;
	});

});