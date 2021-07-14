<%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 14/07/2021
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<div class="img-magnifier-container">
    <img id="myimage" src="${product.photo}">
</div>

<script type = "text/javascript" src = "js/magnifier.js"></script>
<script>magnify('myimage', 3);</script>