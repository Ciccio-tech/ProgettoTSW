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
</head>
<body>
<h1> Registrazione:</h1>
<br/>

<form action="Yettodo" method="get">

    <label for="nome">First name:</label><br>
    <input type="text" id="nome" name="nome"><br>
    <label for="cognome">Last name:</label><br>
    <input type="text" id="cognome" name="cognome"><br>
    <label for="birthday">Birthday:</label><br>
    <input type="date" id="birthday" name="birthday"><br>
    <label for="citta">Città:</label><br>
    <input type="text" id="citta" name="citta"><br>
    <label for="provincia">Provincia:</label><br>
    <input type="text" id="provincia" name="provincia"><br>
    <label for="cod_post">Cod_Postale:</label><br>
    <input type="number" id="cod_post" name="cod_post"><br>
    <input type="radio" id="male" name="gender" value="male">
    <label for="male">Male</label><br>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">Female</label><br>
    <input type="radio" id="other" name="gender" value="other">
    <label for="other">Other</label><br>
    <label for="p_elettronica">Posta Elettronica:</label><br>
    <input type="text" id="p_elettronica" name="p_elettronica"><br>
    <label for="N_tel">Numero di Telefono:</label><br>
    <input type="number" id="N_tel" name="N_tel"><br>


    <input type="submit" value="Submit">

</form>
</body>
</html>
