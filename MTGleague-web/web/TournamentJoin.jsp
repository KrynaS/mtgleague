<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Integer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}%>
<% Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){
    
      

        %>
     
        
        
<%@ page language ="java" import="java.sql.*" %> 
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <head><link rel="stylesheet" type="text/css" href="JS/css/style.css"></head>
    <body>
        
        <% Integer opcja = Integer.parseInt(request.getParameter("option"));
           Integer ajdi = Integer.parseInt(request.getParameter("id"));
           if(opcja==0){
           response.sendRedirect("http://localhost:8080/MTGleague-web/Kontrolery/JoinTournamentController.jsp?t6=0&option=0&id="+ajdi+"");
           }else{

%>
<form method="post" ACTION="Kontrolery/JoinTournamentController.jsp">
    <input type="hidden" id="option" name="option" value="1" />
    <input type="hidden" id="id" name="id" value="<%=ajdi%>" />
    <table>
        <thead>
            <th><center>Wybierz drużynę</center></th>
        </thead>
        <tbody>
          <tr>
              
              <td><center>
                 <select name="t6" id="t6">
    <%
       
        ArrayList<Integer> idList = new ArrayList<Integer>();
       
     
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdDruzyny from DruzynaUzytkownik WHERE IdUzytkownika='"+nruser+"'");
     while(rs.next())
         {
         idList.add(rs.getInt(1));
         
         }
                 
     
}catch(Exception e1)
{}
        
          try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     for(int i=0;i<idList.size();i++){
     ResultSet rs=st.executeQuery("select Id,Nazwa from Druzyna where Id="+idList.get(i)+" AND Kapitan='"+nruser+"'");
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
                
        %>
      
                
       
            <option value="<%=nr%>"><%=Nazwa%></option>
          
      
                
        
       
         <%
               }}}catch(Exception e1)
{}  
         
        %>
             </select></center>
                 </td>
            
            
        </tr>
        </tbody>
    </table>
    
             <center><input type="submit" value="Zapisz się" /></center>
</form>

             </br>
              </br>
               </br>
                </br>
                 </br>
                  </br>
<center><a href="http://localhost:8080/MTGleague-web/UserPanel.jsp">Powrót</a></center>
</body>
</html>

<%}}%>