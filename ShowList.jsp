<%@page import="java.util.*,object.*"%>
<%
	TreeMap<Double,User> compatibles = ( TreeMap< Double , User > )request.getServletContext().getAttribute("match");
	Set < Map.Entry< Double , User > > entries = compatibles.entrySet();
%>
<!-- alaina indray ny liste izay mi-match rehetra -->
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./assets/dist/css/bootstrap.min.css">
	<title>List des compatibles</title>
</head>
<body>
	<div class="container">
		<div class="row compatibility">
			<div class="list">
				<ol class="list-group list-group-numbered">
					<!-- bouclena ito interface ito -->
					<%	if( compatibles.size() == 0 ){
							out.println("Aucun resultat a afficher");
						}
						for( Map.Entry<Double,User> entry : entries ){
							// entry = iteratr.next(); %>

								<li class="list-group-item d-flex justify-content-between align-items-start">
								    <div class="ms-2 me-auto">
								      <div class="fw-bold">
								      	<%
								      		User user = (User)entry.getValue();
								      		out.println(user.getUsername());
								      	%>
								      </div>
								      <a href="" class="btn btn-primary">Raikitra</a>
								    </div>
								    <span class="badge bg-primary rounded-pill">
								    	<%
								      		out.println( entry.getKey());
								      	%>
								    </span>
								</li>

						<% }
					%>
				</ol>
			</div>
				<!-- atao anaty ul sy li -->
		</div>
	</div>
	<script src="./assets/dist/js/bootstrap.min.js"></script>
</body>
</html>