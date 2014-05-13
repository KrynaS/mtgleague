package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class TeamsAdminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
       
        session.setAttribute("idusera",zidusera);
}
      out.write('\n');
 Integer admin=(Integer)session.getAttribute("idusera");
//if(admin==1){
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"JS/css/style.css\" />\n");
      out.write("         <script src=\"JS/sorttable.js\"></script>\n");
      out.write("        <title>Uzytkownicy</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("        <table class=\"sortable\" border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>ID</th>\n");
      out.write("                    <th>IMIĘ</th>\n");
      out.write("                    <th>NAZWISKO</th>\n");
      out.write("                    <th>NICK</th>\n");
      out.write("                    <th>DATA REJESTRACJI</th>\n");
      out.write("                    <th>HASŁO</th>\n");
      out.write("                    <th>EMAIL</th>\n");
      out.write("                    <th>ZABLOKOWANY</th>\n");
      out.write("                    <th>PRAWA</th>\n");
      out.write("                    <th></th>\n");
      out.write("                    <th></th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                  \n");
      out.write("             \n");
      out.write("\n");
      out.write("        ");

        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id,Nazwa,Kapitan,czyZablokowana,Haslo from Druzyna");
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         Integer Kapitan=rs.getInt(3);
         String haslo=rs.getString(5);
         Integer block=rs.getInt(6);
        
         String adres="http://localhost:8080/MTGleague-web/Kontrolery/TeamBlockController.jsp?option=1&id="+nr;
         String adress="http://localhost:8080/MTGleague-web/Kontrolery/TeamBlockController.jsp?option=0&id="+nr;
         String adres2="http://localhost:8080/MTGleague-web/Kontrolery/TeamDeleteController.jsp?id="+nr;     
         
      out.write("\n");
      out.write("                    <td>");
      out.print(nr);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(Nazwa);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(Kapitan);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(haslo);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(block);
      out.write("</td>\n");
      out.write("                    \n");
      out.write("                   ");
if(block==0){
                   
      out.write("\n");
      out.write("                   <td><input type=\"button\" value=\"Zablokuj\" onclick=\"location.href='");
      out.print(adres);
      out.write("';\">\n");
      out.write("           </td>\n");
      out.write("                   ");
}else{
      out.write("\n");
      out.write("                    <td><input type=\"button\" value=\"Odblokuj\" onclick=\"location.href='");
      out.print(adress);
      out.write("';\">\n");
      out.write("           </td>\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("                    <td><input type=\"button\" value=\"Usuń\" onclick=\"location.href='");
      out.print(adres2);
      out.write("';\">\n");
      out.write("           </td>\n");
      out.write("                </tr>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         \n");
      out.write("         ");

         
         }
                 
     
}catch(Exception e1)
{}
        
        
      out.write("\n");
      out.write("      </tbody>\n");
      out.write("        </table>\n");
      out.write("<a href=\"http://localhost:8080/Sklep/PanelAdmina.jsp\">Powrót</a>\n");
      out.write("        </body>\n");
      out.write("</html>\n");
//}
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
