<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Nova Empresa</title>
</head>
<body>
	<c:if test="${not empty empresa}">
	Empresa ${ empresa.nome }, <fmt:formatDate
			value="${ empresa.javaUtilDate }" pattern="dd/MM/yyyy" />, cadastrada com sucesso !
	</c:if>
	<c:if test="${empty empresa}">
	Nenhuma empresa cadastrada !
	</c:if>
</body>
</html>