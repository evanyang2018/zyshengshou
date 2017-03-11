<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>志愿查询</title>
<script src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
<div>
	省份：
	<select id="province">
		<option value="beijing">北京</option>
		<option value="shangdong">山东</option>
	</select> 
</div>
<div>
	文理：
	<select id="science">
		<option value="1">文科</option>
		<option value="2">理科</option>
	</select> 
</div>
<div>
	分数：
	<input type="text" id="score" />
</div>
<div>
	志愿区域：
	<select id="volunteerArea">
		<option value="beijing">北京</option>
		<option value="shangdong">山东</option>
	</select>
</div>
	<input type="button" id="select" value="查询"/>	
<script type="text/javascript">
	$("#select").on("click",function(){
		window.location.href="volunteerResult/"+$('#province').val()+"/"+$('#science').val()+"/"+$('#score').val()+"/"+$('#volunteerArea').val();
	});
</script>
</body>
</html>