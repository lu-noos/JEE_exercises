<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>
	<section>
		<h2>Accueil</h2>
		<form action="gestionCouleur" method="POST">
			<label for="couleurTexte">Couleur d'affichage du texte : </label><select
				name="couleurTexte">
				<option value="#000000">Noir</option>
				<option value="#1500ff">Bleu</option>
				<option value="#ff0000">Rouge</option>
				<option value="#ff0066">Rose</option>
			</select> <input type="submit" value="Changer">
		</form>
		<br>
		<p>
			Vous avez visité cette page <%
		if (session.getAttribute("compteurAcces") != null) {
			int compteurAcces = (int) session.getAttribute("compteurAcces");
		%>
			<%=compteurAcces%>
			<%
			} else {
			%>
			N/A
			<%
			}
			%>
			fois.
		</p>
		
		<a href="gestionCouleur">Consulter le texte</a>
	</section>
</body>
</html>