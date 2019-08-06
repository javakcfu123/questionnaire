//页面日期组件初始化
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

/* 删除 */
function delType(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		// jquery发异步删除数据
		$.post('/Questionnaire/type.do', {
			kc : 'delete',
			type_id : id
		}, function() {
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			}, function() {
				// 窗口重现加载
				window.location.reload();
			});
		});
	});
}

//编辑题目
function editSubject(url) {
	// 判断是否打开新页签
	var arr=parent.$('.x-iframe');
	for (var i = 0; i < arr.length; i++) {
		var tab_id=arr.eq(i).attr('tab-id');
		if ( tab_id== url) {
			parent.tab.tabChange(url);
			return;
		}
	}
	parent.tab.tabAdd("编辑题目", url, url);
	parent.tab.tabChange(url);
}

//批量删除
function delAll(argument) {
	var data = tableCheck.getData();
	//alert("data.join()"+data.join(","));
	layer.confirm('确认要删除吗？', function(index) {
		// 捉到所有被选中的，发异步进行删除
		$.post('/Questionnaire/type.do', {
			kc : 'deleteAll',
			data : data.join(",")
		}, function() {
			layer.msg('已删除!', {
				icon : 1,
				time : 2000,
			}, function() {
				// 窗口重现加载
				window.location.reload();
			});
		});

	});

}

function init_type(){
	layer.confirm('确认要初始化类型？', function(index) {
		// 捉到所有被选中的，发异步进行删除
		$.post('/Questionnaire/type.do', {
			kc : 'init_type'
		}, function() {
			layer.msg('已初始化!', {
				icon : 1,
				time : 2000,
			});
		});

	});
}
