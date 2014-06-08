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
<form ACTION="Kontrolery/TeamEditController.jsp">
    <input type="hidden" id="t0" value="<%=nruser%>" name="t0" />
    
    <center><table>
    <thead></thead>
    <tbody>
      <%
      String nazwa="";
      String haslo="";

        Integer ajdi=0;
        ajdi=Integer.parseInt(request.getParameter("id"));
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Nazwa,Haslo from Druzyna where Id='"+ajdi+"'");
     while(rs.next())
         {
         nazwa=rs.getString(1);
         haslo=rs.getString(2);

     
                 }
        
                 
     
}catch(Exception e1)
{}
        
        %>
        </tr>
<td>Nazwa</td>
<td><input type="text" id="t2" name="t2" value="<%=nazwa%>"></td>
</tr>
<td>Hasło</td>
<td><input type="password" id="t6" name="t3" value="<%=haslo%>"></td>
</tr>




</tbody>

</table>
<input type="hidden" id="t9" name="t9" value="<%=ajdi%>">
<center>
    <input type="submit" value="Zapisz" />
    
    
    
    
    
    </form>  
</br>
</br>
</br>
    <a href="/MTGleague-web/UserPanel.jsp">Powrót</a>
  

</body>
</html>

<%}%>