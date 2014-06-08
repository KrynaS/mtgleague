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
        <title>Druzyny</title>
    </head>
    <body>
      
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAZWA</th>
                    <th>LOGO</th>
                    <th>KAPITAN</th>
                    <th>HASŁO</th>
                    <th>ZABLOKOWANY</th>
                    <th>PRAWA</th>
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
     ResultSet rs=st.executeQuery("select d.Id,d.Nazwa,u.Nick,d.czyZablokowana,d.Haslo from Druzyna d,Uzytkownik u Where d.Kapitan=u.Id");
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         String Kapitan=rs.getString(3);
         String haslo=rs.getString(5);
         Integer block=rs.getInt(4);
         String logo="Kontrolery/BlobController.jsp?id="+nr;
         String adres="/MTGleague-web/Kontrolery/TeamBlockController.jsp?option=1&id="+nr;
         String adress="/MTGleague-web/Kontrolery/TeamBlockController.jsp?option=0&id="+nr;
         String adres2="/MTGleague-web/Kontrolery/TeamDelete.jsp?id="+nr;     
         %>
                    <td><%=nr%></td>
                    <td><%=Nazwa%></td>
                            <td>       <img src="<%=logo%>" width="190" height="190"/></td>
                    <td><%=Kapitan%></td>
                    <td><%=haslo%></td>
                    <td><%=block%></td>
                    
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
<a href="/MTGleague-web/AdminPanel.jsp">Powrót</a>
        </body>
</html>
<%}%>