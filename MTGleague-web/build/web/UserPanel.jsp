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
     <a href="/MTGleague-web/UserProfile.jsp">Profil</a></br>
     <a href="/MTGleague-web/TeamsSearch.jsp">Drużyny</a></br>
     <a href="/MTGleague-web/Tournaments.jsp">Turnieje</a></br>
     
     <a href="/MTGleague-web/YourTeams.jsp">Twoje Drużyny</a></br>
     <a href="/MTGleague-web/YourTournaments.jsp">Twoje Turnieje</a></br>
      <a href="/MTGleague-web/MyTournaments.jsp">Organizowane Turnieje</a></br>
      <%if(admin==1){
          %>
             <a href="AdminPanel.jsp">Panel Administracyjny</a></br>  
                   <%}%>
      
     </br>
     <a href="/MTGleague-web/Kontrolery/LogoutController.jsp">Wyloguj</a></br>
    </body>
</html>
<%}%>