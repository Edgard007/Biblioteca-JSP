
package com.dao;

import com.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Nombre de la clase: DaoPrestamo
 * Fecha: 01-10-2019
 * Version: 1.0
 * Copyright: Biblioteca Online
 * @author Edgard Palacios 
 */
public class DaoPrestamo extends Conexion{
    
    //En este metodo se valida si el Cliente ya reaizo un Prestamo de X Libro
    public boolean validar(int idClie,int idLib) throws Exception
    {
         ResultSet rs = null;
         
         String sql = "SELECT * FROM solicitudprestamo where idCliente=? and idLibro=?";
        try 
        {
            conectar();
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idClie);
            pre.setInt(2, idLib);
            rs = pre.executeQuery();
            while(rs.next())
            {
                return true;
            }
        } 
        catch (Exception e) 
        {
            throw e;
        }
        
        return false;
    }
    
    //En este Metodo se Ingresa la Solicitud del Prestamo
    public void insertarSoliPrestamo(int idClie,int idLib) throws ClassNotFoundException, SQLException, Exception
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date fecha = new Date();
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        try 
        {
            this.conectar();
            String sql="insert into solicitudprestamo(idCliente,idLibro,fecha,borradoLogico) values(?,?,?,?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, idClie);
            pre.setInt(2, idLib);
            pre.setDate(3, sqlDate);
            pre.setInt(4, 1);
            pre.executeUpdate();  
            
            
        } catch (SQLException e) 
        {
           throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
    
    //En este metodo se Verifica cuantos Libros Prestados lleva X Cliente
    
    public int nPrestamos(int idClie) throws Exception
    {
         this.conectar();
         ResultSet rs;
         
            int n=0;
            try 
            {
             String sql = "SELECT MAX(idSolicitud)\n" +
                "FROM solicitudPrestamo\n" +
                "WHERE idCliente=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, idClie);
            
            rs = pre.executeQuery();
            while(rs.next())
            {
                n= rs.getInt("MAX(idSolicitud)");
            }
         } catch (Exception e) {
             throw e;
        }
        finally
        {
            this.desconectar();
        }
            return n;
     }
    
    
}
