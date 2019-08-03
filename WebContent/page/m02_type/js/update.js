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
		console.log(data);
		// 发异步，把数据提交给php
		$.post(document.forms[0].action, data.field, function() {
			layer.alert("修改成功", {
				icon : 6
			}, function() {
				// 父窗口重现加载
				window.parent.location.reload();
			});
		});
		return false;
	});

});