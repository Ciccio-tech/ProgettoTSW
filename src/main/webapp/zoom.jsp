<%--
  Created by IntelliJ IDEA.
  User: damia
  Date: 14/07/2021
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8" %>

<div class="img-magnifier-container">
    <img id="image" src="images/FotoProdotti/NikonG35.jpg">  <!--{product.photo}-->
</div>

<script type = "text/javascript" src = "JavaScript/magnifier.js"></script>
<script>magnify('myimage', 3);</script>