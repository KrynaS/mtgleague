<%-- 
    Document   : UserAddController
    Created on : 2014-05-05, 18:38:20
    Author     : ML
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
        String ajdi = request.getParameter("t9");
        String nazwa = request.getParameter("t2");
        String haslo = request.getParameter("t3");
       
        
          try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query2 = "UPDATE Druzyna SET Nazwa='"+nazwa+"', Haslo='"+haslo+"' WHERE id='"+ajdi+"'";
     st.executeUpdate(query2);
          response.sendRedirect("/MTGleague-web/YourTeams.jsp");
                            
             
}catch(Exception e1)
{}%>
    </body>
    <%}%>
</html>
