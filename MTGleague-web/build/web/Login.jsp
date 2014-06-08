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
<form method="post" ACTION="Kontrolery/LoginController.jsp">
    <center><table>
    <thead></thead>
    <tbody>
<tr>
<td>E-mail</td><td><input type="text" name="t1" ></td>
</tr>
    <td>Hasło</td>
<td><input type="password" name="t2"></td>
</tr>

</tbody>
</table></center>
    
    <center><input type="submit" value="Zaloguj" /></center>


</form>
</br>
</br>
    <center>
Nie masz konta?</center>
<center><a href="/MTGleague-web/UserAdd.jsp">Rejestracja</a></center>
</body>
</html>

