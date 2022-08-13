<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Listar Pesssoas</title>
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
    
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>                    
                </tr>
            </thead>
            <tbody>                
                    <tr>
                        <td>${pessoa.id}</td>
                        <td>${pessoa.nome}</td>                        
                    </tr>                
            </tbody>
        </table>
    </body>
</html>