<%@ page import="model.*" %><%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 12/07/2021
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrello</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<%@include file = "header.jsp" %>


    <div style="overflow-x:auto;">
        <table>
            <tr>
                <th>Rimuovi Prodotto</th>
                <th>Immagine Prodotto</th>
                <th>Nome prodotto</th>
                <th>Prezzo</th>
                <th>IVA</th>
                <th>Quantità</th>
                <th>Tatale prezzo</th> <%
                Carrello carrello= (Carrello) session.getAttribute("carrello");
                if(carrello != null){
                    for(prodottiCarrello p: carrello.getP_carrello()){
                        Prodotto prodotto= p.getProdotto();
                        int q= p.getQuantita();
                        if(prodotto!= null && q!=0){
                            String Nome= prodotto.getModello();
                            String immagine= prodotto.getImmagine();
                            float prezzo = prodotto.getPrezzo();
                            double prezzo_t = p.totale();
                            int id= prodotto.getCodP();

            %>

            </tr>



                <tr class="text-center">
                <td class="product-remove"><form action="RimuoviProdotto" method="get"><button class="removeX button2 button3" id="deleteButton" name="<%=id%>"><span class="glyphicon glyphicon-trash" style="color: white"></span></button></form>
                <td class="image-prod"><div id="img" style="background-image: url(<%=immagine%>);"></div> </td>
                <td class="product-name"><%=Nome%></td>
                <td><%=prezzo%></td>
                <td>22&#37;</td>
                <td class="quantity"><div class="input-group mb-3"><input type="number" name="quantity" class="quantity form-control input-number" value="<%=q%>" min="1" max="100"></div></td> <!-- in value dobbiamo portare la quantita dell'ordine -->
                <td class="total"><%=prezzo_t%></td>
          </tr> <%
                    }
                }

            }
        %>
        </table>


    </div>


<div class="row container3">
    <div class="col-75">
        <div class="container2">
            <form action="Carrello">

                <div class="row">
                    <div class="col-50">
                        <% HttpSession Usersession1= request.getSession();
                            if(Usersession1.getAttribute("username")== null){
                        %>
                        <li><a href="Login.jsp">Login</a></li>
                        <%
                        }else{
                            Cliente cliente= new Cliente();
                            cliente.setUsername((String) Usersession1.getAttribute("username"));
                        %>
                        <h3>Billing Address</h3>
                        <label for="fname"><i class="fa fa-user"></i> </label>
                        <input type="text" id="fname" name="firstname" placeholder="John M. Doe" readonly>
                        <label for="email"><i class="fa fa-envelope"></i> Email</label>
                        <input type="text" id="email" name="email" placeholder="john@example.com" readonly>

                        <label for="adr"><i class="fa fa-address-card-o"></i> Indirizzo</label>
                        <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                        <label for="city"><i class="fa fa-institution"></i> Città </label>
                        <input type="text" id="city" name="city" placeholder="New York">

                        <div class="row">
                            <div class="col-50">
                                <label for="prov">Provincia</label>
                                <input type="text" id="prov" name="prov" placeholder="SA">
                           </div>

                            <div class="col-50">
                                <label for="cap">Cap</label>
                                <input type="text" id="cap" name="cap" placeholder="84049">
                            </div>

                            <div class="col-50">
                                <label for="state">Nazione</label>
                                <input type="text" id="state" name="state" placeholder="NY">
                            </div>
                        </div>
                    </div>

                    <div class="col-50">
                        <h3>Payment</h3>
                        <label for="fname">Accepted Cards</label>
                        <div class="icon-container">
                            <i class="fa fa-cc-visa" style="color:navy;"></i>
                            <i class="fa fa-cc-amex" style="color:blue;"></i>
                            <i class="fa fa-cc-mastercard" style="color:red;"></i>
                            <i class="fa fa-cc-discover" style="color:orange;"></i>
                        </div>

                    </div>

                </div>
                <label>
                    <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                </label>

                <input type="submit" value="Acquista" class="button1 button4" style="width: 100%">

                <%}%>
            </form>
        </div>
    </div>
    <div class="col-25">
        <div class="container2">
            <% assert carrello != null;%>
            <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b><%=carrello.getP_carrello().size()%></b></span></h4>
            <%
                double totale=0.0;
                for(prodottiCarrello p: carrello.getP_carrello()){
                    Prodotto prodotto= p.getProdotto();
            %>
            <p><a href="#"><%=prodotto.getModello()%></a> <span class="price"><%=p.totale()%></span></p>
            <%
                totale+=p.totale();
                }%>
            <hr>
            <p>Total <span class="price" style="color:black"><b><%=totale%></b></span></p>
        </div>
    </div>
</div>

<%@include file = "footer.jsp" %>
</body>
</html>
