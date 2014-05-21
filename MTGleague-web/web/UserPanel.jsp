<%-- 
    Document   : PanelAdmina
    Created on : 2014-01-11, 15:01:51
    Author     : ML
--%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel Użytkownika</title>
        <link rel="stylesheet" href="JS/css/style.css" />
    </head>
    <body>
     <a href="http://localhost:8080/MTGleague-web/UserProfile.jsp">Profil</a></br>
     <a href="http://localhost:8080/MTGleague-web/UsersAdminPanel.jsp1">Drużyny</a></br>
     <a href="http://localhost:8080/MTGleague-web/TournamentAdminPanel.jsp1">Turnieje</a></br>
     
     <a href="http://localhost:8080/MTGleague-web/YourTeams.jsp">Twoje Drużyny</a></br>
     <a href="http://localhost:8080/MTGleague-web/TeamsAdminPanel1.jsp">Twoje Turnieje</a></br>
     </br>
     <a href="http://localhost:8080/MTGleague-web/Kontrolery/LogoutController.jsp">Wyloguj</a></br>
    </body>
</html>
<%}%>