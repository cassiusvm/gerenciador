<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletEntrada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Nova Empresa</title>
</head>
<body>
	<form action="${ linkServletEntrada }" method="post">
		Nome: <input type="text" name="nome" /> <br />
		Data Abertura: <input type="text" name="dataAbertura" /> <br />
		<input type="hidden" name="acao" value="NovaEmpresa" />
		<input type="submit" />
	</form>
</body>
</html>