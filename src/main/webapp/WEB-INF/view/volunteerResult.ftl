<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询结果</title>
<script src="/js/Chart.js"></script>
<script src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	

	
</script>


</head>
<body>
	<div style="width:50%;margin: 0px auto;">

    <!--饼图（Pie chart）开始-->
    <div>
        <h1>结果分布图</h1>
        <canvas id="chart-pie" width="450" height="450"/>
    </div>
    <!--饼图（Pie chart）结束-->
	</div>
	<table>
		<tr>
			<th>可冲刺</th>
			<#list sprintCollegeList as college>
			<td>${college.college}</td>
			</#list>
		</tr>
		<tr>
			<th>稳定</th>
			<#list stablityCollegeList as college>
			<td>${college.college}</td>
			</#list>
		</tr>
		<tr>
			<th>保底</th>
			<#list ensureCollegeList as college>
			<td>${college.college}</td>
			</#list>
		</tr>
		
	</table>

	<script>
        var pieData = [
        	<#if sprintCollegeNum!=0>
				{
				value: ${sprintCollegeNum},
				color:"#F38630",
				text: "可冲刺-${sprintCollegeNum}所"
				},
			</#if>
			<#if stablityCollegeNum!=0>
				{
				value : ${stablityCollegeNum},
				color : "#E0E4CC",
				text: "稳定-${stablityCollegeNum}所"
				},
			</#if> 
			
			<#if ensureCollegeNum!=0>
				{
				value : ${ensureCollegeNum},
				color : "#69D2E7",
				text: "保底-${ensureCollegeNum}所"
				}
			</#if>
		];
        var ctx = document.getElementById("chart-pie").getContext("2d");
        window.myPie = new Chart(ctx).Pie(pieData);
    </script>

</body>
</html>