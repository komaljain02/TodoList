<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" type="text/css" href="css/designn.css">
</head>
<body>
	<div class="c1">
		<div class="c3">
			<a  name="hlink" href="/" class="p1">Home</a> 
			<a class="p1"name="hlink" onclick="display('login')">login</a> 
			<a class="p1"name="hlink" onclick="display('signup')">signup</a>
			 <a class="p1" name="hlink" >about me</a>
		</div>
	</div>
	<div class="c2">
		<div class="c4" id="details">
			<div class="c5">
				<div class="c6 s1" id="box1" onclick="display('signup')">Sign
					Up</div>
				<div class="c6 s1" id="box2" onclick="display('login')">Log in
					<!--<input type="button" value="X" class="s7" onclick="hide()" > -->
				</div>
			</div>
			<div class="c7" id="login">
				<form>
					<div class="s2">
						<div class="imag2 left"></div>
						<input type="email" id="lmail"
							class="bcolor2 s4 left" placeholder="Your email" />
					</div>
					<br>
					<div class="s2">
						<div class="imag1 left"></div>
						<input type="password"  id="lpass"
							class="bcolor2 s4 left" placeholder="Your Password" />
					</div>
					<br> <a href="" class="right">forgot your password ? </a><br>
					<br> <input class="s3 right bcolor1 color1" type="button"
						value="Log in" onclick="validateUser()" /><br> <br> <br>
					<br>
					<p>
					<hr>
					</p>
					<p class="s6" id="check"></p>
				</form>
			</div>
			<div class="c7" id="signup">
				<s:form action="register" method="post" modelAttribute="key" >
					<div class="s2">
						<div class="imag3 left"></div>
						<s:input path="name" class="bcolor2 s4 left"
							placeholder="First name& last name" />
					</div>
					<br>
					<div class="s2">
						<div class="imag2 left"></div>
						<s:input path="mail" class="bcolor2 s4 left"
							placeholder="email" />
					</div>
					<br>
					<div class="s2">
						<div class="imag1 left"></div>
						<s:password path="password" class="bcolor2 s4 left"
							placeholder="Your password" />
					</div>
					<br> <input type="submit" class="s5 right bcolor1 color1"
						value="Create An Account" /> <br> <br> <br>
					<p>
					<hr>
					</p>
				</s:form>
			</div>
		</div>
	</div>

	<script>
		var v = document.getElementById("details");
		function display(g) {
			var x = document.getElementById(g);
			var b1 = document.getElementById("box1");
			var b2 = document.getElementById("box2");
			b1.style.backgroundColor = "white";
			b2.style.backgroundColor = "white";
			v.style.display = "block";
			if (g == "login") {
				document.getElementById("signup").style.display = "none";
				b2.style.backgroundColor = "#d9d4d4";
			} else {
				document.getElementById("login").style.display = "none";
				b1.style.backgroundColor = "#d9d4d4";

			}
			x.style.display = "block";
		}

		function validateUser() {
			var info = document.getElementById("check");
			info.innerHTML="";
			var a = document.getElementById("lmail");
			var b =document.getElementById("lpass");
			var htp = new XMLHttpRequest();
			htp.onreadystatechange = function() {
				if (htp.readyState == 4) {
					var o = JSON.parse(htp.responseText);
					var obj = o[0];
					if(obj.status==0)
						{
							
							info.innerHTML="*user dosen't exists please signup first";
						}
					else
						{
							window.location.href="addtask";
						}
				}
			}
			htp.open("GET","verify?a="+encodeURIComponent(a.value)+"&b="+encodeURIComponent(b.value),true);
			htp.send();
		}
		function hide()
		{
			v.style.display="none";
		}
	</script>
</body>
</html>