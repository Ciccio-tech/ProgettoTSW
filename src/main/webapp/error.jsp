<%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 24/07/2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/stile.css" type = "text/css">
    <script type = "text/javascript" src = "js/jquery.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
    input[type=text]{
        width: 100%;
        border: 2px solid lightseagreen;
        border-radius: 4px;
        padding: 12px 20px;
        margin: 8px 0;
    }
</style>

<body  data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file = "header.jsp" %><br><br>
<div id="errore" class="field2">
    <h1> Errore </h1>
    <h2>Si è verificato un errore, la pagina a cui stai tentando di accedere è privata o inesistente ...</h2>
    <a class="button button2" href= "index.jsp"> Home</a>
</div>
<%@include file = "footer.jsp" %><br><br>

</body>
</html>