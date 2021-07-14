<%@ page import="model.ProdottoDAO" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 27/06/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>${prodotto.getModello()}</title>
    <link rel="stylesheet" href="css1/style.css">
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
        .btn {
            padding: 10px 20px;
            background-color: #333;
            color: #f1f1f1;
            border-radius: 0;
            transition: .2s;
        }
        .btn:hover, .btn:focus {
            border: 1px solid #333;
            background-color: #fff;
            color: #000;
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
    </style>

</head>
<body style="background-image: url('images/FotoProdotti/FujifilmNstax.jpg');" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file = "header.jsp" %>
<%@ page import = "model.Prodotto" %>
<%@ page import = "java.util.List,java.util.ArrayList, model.Recensione, java.util.Random"%>

<section class="card"  style="padding-bottom:90px;">
    <div style="float:left; padding:20px " >
        <%@include file = "zoom.jsp" %>
    </div>
    <div class="capo">
        <h1>{product.getName()} <%@include file = "voto.jsp" %></h1>
        <br>
        <h3 class="price"><span>{product.getPricewithIva()} &#8364</span></h3>
        <p>La quantit&#224 disponibile in magazzino &#232 {product.getQty()}</p>
        <p>{product.getDescription()}</p>

      <!---  <form method = "post" action="ProductControl?id={product.code}&act=addC">-->
            <label  class="myLabel" >Quantit&#224 desiderata</label>
            <input id="inputN" type="number" name="qty" value = "1" min="1" max="{product.getQty()}">
            <br><button  type = "submit" class="button button2" >Acquista</button>
            <a href="Catalogo.jsp" class="button button2">Indietro</a>
      <!-- </form> -->
    </div><br>
</section>
<section>
    <%@include file = "recensione.jsp" %>
</section>




<%@include file = "footer.jsp" %>
</body>
</html>