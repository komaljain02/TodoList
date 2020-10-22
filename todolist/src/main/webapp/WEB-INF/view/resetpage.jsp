<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reset password page</title>
<link rel="stylesheet" href="css/designn.css" >
</head>
<body>
	<f:form method="post" modelAttribute="userkey" >
    <div class="x10">
    <h1>Reset Password Page</h1>
		<div class="s2">
			<div class="imag2 left"></div>
			<f:input path="mail" id="ma" name="em" class="bcolor2 s4 left" placeholder="Your email" />
		</div>
		<br>
		<br>
		<div class="s2">
			<div class="imag1 left"></div>
			<f:password path="password" id="pa1" name="p1" class="bcolor2 s4 left" placeholder="enter Password" />
		</div>
		<br>
		<br>
		<div class="s2">
			<div class="imag1 left"></div>
			<input type="password" id="pa2" name="p2" class="bcolor2 s4 left" placeholder="re-enter Password">
		</div>
		<br> <br> <input type="button" class="s5 right bcolor1 color1" value="Reset" onclick="checkpass()">
			<br><br><br><p id="para"></p>
    </div>
	</f:form>
	<script>
		var message = document.getElementById("para");
		message.innerHTML="";
		function checkpass()
			{
			
				var x = document.getElementById("pa1");
				var y = document.getElementById("pa2");
				var z = document.getElementById("ma");
				message.innerHTML="";
				if(z.value="")
				{
					message.style.color="red";
					message.innerHTML="*enter email ";
				}
				else if(x.value!="" && y.value!="" && x.value==y.value)
				{
					window.location.href="resetpassword";	
						
				}
				else if(x.value!=y.value)
				{
					message.style.color="red";
					message.innerHTML="*both passowrd are mismatch re-enter again";
				}
			}
	</script>
</body>
</html>