<%@ page import="model.ProdottoDAO" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Prodotto</title>
    <link rel="stylesheet" href="css1/style.css" type = "text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        input[type=text], input[type=number]{
            width: 100%;
            border: 2px solid lightseagreen;
            border-radius: 4px;
            padding: 12px 20px;
            margin: 8px 0;
        }
        .navbar-nav>li>a {
            padding-top: 25px;
            padding-bottom: 15px;
        }
        .btn {
            padding: 10px 20px;
            background-color: #333;
            color: #f1f1f1;
            border-radius: 0;
            transition: .2s;
        }
        .btn:hover, .btn:focus {
            border: 1px solid #333;
            background-color: #fff;
            color: #000;
        }
        .navbar-toggle {
            margin-top: 18px;
        }
        .navbar-brand {
            float: left;
            height: 70px;
            padding: 7px 7px;
            font-size: 20px;
            line-height: 20px;
        }
        .navbar {
            font-family: Montserrat, sans-serif;
            margin-bottom: 0;
            background-color: #2d2d30;
            border: 0;
            font-size: 11px !important;
            letter-spacing: 4px;
            opacity: 0.9;
        }
        .nav-tabs li a {
            color: #777;
        }
        .navbar li a, .navbar .navbar-brand {
            color: #d5d5d5 !important;
        }
        .navbar-nav li a:hover {
            color: #fff !important;
        }

        .navbar-nav li.active a {
            color: #fff !important;
            background-color: #29292c !important;
        }
        .navbar-default .navbar-toggle {
            border-color: transparent;
        }
        .open .dropdown-toggle {
            color: #fff;
            background-color: #555 !important;
        }
        .dropdown-menu li a {
            color: #000 !important;
        }
        .dropdown-menu li a:hover {
          background-color: lightseagreen !important;
        }
        footer {
            background-color: #2d2d30;
            color: #f5f5f5;
            padding: 32px;
        }
        footer a {
          color: #f5f5f5;
        }
        footer a:hover {
            color: #777;
            text-decoration: none;
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

        .button2 {
            border-radius: 12px;
        }

        .container {
            padding: 70px 0;
            margin-top: 10px;
        }
        @media (max-width: 600px) {
            .container {
                padding: 40px 40px;

            }

        }
        @media (max-width: 800px) {
            .row {
                flex-direction: column-reverse;
            }
        }
        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            margin: 0 -16px;
        }

        .col-50 {
            -ms-flex: 50%; /* IE10 */
            flex: 50%;
        }


        .col-50{
            padding: 0 16px;
        }

    </style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
    <%@include file = "header.jsp" %>
    <%@ page import = "model.Prodotto" %>
    <%@ page import = "java.util.ArrayList, model.Recensione"%>

    <%

        Prodotto prodotto= (Prodotto) request.getAttribute("Prodotto");
        if(prodotto!= null){
            String Marca= prodotto.getMarca();
            String Modello= prodotto.getModello();
            String Tipo= prodotto.getTipo();
            Float prezzo= prodotto.getPrezzo();
            String immagine= prodotto.getImmagine();
            int quantita = prodotto.getQuantita();
            int codP= prodotto.getCodP();
            ArrayList<Recensione> recensione= prodotto.getRecensione();

    %>
    <section class="card"  style="padding-bottom:60px;">
        <div class="container row" >
            <div class="col-50" style="float:left; padding:20px " >
                    <div class="img-magnifier-container">
                        <img id="image" src=<%=immagine%> >  <!--{product.photo}-->
                    </div>
                    <script type = "text/javascript" src = "JavaScript/magnifier.js"></script>
                    <script>magnify('image', 3);</script>
            </div>
            <div class="col-50" class="capo">
                <h3> <%= Marca + " " + Modello %></h3>
                <hr style="border:3px solid #f1f1f1"><br>
                <h4 class="price"><span>Iva: 22%</span></h4>
                <p>La quantit&#224 disponibile in magazzino è: <%=quantita%></p>
                <p>Prezzo: $<%=prezzo%></p>
                    <label  class="myLabel" for="qty" >Inserite la quantit&#224 che desiderate acquistare:</label>
                    <input id="qty" type="number" name="qty" value = "1" min="1" max="<%=quantita%>"><br>
                    <form action="Carrello" method="get"> <button class="button button2" name="<%=codP%>" style="width: 100%;">Aggiungi al carrello!</button> </form>
                        <a href="Catalogo.jsp" class="button button2" style="width: 100%; ">Indietro</a>

                    </form>
            </div>
            <div >
                <% if(recensione!= null){
                    for(Recensione r: recensione){
                        String commento= r.getCommento();
                        int voto= r.getVoto();
                        String nome = r.getUsername();
                %>
                <h4> Recensioni: </h4><p> <%=nome%>></p><p> <%=voto%></p><p> <%=commento%></p>

                <%}

                }
                else{ %>
                <p>Non ci sono recensioni per questo prodotto...</p>
                <% } %>

                <% } %>
            </div>
        </div>
    </section>

    <!--   <section>
     %@ < include file = "recensione.jsp" %>
    </section>-->
    <%@include file = "footer.jsp" %>
</body>
</html>