<%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 21/07/2021
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Effettua Ordine</title>
    <meta charset="utf-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>



    </style>
</head>
<%@include file = "header.jsp" %>
<div class="field2">
    <div class="row ">
        <div class="card x">
            <div>
                <input type="date" class="ricerca"  name="da" placeholder="da data..." >
                <input type="date" class="ricerca" name="a" placeholder="a data...">
                <form action="">
                <button id = "selector" class="button button2">Cerca</button>
                <input type="hidden" name="username" value=<%=session.getAttribute("username")%>>
                </form>
            </div>
            <div class="cart-list">
                <h1 id = "title">Ordini effettuati</h1>

                <p style = "text-align: center">pg <input class = "pageof" type = "number" value = "1" min="1" max="<%= request.getAttribute("maxPg") %>"> of <%= request.getAttribute("maxPg") %> <button id = "submit">Invia</button></p>
            </div>
        </div>
    </div>
</div>



<%@include file = "footer.jsp" %>
</body>
</html>
