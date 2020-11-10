<%-- 
    Document   : carrito
    Created on : 11-09-2019, 10:30:53 AM
    Author     : SERVER
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Online</title>
        <jsp:include page="layout/css1.jsp"></jsp:include>
        <script src="Recursos/js/carrito.js" type="text/javascript"></script>
    </head>
    <body>
    <jsp:include page="layout/menu_pagep.jsp"></jsp:include>
    <br><br><br>
    <%
        HttpSession ses = request.getSession();
        if(ses.getAttribute("carrito")!=null){
            List<Carrito> ls = (ArrayList)ses.getAttribute("carrito");
            if(!ls.isEmpty()){
    %>  
            
    <center><h3>Carrito de Compras</h3></center>
    <table class="table table-borderless">
        <thead class="table-dark text-center">
            <th>#</th>
            <th>Nombre</th>
            <th>Editorial</th>
            <th>Autor</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Tipo Libro</th>
            <th>Subtotal</th>
            <th>Acción</th>
        </thead>
        <tbody >
            <%
                
                int x = 0;
                DecimalFormat df = new DecimalFormat("######.##");
                double total = 0;
                   for(Carrito c:ls){ 
                   total+= c.getSubtotal();
                %>    
                <tr>
                    <td><%=(x+1)%></td>
                    <td><%=c.getNombre() %></td>
                    <td><%=c.getEditorial() %></td>
                    <td><%=c.getAutor() %></td>
                    <td>$<%=df.format(c.getPrecio()) %></td>
                    <td><input type="number" class="form-control cant col-md-4 ml-auto mr-auto cant"  value="<%= c.getCantidad() %>" data-id="<%=c.getIdLibro() %>" data-cant="<%=c.getCantidad() %>"/></td>
                    <td>
                        <%= (c.isDigital()?" Digital":"" )%><%= (c.isDigital() && c.isFisico()? " y ":"" )%><%=c.isFisico()?" Fisico":"" %>
                    </td>
                    <td>$<%=df.format(c.getSubtotal()) %></td>
                    <td><input type="button" class="btn btn-danger btn-small eliminar " value="Eliminar" id="<%=c.getIdLibro() %>"/></td>
                </tr>
                 <% 
                     x++;
               } 
            %>
        </tbody>
        <tfoot class="table-dark text-right">
            <tr>
                <td colspan="9"><h4><strong>Total: $</strong><%= df.format(total) %></h4></td>
            </tr>
        </tfoot>
    </table>
    <div class="" align="right">
        <a href="finalizarCompra.jsp" class="btn btn-success" style="color:white;">Finalizar Compra</a>
    </div>
    
            <%
                }else{
                %> 
                <center><h3>El Carrito esta vacio</h3></center>   
                 <%
                }
        }else{
           %> 
           <center><h3>El Carrito esta vacio</h3></center>   
            <%
        }
    %>
    
    
    <jsp:include page="layout/footeer.jsp"></jsp:include>
    </body>
</html>
