<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Listagem de Livros</title>
    <style>
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Acervo de Livros</h2>
    
    <c:if test="${empty livros}">
        <p>Nenhum livro cadastrado no momento.</p>
    </c:if>

    <c:if test="${not empty livros}">
        <table>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Ano</th>
                <th>ISBN</th>
                <th>Ação</th>
            </tr>
            <c:forEach var="livro" items="${livros}">
                <tr>
                    <td>${livro.titulo}</td>
                    <td>${livro.autor}</td>
                    <td>${livro.ano}</td>
                    <td>${livro.isbn}</td>
                    <td>
                        <form action="livros" method="post">
                            <input type="hidden" name="isbnExcluir" value="${livro.isbn}" />
                            <button type="submit" onclick="return confirm('Deseja excluir este livro?');">Excluir</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <a href="index.jsp">Voltar ao Menu</a>
</body>
</html>