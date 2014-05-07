<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

                <link rel="stylesheet" type="text/css" href="JS/css/style.css">
        
   
        
<%@ page language ="java" import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<form method="post" ACTION="Kontrolery/UserAddController.jsp">
    <center><table>
    <thead></thead>
    <tbody>
        <tr>
<td>Imię</td>
<td><input type="text" id="t2" name="t2"></td>
</tr
<tr>
<td>Nazwisko</td>
<td><input type="text" id="t3" name="t3"></td>
</tr>
<tr>
<td>Nick</td>
<td><input type="text" id="t4" name="t4"></td>
</tr>
<tr>
<td>E-mail</td>
<td><input type="text" id="t5" name="t5"></td>
</tr>
<tr>
<td>Hasło</td>
<td><input type="password" id="t6" name="t6"></td>
</tr>
</tbody>

</table>
        
        <input type="submit" value="Zarejestruj" />
   
    
    
    
    
    
    
    
    
    


</form>
</body>
</html>

