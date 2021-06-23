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
    <link rel="stylesheet" href="../css1/RegistrazioneCss.css">
</head>
<body>

<form action="Yettodo" method="get">

    <div id="registrazione">
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome"><br>
        <label for="cognome">Cognome:</label><br>
        <input type="text" id="cognome" name="cognome"><br>
        <label for="p_elettronica">E-Mail:</label><br>
        <input type="text" id="p_elettronica" name="p_elettronica"><br>
        <label for="N_tel">Numero di Telefono:</label><br>
        <input type="number" id="N_tel" name="N_tel"><br>
        <label for="birthday">Birthday:</label><br>
        <input type="date" id="birthday" name="birthday"><br>

        <button type="submit" value="Registrati!"></button>

    </div>
    <!--<input type="submit" value="Registrati!"> -->

</form>
</body>
</html>
