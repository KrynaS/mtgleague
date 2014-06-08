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

<form method="post" ACTION="Kontrolery/TeamAddController.jsp">
    <center><table>
    <thead></thead>
    <tbody>
        <tr>
<td>Nazwa</td>
<td><input type="text" id="t2" name="t2"></td>
        </tr>
<tr>
<td>Hasło</td>
<td><input type="password" id="t6" name="t6"></td>
</tr>

<tr>
<td>Logo</td>
<td><input type="file" name="t567" accept="image/png,image/jpeg,image/gif"/></td>
</tr>
</tbody>

</table>
        
        <input type="submit" value="Dodaj drużynę" />
   
    
    
    
    
    
    
    
    
    


</form>
</body>
<%}%>
</html>

