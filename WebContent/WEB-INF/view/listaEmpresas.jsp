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
	Usu&aacute;rio Logado:
	<c:out value="${usuarioLogado.login}" />
	<c:import url="logout-parcial.jsp" />
	<br /> Listagem de Empresas
	<br />
	<br />
	<a href="/gerenciador/entrada?acao=NovaEmpresaForm">Criar Nova
		Empresa</a>
	<br />
	<br />
	<c:if test="${not empty listaEmpresas}">
		<c:if test="${not empty empresa}">
	Empresa ${ empresa.nome }, <fmt:formatDate
				value="${ empresa.javaUtilDate }" pattern="dd/MM/yyyy" />, cadastrada com sucesso !
	</c:if>

		<ul>
			<c:forEach var="empresa" items="${ listaEmpresas }">
				<li>${ empresa.nome },<fmt:formatDate
						value="${ empresa.javaUtilDate }" pattern="dd/MM/yyyy" /> <a
					href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
					<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${empty listaEmpresas}">
	Nenhuma empresa cadastrada !
	</c:if>
</body>
</html>