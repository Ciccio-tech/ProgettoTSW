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
    <link rel="stylesheet" href="css1/LoginCss.css">
</head>
<body>
<h3>Welcome!</h3>
    <div class="login">
        <form id = "val" action="LoginServlet" method="post">
            <fieldset>
                <h1> Account  </h1>
                <%
                    Boolean warning = (Boolean) request.getAttribute("warning");
                    if (warning == null ? false : warning) {
                %>
                <div id="alert3" class="alert" style=""><span class="closebtn" onclick="this.parentElement.style.display='none';">×</span> <strong>Errore!</strong> Nome utente o password non corretti</div>
                <%}
                %>
                <h2>Accedi</h2>
                <p><input class="myInput1" id="username" type="email" size="30" name = "username" placeholder="Email" autocomplete="off"><br></p>
                <p><input class="myInput1" id="password" type="password" size="30" name = "password" placeholder="Password tra i 8 e i 25 caratteri" autocomplete="off"><br></p>
                <button class="button button2" type = "submit" >Accedi</button>
                <button class="button button2" type = "reset">Reset</button><br><br>
                Non sei ancora registrato? &nbsp &nbsp<a href= "Registrazione.jsp"> Registrati ora</a>
            </fieldset>
        </form>
    </div>
</body>
</html>
