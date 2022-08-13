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

<title>Cadastro Endereço</title>
</head>
<body>
  <h1>Cadastrar Endereço</h1>
  <hr>

  <div class="form">
    <c:url var="url" value="processa-cadastrar-endereco"/>
    <form:form action="${url}" method="post" modelAttribute="endereco">
            <form:label path="cep">CEP: </form:label> 
            <form:input type="text" path="cep"/></br>
            <form:label path="nomeRua">Nome Rua: </form:label>
            <form:input type="text" path="nomeRua"/>  </br>        
            <input type="submit" value="submit"/>
        </form:form>    
  </div>

</body>
</html>