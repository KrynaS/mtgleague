<%-- 
    Document   : TeamAddConController
    Created on : May 21, 2014, 3:05:29 PM
    Author     : Lappa
--%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
    </head>
    <body>
       <%
       String imie=request.getParameter("Nazwa");
       int login=0;
try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id from Druzyna Where Nazwa='"+imie+"'");
      while(rs.next())
         {
         login=rs.getInt(1);
                 
             String query2 = "INSERT INTO DruzynaUzytkownik (IdDruzyny,IdUzytkownika) ";
             query2 += "VALUES('"+login+"','"+nruser+"');";
             st.executeUpdate(query2);     
           
             response.sendRedirect("/MTGleague-web/YourTeams.jsp");

                                  
             }
    
}catch(Exception e1)
               {}       


       %><input type="submit" value="<%=login%>" />
    </body>
</html>
<%}%>
