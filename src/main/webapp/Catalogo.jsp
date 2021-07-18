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
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .navbar-nav>li>a {
            padding-top: 25px;
            padding-bottom: 15px;
        }

        .navbar-toggle {
            margin-top: 18px;
        }
        .navbar-brand {
            float: left;
            height: 70px;
            padding: 7px 7px;
            font-size: 20px;
            line-height: 20px;
        }
        .navbar {
            font-family: Montserrat, sans-serif;
            margin-bottom: 0;
            background-color: #2d2d30;
            border: 0;
            font-size: 11px !important;
            letter-spacing: 4px;
            opacity: 0.9;
        }
        .nav-tabs li a {
            color: #777;
        }
        .navbar li a, .navbar .navbar-brand {
            color: #d5d5d5 !important;
        }
        .navbar-nav li a:hover {
            color: #fff !important;
        }

        .navbar-nav li.active a {
            color: #fff !important;
            background-color: #29292c !important;
        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
        }
        .open .dropdown-toggle {
            color: #fff;
            background-color: #555 !important;
        }
        .dropdown-menu li a {
            color: #000 !important;
        }
        .dropdown-menu li a:hover {
            background-color: lightseagreen !important;
        }
        footer {
            background-color: #2d2d30;
            color: #f5f5f5;
            padding: 32px;
        }
        footer a {
            color: #f5f5f5;
        }
        footer a:hover {
            color: #777;
            text-decoration: none;
        }
        .container {
            padding: 60px 0px;
        }
        @media (max-width: 600px) {
            .container {
                padding: 40px 40px;
            }
        }

        .column {
            float: left;
            width: 25%;
            padding: 0 10px;
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
            border-radius: 12px;
        }

        .card button:hover {
            opacity: 0.7;
        }

    </style>
</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<%@include file = "header.jsp" %>


<form action="ProdottiServlet" method="get" >
<% response.sendRedirect("ProdottiServlet");%>
    <div class="container">
        <h2 style="text-align:center">Prodotti</h2>
        <div class="row">
            <div class="column">
                <div class="card">
                    <%
                        ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("products");
                        String Marca, Modello;
                        Float prezzo;
                        String immagine;
                        if(prodotti != null){
                            for (Prodotto p : prodotti) {
                                Marca = p.getMarca();
                                immagine = p.getImmagine();
                                prezzo = p.getPrezzo();
                                Modello = p.getModello();
                                System.out.println(Marca + prezzo + Modello + immagine);
                    %>

                    <img src=<%=immagine%>   alt="Immagine_Prodotto" style="width:100%">
                    <h4><a href="prodotto.jsp" target="_self"><%=Marca + Modello%></a></h4>
                    <p class="price"><%=prezzo%></p>
                    <p><a href="Carrello.jsp" class="card button"> Aggiungi al carrello</a></p>  <!-- qui si deve fare il form per chiamare la servlet che aggiunge al carrello-->
                    <%

                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</form>
    <%@include file = "footer.jsp" %>
</body>
</html>
