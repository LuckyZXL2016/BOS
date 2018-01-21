<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>highcharts</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script src="${pageContext.request.contextPath }/js/highcharts/highcharts.js"></script>
<script src="${pageContext.request.contextPath }/js/highcharts/modules/exporting.js"></script>
<script type="text/javascript">
$(function(){
	//页面加载完成后，动态创建图表
	$("#test").highcharts({
		title: {
            text: '各浏览器份额'
        },
        series: [{
            type: 'pie',
            name: '浏览器占比',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]
        }]
	});
});
</script>
</head>

<body>
	<div id="test"></div>
</body>
</html>