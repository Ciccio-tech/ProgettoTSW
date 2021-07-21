<%--
  Created by IntelliJ IDEA.
  User: franc
  Date: 21/07/2021
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <%
        String username= (String) session.getAttribute("username");
    %>

    Benvenuto! <%=username%>

</body>
</html>
