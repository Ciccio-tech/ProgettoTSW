<%@ page import="model.Dettagli_ordine" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Ordine2" %>
<%@ page import="model.Dettaglio_ordine2" %>
<%@ page import="model.prodottiCarrello" %><%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 19/07/2021
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Visualizza Ordine</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css1/stile.css" type = "text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>


        .container {
            padding: 60px 0;
        }
        @media (max-width: 600px) {
            .container {
                padding: 40px 40px;
            }
        }

        .row {margin: 0 -5px;}

        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        @media screen and (max-width: 600px) {
            .column {
                width: 100%;
                display: block;
                margin-bottom: 20px;
            }
        }

        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 16px;
            text-align: center;
            background-color: #f1f1f1;
        }


        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: lightseagreen;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
            border-radius: 12px;
        }

        .card button:hover {
            opacity: 0.7;
        }

    </style>
</head>
<%@include file = "header.jsp" %>
<div class="container">
    <div class="field2">
        <div class="row ">
            <div class="card x">
                <div>
                    <input type="date" class="ricerca"  name="da" placeholder="da data..." >
                    <input type="date" class="ricerca" name="a" placeholder="a data..." >
                    <button id = "selector" class="button button2">Cerca</button>

                </div>
                <div class="cart-list">
                    <h1 id = "title">Ordini effettuati</h1>
                    <%
                        List<Dettaglio_ordine2> lista= (List<Dettaglio_ordine2>) request.getAttribute("fatture");
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                    %>

                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th> <!--crea lo spazio-->
                            <th>Recenzione</th>
                            <th>Prodotto</th>
                            <th>Modello Prodotto</th>
                            <th>Prezzo</th>
                            <th>Quantità</th>
                        </tr>
                        </thead>
                        <tbody>

                        <!--n ordini esistenti nel database-->
                        <%
                            if (lista == null ? true : lista.size() == 0) {
                        %>
                        <tr>
                            <td colspan = "8" style ="text-align: center">Nessun ordine risulta essere stato effettuato</td>
                        </tr>
                        <%
                        } else {
                            for (Dettaglio_ordine2 det_ord : lista) {
                                int size = det_ord.size();
                                java.util.List<Ordine2> ordine = det_ord.getProdotti();
                        %>
                        <tr class="text-center">
                            <td rowspan="<%=size%> " class="product-name">
                                <p><%= format.format(det_ord.getData().getTime())%></p>
                                <a href="FatturaPDF?id=<%=det_ord.getCod()%>">	<button  class="button button2 submitter" type="submit">Fattura</button></a>
                            </td>
                            <%
                                for(Ordine2 o : ordine){
                                    prodottiCarrello bean = o.getProdotto();
                            %>
                            <td><a  class="button button2" href="ProductControl?id=<%=bean.getProdotto().getCodP()%>&act=view">Aggiungi</a></td>
                            <td><div id="img" style="background-image: url('<%=bean.getProdotto().getImmagine()%>');"></div></td>
                            <td><%=bean.getProdotto().getMarca()%></td>
                            <td><%=bean.getProdotto().getPrezzo()%></td>
                            <td><%=bean.getProdotto().getPrezzoConIva()%></td
                            <td><%=o.getQuantita()%></td>
                        </tr>
                        <%}
                        }
                        }%>
                        </tbody>
                    </table>

                    <p style = "text-align: center">pg <input class = "pageof" type = "number" value = "1" min="1" max="<%= request.getAttribute("maxPg") %>"> of <%= request.getAttribute("maxPg") %> <button id = "submit">Invia</button></p>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file = "footer.jsp" %>
</body>
</html>