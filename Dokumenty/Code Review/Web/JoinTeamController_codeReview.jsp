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
            String haslo = request.getParameter("t1");
                String ajdi = request.getParameter("t2");
                String hastemp = "";
                Integer poprawne = 0;
                Integer juzjest = 0;
                ArrayList<Integer> users = new ArrayList<Integer>();
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin", "mtglol123");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select IdUzytkownika from DruzynaUzytkownik Where IdDruzyny='" + ajdi + "'");
                    while (rs.next()) {
                        users.add(rs.getInt(1));
                    }
                } catch (Exception e1) {}
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i) == nruser) {
                        juzjest = 1;
                        response.sendRedirect("/MTGleague-web/Already.jsp");
                    }
                }
                if (users.size() > 4) {
                    response.sendRedirect("/MTGleague-web/TooMany.jsp");
                } else {
                    try {
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin", "mtglol123");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select Haslo from Druzyna Where Id='" + ajdi + "'");
                        while (rs.next()) {
                            hastemp = rs.getString(1);
                            if (haslo.equals(rs.getString(1))) {
                                poprawne = 1;
                            }
                        }
                        if (poprawne == 1) {
                            String query2 = "INSERT INTO DruzynaUzytkownik (IdDruzyny,IdUzytkownika) ";
                            query2 += "VALUES('" + ajdi + "','" + nruser + "');";
                            st.executeUpdate(query2);
                            response.sendRedirect("/MTGleague-web/YourTeams.jsp");
                        } else {
                            response.sendRedirect("/MTGleague-web/BadPass.jsp");
                        }
                    } catch (Exception e1) {
                    }

               }

%>
   </body>
    <%}%>
</html>
