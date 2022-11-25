<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Connexion</title>
</head>
<body>
	<div class="container">
		<div class="form-container">
			<form action="login" method="POST">
				
				<div class="username">
					<label for="user"> Your username : </label>
					<input type="text" name="username" id="user">
				</div>

				<div class="password">
					<label for="password"> Your password : </label>
					<input type="password" name="password" id="password">
				</div>

				<input type="submit" value="Connexion">
			</form>
			<div class="link-to-User">
				<a href="User.jsp"> Create User </a>
			</div>
		</div>
	</div>

</body>
</html>