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
public class DetalleGastoListado {
    
    private int iddep;
    private int idgas;
    private String nomDep;
    private String nomGas;
    private int precio;
    private Date fecha;

    /**
     * @return the iddep
     */
    public int getIddep() {
        return iddep;
    }

    /**
     * @param iddep the iddep to set
     */
    public void setIddep(int iddep) {
        this.iddep = iddep;
    }

    /**
     * @return the idgas
     */
    public int getIdgas() {
        return idgas;
    }

    /**
     * @param idgas the idgas to set
     */
    public void setIdgas(int idgas) {
        this.idgas = idgas;
    }

    /**
     * @return the nomDep
     */
    public String getNomDep() {
        return nomDep;
    }

    /**
     * @param nomDep the nomDep to set
     */
    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    /**
     * @return the nomGas
     */
    public String getNomGas() {
        return nomGas;
    }

    /**
     * @param nomGas the nomGas to set
     */
    public void setNomGas(String nomGas) {
        this.nomGas = nomGas;
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
