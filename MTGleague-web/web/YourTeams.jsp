<%@page import="java.util.List"%>
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
        <title>Druzyny</title>
    </head>
    <body>
      
        <table class="sortable" border="1">
            <thead>
                <tr>
                    
                    <th>NAZWA</th>
                    <th>KAPITAN</th>
                    <th>HASŁO</th>
                    <th>SZCZEGÓŁY</th>
                    <th></th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
        ArrayList<Integer> myList = new ArrayList<Integer>();
        ArrayList<Integer> idList = new ArrayList<Integer>();
        ArrayList<String> ksywaList = new ArrayList<String>();
        String Kapitan2="";
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id,Nick from Uzytkownik");
     while(rs.next())
         {
         idList.add(rs.getInt(1));
         ksywaList.add(rs.getString(2));
         }
                 
     
}catch(Exception e1)
{}
  
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdDruzyny from DruzynaUzytkownik Where IdUzytkownika="+nruser);
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
     ResultSet rs=st.executeQuery("select Id,Nazwa,Kapitan,Haslo from Druzyna where Id="+myList.get(i));
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         Integer Kapitan=rs.getInt(3);
         String haslo=rs.getString(4);
         
        
         String adres="http://localhost:8080/MTGleague-web/TeamEdit.jsp?id="+nr;
         String adres2="http://localhost:8080/MTGleague-web/TeamDetails.jsp?option=1&id="+nr;
       
        %>
                    <%
                    for(int j=0;j<idList.size();j++){
                        if(Kapitan==idList.get(j)){
                         Kapitan2=ksywaList.get(j); 
                        }
                        
                        
                    }
                    
                    %>
                    <td><%=Nazwa%></td>
                    <td><%=Kapitan2%></td>
                    <td><%=haslo%></td>
                    <td><input type="button" value="Szczegóły" onclick="location.href='<%=adres2%>';"></td>
                    <td>
                  <% if(Kapitan==nruser){%>
                  <input type="button" value="Edytuj" onclick="location.href='<%=adres%>';">
                  
           
           <%}%>
           </td>
                </tr>
         
         
         
         <%
         
         }
    }          
     
}catch(Exception e1)
{}
        
        %>
      </tbody>
        </table>
      </br>
      <a href="http://localhost:8080/MTGleague-web/TeamAdd.jsp">Stwórz drużynę</a>
      </br>
<a href="http://localhost:8080/MTGleague-web/UserPanel.jsp">Powrót</a>
        </body>
</html>
<%}%>