layui.use(
	['form', 'layer' ],
	function() {
		$ = layui.jquery;
		var form = layui.form, layer = layui.layer;
		
		//添加选项事件处理
		form.on('submit(close)',
			function(data) {
				// 获得frame索引
		        var index = parent.layer.getFrameIndex(window.name);
		        //关闭当前frame
		        parent.layer.close(index);
				
				return false;
		});
});
