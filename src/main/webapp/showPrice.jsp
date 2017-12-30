<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车票价格</title>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript">
	//页面加载完成才执行代码
	$(document).ready(function(){
		//表单提交监听事件
		$("#submForm").submit(function(){
			var trainnum=$("#trainnum").val();
			if(trainnum == ""){
				alert("吴陆阳提示您，车次不能为空");
				//务必加return false，表示不提交到服务器端
				return false;
			}
			var startStation=$("#startStation").val();
			if(startStation == ""){
				alert("吴陆阳提示您，出发站不能为空");
				//务必加return false，表示不提交到服务器端
				return false;
			}
			var endStation=$("#endStation").val();
			if(endStation == ""){
				alert("吴陆阳提示您，终点站不能为空");
				//务必加return false，表示不提交到服务器端
				return false;
			}
		})
	})
	

</script>
</head>
<body>
<center>
    <h1>查询车票价格</h1>
	<form id="submForm" action="getPrice.htm" method="post">
	<table border="1" width="50%" style="text-align: center;">
		<tr>
			<td>车次</td>
			<td><input  type="text " name="trainnum" id="trainnum"></td>
		</tr>
		<tr>
			<td>出发地</td>
			<td><input type="text " name="startStation" id="startStation"></td>
		</tr>
		<tr>
			<td>目的地</td>
			<td><input type="text " name="endStation" id="endStation"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
	</form>
	</center>
</body>
</html>