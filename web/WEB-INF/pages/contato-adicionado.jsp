
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Contato Adicionado</title>
        <meta charset="UTF-8">
    </head>
    <body>
        <c:import url="cabecalho.jsp"/>
        Contato ${param.nome} adicionado com sucesso!
        <c:import url="rodape.jsp"/>
    </body>
</html>