
package com.controlador;

import com.dao.DaoPrestamo;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre del Servlet: Prestamos
 * Fecha: 01-10-2019
 * Version: 1.0
 * Copyright: Biblioteca Online
 * @author Edgard Palacios 
 */

public class Prestamos extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=null;
        DaoPrestamo dao=new DaoPrestamo();
        
        int idLib=Integer.parseInt(request.getParameter("l").toString());
        int idClie=Integer.parseInt(request.getParameter("u").toString());
        
        try 
        {
             
            if(request.getParameter("u")!=null)
            {
                if(request.getParameter("l")!=null)
                {
                    if(dao.validar(idClie, idLib))
                    {
                        request.setAttribute("info","Ya Tienes una Solicitud del Prestamo Vigente");
                        request.setAttribute("text","Recurda que solo puedes Prestar 1 Copia por Libro");
                        request.setAttribute("type","error");
                    }
                    else
                    {
                        
                        //Cometario Falso xd
                        int n= dao.nPrestamos(idClie);
                        
                        if(n>3)
                        {
                        request.setAttribute("info","Exediste el Numero de Libros a Prestar");
                        request.setAttribute("text","Solo puedes Prestar un Maximo de 3 Libros");
                        request.setAttribute("type","error");
                        }
                        else
                        {
                        dao.insertarSoliPrestamo(idClie, idLib);
                        request.setAttribute("info","Solicitud Exitosa");
                        request.setAttribute("text","Ya puedes acercarte a la Localidad más cercana a Recoger tu Prestamo");
                        request.setAttribute("type","success");
                        }
                    }
                }
            }
            
            
            
            rd=request.getRequestDispatcher("ver-libro.jsp");
        } 
        catch (Exception e) 
        {
            request.setAttribute("Error",e.toString());
        }
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
