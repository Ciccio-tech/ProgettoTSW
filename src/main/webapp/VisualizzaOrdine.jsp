<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %><%--
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
<body>
<%@include file = "header.jsp" %>

<%response.sendRedirect(response.encodeRedirectURL("VisualizzaOrdine"));%>
<div class="container">
    <div class="field2">
        <div class="row ">
            <div class="card x">
                <div>

                </div>
                <div class="cart-list">
                    <h1 id = "title">Ordini effettuati</h1>
                    <%
                        System.out.println("ordini effettuati");
                        ArrayList<Ordine> ordini = (ArrayList<Ordine>) request.getAttribute("ordini");
                        if(ordini != null)
                            System.out.println(ordini.get(0).getUsername());
                    %>

                    <table class="table">
                        <thead class="thead-primary">
                        <tr class="text-center">
                            <th>&nbsp;</th> <!--crea lo spazio-->
                            <th>Codice Ordine</th>
                            <th>Stato</th>
                            <th>Data Ordine</th>
                        </tr>
                        </thead>
                        <tbody>

                        <%
                            if (ordini == null) {
                        %>
                        <tr>
                            <td colspan = "8" style ="text-align: center">Nessun ordine risulta essere stato effettuato</td>
                        </tr>
                        <%
                        } else {
                        %>
                            <tr class="text-center">
                            <%
                                for(Ordine o: ordini){
                            %>
                                <td><%=o.getCodO()%></td>
                                <td><%=o.isStato()%></td>
                                <td><%=o.getData()%></td
                            </tr>
                        <%
                                }
                        }
                        %>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>
<%@include file = "footer.jsp" %>
</body>
</html>