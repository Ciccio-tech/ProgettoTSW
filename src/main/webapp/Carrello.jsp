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
    <style>
        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
        }

        .col-25 {
            -ms-flex: 25%; /* IE10 */
            flex: 25%;
        }

        .col-50 {
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
        }

        .col-75 {
            -ms-flex: 75%; /* IE10 */
            flex: 75%;
        }

        .col-25,
        .col-50,
        .col-75 {
            padding: 0 16px;
        }

        .container2 {
            background-color: #f2f2f2;
            padding: 5px 20px 15px 20px;
            border: 1px solid lightgrey;
            border-radius: 3px;
        }

        input[type=email], input[type=password], input[type=date], input[type=text]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }

        label {
            margin-bottom: 10px;
            display: block;
        }

        .icon-container {
            margin-bottom: 20px;
            padding: 7px 0;
            font-size: 24px;
        }


        a {
            color: #2196F3;
        }

        hr {
            border: 1px solid lightgrey;
        }

        span.price {
            float: right;
            color: grey;
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
        .button4 {border-radius: 12px;}
        @media (max-width: 800px) {
            .row {
                flex-direction: column-reverse;
            }
            .col-25 {
                margin-bottom: 20px;
            }
        }
        .container1 {
            padding: 30px 20px;
        }
        @media (max-width: 600px) {
            .container1 {
                padding: 40px 40px;
            }
        }

        table {
            margin-bottom: 20px;
            margin-top: 100px;
            margin-left: 20px;
            border-collapse: collapse;
            width: 97%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}
        div #img {
            width: 80px;
            height:80px;
            background-repeat: no-repeat;
            background-size: contain;
            border-radius:50%;
        }
        .button3 {background-color: #f44336;} /* Red */
        .button2 {
            border: none;
            color: white;
            padding: 15px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius:50%;
        }

    </style>
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


<div class="row container1">
    <div class="col-75">
        <div class="container2">
            <form action="Ordine" method="get">

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
                        <!-- name, email, adr, city, prov, cap,  -->
                        <h3>Billing Address</h3>
                        <label for="name"><i class="fa fa-user"></i> </label>
                        <input type="text" id="name" name="name" placeholder="John M. Doe" >
                        <label for="email"><i class="fa fa-envelope"></i> Email</label>
                        <input type="text" id="email" name="email" placeholder="john@example.com">

                        <label for="adr"><i class="fa fa-address-card-o"></i> Indirizzo</label>
                        <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                        <label for="city"><i class="fa fa-institution"></i> Città </label>
                        <input type="text" id="city" name="city" placeholder="New York">
                        <label for="prov">Provincia</label>
                        <input type="text" id="prov" name="prov" placeholder="SA">
                        <label for="cap">Cap</label>
                        <input type="text" id="cap" name="cap" placeholder="84049">
                        <label for="state">Nazione</label>
                        <input type="text" id="state" name="state" placeholder="NY">

                        </div>
                    </div>

                    <div class="col-50">
                        <h3>Payment</h3>
                        <label for="card">Accepted Cards</label>
                        <input type="text" id="card" name="card">
                        <div class="icon-container">
                            <i class="fa fa-cc-visa" style="color:navy;"></i>
                            <i class="fa fa-cc-amex" style="color:blue;"></i>
                            <i class="fa fa-cc-mastercard" style="color:red;"></i>
                            <i class="fa fa-cc-discover" style="color:orange;"></i>
                        </div>

                    </div>


                <label>
                    <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                </label>

                <input type="submit" value="Acquista" class="button button4" style="width: 100%">

    <%  session.setAttribute("carrello", carrello);%>

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
