<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Créer une liste</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp"%>
	<section>
		<form action="" method="POST">
			<label for="nomListe">Nom : </label><input type="text"
				name="nomListe" value="${cookie.nomListe.value}" required></input> <br>
			<c:if test="${requestScope.coursesTemp != null}" >
			<c:forEach var="entry" items="${requestScope.coursesTemp}">
				<p>${entry.key}</p>
			</c:forEach>
			</c:if>
			<p>
				<input type="text" name="newCourse"><input type="submit" value="Ajouter" name="ajoutcourse">
			</p>
			<p>
				<input type="submit" value="Valider la liste" name="validation">
			</p>
		</form>
		<a href="/TP_javaEE/tps/tp_listecourses/ServletAffichageListes">Retour</a>
	</section>
</body>
</html>