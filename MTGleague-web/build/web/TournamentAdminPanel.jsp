<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
       
        session.setAttribute("idusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
if(admin==1){%>
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
        <title>Uzytkownicy</title>
    </head>
    <body>
      
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAZWA</th>
                    <th>TERMIN</th>
                    <th>TYP</th>
                    <th>ZAŁOŻYCIEL</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id,Nazwa,Data,Typ,Zalozyciel from Turniej");
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         String Data=rs.getString(3);
         String Typ=rs.getString(4);
         String ListaUczestnikow=rs.getString(5);
        
         String adres2="http://localhost:8080/MTGleague-web/Kontrolery/TournamentDelete.jsp?id="+nr;     
         %>
                    <td><%=nr%></td>
                    <td><%=Nazwa%></td>
                    <td><%=Data%></td>
                    <td><%=Typ%></td>
                    <td><%=ListaUczestnikow%></td>


                    <td><input type="button" value="Usuń" onclick="location.href='<%=adres2%>';">
           </td>
                </tr>
         
         
         
         <%
         
         }
                 
     
}catch(Exception e1)
{}
        
        %>
      </tbody>
        </table>
<a href="http://localhost:8080/MTGleague-web/AdminPanel.jsp">Powrót</a>
        </body>
</html>
<%}%>