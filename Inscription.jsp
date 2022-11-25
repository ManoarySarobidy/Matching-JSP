<%@page import="object.Info,formulary.Formulaire,javax.swing.*"%>
<%
	Object obj = new Info();
	Formulaire form = new Formulaire( obj );
	form.getListeChamp().get(0).setVisibility(false);
	form.getListeChamp().get(1).setTitle("Salaire");
	form.getListeChamp().get(1).setComposant((JComponent)obj.getClass().getMethod("initializeSalaire").invoke(obj));
	form.getListeChamp().get(2).setTitle("Nationalite");
	form.getListeChamp().get(2).setComposant((JComponent)obj.getClass().getMethod("initializeComponent").invoke(obj));
	form.getListeChamp().get(3).setTitle("Finoana");
	form.getListeChamp().get(3).setComposant((JComponent)obj.getClass().getMethod("initializeFinoana").invoke(obj));
	form.getListeChamp().get(4).setTitle("Diplome");
	form.getListeChamp().get(4).setComposant((JComponent)obj.getClass().getMethod("initializeDiplome").invoke(obj));
	form.getListeChamp().get(5).setTitle("Fumeur");
	form.getListeChamp().get(5).setComposant((JComponent)obj.getClass().getMethod("initializeSmoke").invoke(obj));
	form.getListeChamp().get(6).setTitle("Teinte");
	form.getListeChamp().get(6).setComposant((JComponent)obj.getClass().getMethod("initializeTeinte").invoke(obj));
	form.getListeChamp().get(7).setTitle("Taille");
	form.getListeChamp().get(7).setComposant((JComponent)obj.getClass().getMethod("initializeLongeur").invoke(obj));
	form.getListeChamp().get( form.getListeChamp().size()-1 ).setVisibility(false);
	String html = form.getHtml();	
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title> Create User </title>
</head>

<!-- rehefa avy ato dia asaina msave anaty base aloha izy -->
<!-- zany hoe mila foronina aloha le personne zay vao mampiditra data -->

<body>
	<div class="container">
		<form action="add-Info" method="POST" style="display: flex; flex-direction: column; width: 50%;">
			<%
				out.println(html);
			%>
			<input type="submit" value="Sign Up">
			<!-- rehefa avy mi-signup izy dia alefa any am page ireay hafa mameno ny critere indray -->
		</form>
	</div>
</body>
</html>