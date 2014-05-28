<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>     
<%@ page language ="java" import="java.sql.*" %> 
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head><link rel="stylesheet" type="text/css" href="JS/css/style.css"></head>
    <body>
<form method="post" ACTION="/MTGleague-web/TeamsFound.jsp">
    <center><table>
    <thead></thead>
    <tbody>
<tr>
<td>Szukaj drużyny</td><td><input type="text" name="t1" ></td>
</tr>
   

</tbody>
</table></center>
    
    <center><input type="submit" value="Szukaj" /></center>


</form>
</br>
</br>

<center><a href="http://localhost:8080/MTGleague-web/UserPanel.jsp">Powrót</a></center>
</body>
<%}%>
</html>

