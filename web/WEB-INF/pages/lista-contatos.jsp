<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Adiciona Contato</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <table>
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Endereço</td>
                <td>Data de Nascimento</td>
            </tr>
            <c:forEach var="contato" items="${contatos}" varStatus="status">
                <tr>
                    <td>${contato.id} </td>
                    <td><a href="altera-contato?id=${contato.id}">${contato.nome}</a></td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty contato.email}">
                                <a href="mailto:${contato.email}">${contato.email}</a>
                            </c:when>
                            <c:otherwise>
                                Sem email definido
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${contato.endereco}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy"  value="${contato.dataNascimento.time}"/> </td>
                    <td><a href="remove-contato?id=${contato.id}">Excluir</a></td>
                </tr>
            </c:forEach>                
        </table>
        <c:import url="rodape.jsp"/>
    </body>
</html>