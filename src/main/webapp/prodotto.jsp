<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 27/06/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Prodotto</title>
</head>
<body>
<!-- DA CORREGGERE E COMPLETARE-->
    <div>
        <img src="${prodotto.immagine}">
        <h3>${prodotto.nome}</h3>
        <p>${prodotto.descrizione}</p>
    </div>

    <div id="ammin">
        <c: if test="${amministratore}">
            <form action="AdminProdotto" method="post">
                <input type="submit" value="Modifica">
                <input type="submit" value="Rimuovi>
            </form>
        </c:>
    </div>


</body>
</html>