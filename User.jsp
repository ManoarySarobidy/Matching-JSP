<!-- tonga de object no omena azy mba ampalaky azy de atao not visible fotsiny ilay idUser-->
<%@page import="object.*,formulary.Formulaire"%>
<%
	Object object = new User();
	Formulaire form = new Formulaire( object );
	form.getListeChamp().get(0).setVisibility(false);
	form.getListeChamp().get(1).setTitle("Enter your username");
	form.getListeChamp().get(2).setTitle("Enter a password");
	form.getListeChamp().get(2).setType("password");
	
	form.getListeChamp().get(form.getListeChamp().size()-1).setComposant( (javax.swing.JComponent)object.getClass().getMethod("initializeComponent").invoke(object) );
	String html = form.getHtml();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Sign User</title>
</head>
<body>
	<div class="container">
		<div class="form-User">
			<form action="inscribe" method="POST">
				<%
					out.println(html);
				%>
				<input type="submit" value="Create User">
			</form>
		</div>
	</div>
</body>
</html>