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

function delUser(obj, id) {
	layer.confirm('确认要删除吗？', function(index) {
		// jquery发异步删除数据
		$.post('/Questionnaire/user.do', {
			kc:'delete',
			user_id:id
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
		//判断当前页签是否打开
		if ( tab_id== url) {
			//如果此页签已经打开，则切换
			parent.tab.tabChange(url);
			return;
		}
	}
	//此页签第一次打开，
	parent.tab.tabAdd("编辑题目", url, url);
	//改变显示的页签
	parent.tab.tabChange(url);
}


//批量删除
function delAll(argument) {
	var data = tableCheck.getData();
	//alert("data.join()"+data.join(","));
	layer.confirm('确认要删除吗？', function(index) {
		// 捉到所有被选中的，发异步进行删除
		$.post('/Questionnaire/user.do', {
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