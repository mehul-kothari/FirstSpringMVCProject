<html>
<body>
	<h1> ${userType} login form for XYZ company</h1>

	<form action="/FirstSpringMVCProject/${userType}/submitLoginForm.html" method="post">
		<p>
			${userType}'s ID : <input type="text" name="employeeID" />
		</p>
		<p>
			${userType}'s password : <input type="text" name="employeePassword" />
		</p>
		<input type="submit" value="Login" />
	</form>
 
</body>
</html>

