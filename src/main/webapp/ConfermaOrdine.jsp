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
<%@include file = "header.jsp" %>
<div class="field2">
    <% String username= (String) session.getAttribute("username"); %>
    <h1>Ciao <%=username%>...</h1>
    <h1> Grazie per aver acquistato da noi... </h1>
    <h2>Grazie per aver acquistato i nostri prodotti, progettato e prodotto secondo
        standard elevati per conferire prestazioni di alta qualit&agrave. Se il prodotto si rivela difettoso, Reflex Your World ne dispone la riparazione,
        la sostituzione, il rimborso o la fornitura delle relative parti di ricambio in base ai termini della garanzia in vigore nel Paese
        in cui &egrave stato acquistato.	La garanzia ha inizio il giorno in cui viene acquistato il prodotto presso un rivenditore
        autorizzato e termina dopo due anni. Se si verificano difetti dovuti a imperfezioni dei materiali
        o della fabbricazione durante questo periodo di garanzia, Reflex Your World disporr&agrave la riparazione o la
        sostituzione del prodotto a proprie spese. In caso di sostituzione del prodotto, la data di inizio
        della garanzia resta la data di acquisto del prodotto originale</h2>
    <a class="button button2" href= "index.jsp"> Home</a>
</div>

<%@include file = "footer.jsp" %>
</body>
</html>
