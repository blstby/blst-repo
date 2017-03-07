<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affaires</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<h2>List des affaires</h2>
	<table>
		<tr>
			<td>id</td>
			<td>code produit</td>
			<td>montant</td>
			<td>id tiers</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${affaires}" var="affaire">
			<tr>
				<td>${affaire.id}</td>
				<td>${affaire.codeProduit}</td>
				<td>${affaire.montantFin}</td>
				<td>${affaire.idTier}</td>
				<td><a href="<c:url value='/save-${affaire.id}-affaire' />">Sauvegarder en local</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="<c:url value='/index' />">Retour au menu principal</a>
	<a href="<c:url value='/newA' />">Nouvelle affaire</a>
	<form:form method="POST" modelAttribute="tier">
		<table>
			<tr>
				<td><label for="id">Id du tier: </label></td>
				<td><form:input path="id" id="id" /></td>
				<td><input type="submit" value="Recherche affaires par tier" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>