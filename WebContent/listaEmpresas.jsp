<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Lista Empresas</title>
</head>
<body>
	Empresas
	<br />
	<ul>
		<c:forEach var="empresa" items="${ listaEmpresas }">
			<li>${ empresa.nome }, <fmt:formatDate
					value="${ empresa.javaUtilDate }" pattern="dd/MM/yyyy"/></li>
		</c:forEach>
	</ul>
</body>
</html>