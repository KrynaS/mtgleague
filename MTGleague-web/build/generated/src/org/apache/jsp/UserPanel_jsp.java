package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Panel Użytkownika</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"JS/css/style.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/UserProfile.jsp\">Profil</a></br>\n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/UsersAdminPanel.jsp1\">Drużyny</a></br>\n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/TournamentAdminPanel.jsp1\">Turnieje</a></br>\n");
      out.write("     \n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/UsersAdminPanel1.jsp\">Twoje Drużyny</a></br>\n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/TeamsAdminPanel1.jsp\">Twoje Turnieje</a></br>\n");
      out.write("     </br>\n");
      out.write("     <a href=\"http://localhost:8080/MTGleague-web/Kontrolery/LogoutController.jsp\">Wyloguj</a></br>\n");
      out.write("    </body>\n");
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
