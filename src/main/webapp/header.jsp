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
                <li><a href="#band">Chi siamo?</a></li>
                <li><a href="Catalogo.jsp">Prodotti</a></li>


                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Catalogo
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="Catalogo.jsp">Fotocamere</a></li>
                        <li><a href="Catalogo.jsp">Obiettivi fotografici</a></li>
                        <li><a href="Catalogo.jsp">Accessori</a></li>
                    </ul>
                </li>
                <% HttpSession Usersession= request.getSession();
                    if(Usersession.getAttribute("username")== null){
                %>
                <li><a href="Login.jsp">Login</a></li>
                <%
                }else{
                %>>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><%=Usersession.getAttribute("username")%>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="ProfiloPrivato.jsp">Area Personale</a></li>
                        <li><a href="">Visualizza Ordini</a></li>
                        <li><a href="">Logout</a></li>
                    </ul>
                </li>
                <%} %>
                <li><a href="Carrello.jsp"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
                <li><a href="ricerca.jsp"><span class="glyphicon glyphicon-search"></span></a></li>
            </ul>
        </div>
    </div>
</nav>




