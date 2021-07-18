<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 11/06/2021
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Cliente, model.Amministratore"%>
<% Boolean user= (Boolean)session.getAttribute("");
   if(user == null ? true : !user.booleanValue()) {
    response.sendRedirect(response.encodeURL("Login.jsp"));
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Profilo utente privato</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>
        input[type=text], input[type=password]{
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
        .button4 {
            border-radius: 12px;
        }

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

<%@include file = "header.jsp" %><br>
<body  data-spy="scroll" data-target=".navbar" data-offset="50">

<div class="field2 container">
    <div class="field2">

        <h3>Dati Personali </h3>
        <label  class="myLabel" ><i class="fa fa-user"></i> Nome</label>
        <input class="myInput1" type="text" id="name" name="firstname" value="${user.name}" placeholder="${user.name}" >
        <div id= "nameWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Nome non valido, deve essere costituito da soli caratteri e senza spazi bianchi</div>

        <label  class="myLabel" ><i class="fa fa-user"></i> Cognome</label>
        <input class="myInput1" type="text" id="surname" name="firstname" value="${user.cognome}" placeholder="${user.cognome}" >
        <div id= "surnameWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Cognome non valido, deve essere costituito da soli caratteri e senza spazi bianchi</div>

        <button id="but1" class=" button button2">Modifica</button>

        <div id= "success1" class="alert success" ><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Successo!</strong> Nome e/o Cognome aggiornati correttamente</div>
        <div id= "alert1" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Errore durante l aggiornamento</div>
        <hr>

        <h3>Credenziali</h3>
        <i class="fa fa-envelope"></i> Email: ${user.login}<br><br>
        <label  class="myLabel" ><i class="fa fa-lock"></i>Password</label>
        <input class="myInput1" type="text" id="vpass" name="firstname">
        <label  class="myLabel" ><i class="fa fa-lock"></i>Ripeti Password</label>
        <input class="myInput1" type="text" id="password" name="firstname">
        <div id= "passwordWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Password non valida, deve essere tra 8 e 25 caratteri</div>

        <button id="but2" class="but2 button button2">Modifica Password</button>
        <div id= "success2" class="alert success"> <!--<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Successo!</strong> Password aggiornata correttamente</div>-->
        <div id= "alert2" class="alert"> <!--<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> Errore durante l aggiornamento</div>-->
        <div id= "alert3" class="alert"> <!--<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> La password non corrisponde a quella digitata</div>-->
</div><br>
</div>

<%@include file = "footer.jsp" %>
<script type="text/javascript" src= "JavaScript/credenziali.js"></script>
<!--<script src = "JavaScript/validation.js"></script-->
<script src = "JavaScript/profilo.js"></script>>
</body>
</html>