<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="displayError.jsp"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jouer à pierre-feuille-ciseaux</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<a href="/TP_javaEE/index.html">Travaux Pratiques réalisés avec Java
			Enterprise Edition</a>
	</header>
	<section>
		<h1>Manche contre le serveur</h1>
		<form action="determinationDuGagnant" method="POST">
			<button type="submit" value="0" name="btnSubmit"><img src="/TP_javaEE/images/pierre.png"><br>PIERRE</button>
			<button type="submit" value="1" name="btnSubmit"><img src="/TP_javaEE/images/feuille.png"><br>FEUILLE</button>
			<button type="submit" value="2" name="btnSubmit"><img src="/TP_javaEE/images/ciseaux.png"><br>CISEAUX</button>
		</form>
	</section>
</body>
</html>