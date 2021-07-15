<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 16/03/2021
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        input[type=email], input[type=password], input[type=date], input[type=text]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }
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
        .container {
        padding: 80px 120px;
        }
        @media (max-width: 600px) {
            .container {
                padding: 40px 40px;
            }
        }
        .button {
            background-color: lightseagreen; /* Green */
            border: none;
            color: white;
            padding: 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
        .button4 {border-radius: 12px;}
        .mylink:link, .mylink:visited {
            background-color: white;
            color: black;
            border: 2px solid lightseagreen;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        .mylink:hover, .mylink:active {
            background-color: lightseagreen;
            color: white;
        }

        .myimage {
            display: block;
            width: 100%;
            height: auto;
            border-radius: 50%;
        }
    </style>
</head>

<body>
<%@include file = "header.jsp" %>
<div id="contact" class="container">
    <br>
    <div class="row">
        <div class="col-md-4">
            <img src="images/img_avatar2.png" class="myimage">
        </div>
        <div class="col-md-6">
            <div class="registrazione">
                <form id = "val" action="RegistrazioneServlet" method="post">
                    <fieldset>
                        <h2> Registrazione  </h2>
                            <%
                            Boolean warning = (Boolean) request.getAttribute("warning");
                            if (warning != null && warning) {
                        %>
                        <div id="alert3" class="alert" style=""><span class="closebtn" onclick="this.parentElement.style.display='none';">×</span> <strong>Errore!</strong> Esite già un utente con questa email e username! Cambiare username ed email!</div>
                            <%}
                        %>
                        <p><input class="myInput1" id="username" type="text" size="30" name = "username" placeholder="username maggiore di 6 caratteri" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="pass" type="password" size="30" name = "pass" placeholder="Password tra i 8 e i 25 caratteri" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="comfermaPassword" type="password" size="30" name = "confermaPassword" placeholder="Conferma Password" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="nome" type="text" size="30" name = "nome" placeholder="Nome" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="cognome" type="text" size="30" name = "cognome" placeholder="Cogname" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="email" type="email" size="30" name = "email" placeholder="Email" autocomplete="off"><br></p>

                        <button class="button button4" type="submit" value="Registrati!"> Registrati</button>

                    </div>

                </form>
            </div>
        </div>
    </div>
</div>

<%@include file = "footer.jsp" %>


</body>
</html>
