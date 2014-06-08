<%-- 
    Document   : UserDeleteController
    Created on : 2014-05-05, 18:11:54
    Author     : ML
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%

Integer id=0;
id = Integer.parseInt(request.getParameter("id"));
Integer opcja=0;
opcja = Integer.parseInt(request.getParameter("option"));
Integer did=0;
did = Integer.parseInt(request.getParameter("did"));
     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="";
      if(opcja==0){
     query3="DELETE from DruzynaTurniej WHERE IdDruzyny='"+did+"' AND IdTurnieju='"+id+"'";
         }else{
     query3="DELETE from UzytkownikTurniej WHERE IdUzytkownika='"+did+"' AND IdTurnieju='"+id+"'";
         
         }
     st.executeUpdate(query3);
       
     }
     catch(SQLException ex){}
     


    response.sendRedirect("/MTGleague-web/UserPanel.jsp");







%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        
    </body>
</html>
