      <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
          pageEncoding="ISO-8859-1"%>
           <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     </head>
    <body>
     <%@ page import="java.io.*"%>
 <%@ page import="java.sql.*"%>
 <%@ page import="java.util.*"%>
  <%@ page import="java.text.*"%>
 <%@ page import="javax.servlet.*"%>
 <%@ page import="javax.servlet.http.*"%>
 <%@ page import="javax.servlet.http.HttpSession"%>
 <%@ page language="java"%>
 <%@ page session="true"%>
 <%
       String ajdi=request.getParameter("id");
Blob image = null;
Connection con = null;
byte[ ] imgData = null ;
Statement stmt = null;
ResultSet rs = null;
      try {
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");

stmt = con.createStatement();
rs = stmt.executeQuery("select Logo from Druzyna where id = '"+ajdi+"'");
if (rs.next()) {
image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
} else {
return;
}
response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);

o.flush();

o.close();

} catch (Exception e) {

return;

} finally {

try {

rs.close();

stmt.close();

con.close();

} catch (SQLException e) {
}}
%>
  </body>
    </html>