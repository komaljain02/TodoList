<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My task</title>
<link rel="stylesheet" href="css/designn.css" >
</head>
<body>
<div class="c1">
		<div class="c13 s9 left" >
			<a href="/" class="p1" name="hlink" >Home</a>
			<a href="addtask" class="p1" name="hlink" >Add task</a>
			<a href="mytask?i=${i}" class="p1" name="hlink" >My task</a>
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
	<div class="c10" >
		<div class="c18">
	    	<div class="c20">
	            <input type="text" class="f9"><input type="submit" value="find" class="f10">
	            <select name="typelist" class="f9">
	                <option selected="selected" hidden="">sorting task</option>
	                <option value="1">sort by date</option>
	                <option value="2">sort by priority</option>
	                <option value="3">All high priority</option>
	                <option value="4">All meduim priority</option>
	                <option value="5">All low priority</option>
				</select>
	        </div>
		</div>
        <div class="c19">
	        <div class="f13" >
		        	<div class="c21">
		                <div class="left f11 texta bcolor5 color1">Date</div>
		                <div class="left f11 texta bcolor5 color1">Time</div>
		                <div class="left f12 texta bcolor5 color1">Title</div>
		                <div class="left f12 texta bcolor5 color1">Description</div>
		                <div class="left f11 texta bcolor5 color1">Priority</div>
		                <div class="left f11 texta bcolor5 color1">Action</div>
		            </div>
		             <c:forEach var="j" items="${listdata}" >
		           			 <div class="c22">
				            	<c:set value="${j.date.time}" var="d" ></c:set>
	        					<c:set value="${f:split(d,' ')}" var="s" ></c:set>
			                    <div class="left f11 texta bcolor4">${j.years}/${j.month}/${j.day}</div>
			                    <div class="left f11 texta bcolor4">${s[3]}</div>
			                    <div class="left f12 bcolor4"><div class="f14" >${j.title}</div></div>
			                    <div class="left f12 bcolor4"><div class="f14" >${j.taskdata}</div></div>
			                    <div class="left f11 texta bcolor4">${j.priority}</div>
			                    <div class="left f11 texta bcolor4"><a href="" >edit</a> / <a href="deletedata?id=${j.tid}&i=${j.regvo.rid}">delete</a></div>
		               	     </div>
		             </c:forEach>
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