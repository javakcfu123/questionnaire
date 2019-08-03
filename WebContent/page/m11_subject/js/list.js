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

	// 执行一个laydate实例
	laydate.render({
		elem : '#create' // 指定元素
	});

});



/* 删除 */
function delSubject(obj, id) {
	layer.confirm('确认要删除吗？', function() {
		// jquery发异步删除数据
		$.post(document.forms[0].action, {
			kc : 'delete',
			subject_id : id
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

function delAll(argument) {
	var data= tableCheck.getData();
//	alert("data.join()"+data.join(","));
	layer.confirm('确认要删除吗？', function(index) {
		// jquery发异步删除数据
		$.post(document.forms[0].action, {
			kc : 'deleteAll',
			data : data.join(",")
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

function previewAll(){
	//alert("111111111");
	var data= tableCheck.getData();
	alert("data.join()"+data.join(","));
	// jquery发异步删除数据
	$.post('/Questionnaire/subject.do', {
			kc : 'previewAll',
			data : data.join(",")
	});
}