<%@ page import="model.Prodotto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.ProdottoDAO" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 20/07/2021
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fotocamere</title>
</head>
<body>
<%@include file = "header.jsp" %>

<% response.sendRedirect("Categorie");%>


<%

    ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("products");


    //ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("products");
    String Marca, Modello;
    Float prezzo;
    String immagine;
    int codP;
    if(prodotti != null){
        for (Prodotto p : prodotti) {
                codP = p.getCodP();
                Marca = p.getMarca();
                immagine = p.getImmagine();
                prezzo = p.getPrezzo();
                Modello = p.getModello();
%>

<img src=<%=immagine%>  alt="Immagine_Prodotto">
<h3><%=Marca + Modello%></h3>
<p class="price">$<%=prezzo%></p>
<p> <form action="Carrello" method="get"> <button id="carrello">Aggiungi al Carrello</button> </form>
<p> <form action="ProdottoServlet" method="get"><button id="prodotto" name="<%=codP%>">Visualizza Prodotto</button> </form>

<%
            }
    }
%>


<!-- </form> -->
<%@include file = "footer.jsp" %>
</body>
</html>
