<%@page import="com.modelo.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Notificacion"%>
<%@page import="com.dao.DaoNotificacion"%>
<header>
    
     <%
            HttpSession ses=request.getSession();         
        %>
        
    <%
         DaoNotificacion daon = new DaoNotificacion();
             Notificacion n = new Notificacion();
             int num = 0;
             
    %>

    
    <nav class="navbar navbar-expand-lg fixed-top p-3" id="mainNav" style="background-color: #2F2F2F;">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="index.jsp"><img src="assets/img/Imagen1.png"width="210px" height="35px"/></a>
      <button class="navbar-toggler navbar-toggler-right  font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="index.jsp" style="color: white">Home</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="autores.jsp" style="color: white">Autores</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="libros.jsp" style="color: white">Libros</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="libroGenero.jsp" style="color: white">Genero de Libros</a>
          </li>
          <li class="nav-item mx-0 mx-lg-1">
              <%
        if(ses.getAttribute("carrito")!=null){
            List<Carrito> ls = (ArrayList)ses.getAttribute("carrito");
            if(!ls.isEmpty()){
                int x = 0;
                   for(Carrito c:ls){
                       x++;
                   }
        %>
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"style="text-decoration: none; color: white;"  href="carrito.jsp"><i class="fas fa-shopping-cart mr-1"></i><span class="badge badge-info"><%=x%></span></i></a>
          <%
                }else{
                %>
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"  style="text-decoration: none; color: white;"  href="carrito.jsp"><i class="fas fa-shopping-cart mr-1"></i><span class="badge badge-info">0</span></i></a>
              <%
                }
        }else{
        %>
          
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" style="text-decoration: none; color: white;"  href="carrito.jsp"><i class="fas fa-shopping-cart mr-1"></i><span class="badge badge-info">0</span></i></a>
          </li>   
                <%
                    }
                 if(ses.getAttribute("sis")!=null)  //Esta sesion trae el ID del Usuario logeado
                {
                    int id=Integer.parseInt(ses.getAttribute("sis").toString()); 
                    List<Notificacion> list = daon.cargarNotificacion(id);
                
                %>
                
                <li class="nav-item mx-0 mx-lg-1">


                    <a  href="notificaciones.jsp" style="text-decoration: none; color: white;"  class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"><i class="fas fa-globe-americas mr-1"></i><span class="badge badge-info"><div id="noti"></div></span></a>

                     <ul class="dropdown-menu">
                         <%                         
                              for(Notificacion no:list){
                                num++; 
                                  
                         %>
                         
                         <a href="procesarNotificacion?n=<%= no.getIdNotificacion() %>" class="external" style="text-decoration: none; color: black;">
                         <li >
                             <div class="span3" id="n" style="background: <%=(no.getEstado())?"#D2FEC5":"#FFFFFF"%>; padding: 5px;">
                                 <p><b>Oferta:</b> <%= no.getOferta().getNombre() %></p>
                             </div>
                         </li>
                        </a>
                        <%
                             }
                        %>
                        <script>
                           var noti = document.getElementById("noti");
                           noti.innerHTML = "<%=num%>";
                        </script>
                  </ul>
                 </li>
                 
                 <%
                    }
                %>
        </ul>
      </div>
    </div>
   </nav><br><br><br>
</header>
