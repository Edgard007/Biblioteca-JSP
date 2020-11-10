/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.dao.DaoLibro;
import com.modelo.Carrito;
import com.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Nombre de la clase: Carro
 * Fecha: 09-11-2019
 * Version: 1.0
 * Copyright: Denis Valladares
 * @author Denis Valladares
 */
public class Carro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String accion = request.getParameter("accion");
        
        HttpSession ses = request.getSession();
        DaoLibro dao = new DaoLibro();
        List<Libro> ls;
        List<Carrito> arreglo = new ArrayList();
        if(accion.equals("agregar")){
            int cantidad = Integer.parseInt(request.getParameter("cant"));
            List<Carrito> car = (ArrayList)ses.getAttribute("carrito");
            boolean flag = false;
            if(car==null || car.isEmpty()){
                    try {
                       ls = dao.verLibro(idLibro);
                       boolean digital = Boolean.parseBoolean(request.getParameter("libroDigital"));
                       boolean fisico = Boolean.parseBoolean(request.getParameter("libroFisico"));
                       for(Libro l:ls){
                           if(cantidad<=l.getCantidad()){
                                Carrito c = new Carrito();
                                c.setIdLibro(idLibro);
                                c.setNombre(l.getNombre());
                                c.setAutor(l.getAutor().getNombre());
                                c.setEditorial(l.getEditorial().getNombre());
                                c.setPrecio(l.getPrecio());
                                c.setCantidad(cantidad);
                                c.setSubtotal(cantidad*l.getPrecio());
                                c.setStock(l.getCantidad());
                                c.setDigital(digital);
                                c.setFisico(fisico);
                                arreglo.add(c);
                                flag = true;
                           }else{
                               out.print("No hay mas libros en Stock");
                               flag = false;
                           }
                       }
                       ses.setAttribute("carrito", arreglo);
                       if(flag){
                       out.print("Se agregó exitosamente al carrito");
                       }
                    } catch (Exception e) {
                        out.print("Error: "+e.getMessage());
                    }
               } else {
                List<Carrito> list = (ArrayList) ses.getAttribute("carrito");
                boolean band= false;
                for (Carrito c : list){
                    if (idLibro!=c.getIdLibro()) {
                        band=true;
                    } else {
                        band=false;
                        c.setCantidad(c.getCantidad()+cantidad);
                        if(!c.isDigital()){
                            c.setDigital(true);
                        }
                        if(!c.isFisico()){
                            c.setFisico(true);
                        }
                        out.print("Se agregó de nuevo el libro");
                    }
                }
                if(band){
                    try {
                       List<Libro> lst = new ArrayList();
                       lst = dao.verLibro(idLibro);
                       boolean digital = Boolean.parseBoolean(request.getParameter("libroDigital"));
                       boolean fisico = Boolean.parseBoolean(request.getParameter("libroFisico"));
                       for(Libro l:lst){
                           if(cantidad<=l.getCantidad()){
                                Carrito c = new Carrito();
                                c.setIdLibro(idLibro);
                                c.setNombre(l.getNombre());
                                c.setAutor(l.getAutor().getNombre());
                                c.setEditorial(l.getEditorial().getNombre());
                                c.setPrecio(l.getPrecio());
                                c.setCantidad(cantidad);
                                c.setSubtotal(cantidad*l.getPrecio());
                                c.setStock(l.getCantidad());
                                c.setDigital(digital);
                                c.setFisico(fisico);
                                list.add(c);
                                flag = true;
                           }else{
                               out.print("No hay mas libros en Stock");
                               flag = false;
                           }
                       }
                       ses.setAttribute("carrito", list);
                       if(flag){
                       out.print("Se agregó otro exitosamente al carrito");
                       }
                    } catch (Exception e) {
                        out.print("Error: "+e.getMessage());
                    }
                }
            }

        }
        if(accion.equals("eliminar")){ 
                int idLib = Integer.parseInt(request.getParameter("idLibro"));
                List<Carrito> list = (ArrayList) ses.getAttribute("carrito");
                List<Carrito> nuevo = new ArrayList();
                boolean band = false;
                for (Carrito c : list){
                    if (idLib != c.getIdLibro()) {
                        Carrito ca = new Carrito();
                        ca.setAutor(c.getAutor());
                        ca.setCantidad(c.getCantidad());
                        ca.setEditorial(c.getEditorial());
                        ca.setIdCliente(c.getIdCliente());
                        ca.setIdLibro(c.getIdLibro());
                        ca.setNombre(c.getNombre());
                        ca.setPrecio(c.getPrecio());
                        ca.setSubtotal(c.getSubtotal());
                        //ca.setDigital(c.isDigital());
                        //ca.setFisico(c.isFisico());
                        nuevo.add(ca);
                        band=false;
                    }else{
                        band = true;
                    }
                }
                if(band){
                    out.print("Se eliminó correctamente ");
                }
                ses.setAttribute("carrito", nuevo);    
        }
        
        if(accion.equals("update")){
            int idLi = Integer.parseInt(request.getParameter("idLibro"));
            int canti = Integer.parseInt(request.getParameter("cant"));
            List<Carrito> list = (ArrayList) ses.getAttribute("carrito");
                for (Carrito c : list){
                    if (idLi == c.getIdLibro()) {
                        if(canti<=c.getStock()){
                        c.setCantidad(c.getCantidad()<canti? c.getCantidad()+1: c.getCantidad()-1);
                        c.setSubtotal(c.getCantidad()*c.getPrecio());
                        }else{
                            out.print("No hay mas libros en stock");
                        }
                    }
                }
                ses.setAttribute("carrito", list);
        }
        

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
