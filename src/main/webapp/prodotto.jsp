<%@ page import="model.ProdottoDAO" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Prodotto</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
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
                <form action="Carrello" method="get">
                    <label  class="myLabel" for="qty" >Inserite la quantit&#224 che desiderate acquistare:</label>
                    <input id="qty" type="number" name="qty" value = "1" min="1" max="<%=quantita%>"><br>
                    <input type="hidden" name="codP" value=<%=codP%> >
                        <%
                    if(session.getAttribute("amministratore")==null){%>
                        <button class="button button2" style="width: 100%;">Aggiungi al carrello!</button>
                    <% } %>

                </form>
                        <a href="Categorie?categoria=0" class="button button2" style="width: 100%; ">Indietro</a>

            </div>
            <div style="margin: 30px;">
                <% if(recensione!= null){
                    for(Recensione r: recensione){
                        String commento= r.getCommento();
                        String nome = r.getUsername();
                %>
                <h4> Recensioni: </h4><p> <%=nome%> afferma:  <%=commento%></p>

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