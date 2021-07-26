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
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        input[type=text], input[type=password], input[type=number]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }
        input[type=hidden], input[type=submit]{
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
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



        .container1 {
            padding: 80px 120px;
            text-align: center;
        }
        @media (max-width: 600px) {
            .container1 {
                padding: 40px 40px;

            }
        }

        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: lightseagreen;
            color: white;
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

<div id="choice" class="container1" >
    <h2 style="position: center">Pannello di Controllo!</h2>
    <h3>Benvenuto, <%=username%>!</h3> <br>

    <button class="admin"  name="AggiuntaProdotto" onclick="revealFormProd()"> Aggiungi un Prodotto!</button> <br>
    <div id="addP" style="display: none">
        <form action="AdminProdotto" method="get">
            <label class="prodForm" for="cod">Codice Prodotto:</label>
            <input class="prodForm" type="number" id="cod" name="cod"><br><br>
            <label class="prodForm" for="tipo">Tipo:</label>
            <input class="prodForm" type="text" id="tipo" name="tipo"><br><br>
            <label class="prodForm" for="marca">Marca:</label>
            <input class="prodForm" type="text" id="marca" name="marca" ><br><br>
            <label class="prodForm" for="modello">Modello:</label>
            <input class="prodForm" type="text" id="modello" name="modello" ><br><br>
            <label class="prodForm" for="prezzo">Prezzo:</label>
            <input class="prodForm" type="number" id="prezzo" name="prezzo" ><br><br>
            <label class="prodForm" for="quantita">Quantità:</label>
            <input class="prodForm" type="number" id="quantita" name="quantita" ><br><br>
            <label class="prodForm" for="immagine">Immagine:</label>
            <input class="prodForm" type="text" id="immagine" name="immagine" ><br><br>
            <label class="prodForm" for="iva">Iva:</label>
            <input class="prodForm" type="number" id="iva" name="iva" ><br><br>
            <input class="prodForm" type="submit" value="Submit">
        </form>
    </div>

    <button class="admin" name="RimozioneProdotto" onclick="revealDeleteP()"> Rimuovi un prodotto!</button> <br>
    <div id="deleteProduct" style="display: none">
        <form action="AdminProdotto" method="get">
            <label class="codP" for="codP">Codice Prodotto:</label>
            <input type="number" id="codP" name="codP"><br><br>
            <input type="hidden" id="rimuovi" name="rimuovi" value="true">
            <input  type="submit" value="Submit">
        </form>
    </div>


    <form action="AdminUtenti" method="get"><button class="admin" name="Clienti"> Visualizza tutti i clienti!</button>  </form> <br>
    <div class="admin" id="allCliente">
            <table id="customers">
                <%
                    ArrayList<Cliente> clienti= (ArrayList<Cliente>) request.getAttribute("clienti");
                    if(clienti != null){
                %>
                <tr>
                    <th>Username</th>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Posta elettronica</th>
                </tr>
                <%
                        for(Cliente c: clienti){
                            String u= c.getUsername();
                            String nome= c.getNome();
                            String cognome= c.getCognome();
                            String email= c.getP_elettronica();
                %>
                <tr class="text-center" >
                    <td><%=u%></td>
                    <td><%=nome%></td>
                    <td><%=cognome%></td>
                    <td><%=email%></td>

                </tr>
                <%  }
                }
                %>
            </table>
    </div>

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
            <label class="codP" for="username">Username Admin:</label>
            <input type="text" id="u" name="username"><br><br>
            <input type="hidden" id="remove" name="rimuovi" value="true">
            <input  type="submit" value="Submit">
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
        }

        function revealDeleteP(){
            var x= document.getElementById("deleteProduct");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }

        function revealNewA(){
            var x= document.getElementById("addA");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }

        function revealDeleteA(){
            var x= document.getElementById("deleteA");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }


    </script>
</div>

<%@include file = "footer.jsp" %>
</body>
</html>
