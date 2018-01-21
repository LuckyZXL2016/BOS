<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ocupload</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		//页面加载完成后，调用插件的upload方法，动态修改了HTML页面元素
		$("#myButton").upload({
			action:'xxx.action',
			name:'myFile'
		});
	});
</script>
</head>
<body>
	<!-- 普通上传方式 
	<iframe style="display: none" name="abc"></iframe>
	<form target="abc" action="xxx" method="post" enctype="multipart/form-data">
		<input type="file" name="myFile">
		<input type="submit" value="upload">
	</form> -->
	
	<!-- 一键上传 -->
	<input id="myButton" type="button" value="上传">
</body>
</html>












