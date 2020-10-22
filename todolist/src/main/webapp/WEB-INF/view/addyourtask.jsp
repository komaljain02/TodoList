<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Addtask page</title>
<link rel="stylesheet" href="css/designn.css" >
</head>
<body>
<div class="c1">
		<div class="c13 s9 left" >
			<a href="/" class="p1" name="hlink" >Home</a>
			<a href="addtask" class="p1" name="hlink" >Add task</a>
			<a href="mytask?i=${sessionScope.id}" class="p1" name="hlink" >My task</a>
		</div>
		<div class="c14 left s10" onmouseleave="displayData()">
			<div class="c15">
			<a href="" class="color2" onmouseover="blockData()" name="hlink" >Hi ${sessionScope.user}</a>
			</div>
			<div class="c16" id="blockofdata" >
				<div class="c17"><a href="#" class="color2">profile</a></div>
				<div class="c17"><a href="/" class="color2">logout</a></div>
			</div>
		</div>
	</div>
	<div class="c9" >
		<div class="c11" >
		<div class="c12" >
			<f:form action="insertdata"  modelAttribute="tasklist" method="post" >
				<div class="f1 color1" >
					Enter New Working Schedule
				</div>	
				<div class="f2" >
					<div class="f7 left ">
						<div class="f3 color1">Month</div>
						<f:select path="month"  class="f3" >
							<option selected hidden>Month</option>
							<f:option value='01'>January</f:option>
							<f:option value='02'>February</f:option>
							<f:option value='03'>March</f:option>
							<f:option value='04'>April</f:option>
							<f:option value='05'>May</f:option>
							<f:option value='06'>June</f:option>
							<f:option value='07'>July</f:option>
							<f:option value='08'>August</f:option>
							<f:option value='09'>September</f:option>
							<f:option value='10'>October</f:option>
							<f:option value='11'>November</f:option>
							<f:option value='12'>December</f:option>
						</f:select>
					</div>
					<div class="f7 left">
						<div class="f3 color1">Date</div>
						<f:select path="day" class="f3">
								<option selected hidden >Date</option>
								<f:option value='01'>01</f:option>
								<f:option value='02'>02</f:option>
								<f:option value='03'>03</f:option>
								<f:option value='04'>04</f:option>
								<f:option value='05'>05</f:option>
								<f:option value='06'>06</f:option>								
								<f:option value='07'>07</f:option>
								<f:option value='08'>08</f:option>
								<f:option value='09'>09</f:option>
								<f:option value='10'>10</f:option>
								<f:option value='11'>11</f:option>
								<f:option value='12'>12</f:option>
								<f:option value='13'>13</f:option>
								<f:option value='14'>14</f:option>
								<f:option value='15'>15</f:option>
								<f:option value='16'>16</f:option>
								<f:option value='17'>17</f:option>
								<f:option value='18'>18</f:option>
								<f:option value='19'>19</f:option>
								<f:option value='20'>20</f:option>
								<f:option value='21'>21</f:option>								
								<f:option value='22'>22</f:option>
								<f:option value='23'>23</f:option>
								<f:option value='24'>24</f:option>
								<f:option value='25'>25</f:option>
								<f:option value='26'>26</f:option>
								<f:option value='27'>27</f:option>
								<f:option value='28'>28</f:option>
								<f:option value='29'>29</f:option>
								<f:option value='30'>30</f:option>
								<f:option value="31">31</f:option>
						</f:select>
					</div>
					<div class="f7 left">
						<div class="f3 color1" >Year</div>
						<f:input path="years" placeholder="enter year" class="f8" />
					</div>
				</div>	
				<div class="f2" >
					<div class="f3 color1" >Give a title for your task</div>
					<f:input path="title" class="f3" placeholder="give a title" />
				</div>
				<div class="f5" >
					<div class="f4 color1" >Give a description for your task</div>
					<f:textarea class="f6" path="taskdata" placeholder="Add description for the task"></f:textarea>
				</div>	
				<div class="f2" >
					<div class="f7 left ">
						<div class="f3 color1">High</div>
						<div class="f3 ">
							<f:radiobutton path="priority"  class="size1" value="1" />
						</div>
					</div>
					<div class="f7 left">
						<div class="f3 color1">Medium</div>
						<div class="f3 ">	
							<f:radiobutton path="priority"  class="size1" value="2" />
						</div>
					</div>
					<div class="f7 left">
						<div class="f3 color1">Low</div>
						<div class="f3 ">	
							<f:radiobutton path="priority"  class="size1" value="3" />
						</div>
					</div>
				</div>	
				<div>
					<f:hidden path="tid" />
					<f:hidden path="regvo.rid" value="${sessionScope.id}" />
					<input type="submit" value="Add Task" class="s8" />
				</div>
			</f:form>
		</div>	
		</div>	
	</div>
	<script>
	var y = document.getElementById("blockofdata");
		function blockData()
		{
			y.style.display="block";
		}
		function displayData()
		{
			y.style.display="none";
		}
	</script>
</body>
</html>