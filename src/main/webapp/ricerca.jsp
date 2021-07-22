<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 14/07/2021
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<form class="navbar-form navbar-left" action="${pageContext.request.contextPath}/Carrello">
    <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <button type="submit" class="form-control lente" > Cerca</button>
        <p>Ecco cosa abbiamo trovato in base alla tua ricerca:</p>
        <% ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) request.getAttribute("prodotti");
           if(prodotti!= null){
               for(Prodotto p: prodotti){
                   String Marca= p.getMarca();
                   String Modello= p.getModello();
                   String Tipo= p.getTipo();
                   Float prezzo= p.getPrezzo();
                   String immagine= p.getImmagine();
                   int quantita = p.getQuantita();
                   int codP= p.getCodP();
        %>

        <img src=<%=immagine%> alt=<%=Modello%> >
        <h3> <%= Marca + " " + Modello %></h3>
        <hr style="border:3px solid #f1f1f1"><br>
        <h4 class="price"><span>Iva: 22%</span></h4>
        <p>La quantit&#224 disponibile in magazzino è: <%=quantita%></p>
        <p>Prezzo: $<%=prezzo%></p>
        <label  class="myLabel" for="qty" >Inserite la quantit&#224 che desiderate acquistare:</label>
        <input id="qty" type="number" name="qty" value = "1" min="1" max="<%=quantita%>"><br>
        <form action="Ricerca" method="get"> <button class="button button2" name="<%=codP%>" style="width: 100%;">Aggiungi al carrello!</button> </form>
        <a href="Catalogo.jsp" class="button button2" style="width: 100%; ">Indietro</a>

        <%
               }
           } %>
    </div>
</form>
