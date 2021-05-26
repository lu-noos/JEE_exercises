<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<a href="/TP_javaEE/index.html">Travaux Pratiques réalisés avec
			Java Enterprise Edition</a>
	</header>
	<section>
	<p>(<%= exception %>) <%=exception.getMessage() %></p>
	</section>
</body>
</html>