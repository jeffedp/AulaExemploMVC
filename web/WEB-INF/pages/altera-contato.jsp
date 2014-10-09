<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Altera Contato</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <form action="altera-contato" method="post">
            Id: <input type="number" name="id" value="${contato.id}"/><br />
            Nome: <input type="text" name="nome" value="${contato.nome}"/><br />
            E-mail: <input type="email" name="email" value="${contato.email}"/><br />
            Endereco: <input type="text" name="endereco" value="${contato.endereco}"/><br />
            <fmt:formatDate pattern="yyyy-MM-dd" value="${contato.dataNascimento.time}" var="dataNascimento" />
            Data Nascimento:<input type="date" name="dataNascimento" value="${dataNascimento}"/><br/>
            <input type="submit" value="Gravar" />
        </form>
        <c:import url="rodape.jsp"/>
    </body>
</html>