<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suivi des repas</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<a href="http://localhost:8080/TP_javaEE/index.html">Travaux
			Pratiques réalisés avec Java Enterprise Edition</a>
	</header>
	<section>
		<h2>Que voulez-vous faire ?</h2>
		<form action="ServletAjoutRepas">
			<input type="submit" value="Ajouter un repas">
		</form>
		<form action="ServletAffichageRepas">
			<input type="submit" value="Voir les repas">
		</form>

	</section>
</body>
</html>