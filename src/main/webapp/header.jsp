<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" style = "width: 65px" alt="logo" class="logo" ></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">Home</a></li>
                <li><a href="Categorie?categoria=0">Prodotti</a></li>


                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="">Catalogo
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Categorie?categoria=1">Fotocamere</a></li>
                        <li><a href="Categorie?categoria=2">Obiettivi fotografici</a></li>
                        <li><a href="Categorie?categoria=3">Accessori</a></li>
                    </ul>
                </li>
                <% HttpSession Usersession= request.getSession();
                    if(Usersession.getAttribute("username")== null){
                %>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="Carrello.jsp"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
                <%
                    }else{
                %>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=Usersession.getAttribute("username")%>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <% if(session.getAttribute("amministratore")==null){%>
                            <li><a href="ProfiloPrivato.jsp">Area Personale</a></li>
                            <li><a href="VisualizzaOrdine.jsp">Visualizza Ordini</a></li>
                        <% } else {  %>
                            <li><a href="admin.jsp">Pannello Controllo</a> </li>
                        <% } %>
                        <li><form action="Logout" method="get"> <button style="background-color: lightseagreen;border: none;color: white;width: 98%;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;" name="logout"> Logout </button> </form></li>
                    </ul>
                </li>
                <% if(session.getAttribute("amministratore")==null){%>
                <li><a href="Carrello.jsp"><span class="glyphicon glyphicon-shopping-cart"></span></a></li><% } %><%} %>

                <li><form class="navbar-form navbar-left" action="Ricerca">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" name="ricerca">
                        <button type="submit" class="form-control lente"  > Cerca</button>
                    </div>
                </form></li>

            </ul>
        </div>
    </div>
</nav>




