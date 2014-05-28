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
        <title>Drużyny</title>
    </head>
    <body>
      
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>NAZWA</th>
                    <th></th>
                    <th></th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
        
        try{
     String szuk="";
     szuk=request.getParameter("t1");
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id,Nazwa from Druzyna Where Nazwa LIKE '%"+szuk+"%'");
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);

                 
         String adres="http://localhost:8080/MTGleague-web/TeamDetails.jsp?option=5&id="+nr;
         String adress="http://localhost:8080/MTGleague-web/TeamJoin.jsp?&id="+nr;
    
         %>
                    <td><%=Nazwa%></td>

                 
                   <td><input type="button" value="Szczegóły" onclick="location.href='<%=adres%>';">
           </td>
                
                    <td><input type="button" value="Dołącz" onclick="location.href='<%=adress%>';">
           </td>
                                
                </tr>
         
         
         
         <%
         
         }
                 
     
}catch(Exception e1)
{}
        
        %>
      </tbody>
        </table>
<a href="http://localhost:8080/MTGleague-web/UserPanel.jsp">Powrót</a>
        </body>
</html>
<%}%>