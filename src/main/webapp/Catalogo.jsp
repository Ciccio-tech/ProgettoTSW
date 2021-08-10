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
    <style>
        .container {
            padding: 60px 0;
        }
        @media (max-width: 600px) {
            .container {
                padding: 40px 40px;
            }
        }

        input[type=text]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }

        .column {
            float: left;
            width: 25%;
            padding: 10px 10px;
        }

        .row {margin: 0 -5px;}

        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        @media screen and (max-width: 600px) {
            .column {
                width: 100%;
                display: block;
                margin-bottom: 20px;
            }
        }

        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 16px;
            text-align: center;
            background-color: #f1f1f1;
            height: 470px;
        }

        .price {
            color: grey;
            font-size: 22px;
        }

        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: lightseagreen;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        .card button:hover {
            opacity: 0.7;
        }

    </style>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<%@include file = "header.jsp" %>
<%
    ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");
%>
<div class="container">
    <h2 style="text-align:center">Prodotti </h2>
    <div class="row">



            <%
                if(prodotti!= null)
                for (Prodotto e : prodotti) { %>
        <div class="column" >
            <div class="card">

                <img src=<%=e.getImmagine()%>  alt="Immagine_Prodotto" style="width:100%">
                <h5><%= e.getMarca()+ e.getModello()%></h5>
                <p class="price">$<%=e.getPrezzo()%>
                </p>
                <p>  <%
                    if(session.getAttribute("amministratore")==null){%>
                         <form action="Carrello" method="get"> <button id="carrello"  >Aggiungi al Carrello </button> </p>
                    <% } %>
                    <input type="hidden" name="codP" value=<%=e.getCodP()%> >
                    <input type="hidden" name="qty" value="1">
                    </form>
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
