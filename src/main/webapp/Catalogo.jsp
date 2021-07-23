<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 12/07/2021
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catalogo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<%@include file = "header.jsp" %>
<%
    ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");
%>
<div class="container4">
    <h2 style="text-align:center">Prodotti </h2>
    <div class="row">



            <%
                for (Prodotto e : prodotti) { %>
        <div class="column" >
            <div class="card">

                <img src=<%=e.getImmagine()%>  alt="Immagine_Prodotto" style="width:100%">
                <h5><%= e.getMarca()+ e.getModello()%></h5>
                <p class="price">$<%=e.getPrezzo()%>
                </p>
                <p> <form action="Carrello" method="get"> <button id="carrello" name="<%=e.getCodP()%>" >Aggiungi al Carrello </button> </form> </p>
                <p> <form action="ProdottoServlet" method="get"> <button id="prodotto" name="<%=e.getCodP()%>">Visualizza Prodotto</button> </form> </p>
            </div>
        </div>
        <%}
        %>
</div>
</div>
    <%@include file = "footer.jsp" %>
</body>
</html>
