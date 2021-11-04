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
			</tr>
			<c:forEach var="p" items="${listProdutos}">
				<tr>
					<td>${p.id}</td>
					<td>${p.estabelecimento.endereco.cidade}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>*</th>
				<th>Nome</th>
				<th>CNPJ</th>
			</tr>
			<c:forEach var="e" items="${estabelecimentos}">
				<tr>
					<td>${e.id}</td>
					<td>${e.nome}</td>
					<td>${e.cnpj}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
		
			<tr>
				<th>*</th>
				<th>Data pedidos</th>
			</tr>
			<c:forEach var="c" items="${comandas}">
				<c:forEach var="pe" items="${ped}">
					<tr>
						<td>${c.id}</td>

						<td>${ped.dataCriacao}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<form action="/Restaurante/produtoSave" method="POST"
			modelAttribute="produto">
			<form:hidden path="produto.id" />
			<p>
				Nome:
				<form:input path="produto.nome" />
			</p>
			<input type="submit" value="Salvar" />

		</form>
	</div>
</body>
</html>