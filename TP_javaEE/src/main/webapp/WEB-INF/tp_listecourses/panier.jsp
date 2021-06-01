<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp"%>
	<section>
		<h2>${requestScope.listeAAfficher.getNomListe() }</h2>
		<c:forEach items="${requestScope.listeAAfficher.getCourses() }" var="entry">
			<p><form>
			<input type="checkbox" <c:if test="${entry.value }">checked</c:if>>
			${entry.key }
			</form></p>
		</c:forEach>
		<a href="/TP_javaEE/tps/tp_listecourses/ServletAffichageListes">Retour</a>
	</section>
</body>
</html>