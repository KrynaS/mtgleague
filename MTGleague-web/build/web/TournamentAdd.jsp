<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

                <link rel="stylesheet" type="text/css" href="JS/css/style.css">
        
   
        
<%@ page language ="java" import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>
<form method="post" ACTION="Kontrolery/TournamentAddController.jsp">
    <center><table>
    <thead></thead>
    <tbody>
        <tr>
<td>Nazwa</td>
<td><input type="text" id="t2" name="t2"></td>
</tr
<tr>
<td>Data</td>
<td><input type="date" name="t3" id="t3"></td>
</tr>
<tr>
<td>Typ</td>
<td><select id="t4" name="t4">
        <option>T2 (Standard)</option>
        <option>Modern</option>
        <option>Legacy</option>
        <option>Two-Headed Giant</option>
        <option>Draft</option>
        <option>Pentagram</option>
    </select></td>
</tr>

</tbody>

</table>
        
        <input type="submit" value="Stwórz turniej" />
   
    
    
    
    
    
    
    
    
    


</form>
</body>
<%}%>
</html>

