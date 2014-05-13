<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
       
        session.setAttribute("idusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
//if(admin==1){%>
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
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>NICK</th>
                    <th>DATA REJESTRACJI</th>
                    <th>HASŁO</th>
                    <th>EMAIL</th>
                    <th>ZABLOKOWANY</th>
                    <th>PRAWA</th>
                    <th></th>
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
     ResultSet rs=st.executeQuery("select id,Imie,Nazwisko,Nick,DataRejestracji,Haslo,Email,czyZablokowany,prawaAdmin from Uzytkownik");
     while(rs.next())
         {
         Integer nruser=rs.getInt(1);
         String imie=rs.getString(2);
         String Nazwisko=rs.getString(3);
         String Nick=rs.getString(4);
         String DataRejestracji=rs.getString(5);
         String haslo=rs.getString(6);
         String email=rs.getString(7);
         Integer block=rs.getInt(8);
         Integer czyadmin=rs.getInt(9);
         String adres="http://localhost:8080/MTGleague-web/Kontrolery/UserBlockController.jsp?option=1&id="+nruser;
         String adress="http://localhost:8080/MTGleague-web/Kontrolery/UserBlockController.jsp?option=0&id="+nruser;
         String adres2="http://localhost:8080/MTGleague-web/Kontrolery/UserBlockController.jsp?id="+nruser;     
         %>
                    <td><%=nruser%></td>
                    <td><%=imie%></td>
                    <td><%=Nazwisko%></td>
                    <td><%=Nick%></td>
                    <td><%=DataRejestracji%></td>
                    <td><%=haslo%></td>
                    <td><%=email%></td>
                    <td><%=block%></td>
                    <td><%=czyadmin%></td>
                   <%if(block==0){
                   %>
                   <td><input type="button" value="Zablokuj" onclick="location.href='<%=adres%>';">
           </td>
                   <%}else{%>
                    <td><input type="button" value="Odblokuj" onclick="location.href='<%=adress%>';">
           </td>
                   <%}%>
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
<a href="http://localhost:8080/Sklep/PanelAdmina.jsp">Powrót</a>
        </body>
</html>
<%//}%>