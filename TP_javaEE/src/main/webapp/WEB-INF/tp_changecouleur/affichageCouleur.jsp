<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Texte à consulter</title>
<link href="/TP_javaEE/CSS/styles.css" rel="stylesheet">
</head>
<body>
	<% 	Cookie[] cookies = request.getCookies();
	 	Cookie cookie = null;
	 	String couleurTexte = "#000000";
		if (request.getAttribute("couleurTexte")!=null) {
			couleurTexte= (String) request.getAttribute("couleurTexte");
		}
	%>
	<%@ include file="/header.jsp" %>
	<section>
		<h2>Lorem ipsum dolor sit amet.</h2>
		<p style="color:${cookie.couleurTexte.value}">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi
			laoreet turpis nisl, fringilla varius justo posuere eget. Proin nec
			ultrices nisi, sed luctus orci. Duis ultricies libero at velit
			lacinia eleifend. Ut commodo lorem quis est ultricies laoreet. Etiam
			ac nisi mi. Pellentesque pulvinar et ligula at mattis. Nunc vulputate
			eros in lorem maximus, non eleifend velit suscipit. Nam ullamcorper
			est dolor, at sollicitudin lectus hendrerit vitae. Maecenas
			vestibulum tempus orci maximus ultricies. Donec malesuada et libero
			eu blandit. Vestibulum lacinia consequat quam. Phasellus a vulputate
			sem. Sed a varius magna. Curabitur nec commodo nibh. Donec imperdiet
			consectetur sem, in posuere tellus ullamcorper in. Pellentesque
			habitant morbi tristique senectus et netus et malesuada fames ac
			turpis egestas. Nam id iaculis urna, ut scelerisque purus. Aenean
			efficitur malesuada sapien, vitae condimentum nisl molestie ut. Morbi
			nec ligula a purus convallis scelerisque at vulputate velit. Nam et
			felis neque. Fusce leo purus, bibendum a tortor et, varius dapibus
			ligula. Morbi et suscipit ex. In lacinia vel dui in viverra.

			Suspendisse potenti. Vestibulum commodo laoreet tincidunt. Sed
			tincidunt eget sem eu porttitor. Sed maximus lorem eros, et molestie
			arcu euismod id. Sed nec elit lobortis, tincidunt leo ut, iaculis
			sem. Donec at lorem sed est condimentum cursus in eu orci. Proin non
			convallis libero. Maecenas consectetur lectus vitae ultricies
			ultrices. Suspendisse porta lorem a metus commodo porttitor. Proin
			elementum, mi ac bibendum volutpat, eros tortor scelerisque lacus,
			sit amet auctor nisl nibh non diam. Maecenas vel maximus elit. Nulla
			vitae quam lobortis, volutpat enim ac, viverra ex. Integer tempor dui
			non orci cursus, at vestibulum diam consectetur. Maecenas lacus
			justo, ullamcorper venenatis tortor id, imperdiet posuere libero.
			Phasellus nulla nulla, vulputate vitae ante id, dapibus egestas
			lorem. Ut dapibus ante vel mi scelerisque, tristique bibendum est
			tristique. Vestibulum dignissim quis arcu at volutpat. Nullam ac
			condimentum eros. Nullam ullamcorper ligula orci. Aliquam lorem mi,
			pretium at blandit sed, gravida eleifend urna. Curabitur dictum dolor
			sit amet tellus hendrerit, sit amet pulvinar sem pharetra. In dictum
			tortor augue, vitae aliquet mi facilisis eget. Phasellus iaculis
			nulla ac elit egestas imperdiet. Aenean sagittis dolor nec massa
			porta tristique. Proin semper ullamcorper ligula, sed dictum eros
			varius ut. Nunc at lacus vitae odio ultricies ultricies ac a nulla.
			Vestibulum a sapien scelerisque, mattis est vitae, sodales sem.
			Mauris non erat placerat lacus fermentum laoreet id nec erat.</p>
		<a href="accueilCouleur">Retour</a>
	</section>
</body>
</html>