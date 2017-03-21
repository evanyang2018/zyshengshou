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
		<option value="北京">北京</option>
		<option value="山东">山东</option>
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
	<input type="button" id="select" value="查询"/>	
<script type="text/javascript">
	
	$("#select").on("click",function(){
	
		var ranking="";
		
		var requestUrl="ranking/"+$("#province").val()+"/"+$("#science").val()+"/"+$("#score").val();
		$.ajax({
		   type: "GET",
		   url: requestUrl,
		   success: function(msg){
		     if(msg.ret==200){
		     	ranking=msg.ranking;
		     	window.location.href="volunteerResultPage/"+$('#province').val()+"/"+$('#science').val()+"/"+ranking;
		     }else{
		     	alert(msg.info);
		     	$("#score").css("background","red");
		     	return ;
		     }
		   }
		});
	});
</script>
</body>
</html>