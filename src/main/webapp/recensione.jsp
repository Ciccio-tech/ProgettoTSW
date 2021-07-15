<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List, model.Recensione, java.util.Random, model.Prodotto"%>
<%@ page import="model.Recensione" %>
<div class="Myvotazione card">
    <%
        List<Recensione> list =(List<Recensione>)  request.getAttribute("recenzioni");
        List<Recensione> listNew= new java.util.ArrayList<Recensione>();
        Boolean f=(Boolean) request.getAttribute("payed");
        int size = 0;


        if(request.getAttribute("userComment")!=null){

    %>
    <div class=commento>
        <h3>You</h3>
        <p>${userComment.description}</p>
    </div>

    <%} else if (f!= null ? f.booleanValue() : false) {%>
    <div id = "votazione">
        <%--@declare id="fname"--%><h3>Lascia la tua opinione </h3>
        <label  class="myLabel" for="fname">Inserisci un voto da 1 a 5</label>
        <input class="myInput1" id="voto"  type = "number" min = "1" max = "5">
        <label  class="myLabel" for="fname">Inserisci una recensione</label>
        <textarea class="myInput1" id="text" rows="4" cols="50" placeholder="Commenta..."></textarea>
        <button id = "send" class="button button2">Aggiungi</button><br>
        <div id= "alert4" class="alert"><span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> <strong>Errore!</strong> Errore durante l inserimento</div>

    </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#success4").hide();
            $("#alert4").hide();
            $("#send").click(function () {
                var text = "caio" ; /*$("#text").val() */
                var id = 1;  /* {product.code} */
                var voto = 10 ; /*$("#voto").val()*/
                if (voto > 0 && voto < 6) {
                    $.post("RecenzioneServlet", {act: "insert", id: id, comment: text, vote: voto})
                        .done(function(){
                            $("#votazione").empty();
                            $("#votazione").addClass ("commento");
                            $("#votazione").append ('<div class=commento><h3>You</h3><p>'+text+'</p></div>');
                        })
                        .fail(function() {
                            $("#alert4").slideDown();
                        });
                } else
                    $("#alert4").slideDown();
            });
        });
    </script>
    <%
        }
        if(list == null ? false : (size = list.size ()) != 0){

            if(size>5) {
                Random rand= new Random();
                int i=0;
                int j = 0;
                for(j = 0;j < 5; j++);
                {
                    i = rand.nextInt(size - j);
                    listNew.add(list.get(i));
                    list.remove(i);
                }
            }
            else
                listNew = list;
    %>
    <h3 style="margin-top: 5%;">Ecco cosa ne pensano i nostri clienti...</h3>
    <% for (Recensione e : listNew) {
    %>

    <div class=commento>
        <h3><%=e.getUsername() %></h3>
        <p><%=e.getCommento() %></p>
    </div>
    <%
        }
    } else {
    %>
    <h3 style="margin-top: 5%; text-align: center">Altri utenti non hanno ancora commentato</h3>
    <%
        }
    %>
</div>