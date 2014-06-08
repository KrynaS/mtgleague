<%@page import="java.util.ArrayList"%>
<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){%>
<%-- 
    Document   : PanelUsers
    Created on : 2014-01-09, 16:58:40
    Author     : ML
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
        <link rel="stylesheet" href="JS/css/style.css" />
         <script src="JS/sorttable.js"></script>
        <title>Turniej</title>
    </head>
    <body>
        <%
         Integer ajdi=0;
        ajdi=Integer.parseInt(request.getParameter("id"));
                
         String option="";
        option=request.getParameter("option");
         if(option.equals("Two-Headed Giant")){
           %>        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>NAZWA</th>
                    <th>LOGO</th>
                    <th></th>
                   
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
       
         
     ArrayList<Integer> myList = new ArrayList<Integer>();
               try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdDruzyny from DruzynaTurniej Where IdTurnieju="+ajdi);
     while(rs.next())
         {
         myList.add(rs.getInt(1));
         }
                 
     
}catch(Exception e1)
{}
        
        
        
        
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     for(int i=0;i<myList.size();i++){
     ResultSet rs=st.executeQuery("select Id,Nazwa Druzyna where Id='"+myList.get(i)+"'");
     while(rs.next())
         {
         Integer di=rs.getInt(1);
         String Nazwa=rs.getString(2);
         String logo= "Kontrolery/BlobController.jsp?id="+di;
         String adres="/MTGleague-web/TeamDetails.jsp?option=5&id="+di;
         %>
                    <td><%=Nazwa%></td>
                         <td>       <img src="<%=logo%>" width="190" height="190"/></td>
                    <td><input type="button" value="Szczegóły" onclick="location.href='<%=adres%>';"></td>

                    
                 
                  
                </tr>
         
         
         
         <%
         
         }
         }       
     
}catch(Exception e1)
{}
        
        %>
      </tbody>
        </table><%  
             
             
         }else{
        %>
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>NICK</th>
                    <th>EMAIL</th>
                   
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
       
         
     ArrayList<Integer> myList = new ArrayList<Integer>();
               try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdUzytkownika from UzytkownikTurniej Where IdTurnieju="+ajdi);
     while(rs.next())
         {
         myList.add(rs.getInt(1));
         }
                 
     
}catch(Exception e1)
{}
        
        
        
        
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     for(int i=0;i<myList.size();i++){
     ResultSet rs=st.executeQuery("select Id,Imie,Nazwisko,Nick,Email from Uzytkownik where Id='"+myList.get(i)+"'");
     while(rs.next())
         {
         Integer di=rs.getInt(1);
         String imie=rs.getString(2);
         String Nazwisko=rs.getString(3);
         String Nick=rs.getString(4);
         String email=rs.getString(5);
         %>
                    <td><%=imie%></td>
                    <td><%=Nazwisko%></td>
                    <td><%=Nick%></td>
                    <td><%=email%></td>
                    
                 
                  
                </tr>
         
         
         
         <%
         
         }
         }       
     
}catch(Exception e1)
{}
        
        %>
      </tbody>
        </table>
<%}%>
</br>
<a href="/MTGleague-web/UserPanel.jsp">Powrót</a>

        </body>
</html>
<%}%>