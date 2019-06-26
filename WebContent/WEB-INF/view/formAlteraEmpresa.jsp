<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletEntrada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Altera Empresa</title>
</head>
<body>
	<form action="${ linkServletEntrada }" method="post">
		Nome: <input type="text" name="nome" value="${nome}" /> <br />
		Data Abertura: <input type="text" name="dataAbertura" value="${dataAbertura}" /> <br />
		<input type="hidden" name="id" value="${id}" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>