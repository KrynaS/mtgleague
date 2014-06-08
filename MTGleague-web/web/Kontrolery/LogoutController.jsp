<%if((String)session.getAttribute("login")==null){
        Integer zidusera=99999;
        session.setAttribute("idusera",zidusera);
}%>
<%-- 
    Document   : logout
    Created on : 2012-12-08, 14:18:47
    Author     : ML
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="JS/css/style.css">
        <title></title>
    </head>
    <body>
        <% 
        Integer reset=0;
        session.setAttribute("login","blank");
        session.setAttribute("idusera",99999);
        session.setAttribute("nrusera",99999);
        response.sendRedirect("/MTGleague-web/Login.jsp");


%>
        
    </body>
</html>
