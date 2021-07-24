<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 24/07/2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EsitoOrdine</title>
</head>
<body>
    <% String username= (String) session.getAttribute("username"); %>

    <h1>Ciao <%=username%></h1>
    <%
        String e = (String) session.getAttribute("esito");
        System.out.println(e);
        boolean esito = Boolean.parseBoolean(e);
        System.out.println(esito);
        if(esito){
    %>
        <h1 style="text-align: center">Conferma Ordine: </h1>
        <h2 style="text-align: center">Ordine andato a buon fine!</h2>
    <%
        }else{
    %>
    <h1 style="text-align: center">Esito Ordine: </h1>
    <h2 style="text-align: center">L'Ordine NON è andato a buon fine... Riprova: <a href="Carrello.jsp" style="text-decoration: none"></a> </h2>
    <%
        }
    %>


</body>
</html>
