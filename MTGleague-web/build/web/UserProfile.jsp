<link rel="stylesheet" type="text/css" href="JS/css/style.css"><%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

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
<form ACTION="Kontrolery/UserEditController.jsp">
    <input type="hidden" id="t0" value="<%=nruser%>" name="t0" />
    
    <center><table>
    <thead></thead>
    <tbody>
      <%
      String email="";
      String imie="";
      String Nazwisko="";
      String Nick="";
      String DataRejestracji="";
      String haslo="";
      
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Imie,Nazwisko,Nick,DataRejestracji,Haslo,Email from Uzytkownik where Id="+nruser);
     while(rs.next())
         {
         imie=rs.getString(1);
         Nazwisko=rs.getString(2);
         Nick=rs.getString(3);
         DataRejestracji=rs.getString(4);
         haslo=rs.getString(5);
         email=rs.getString(6);
     
                 }
        
                 
     
}catch(Exception e1)
{}
        
        %>
        </tr>
<td>Imię</td>
<td><input type="text" id="t2" name="t2" value="<%=imie%>"></td>
</tr>
<td>Nazwisko</td>
<td><input type="text" id="t3" name="t3" value="<%=Nazwisko%>"></td>
</tr>
<td>Nick</td>
<td><input type="text" id="t4" name="t4" value="<%=Nick%>"></td>
</tr>
<td>Data dołączenia</td>
<td><%=DataRejestracji%><input type="hidden" id="t5" name="t5" value="<%=DataRejestracji%>"></td>
</tr>
<td>Hasło</td>
<td><input type="password" id="t6" name="t6" value="<%=haslo%>"></td>
</tr>
<td>E-mail</td>
<td><%=email%><input type="hidden" id="t7" name="t7" value="<%=email%>"></td>
</tr>
</tr>

</tbody>

</table><center>
    <input type="submit" value="Zapisz" />
    
    
    
    
    
    </form>  
</br>
</br>
</br>
    <a href="http://localhost:8080/MTGleague-web/UserPanel.jsp">Powrót</a>
  

</body>
</html>

<%}%>