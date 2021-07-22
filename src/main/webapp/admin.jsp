<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Cliente" %><%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 21/07/2021
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
    body {
    font: 400 15px/1.8 Lato, sans-serif;
    color: #777;
    }
    h3, h4 {
    margin: 10px 0 30px 0;
    letter-spacing: 10px;
    font-size: 20px;
    color: #111;
    }
    .container {
    padding: 80px 120px;
    }
    .person {
    border: 10px solid transparent;
    margin-bottom: 25px;
    width: 80%;
    height: 80%;
    opacity: 0.7;
    }
    .person:hover {
    border-color: #f1f1f1;
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
    .navbar-nav>li>a {
    padding-top: 25px;
    padding-bottom: 15px;
    }
    .carousel-inner img {
    /* -webkit-filter: grayscale(90%);
    filter: grayscale(90%);  make all photos black and white */
    width: 100%; /* Set width to 100% */
    margin: auto;
    }
    .carousel-caption h3 {
    color: #fff !important;
    }
    @media (max-width: 600px) {
    .carousel-caption {
    display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
    }
    .bg-1 {
    background: #2d2d30;
    color: #bdbdbd;
    }
    .bg-1 h3 {color: #fff;}
    .bg-1 p {font-style: italic;}
    .list-group-item:first-child {
    border-top-right-radius: 0;
    border-top-left-radius: 0;
    }
    .list-group-item:last-child {
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
    }
    .thumbnail {
    padding: 0 0 15px 0;
    border: none;
    border-radius: 0;
    }
    .thumbnail p {
    margin-top: 15px;
    color: #555;
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
    .modal-header, h4, .close {
    background-color: #333;
    color: #fff !important;
    text-align: center;
    font-size: 30px;
    }
    .modal-header, .modal-body {
    padding: 40px 50px;
    }
    .nav-tabs li a {
    color: #777;
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
    .form-control {
    border-radius: 0;
    }
    textarea {
    resize: none;
    }

    button.admin{
        border: none;
        outline: 0;
        padding: 12px;
        margin: 10px;
        color: white;
        background-color: lightseagreen;
        text-align: center;
        cursor: pointer;
        width: 25%;
        font-size: 18px;
    }

    /*
    label.prodForm{
        display: none;
    }

    input.prodForm{
        display: none;
    }
    */
    ul.c{
        padding: 20px;
        margin: 15px;
        box-shadow: #2d2d30;
    }



</style>
</head>
<body>
<%@include file = "header.jsp" %>

<br>
<br>
<br>
<br>
<br>

    <%
        String username= (String) session.getAttribute("username");
    %>
<div id="choice">
    <h3>Benvenuto! <%=username%> </h3> <br>

        <button class="admin"  name="AggiuntaProdotto" onclick="revealFormProd()"> Aggiungi un Prodotto!</button> <br>
        <div id="addP" style="display: none">
            <form action="AdminProdotto" method="get">
                <label class="prodForm" for="cod">Codice Prodotto:</label>
                <input class="prodForm" type="text" id="cod" name="cod"><br><br>
                <label class="prodForm" for="tipo">Tipo:</label>
                <input class="prodForm" type="text" id="tipo" name="tipo"><br><br>
                <label class="prodForm" for="marca">Marca:</label>
                <input class="prodForm" type="text" id="marca" name="marca" ><br><br>
                <label class="prodForm" for="modello">Modello:</label>
                <input class="prodForm" type="text" id="modello" name="modello" ><br><br>
                <label class="prodForm" for="prezzo">Prezzo:</label>
                <input class="prodForm" type="text" id="prezzo" name="prezzo" ><br><br>
                <label class="prodForm" for="quantita">Quantità:</label>
                <input class="prodForm" type="text" id="quantita" name="quantita" ><br><br>
                <label class="prodForm" for="immagine">Immagine:</label>
                <input class="prodForm" type="text" id="immagine" name="immagine" ><br><br>
                <label class="prodForm" for="iva">Iva:</label>
                <input class="prodForm" type="text" id="iva" name="iva" ><br><br>
                <input class="prodForm" type="submit" value="Submit">
             </form>
        </div>
        <button class="admin" name="RimozioneProdotto" onclick="revealDeleteP()"> Rimuovi un prodotto!</button> <br>
        <div id="deleteProduct" style="display: none">
            <form action="AdminProdotto" method="get">
            <label class="codP" for="codP">Codice Prodotto:</label>
            <input type="text" id="codP" name="codP"><br><br>
                <%request.setAttribute("rimuovi",true);%>
            <input  type="submit" value="Submit">
            </form>
        </div>


        <form action="AdminUtenti" method="get"> <button class="admin" name="Clienti" > Visualizza tutti i clienti!</button> </form> <br>
            <%
                ArrayList<Cliente> clienti= (ArrayList<Cliente>) request.getAttribute("clienti");
                if(clienti != null){
                for(Cliente c: clienti){
                    String u= c.getUsername();
                    String nome= c.getNome();
                    String cognome= c.getCognome();
                    String email= c.getP_elettronica();
            %>
            <div class="clienti" id="c">
                <ul class="c">
                    <li><%=u%></li>
                    <li><%=nome%></li>
                    <li><%=cognome%></li>
                    <li><%=email%></li>
                </ul>
            </div>

            <%  }
                }
            %>

    <button class="admin" name="AggiuntaAmministratore" onclick="revealNewA()">Aggiungi un Amministratore!</button> <br>
    <div id="addA" style="display: none">
        <form action="AdminServlet" method="get">
            <label class="prodForm" for="username">Username:</label>
            <input class="prodForm" type="text" id="username" name="username"><br><br>
            <label class="prodForm" for="pass">Password:</label>
            <input class="prodForm" type="text" id="pass" name="pass" ><br><br>
            <label class="prodForm" for="nome">Nome:</label>
            <input class="prodForm" type="text" id="nome" name="nome" ><br><br>
            <label class="prodForm" for="cognome">Cognome:</label>
            <input class="prodForm" type="text" id="cognome" name="cognome" ><br><br>
            <input class="prodForm" type="submit" value="Submit">
        </form>
    </div>
    <button class="admin" name="RimozioneAmministratore" id="removeAdmin" onclick="revealDeleteA()">Rimuovi un Amministratore!</button>
    <div id="deleteA" style="display: none">
        <form action="AdminServlet" method="get">
            <label class="codP" for="userA">Username Admin:</label>
            <input type="text" id="userA" name="userA"><br><br>
            <input  type="submit" value="Submit">
            <%request.setAttribute("rimuovi",true);%>
        </form>
    </div>

        <script>
            function revealFormProd(){
                var x= document.getElementById("addP");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
                //$("prodForm").css("display, inline");
            }

            function revealDeleteP(){
                var x= document.getElementById("deleteProduct");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
                //$("prodForm").css("display, inline");
            }

            function revealNewA(){
                var x= document.getElementById("addA");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
                //$("prodForm").css("display, inline");
            }

            function revealDeleteA(){
                var x= document.getElementById("deleteA");
                if (x.style.display === "none") {
                    x.style.display = "block";
                } else {
                    x.style.display = "none";
                }
                //$("prodForm").css("display, inline");
            }

        </script>
</div>

<%@include file = "footer.jsp" %>
</body>
</html>
