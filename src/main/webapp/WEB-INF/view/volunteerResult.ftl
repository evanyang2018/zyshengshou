<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询结果</title>
<script src="/js/Chart.js"></script>
<script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div style="width:50%;margin: 0px auto;">

    <!--饼图（Pie chart）开始-->
    <div>
        <h1>结果分布图</h1>
        <canvas id="chart-pie" width="450" height="450"/>
    </div>
    <script>
        var pieData = [
			{
			value: 10,
			color:"#F38630"
			,text: "可冲刺-10"
			},
			{
			value : 20,
			color : "#E0E4CC"
			,text: "稳定-20"
			},
			{
			value : 30,
			color : "#69D2E7"
			,text: "保底-30"
			}
			
		];
        var ctx = document.getElementById("chart-pie").getContext("2d");
        window.myPie = new Chart(ctx).Pie(pieData);
    </script>

    <!--饼图（Pie chart）结束-->
</div>
<table>
	<tr>
		<th>保底</th>
		<th>稳定</th>
		<th>可冲刺</th>
	</tr>
	<tr>
		<td>保底学校1</td>
		<td>稳定学校1</td>
		<td>可冲刺学校1</td>
	</tr>
	<tr>
		<td>保底学校2</td>
		<td>稳定学校2</td>
		<td>可冲刺学校2</td>
	</tr>
	
</table>



</body>
</html>