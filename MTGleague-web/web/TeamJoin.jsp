<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){
    
        Integer ajdi=0;
        ajdi=Integer.parseInt(request.getParameter("id"));
        
        %>
     
        
        
<%@ page language ="java" import="java.sql.*" %> 
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head><link rel="stylesheet" type="text/css" href="JS/css/style.css"></head>
    <body>
<form method="post" ACTION="Kontrolery/JoinTeamController.jsp">
    <center><table>
    <thead></thead>
    <tbody>
<tr>
    <td>Hasło</td>
<td><input type="password" name="t1"></td>
</tr>

<input type="hidden" name="t2" value="<%=ajdi%>">
</tbody>
</table></center>
    
    <center><input type="submit" value="Dołącz" /></center>


</form>
</br>
</br>

<center><a href="/MTGleague-web/TeamsSearch.jsp">Powrót</a></center>
</body>
</html>

<%}%>