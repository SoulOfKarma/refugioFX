/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

import java.util.Date;

/**
 *
 * @author Ricar
 */
public class DetalleGasto {
    
    private int idDep;
    private int idGasto;
    private int precio;
    private Date fecha;

    /**
     * @return the idDep
     */
    public int getIdDep() {
        return idDep;
    }

    /**
     * @param idDep the idDep to set
     */
    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    /**
     * @return the idGasto
     */
    public int getIdGasto() {
        return idGasto;
    }

    /**
     * @param idGasto the idGasto to set
     */
    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
