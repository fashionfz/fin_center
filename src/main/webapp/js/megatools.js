function postData(frm,url){
	var para = $(frm).serialize();
	$.ajax({
		type : "POST", // 访问WebService使用Post方式请求
		contentType : "application/text", // WebService 会返回Json类型
		url : url+"&"+para, // 调用WebService的地址和方法名称组合 ---- WsURL/方法名
		data : para, // 这里是要传递的参数，格式为 data:
		dataType : "html",
		success : function(result) { // 回调函数，result，返回值
			$("#resultXML").html(result);
		}
	});
	
}
