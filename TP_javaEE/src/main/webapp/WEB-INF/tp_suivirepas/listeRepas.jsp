<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="fr.lucien.laurain.suivirepas.BO.Repas,java.util.List,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique des repas</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>
	<section>
		<%
		List<Repas> repasAAfficher = (List<Repas>) request.getAttribute("repasAAfficher");
		%>
		<h2>Liste des repas :</h2>
		<table>
			<tr style="background-color:#000000; color:#ffffff">
				<td>Date</td>
				<td>Heure</td>
			</tr>
			<%
			for (int i = 0; i < repasAAfficher.size(); i++) {
			%>
			<tr>
				<td><%=repasAAfficher.get(i).getDate()%></td>
				<td><%=repasAAfficher.get(i).getHeure()%></td>
				<td><button type="button" class="collapser">detail</button></td>
			</tr>
			<tr class="listealiments">
				<td><%=repasAAfficher.get(i).getAliments().toString()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<h2>Retour</h2>
		<form action="accueilRepas">
			<input type="submit" value="Accueil">
		</form>
	</section>
</body>
</html>