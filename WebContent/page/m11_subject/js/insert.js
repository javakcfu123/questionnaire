function fun_load() {
	document.getElementById("qu_id").value = parent.document.getElementById("qu_id").value;
}
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
			//收集界面的数据
			var arr=document.getElementsByName("correct");
			var arr2=new Array();
			for(var e of arr){
				if(e.checked){
					arr2.push(1);
				}else{
					arr2.push(0);
				}
			}
			document.getElementById("corrects").value=arr2.join(",");
			
			// (url请求的路径，数据，成功后执行的函数)
			$.post(document.forms[0].action, $("#myForm").serialize(),
					function() {
						layer.alert("增加成功", {
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
				html += ' <input type="checkbox" name="correct" lay-skin="switch" lay-text="对|错">';
				html += ' <button class="layui-btn layui-btn-danger layui-btn-radius btn_small"';
				html += ' onclick="item_del(this);">删除</button> ';
				html += ' </div>';
				
				html += ' </div>';
				$("#items").append(html);
				//渲染复选框
				form.render('checkbox');
				
				return false;
			});
});