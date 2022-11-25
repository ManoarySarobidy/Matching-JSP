<%@page import="formulary.Formulaire,object.Annexe,javax.swing.JComponent"%>
<%
	// eto amzay izy no kozina hoe annexe an'ilay olona ilaina no foronina
	// ca fait zany hoe azo ampiana ilay izy na tsia
	Object obj = new Annexe();
	Formulaire form = new Formulaire( obj );
	form.getListeChamp().get(0).setVisibility(false);
	form.getListeChamp().get(1).setTitle("Coefficient Salaire :");
	form.getListeChamp().get(1).setType("Number");
	form.getListeChamp().get(2).setTitle("Coefficient Nationalite");
	form.getListeChamp().get(2).setType("Number");
	form.getListeChamp().get(3).setTitle("Coefficient Finoana");
	form.getListeChamp().get(3).setType("Number");
	form.getListeChamp().get(4).setTitle("Coefficient Diplome");
	form.getListeChamp().get(4).setType("Number");
	form.getListeChamp().get(5).setTitle("Coefficient Fumeur");
	form.getListeChamp().get(5).setType("Number");
	form.getListeChamp().get(6).setTitle("Coefficient Teinte");
	form.getListeChamp().get(6).setType("Number");
	form.getListeChamp().get(7).setTitle("Coefficient Hauteur");
	form.getListeChamp().get(7).setType("Number");
	form.getListeChamp().get(form.getListeChamp().size()-1).setVisibility(false);
	String html = form.getHtml();


%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Fill your criterial </title>
</head>
<body>

	<div class="container">
		<form action="add-Crit" method="post" style="display: flex;width: 50%;flex-direction: column;">
			<%
				out.println( html );
			%>
			<input type="submit" value="Finish">
		</form>
	</div>
	
</body>
</html>