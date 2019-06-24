<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.eti.cvm.gerenciador.servlet.Empresa"%>
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
		<%
			List<Empresa> listaEmpresas = (List<Empresa>) request.getAttribute("listaEmpresas");

			for (Empresa empresa : listaEmpresas) {
		%>
		<li><%=empresa.getNome()%></li>
		<%
			}
		%>
	</ul>
</body>
</html>