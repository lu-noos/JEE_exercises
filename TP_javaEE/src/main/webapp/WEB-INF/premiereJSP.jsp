<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%! int maVar = 6; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Yeah bb</title>
</head>
<body>
	<section>
		<h1>PREMIERE JSP</h1>
		<a href="../../index.html">index</a>
		<% maVar++; %>
		<p><%= maVar %></p>
	</section>
</body>
</html>