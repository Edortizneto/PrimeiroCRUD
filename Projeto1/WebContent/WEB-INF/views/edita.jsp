<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
<form action='edita' method='post'>
Nome: <input type='text' name='nome' value='${param.nome}'><br>
Status: <input type='number' name='status' value='${param.status}'><br>
<br>
<input type='hidden' name='id' value='${param.id}'>
<input type='submit' value='editar'>
</form>

</body>
</html>