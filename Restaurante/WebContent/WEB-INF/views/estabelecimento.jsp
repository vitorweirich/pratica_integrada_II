<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Estabelecimentos</title>
</head>
<body>
	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>id</th>
				<th>nome</th>
				<th>razao social</th>
				<th>cnpj</th>
				<th>inscricao estadual</th>
				<th>telefone</th>
				<th>endereco id</th>
			</tr>
			<c:forEach var="p" items="${listEstabelecimentos}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nome}</td>
					<td>${p.razaoSocial}</td>
					<td>${p.cnpj}</td>
					<td>${p.inscricaoEstadual}</td>
					<td>${p.telefone}</td>
					<td>${p.endereco.id}</td>
					<td><a href="estabelecimento/${p.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
		<form action="/Restaurante/estabelecimentoSave" method="POST" modelAttribute="estabelecimentoForm">
			<form:hidden path="estabelecimentoForm.id" />
			<p>
				Endereço:
				<form:select path="estabelecimentoForm.endereco">
                    <form:option value="-1" label="--Selecione Endereco"/>
                    <form:options items="${listEnderecos}" itemValue="id" itemLabel="logradouro"/>
                </form:select>
				
			</p>

			<p>
				Nome:
				<form:input path="estabelecimentoForm.nome" />
			</p>

			<p>
				Razao Social:
				<form:input path="estabelecimentoForm.razaoSocial" />
			</p>
			
			<p>
				CNPJ:
				<form:input path="estabelecimentoForm.cnpj" />
			</p>

			<p>
				Inscricao Estadual:
				<form:input path="estabelecimentoForm.inscricaoEstadual" />
			</p>
			
			<p>
				Telefone:
				<form:input path="estabelecimentoForm.telefone" />
			</p>

			<input type="submit" value="Salvar" />

		</form>
	</div>

	<a href="/Restaurante/"> Voltar</a>
</body>
</html>