<%-- 
    Document   : UserDeleteController
    Created on : 2014-05-05, 18:11:54
    Author     : ML
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
 <%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>
<%

Integer id=0;
id = Integer.parseInt(request.getParameter("id"));
     
    
     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="DELETE from DruzynaUzytkownik WHERE IdDruzyny='"+id+"' AND IdUzytkownika='"+nruser+"'";
     st.executeUpdate(query3);
       
     }
     catch(SQLException ex){}
     


    response.sendRedirect("http://localhost:8080/MTGleague-web/YourTeams.jsp");







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
<%}%>