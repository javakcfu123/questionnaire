//下一页
function fun_next() {
	var page = document.getElementById("page").value;
	var count = document.getElementById("count").value;
	var maxPage = Math.ceil(count / 5);
	if (page < maxPage) {
		page++;
		document.getElementById("page").value = page;
		document.forms[0].submit();
	}
}
// 上一页
function fun_prev() {
	var page = document.getElementById("page").value;
	if (page > 1) {
		page--;
		document.getElementById("page").value = page;
		document.forms[0].submit();
	}
}
// 转到
function fun_to(n) {
	document.getElementById("page").value = n;
	document.forms[0].submit();
}
$(function(){
	var page = document.getElementById("page").value;
	var count = document.getElementById("count").value;
	var maxPage = Math.ceil(count / 5);
	// document.getElementById("maxPage").innerText=maxPage;
	var html = "";

	var n = page - 2;
	if (n <= 0) {
		n = 1
	}
	for (var i = 0; i < 5; i++) {
		if (n == page) {
			html += "<span class='current'>" + n + "</span>&nbsp;";
		} else {
			if (n < maxPage) {
				html += "<a href='javascript:fun_to(" + n + ")'>" + n
						+ "</a>&nbsp;";
			}
		}
		n++;
	}
	if (page < maxPage) {
		html += "<a id='maxPage' href='javascript:fun_to(" + maxPage + ")'>"
				+ maxPage + "</a>";
	}
	document.getElementById("pageInfo").innerHTML = html;
	
	
}); 