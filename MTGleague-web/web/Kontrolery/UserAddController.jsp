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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <%
        String imie = request.getParameter("t2");
        String nazwisko = request.getParameter("t3");
        String nick = request.getParameter("t4");
        String email = request.getParameter("t5");
        String haslo = request.getParameter("t6");
        
          try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Email from Uzytkownik");
      while(rs.next())
         {
         String login=rs.getString(1);
         
         if(email.equals(login)){}
                          else{  
             String query2 = "INSERT INTO Uzytkownik (Imie,Nazwisko,Nick,DataRejestracji,Haslo,Email,czyZablokowany,prawaAdmin) ";
             query2 += "VALUES('"+imie+"', '"+nazwisko+"', '"+nick+"' ,CURDATE(), '"+haslo+"' , '"+email+"','0','0');";
             st.executeUpdate(query2);
           
                         response.sendRedirect("/MTGleague-web/RegSuccess.jsp");

                           }       
             }
             
}catch(Exception e1)
{}%>
    </body>
</html>
