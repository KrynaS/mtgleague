<%@page import="java.util.Date"%>
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
        <title>Turnieje</title>
    </head>
    <body>
      
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>NAZWA</th>
                    <th>TERMIN</th>
                    <th>TYP</th>
                    <th></th>
               
                </tr>
            </thead>
            <tbody>
                <tr>
                  
             

        <%
        try{
     String adres2="";
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     String query = "Select t.Id, t.Nazwa, t.Data, t.Typ, u.Id FROM Turniej t, UzytkownikTurniej ut, Uzytkownik u "
                + "Where t.Id=ut.idTurnieju AND ut.IdUzytkownika="+nruser+" AND t.Zalozyciel=u.Id";
     String query2 = "Select t.Id, t.Nazwa, t.Data, t.Typ, u.Nick, d.Id FROM Turniej t, Druzyna d, DruzynaTurniej dt, DruzynaUzytkownik du, Uzytkownik u "
                + "Where du.IdDruzyny=d.Id AND d.Id=dt.IdDruzyny AND dt.IdTurnieju=t.Id AND du.IdUzytkownika="+nruser+" AND t.Zalozyciel=u.Id";  
  ResultSet rs=st.executeQuery(query);
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         Date Data=rs.getDate(3);
         String Typ=rs.getString(4);
         Integer Idusera=rs.getInt(5);
         
         if(Typ.equals("Two-Headed Giant")){
         adres2="/MTGleague-web/TournamentJoin.jsp?did="+Idusera+"option=1&id="+nr;}else{
         adres2="/MTGleague-web/TournamentJoin.jsp?did="+Idusera+"option=0&id="+nr;
                  }         
         %>
           
                    <td><%=Nazwa%></td>
                    <td><%=Data%></td>
                    <td><%=Typ%></td>
                


                    <td><input type="button" value="Opuść turniej" onclick="location.href='<%=adres2%>';">
           </td>
                </tr>
         
         
         
         <%
         
         }
   rs=st.executeQuery(query2);
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         Date Data=rs.getDate(3);
         String Typ=rs.getString(4);
         String Idusera=rs.getString(6);
         if(Typ.equals("Two-Headed Giant")){
         adres2="/MTGleague-web/TournamentJoin.jsp?did="+Idusera+"option=1&id="+nr;}else{
         adres2="/MTGleague-web/TournamentJoin.jsp?did="+Idusera+"option=0&id="+nr;
                  }         
         %>
           
                    <td><%=Nazwa%></td>
                    <td><%=Data%></td>
                    <td><%=Typ%></td>
                


                    <td><input type="button" value="Opuść turniej" onclick="location.href='<%=adres2%>';">
           </td>
                </tr>
         
         
         
         <%
         
         }
                 
     
}catch(Exception e1)
        
{}
        %>
      </tbody>
        </table>
<a href="/MTGleague-web/UserPanel.jsp">Powrót</a>
        </body>
</html>
<%}%>