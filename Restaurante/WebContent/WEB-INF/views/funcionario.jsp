<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Funcionarios</title>
</head>
<body>
<div
        style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
    <table border="2" width="70%" cellpadding="2">
        <tr>
            <th>id</th>
            <th>Nome</th>
            <th>Nascimento</th>
            <th>CPF</th>
            <th>Função</th>
            <th>Endereço</th>
            <th>Estabelecimento</th>
        </tr>
        <c:forEach var="p" items="${listFuncionarios}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nome}</td>
                <td>${p.nascimento}</td>
                <td>${p.cpf}</td>
                <td>${p.funcao}</td>
                <td>${p.endereco.id}</td>
                <td>${p.estabelecimento.id}</td>
                <td><a href="funcionario/${p.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div
        style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
    <!--  Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao -->
    <form action="/Restaurante_war/funcionarioSave" method="POST" modelAttribute="funcionarioForm">
        <form:hidden path="funcionarioForm.id" />

        <p>
            Nome:
            <form:input path="funcionarioForm.nome" />
        </p>

        <p>
            Nascimento:
            <form:input path="funcionarioForm.nascimento" />
        </p>

        <p>
            CPF:
            <form:input path="funcionarioForm.cpf" />
        </p>

        <p>
            Função:
            <form:input path="funcionarioForm.funcao" />
        </p>

        <p>
            Endereço:
            <form:select path="funcionarioForm.endereco">
                <form:option value="-1" label="--Selecione Endereco"/>
                <form:options items="${listEnderecos}" itemValue="id" itemLabel="logradouro"/>
            </form:select>

        </p>

        <p>
            Estabelecimento:
            <form:select path="funcionarioForm.estabelecimento">
                <form:option value="-1" label="--Selecione Estabelecimento"/>
                <form:options items="${listEstabelecimentos}" itemValue="id" itemLabel="razaoSocial"/>
            </form:select>

        </p>

        <input type="submit" value="Salvar" />

    </form>
</div>

<a href="/Restaurante/"> Voltar</a>
</body>
</html>