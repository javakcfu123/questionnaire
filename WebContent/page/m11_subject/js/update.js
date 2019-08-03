function item_del(o) {
	// js对象 转成jquery对象
	$(o).parent().parent().remove();
}

layui.use(
	['form', 'layer' ],
	function() {
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
			nikename : function(value) {
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
			console.log($("#myForm").serialize());
			// 发异步，把数据提交给Servlet
			
			// (url请求的路径，数据，成功后执行的函数)
			$.post(document.forms[0].action, $("#myForm").serialize(),
					function() {
						layer.alert("修改成功", {
							icon : 6
						}, function() {
							// 父窗口重现加载
							window.parent.location.reload();
						});
					});

			return false;
		});
		//添加选项事件处理
		form.on('submit(addItem)',
			function(data) {
				var html = ' <div class="layui-form-item">';
				html += ' <label for="username" class="layui-form-label">';
				html += ' <span class="x-red">*</span>选项';
				html += ' </label>';
				html += ' <div class="layui-input-inline">';
				html += ' <input type="text" value="1" name="item_content" required lay-verify="required"';
				html += ' autocomplete="off" class="layui-input"  value="3">';
				html += ' </div>';
				html += ' <div class="layui-input-inline">';
				html += ' <input type="checkbox" name="correct" lay-skin="switch" lay-filter="correct" lay-text="对|" onclick="check_item(this)">';
				html += ' <button class="layui-btn layui-btn-danger layui-btn-radius btn_small"';
				html += ' onclick="item_del(this);">删除</button> ';
				html += ' <input type="hidden" name="correct" value="0"> ';
				html += ' </div>';
				
				html += ' </div>';
				$("#items").append(html);
				//渲染复选框
				form.render('checkbox');
				
				return false;
			});
		
		//监听switch开关,lay-filter属性是correct
		form.on('switch(correct)', function(data){
//			  console.log(data.elem); //得到checkbox原始DOM对象
//			  console.log(data.elem.checked); //开关是否开启，true或者false
//			  console.log(data.value); //开关value值，也可以通过data.elem.value得到
//			  console.log(data.othis); //得到美化后的DOM对象
			//data.elem:是复选框
			//obj_div:是复选框的父节点div
			var obj_div=$(data.elem).parent();
			//obj_hid:是div中的隐藏域
			var obj_hid=obj_div.find("[name='correct']");
			//为隐藏域赋值
			obj_hid.val(data.elem.checked?1:0);
		}); 
});

function check_item(chk){
	//chk:是复选框
	//obj_div:是复选框的父节点div
	var obj_div=$(chk).parent();
	//obj_hid:是div中的隐藏域
	var obj_hid=obj_div.find("[name='correct']");
	//为隐藏域赋值
	obj_hid.val(chk.checked?1:0);
}
