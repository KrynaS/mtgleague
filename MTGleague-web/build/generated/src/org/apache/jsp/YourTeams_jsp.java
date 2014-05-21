package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class YourTeams_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
if((String)session.getAttribute("login")==null){

        Integer zidusera=99999;
        Integer znrusera=99999;
       
        session.setAttribute("idusera",zidusera);
        session.setAttribute("nrusera",zidusera);
}
      out.write('\n');
 Integer admin=(Integer)session.getAttribute("idusera");
Integer nruser=(Integer)session.getAttribute("nrusera");
if(nruser!=99999){
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
      out.write("        <title>Druzyny</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("        <table class=\"sortable\" border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                    <th>NAZWA</th>\n");
      out.write("                    <th>KAPITAN</th>\n");
      out.write("                    <th>HASŁO</th>\n");
      out.write("                    <th>SZCZEGÓŁY</th>\n");
      out.write("                    <th></th>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                  \n");
      out.write("             \n");
      out.write("\n");
      out.write("        ");

        ArrayList<Integer> myList = new ArrayList<Integer>();
        ArrayList<Integer> idList = new ArrayList<Integer>();
        ArrayList<String> ksywaList = new ArrayList<String>();
        String Kapitan2="";
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select Id,Nick from Uzytkownik");
     while(rs.next())
         {
         idList.add(rs.getInt(1));
         ksywaList.add(rs.getString(2));
         }
                 
     
}catch(Exception e1)
{}
  
        try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select IdDruzyny from DruzynaUzytkownik Where IdUzytkownika="+nruser);
     while(rs.next())
         {
         myList.add(rs.getInt(1));
         }
                 
     
}catch(Exception e1)
{}
  
     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/mtgleague","mtgadmin","mtglol123");
     Statement st=con.createStatement();
     for(int i=0;i<myList.size();i++){
     ResultSet rs=st.executeQuery("select Id,Nazwa,Kapitan,Haslo from Druzyna where Id="+myList.get(i));
     while(rs.next())
         {
         Integer nr=rs.getInt(1);
         String Nazwa=rs.getString(2);
         Integer Kapitan=rs.getInt(3);
         String haslo=rs.getString(4);
         
        
         String adres="http://localhost:8080/MTGleague-web/TeamEdit.jsp?id="+nr;
         String adres2="http://localhost:8080/MTGleague-web/TeamDetails.jsp?id="+nr;
       
        
      out.write("\n");
      out.write("                    ");

                    for(int j=0;j<idList.size();j++){
                        if(Kapitan==idList.get(j)){
                         Kapitan2=ksywaList.get(j); 
                        }
                        
                        
                    }
                    
                    
      out.write("\n");
      out.write("                    <td>");
      out.print(Nazwa);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(Kapitan2);
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(haslo);
      out.write("</td>\n");
      out.write("                    <td><input type=\"button\" value=\"Szczegóły\" onclick=\"location.href='");
      out.print(adres2);
      out.write("';\"></td>\n");
      out.write("                    <td>\n");
      out.write("                  ");
 if(Kapitan==nruser){
      out.write("\n");
      out.write("                  <input type=\"button\" value=\"Edytuj\" onclick=\"location.href='");
      out.print(adres);
      out.write("';\">\n");
      out.write("                  \n");
      out.write("           \n");
      out.write("           ");
}
      out.write("\n");
      out.write("           </td>\n");
      out.write("                </tr>\n");
      out.write("         \n");
      out.write("         \n");
      out.write("         \n");
      out.write("         ");

         
         }
    }          
     
}catch(Exception e1)
{}
        
        
      out.write("\n");
      out.write("      </tbody>\n");
      out.write("        </table>\n");
      out.write("      </br>\n");
      out.write("      <a href=\"http://localhost:8080/MTGleague-web/TeamAdd.jsp\">Stwórz drużynę</a>\n");
      out.write("      </br>\n");
      out.write("<a href=\"http://localhost:8080/MTGleague-web/UserPanel.jsp\">Powrót</a>\n");
      out.write("        </body>\n");
      out.write("</html>\n");
}
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
