<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.lucien.laurain.listecourses.BO.ListeCourses"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mes courses</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp"%>
	<section>
		<h2>Mes listes de courses :</h2>
		<table>
			<tr style="background-color: #000000; color: #ffffff">
				<td>Nom</td>
				<td>Date</td>
				<td>Articles</td>
			</tr>
			<c:forEach var="i" begin="0"
				end="${requestScope.listesAAfficher.size()-1}">
				<tr>
					<td>${requestScope.listesAAfficher.get(i).getNomListe()}</td>
					<td>${requestScope.listesAAfficher.get(i).getDate()}</td>
					<td>${requestScope.listesAAfficher.get(i).getCourses().size()}</td>
				</tr>
				<tr style="background-color: rgba(0, 0, 0, 0)" class="bouton">
					<td>
						<form action="ServletSuppressionListe">
							<button type="submit" value="${requestScope.listesAAfficher.get(i).getIdListe()}" name="idListe">
								<img src="/TP_javaEE/images/trash.png" style="border-radius: 0%">
							</button>
						</form>
					</td>
					<td>
						<form action="ServletDuPanier" method="GET">
							<button type="submit" value="${requestScope.listesAAfficher.get(i).getIdListe()}" name="idListe">
								<img src="/TP_javaEE/images/shop.png" style="border-radius: 0%">
							</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<form action="/TP_javaEE/tps/tp_listecourses/ServletAjoutListe"
					method="GET">
					<td><input type="text" name="nomListe" required></td>
					<td><input type="submit" value="Ajouter"></td>
				</form>
			</tr>
		</table>

	</section>
</body>
</html>