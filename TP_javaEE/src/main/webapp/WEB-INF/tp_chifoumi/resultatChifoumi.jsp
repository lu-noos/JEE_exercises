<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="displayError.jsp"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat de votre affrontement</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<a href="/TP_javaEE/index.html">Travaux Pratiques réalisés avec Java
			Enterprise Edition</a>
	</header>
	<section>
		<h1>
		<%= request.getAttribute("cpServeur")%><br>
		<%= request.getAttribute("cpClient") %><br>
		<%= request.getAttribute("decision") %><br></h1>
		<p> Parties : <%= request.getAttribute("nbParties") %></p>
		<p> Victoires : <%= request.getAttribute("nbVictoires")%></p>
		<p> Defaites : <%= request.getAttribute("nbDefaites")%></p>
		<a href="pageChifoumi">Rejouer</a>
	</section>
</body>
</html>