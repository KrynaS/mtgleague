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
Integer admin=(Integer)session.getAttribute("idusera");
Integer id=0;
id = Integer.parseInt(request.getParameter("id"));
     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="DELETE from Turniej WHERE Id='"+id+"'";
     st.executeUpdate(query3);
    // query3="DELETE from DruzynaUzytkownik WHERE IdUzytkownika='"+id+"'";
    // st.executeUpdate(query3);
       
     }
     catch(SQLException ex){}
     

    if(admin!=1){response.sendRedirect("http://localhost:8080/MTGleague-web/MyTournaments.jsp");}else{
    response.sendRedirect("http://localhost:8080/MTGleague-web/TournamentAdminPanel.jsp");
    }






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
