<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletEntrada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciador - Login</title>
</head>
<body>
	<form action="${ linkServletEntrada }" method="post">
		Login: <input type="text" name="login" /> <br />
		Senha: <input type="password" name="senha" /> <br />
		<input type="hidden" name="acao" value="Login" />
		<input type="submit" />
	</form>
</body>
</html>