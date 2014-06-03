<%@page import="java.util.ArrayList"%>
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
        Integer druzyna = Integer.parseInt(request.getParameter("t6"));
        Integer ajdi = Integer.parseInt(request.getParameter("id"));
        Integer option = Integer.parseInt(request.getParameter("option"));
        
       ArrayList<Integer> users = new ArrayList<Integer>();
               if(option==0){
 try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdUzytkownika from UzytkownikTurniej Where IdTurnieju='"+ajdi+"' AND IdUzytkownika='"+nruser+"'");
     while(rs.next())
         {
            users.add(rs.getInt(1));
              }
         }
     catch(Exception e1)
{}

    if(users.size()>0){
           response.sendRedirect("http://localhost:8080/MTGleague-web/Already.jsp");
       }else{

    try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
   
     
        
             String query2 = "INSERT INTO UzytkownikTurniej (IdUzytkownika,IdTurnieju) ";
             query2 += "VALUES('"+nruser+"', '"+ajdi+"');";
             st.executeUpdate(query2);
            response.sendRedirect("http://localhost:8080/MTGleague-web/UserPanel.jsp");
             

             
}catch(Exception e1)
{}
 
    }
 

 }
       if(option==1){
       
        try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdDruzyny from DruzynaTurniej Where IdTurnieju='"+ajdi+"' AND IdDruzyny='"+druzyna+"'");
     while(rs.next())
         {
            users.add(rs.getInt(1));
              }
         }
     catch(Exception e1)
{}

    if(users.size()>0){
           response.sendRedirect("http://localhost:8080/MTGleague-web/Already.jsp");}
                 else{

    try{
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
   
     
        
             String query2 = "INSERT INTO DruzynaTurniej (IdDruzyny,IdTurnieju) ";
             query2 += "VALUES('"+druzyna+"', '"+ajdi+"');";
             st.executeUpdate(query2);
            response.sendRedirect("http://localhost:8080/MTGleague-web/UserPanel.jsp");
             

             
}catch(Exception e1)
{}
          }
       
       
       }
            

               








%>



    </body>
    <%}%>
</html>
