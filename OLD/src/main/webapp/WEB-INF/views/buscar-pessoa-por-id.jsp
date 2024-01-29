<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">
<script type="text/javascript" src="/resources/js/app.js"></script>

<title>Busca de Pessoa por ID</title>
</head>
<body>
  <h1>Busca por ID:</h1>
  <hr>
    <!-- COMENTARIO -->
  <div class="form">
    <c:url var="url" value="buscar-pessoa-por-id"/>
    <form:form action="${url}" method="post" > 
        Id Pessoa: <td><input id="id" name="id"></td>
        <td><input type="submit" value="Submit"></td>                
    </form:form>    
  </div>

</body>
</html>