<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
 
       
        
        session.setAttribute("idusera",zidusera);
}%>
<% Integer skora=(Integer)session.getAttribute("skorka");%>
     
        
        
<%@ page language ="java" import="java.sql.*" %> 
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head><link rel="stylesheet" type="text/css" href="JS/css/style.css"></head>
    <body>

    <center><table>

    <tbody>

    <center>
Zbyt wielu użytkowników w drużynie</center>
<center><a href="http://localhost:8080/MTGleague-web/TeamsSearch.jsp">Powrót</a></center>
</body>
</html>

