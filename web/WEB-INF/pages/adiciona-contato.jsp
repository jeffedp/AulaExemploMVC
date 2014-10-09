<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Adiciona Contato</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        <form action="adiciona-contato" method="post">
            Nome: <input type="text" name="nome"/><br />
            E-mail: <input type="email" name="email"/><br />
            Endereco: <input type="text" name="endereco"/><br />
            Data Nascimento:<input type="date" name="dataNascimento"/><br/>
            <input type="submit" value="Gravar" />
        </form>
        <c:import url="rodape.jsp"/>
    </body>
</html>