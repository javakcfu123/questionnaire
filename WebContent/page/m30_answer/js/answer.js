layui.use([ 'form', 'layer' ], function() {
	$ = layui.jquery;
	var form = layui.form, layer = layui.layer;

	// 提供时间样式

	form.on('submit(add)', function(data) {
		console.log("监听提交:"+data);
		// 发异步，把数据提交给servlet
		
		var params=$("form").serialize();
		// （url请求的路径,数据，成功后执行的函数）
		$.post(document.forms[0].action, params, function() {
			layer.alert("提交成功", {
				icon : 6
			}, function() {
				// 父窗口重现加载
				//window.parent.location.reload();
			});
		});

		return false;
	});
	
	
	
	
});