<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="teste.css" rel="stylesheet" type="text/css"/>
        <title>Listar Voos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Origem</th>
                    <th>Destino</th>
                    <th>Data de ida</th>
                    <th>Data de volta</th>
                    <th>Quantidade de passagens</th>
                    <th>Preco</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="voos" items="${encontrados}">
                    <tr>
                        <td name="origem">${voos.getOrigem()}</td>
                        <td name="destino">${voos.getDestino()}</td>
                        <td name="data_ida">${voos.getData_ida()}</td>
                        <td name="data_volta">${voos.getData_volta()}</td>
                        <td name="quantidade_passagens">${voos.getQuantidade_passagens()}</td>
                        <td name="preco">${voos.getPreco()}</td>
                        <td><a class="button" href="ExcluiVooServlet?action=edit&id=<c:out value="${voos.getId_voo()}"/>&pesquisa=<c:out value="${pesquisa}"/>">Remover</a></td>
                        <td><a class="button" href="EditaVooServlet?action=edit&id=<c:out value="${voos.getId_voo()}"/>">Alterar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
