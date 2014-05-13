<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
       
        session.setAttribute("idusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
//if(admin==1){%><%-- 
    Document   : Blokowanie
    Created on : 2014-01-09, 17:35:09
    Author     : ML
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
        

Integer id=0;
id=Integer.parseInt(request.getParameter("id"));
Integer opcja=0;
opcja=Integer.parseInt(request.getParameter("option"));



     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="";
     if(opcja==1){
     query3 = "UPDATE Druzyna SET czyZablokowana='1' WHERE id="+id;
     }
     if(opcja==0){
     query3 = "UPDATE Druzyna SET czyZablokowana='0' WHERE id="+id;
     }
     st.executeUpdate(query3);
        
     response.sendRedirect("http://localhost:8080/MTGleague-web/TeamsAdminPanel.jsp");
       
}catch(Exception e1)
{}





%>
    </body>
</html>
<%//}%>