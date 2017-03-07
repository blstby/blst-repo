<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle Affaire</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<h2>Creation affaire</h2>

	<form:form method="POST" modelAttribute="affaire">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="codeProduit">Code produit: </label></td>
				<td><form:input path="codeProduit" id="codeProduit" /></td>
			</tr>

			<tr>
				<td><label for="montantFin">Montant : </label></td>
				<td><form:input path="montantFin" id="montantFin" /></td>
			</tr>

			<tr>
				<td><label for="idTier">Id tier : </label></td>
				<td><form:input path="idTier" id="idTier" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Creer" /></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Retour a
	<a href="<c:url value='/listA' />">Liste des affaires</a>
</body>
</html>