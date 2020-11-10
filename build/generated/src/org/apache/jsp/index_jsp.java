package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.DaoClub;
import com.modelo.Club;
import com.modelo.Libro;
import com.dao.DaoLibro;
import java.util.List;
import com.modelo.Autor;
import com.dao.DaoAutor;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Biblioteca Online</title>\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("  <meta name=\"description\" content=\"\" />\n");
      out.write("  <meta name=\"author\" content=\"\" />\n");
      out.write("  \n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/css.jsp", out, false);
      out.write("\n");
      out.write("  ");

      DaoAutor daoA = new DaoAutor();
      DaoLibro daoL = new DaoLibro();
  
      out.write("\n");
      out.write("  \n");
      out.write("   ");

            if(request.getAttribute("info")!=null)
            {
         
      out.write("\n");
      out.write("         <script>\n");
      out.write("           $(document).ready(function(e)\n");
      out.write("             {\n");
      out.write("               const Toast = Swal.mixin({\n");
      out.write("                toast: true,\n");
      out.write("                position: 'top-end',\n");
      out.write("                showConfirmButton: false,\n");
      out.write("                timer: 6000\n");
      out.write("              })\n");
      out.write("\n");
      out.write("              Toast.fire({\n");
      out.write("                type: '");
      out.print( request.getAttribute("type") );
      out.write("',\n");
      out.write("                title: '");
      out.print( request.getAttribute("info") );
      out.write("'\n");
      out.write("              })\n");
      out.write("             });\n");
      out.write("         </script>\n");
      out.write("         \n");
      out.write("         ");

             }
          
      out.write("\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/menu.jsp", out, false);
      out.write("\n");
      out.write("  <!-- section intro -->\n");
      out.write("  <section id=\"intro\">\n");
      out.write("    <div class=\"slogan\">\n");
      out.write("      <div class=\"icon\">\n");
      out.write("        <i class=\"icon-book icon-10x\"></i>\n");
      out.write("      </div>\n");
      out.write("      <h1>Bienvenido a tu <span>Biblioteca</span> online </h1>\n");
      out.write("      <h2>Todo lo que necesitas al alcance de tu mano</h2>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <!-- end intro -->\n");
      out.write("  <!-- Section about -->\n");
      out.write("  <section id=\"about\" class=\"section\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"span12\">\n");
      out.write("          <div class=\"heading\">\n");
      out.write("            <h3><span>Autores</span></h3>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"sub-heading\">\n");
      out.write("           \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("        ");
 
            List<Autor> ls = daoA.mostrarAutorIndex();
            for(Autor u:ls){
                
           
        
      out.write("\n");
      out.write("        <div class=\"span3\">\n");
      out.write("            <img src=\"assets/img/autor/");
      out.print( u.getImagen() );
      out.write("\" alt=\"");
      out.print( u.getNombre());
      out.write("\" width=\"900\" height=\"200\" class=\"img-polaroid\" />\n");
      out.write("          <div class=\"roles\">\n");
      out.write("            <h5><strong>");
      out.print( u.getNombre());
      out.write("</strong></h5>\n");
      out.write("            <p>\n");
      out.write("                <b>Genero: </b>");
      out.print( u.getGenero().getNombre() );
      out.write("\n");
      out.write("            </p>\n");
      out.write("            <a href=\"autor.jsp?a=");
      out.print( u.getIdAutor() );
      out.write("\" class=\"btn btn-theme\">Leer mas</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        ");

             }
        
      out.write("\n");
      out.write("        <div class=\"span3\">\n");
      out.write("            <a href=\"autores.jsp\"><img src=\"assets/img/autor/masAutor.png\" alt=\"\" width=\"400\" height=\"400\" class=\"\" /></a>\n");
      out.write("          <div class=\"roles\">\n");
      out.write("            <h5><strong></strong></h5>\n");
      out.write("           \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <!-- end section about -->\n");
      out.write("  <!-- section services -->\n");
      out.write("  <section id=\"services\" class=\"section parallax dark\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("          \n");
      out.write("        <div class=\"span12\">\n");
      out.write("          <div class=\"heading\">\n");
      out.write("            <h3><span>Libros</span></h3>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"sub-heading\">\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("        ");

              List<Libro> lst = daoL.mostrarLibroIndex();
              for(Libro l:lst){ 
          
      out.write("\n");
      out.write("        <div class=\"span3\">\n");
      out.write("          <div class=\"box aligncenter\">\n");
      out.write("            <div class=\"halftop\">\n");
      out.write("                <img src=\"assets/img/libro/");
      out.print( l.getImagen() );
      out.write("\" alt=\"");
      out.print( l.getNombre());
      out.write("\"  width=\"400\" height=\"400\" class=\"img-polaroid\" />\n");
      out.write("              \n");
      out.write("            </div>\n");
      out.write("            <h4><strong>");
      out.print( l.getNombre());
      out.write("</strong></h4>\n");
      out.write("            <a href=\"ver-libro.jsp?l=");
      out.print( l.getIdLibro() );
      out.write("\" class=\"btn btn-theme\">Leer mas</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("          ");

            }
        
      out.write(" \n");
      out.write("        <div class=\"span3\">\n");
      out.write("          <div class=\"box aligncenter\">\n");
      out.write("            <div class=\"halftop\">\n");
      out.write("                <a href=\"libros.jsp\"><img src=\"assets/img/libro/masLibro.png\"/></a>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </section>\n");
      out.write("  <!-- end section services -->\n");
      out.write("  <!-- section works -->\n");
      out.write("  <!-- <section id=\"works\" class=\"section gray-bg\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"span12\">\n");
      out.write("          <div class=\"heading\">\n");
      out.write("            <h3><span>Membresia</span></h3>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"sub-heading\">\n");
      out.write("            <p>\n");
      out.write("              We have a history of doing what our name implies, creating a visual language around the beliefs of the brands we work with.\n");
      out.write("            </p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"row\">\n");
      out.write("    \n");
      out.write("    </div>\n");
      out.write("  </section> -->\n");
      out.write("  <!-- section works -->\n");
      out.write("  <!-- section contact -->\n");
      out.write("  \n");
      out.write("  ");


     HttpSession ses=request.getSession();
     if(ses.getAttribute("sis")!=null)  //Esta sesion trae el ID del Usuario logeado
       {
     int id=Integer.parseInt(ses.getAttribute("sis").toString());                  
  
      out.write("\n");
      out.write("  <section id=\"contact\" class=\"section\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"span12\">\n");
      out.write("          <div class=\"heading\">\n");
      out.write("            <h3><span>Club</span></h3>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"sub-heading\">\n");
      out.write("            \n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"row\">\n");
      out.write("        ");
 
            
            DaoClub daoC=new DaoClub();
        
      out.write("\n");
      out.write("        ");

            List<Club> l = daoC.mostrarClubIndex();
            for(Club cb:l){
                
           
        
      out.write("\n");
      out.write("        <div class=\"span3\">\n");
      out.write("          <div class=\"roles\">\n");
      out.write("            <h3><strong>");
      out.print( cb.getNombre());
      out.write("</strong></h3>\n");
      out.write("            <img src=\"assets/img/club.jpg\"/>\n");
      out.write("            <br>\n");
      out.write("            <a href=\"club?c1=");
      out.print( cb.getIdClub() );
      out.write("&c2=");
      out.print( id );
      out.write("\" class=\"icon-edit btn btn-theme\">Unirme</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        ");

             }
        
      out.write("\n");
      out.write("        <div class=\"span3\">\n");
      out.write("          <div class=\"box aligncenter\">\n");
      out.write("            <div class=\"halftop\">\n");
      out.write("                <a href=\"clubs.jsp\"><img src=\"assets/img/masClub.PNG\"/></a>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </section>\n");
      out.write("  <!-- end section contact -->\n");
      out.write("   ");

    }  
   
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
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
