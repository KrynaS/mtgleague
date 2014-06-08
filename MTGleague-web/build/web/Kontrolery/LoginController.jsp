<%-- 
    Document   : LoginController
    Created on : May 21, 2014, 1:15:44 PM
    Author     : Lappa
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
       String user=request.getParameter("t1");
String pass=request.getParameter("t2");

     try{
    
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Email,Haslo,prawaAdmin,Id, czyZablokowany from Uzytkownik");
     while(rs.next())
         {
         String login=rs.getString(1);
         String haslo=rs.getString(2);
         Integer czyadmin=rs.getInt(3);
         Integer nruser=rs.getInt(4);
         Integer block=rs.getInt(5);
         if(user.equals(login) && pass.equals(haslo)&& block==0)
             {session.setAttribute("login",login);
              session.setAttribute("idusera",czyadmin);
              session.setAttribute("nrusera",nruser);
                 if(czyadmin!=1){
                 response.sendRedirect("/MTGleague-web/UserPanel.jsp");
                }
                      if(czyadmin==1){
                          response.sendRedirect("/MTGleague-web/AdminPanel.jsp");

                           }
         }
                 
     }
}catch(Exception e1)
{}

       
       
       
       %>


    </body>
</html>
