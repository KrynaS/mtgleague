<%-- 
    Document   : PanelAdmina
    Created on : 2014-01-11, 15:01:51
    Author     : ML
--%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
       
        session.setAttribute("idusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
//if(admin==1){%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel Administracyjny</title>
        <link rel="stylesheet" href="JS/css/style.css" />
    </head>
    <body>
     <a href="http://localhost:8080/MTGleague-web/UsersAdminPanel.jsp">Użytkownicy</a></br>
     <a href="http://localhost:8080/MTGleague-web/TournamentAdminPanel.jsp">Turnieje</a></br>
     <a href="http://localhost:8080/MTGleague-web/TeamsAdminPanel.jsp">Drużyny</a></br>
     </br>
     <a href="http://localhost:8080/Sklep/logout.jsp">Wyloguj</a></br>
    </body>
</html>
<%//}%>