<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>*</th>
				<th>Descrição</th>
				<th>-</th>
				<th>-</th>
			</tr>
			<c:forEach var="p" items="${listProdutos}">
				<tr>
					<td>${p.id}</td>
					<td>${p.descricao}</td>
					<td><a href="produto/${p.id}">Editar</a></td>
					<td><a href="produto/${p.id}/deletar">Deletar</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="/Restaurante/produtoSave" method="POST"
			modelAttribute="produto">
			<form:hidden path="produto.id" />
			<p>
				Descricao:
				<form:input path="produto.descricao" />

			</p>

			<input type="submit" value="Salvar" />

		</form>
	</div>
</body>
</html>