<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div
        style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
        <table border="2" width="70%" cellpadding="2">
            <tr>
                <th>*</th>
                <th>Logradouro</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>CEP</th>
            </tr>
            <c:forEach var="a" items="${listEnderecos}">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.logradouro}</td>
                    <td>${a.bairro}</td>
                    <td>${a.cidade}</td>
                    <td>${a.cep}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div
            style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
        <form action="/Restaurante/enderecoSave" method="POST"
              modelAttribute="enderecoForm">
            <form:hidden path="enderecoForm.id" />
            <p>
                Logradouro:
                <form:input path="enderecoForm.logradouro" />
            </p>
            <p>
                Bairro:
                <form:input path="enderecoForm.bairro" />
            </p>
            <p>
                Cidade:
                <form:input path="enderecoForm.cidade" />
            </p>
            <p>
                Cep:
                <form:input path="enderecoForm.cep" />
            </p>
            <input type="submit" value="Salvar" />

        </form>
    </div>
	<a href="/Restaurante/"> Voltar</a>

</body>
</html>
