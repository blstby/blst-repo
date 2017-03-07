<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouveau Tier</title>
<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>
</head>
<body>
	<h2>Creation tier</h2>

	<form:form method="POST" modelAttribute="tier">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="nom">Nom: </label></td>
				<td><form:input path="nom" id="nom" /></td>
			</tr>

			<tr>
				<td><label for="tier">tier: </label></td>
				<td><form:input path="tier" id="tier" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Creer" /></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Retour a
	<a href="<c:url value='/listT' />">Liste des tiers</a>
</body>
</html>