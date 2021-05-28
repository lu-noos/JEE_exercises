<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau repas</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<header>
		<a href="http://localhost:8080/TP_javaEE/index.html">Travaux
			Pratiques réalisés avec Java Enterprise Edition</a>
	</header>
	<section>
	<h2>Mon repas :</h2>
		<form action="ServletAjoutRepas" method="POST">
		<label for="date">Date du repas : </label><input type="date" name="date" placeholder="01/01/2000" required><br>
		<label for="time">Heure du repas : </label><input type="time" name="time" placeholder="00:00" required><br>
		<label for="aliments"><br>Repas<br></label><input size="50" name="aliments" placeholder="Entree, Plat, ..." required>
		<br>
		<input type="submit" value="Ajouter">
		</form>
	<h2>Retour</h2>
		<form action="accueilRepas">
			<input type="submit" value="Accueil">
		</form>
	</section>
</body>
</html>