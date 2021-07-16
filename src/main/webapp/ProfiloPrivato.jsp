<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 11/06/2021
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@page import="model.Cliente, model.Amministratore"%>
<% Boolean user= (Boolean)session.getAttribute("utente_registrato");
    if(user == null ? true : !user.booleanValue()) {
        response.sendRedirect(response.encodeURL("Login.jsp"));
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/stile.css" type = "text/css">
    <link rel="stylesheet" href="css/bootstrap.css" type = "text/css">
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Protected page</title>
</head>
<body  style="background-image: url('images/profilo.png');" data-spy="scroll" data-target=".navbar" data-offset="50">
<%@include file = "header.jsp" %><br>

<div class="field2">

    <h3>Dati Personali </h3>
    <label  class="myLabel" ><i class="fa fa-user"></i> Nome</label>
    <input class="myInput1" type="text" id="name" name="firstname" value="${user.nome}" placeholder="${user.nome}" readonly>

    <label  class="myLabel" ><i class="fa fa-user"></i> Cognome</label>
    <input class="myInput1" type="text" id="surname" name="firstname" value="${user.cognome}" placeholder="${user.cognome}" readonly>

    <hr>

    <h3>Credenziali</h3>
    <i class="fa fa-envelope"></i> Email: ${user.p_elettronica}<br><br>
    <label  class="myLabel" ><i class="fa fa-lock"></i>Password</label>
    <input class="myInput1" type="text" id="vpass" name="firstname">
    <label  class="myLabel" ><i class="fa fa-lock"></i>Ripeti Password</label>
    <input class="myInput1" type="text" id="password" name="firstname">
    <!-- <div id= "passwordWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Password non valida, deve essere tra 8 e 25 caratteri</div>-->

     <button id="but2" class="but2 button button2">Modifica Password</button>
    <!-- <div id= "success2" class="alert success"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Successo!</strong> Password aggiornata correttamente</div>
     <div id= "alert2" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> Errore durante l aggiornamento</div>
     <div id= "alert3" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> La password non corrisponde a quella digitata</div>-->
     <hr>
     <!-- <h3>Aggiungi nuovo indirizzo</h3>
     - <br> <button id="toggle" class="button button2">Aggiungi indirizzo</button><br>
      - <div id="AddIndirizzo"><br>
            <label  class="myLabel" for="adr"><i class="fa fa-address-card-o"></i> Indirizzo</label>
            <input class="myInput1" type="text"  id="adr" name="address" placeholder="via della repubblica">
            <div id= "AddressWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> L'indirizzo non può contenere numeri o caratteri speciali</div>

            <label  class="myLabel" for="adr"><i class="fa fa-address-card-o"></i> Numero civico</label>
            <input class="myInput1" type="number"  id="nc" name="nc" min="1" ><br>

            <label class="myLabel" for="city"><i class="fa fa-institution"></i> Città</label>
            <input class="myInput1" type="text"  id="city" name="city" placeholder="Roma">
            <div id= "cityWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> La città non può contenere spazi bianchi, numeri o caratteri speciali</div>

            <label  class="myLabel" for="city"><i class="fa fa-institution"></i> Provincia</label>
            <input class="myInput1" type="text"  id="provincia" name="provincia" placeholder="Roma">
            <div id= "provinciaWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> La provincia non può contenere spazi bianchi, numeri o caratteri speciali</div>

            <label  class="myLabel" for="adr"><i class="fa fa-address-card-o"></i> CAP</label>
            <input class="myInput1" type="text" id="CAP"  name="CAP" placeholder="80890">
            <div id= "capWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> Il CAP deve essere composto da 5 numeri</div>

            <label  class="myLabel" for="state">Stato</label>
            <input class="myInput1" type="text" id="state" name="state"  placeholder="Italia">
            <div id= "statoWarning" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> Lo stato non può contenere spazi bianchi, numeri o caratteri speciali</div>

            <button id="butt" class="button button2">Aggi</button>

             <div id= "successAddr" class="alert success"><span class="closebtn">&times;</span><strong>Successo!</strong> Indirizzo inserito correttamente</div>
            <div id= "alertAddr" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span><strong>Errore!</strong> Errore durante l inserimento</div>-->

    </div><br>
</div>

<%@include file = "footer.jsp" %>
<!--<script type="text/javascript" src= "JavaScript/credenziali.js"></script>
<script src = "JavaScript/validation.js"></script>
<script src = "JavaScript/profilo.js"></script>-->
</body>
</html>