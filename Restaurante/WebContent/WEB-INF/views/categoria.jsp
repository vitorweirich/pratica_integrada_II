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
                <th>Descrição</th>
            </tr>
            <c:forEach var="p" items="${listCategorias}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.descricao}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div
            style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
        <form action="/Restaurante/categoriaSave" method="POST"
              modelAttribute="categoriaForm">
            <form:hidden path="categoriaForm.id" />
            <p>
                Nome:
                <form:input path="categoriaForm.descricao" />
            </p>
            <input type="submit" value="Salvar" />

        </form>
    </div>
	<a href="/Restaurante/"> Voltar</a>

</body>
</html>
