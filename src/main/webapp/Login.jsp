<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 04/06/2021
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        input[type=text], input[type=password]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
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
<body>
<%@include file = "header.jsp" %>
<div id="contact" class="container">
<br>
    <div class="row">
        <div class="col-md-4">
              <img src="images/img_avatar2.png" class="myimage">
        </div>
        <div class="col-md-6">
            <div class="login">
                <form id = "val" action="LoginServlet" method="post">
                    <fieldset>
                        <h2> Account  </h2>
                        <%
                            Boolean warning = (Boolean) request.getAttribute("warning");
                            if (warning == null ? false : warning) {
                        %>
                        <div id="alert3" class="alert" style=""><span class="closebtn" onclick="this.parentElement.style.display='none';">×</span> <strong>Errore!</strong> Nome utente o password non corretti</div>
                        <%}
                        %>
                        <p><input class="myInput1" id="username" type="text" size="30" name = "username" placeholder="Username" autocomplete="off"><br></p>
                        <p><input class="myInput1" id="pass" type="password" size="30" name = "pass" placeholder="Password tra i 8 e i 25 caratteri" autocomplete="off"><br></p>
                        <button class="button button4" type = "submit" >Accedi</button>
                        <button class="button button4" type = "reset">Cancella</button><br><br>
                        Non sei ancora registrato? &nbsp &nbsp<a class="mylink" href= "Registrazione.jsp"> Registrati ora</a>
                    </fieldset>
                </form>
            </div>
        </div>
        </div>
</div>

<%@include file = "footer.jsp" %>

</body>
</html>
