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
<%

Integer id=0;
id = Integer.parseInt(request.getParameter("id"));
     ArrayList<Integer> myList = new ArrayList<Integer>();
      try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id from Druzyna Where Kapitan='"+id+"'");
     while(rs.next())
         {
         myList.add(rs.getInt(1));
         }
             
    }catch(Exception e1)
    {}
     
     
     if(myList.size()>0){
         for(int i=0;i<myList.size();i++){
             ArrayList<Integer> userzy = new ArrayList<Integer>();
     try{
     
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdUzytkownika from DruzynaUzytkownik Where IdDruzyny="+myList.get(i)+" AND IdUzytkownika<>'"+id+"'");
     while(rs.next())
         {
         userzy.add(rs.getInt(1));
         }
             
    }catch(Exception e1)
    {}
             
     if(userzy.size()!=0){
     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="UPDATE Druzyna Set Kapitan='"+userzy.get(0)+"' WHERE Id='"+myList.get(i)+"'";
     st.executeUpdate(query3);
    
       
     }
     catch(SQLException ex){}
     
     }else{
                try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="DELETE from Druzyna WHERE Id='"+myList.get(i)+"'";
     st.executeUpdate(query3);
     query3="DELETE from DruzynaUzytkownik WHERE IdDruzyny='"+myList.get(i) +"'";
     st.executeUpdate(query3);
       
     }
     catch(SQLException ex){}   
                                 }
     }
     
         }
     
     
    
     try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query3="DELETE from Uzytkownik WHERE id='"+id+"'";
     st.executeUpdate(query3);
     query3="DELETE from DruzynaUzytkownik WHERE IdUzytkownika='"+id+"'";
     st.executeUpdate(query3);
       
     }
     catch(SQLException ex){}
     


    response.sendRedirect("/MTGleague-web/UsersAdminPanel.jsp");







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
