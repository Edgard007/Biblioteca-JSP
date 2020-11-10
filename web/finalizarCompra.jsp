<%-- 
    Document   : finalizarCompra
    Created on : 11-11-2019, 08:28:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<%
    HttpSession ses = request.getSession();
    if(ses.getAttribute("sis")!=null){
        
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca Onile</title>
        <jsp:include page="layout/css1.jsp"></jsp:include>
    </head>
    <body>
    <jsp:include  page="layout/menu_pagep.jsp"></jsp:include>
    
    
    <jsp:include page="layout/footeer.jsp"></jsp:include>
    </body>
</html>
<%
   }else{
    response.sendRedirect("inicioSesion.jsp");
}
%>
