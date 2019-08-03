layui.use([ 'form', 'layer' ], function() {
	$ = layui.jquery;
	var form = layui.form, layer = layui.layer;

	// 提供时间样式
	layui.use('laydate', function() {
		var laydate = layui.laydate;

		// 执行一个laydate实例
		laydate.render({
			elem : '#start' // 指定元素
		});

		// 执行一个laydate实例
		laydate.render({
			elem : '#end' // 指定元素
		});
	});

	// 自定义验证规则
	form.verify({
		qu_title : function(value) {
			if (value.length < 5) {
				return '昵称至少得5个字符啊';
			}
		},
		pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
		repass : function(value) {
			if ($('#L_pass').val() != $('#L_repass').val()) {
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