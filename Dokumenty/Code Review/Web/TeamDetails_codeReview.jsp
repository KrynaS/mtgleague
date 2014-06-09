<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
    <%if ((String) session.getAttribute("login") == null) {

            Integer zidusera = 99999;
            Integer znrusera = 99999;

            session.setAttribute("idusera", zidusera);
            session.setAttribute("nrusera", zidusera);
        }%>
    <% Integer admin = (Integer) session.getAttribute("idusera");
        Integer nruser = (Integer) session.getAttribute("nrusera");
        if (nruser != 99999) {%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="JS/css/style.css" />
        <script src="JS/sorttable.js"></script>
        <title>Drużyna</title>
    </head>
    <body>
        <%
            Integer ajdi = 0;
            ajdi = Integer.parseInt(request.getParameter("id"));
            Integer option = 0;
            if ((String) session.getAttribute("option") != null) {
                option = Integer.parseInt(request.getParameter("option"));
            }
            Integer kapitan = 0;
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin", "mtglol123");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select Kapitan from Druzyna Where Id='" + ajdi + "'");
                while (rs.next()) {
                    kapitan = rs.getInt(1);
                }

            } catch (Exception e1) {
            }
        %>
        <table class="sortable" border="1">
            <thead>
                <tr>
                    <th>IMIĘ</th>
                    <th>NAZWISKO</th>
                    <th>NICK</th>
                    <th>EMAIL</th>
                    <% if (kapitan == nruser && option == 1) {%>
                    <th></th><%}%>
                </tr>
            </thead>
            <tbody>
                <tr>



                    <%
                        String adres2 = "/MTGleague-web/Kontrolery/UserLeaveTeamController.jsp?&id=" + ajdi;
                        ArrayList<Integer> myList = new ArrayList<Integer>();
                        try {

                            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague", "mtgadmin", "mtglol123");
                            Statement st = con.createStatement();
                            ResultSet rs = st.executeQuery("select IdUzytkownika from DruzynaUzytkownik Where IdDruzyny=" + ajdi);
                            while (rs.next()) {
                                myList.add(rs.getInt(1));
                            }
                            for (int i = 0; i < myList.size(); i++) {
                                rs = st.executeQuery("select Id,Imie,Nazwisko,Nick,Email from Uzytkownik where Id='" + myList.get(i) + "'");
                                while (rs.next()) {
                                    Integer di = rs.getInt(1);
                                    String imie = rs.getString(2);
                                    String Nazwisko = rs.getString(3);
                                    String Nick = rs.getString(4);
                                    String email = rs.getString(5);
                                    String adres = "/MTGleague-web/Kontrolery/UserSetCaptainController.jsp?option=" + ajdi + "&id=" + di;
                    %>
                    <td><%=imie%></td>
                    <td><%=Nazwisko%></td>
                    <td><%=Nick%></td>
                    <td><%=email%></td>

                    <%if (kapitan == nruser && option == 1) {%> <td> <% if (kapitan != di) {%>
                        <input type="button" value="Ustaw kapitana" onclick="location.href='<%=adres%>';">
                        <%}%></td><%}%>

                </tr>



                <%
                            }
                        }
                    } catch (Exception e1) {
                    }

                %>
            </tbody>
        </table>
        <%if (kapitan != nruser && option == 1) {%>
    <center> <input type="button" value="Opuść drużynę" onclick="location.href='<%=adres2%>';"></center>
        <%}%>
    </br>
    </br>
    <%if (option == 1) {%>
    <a href="/MTGleague-web/YourTeams.jsp">Powrót</a>
    <%}%>
    <%if (option == 5) {%>
    <a href="/MTGleague-web/TeamJoin.jsp?id=<%=ajdi%>">Dołącz</a>
    </br>
    <a href="/MTGleague-web/TeamsSearch.jsp">Powrót</a>
    <%}%>
</body>
</html>
<%}%>