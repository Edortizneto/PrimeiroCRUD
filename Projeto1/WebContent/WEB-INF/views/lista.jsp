<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,br.edu.insper.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tarefas</title>
</head>
<body>
<h1>Tarefas atuais</h1>
<!-- br.edu.insper.mvc.model.DAO dao = new br.edu.insper.mvc.model.DAO();-->
<table border="1">
<tr>
<td><b>Nome</b></td>
<td><b>Status</b></td>
</tr>
<c:forEach var="tarefa" items="${tarefas}">
<tr>
<td>${tarefa.nome}</td>
<td>${tarefa.status > 0 ? "Feito" : "Pendente"}</td>
<td>
<form action='remove' method='post'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='submit' value='remover'>
</form>
</td>
<td>
<form action='edita' method='get'>
<input type='hidden' name='id' value='${tarefa.id}'>
<input type='hidden' name='nome' value='${tarefa.nome}'>
<input type='hidden' name='status' value='${tarefa.status}'>
<input type='submit' value='editar'>
</form>
</td>
</tr>

</c:forEach>

</table>
<br>
<a>
<form action='Cria' method='get'>
<input type='submit' value='Adicionar Tarefa'>
</form>
</a>
</body>
</html>