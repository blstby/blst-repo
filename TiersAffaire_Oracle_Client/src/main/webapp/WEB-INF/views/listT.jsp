<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tiers</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<h2>List des Tiers</h2>
	<table>
		<tr>
			<td>id</td>
			<td>Nom</td>
			<td>Tier</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${tiers}" var="tier">
			<tr>
				<td>${tier.id}</td>
				<td>${tier.nom}</td>
				<td>${tier.tier}</td>
				<td><a href="<c:url value='/save-${tier.id}-tier' />">Sauvegarder en local</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value='/index' />">Retour au menu principal</a>
	<a href="<c:url value='/newT' />">Nouveau Tier</a>
</body>
</html>