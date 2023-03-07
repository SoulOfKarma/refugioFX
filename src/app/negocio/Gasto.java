/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

/**
 *
 * @author Ricar
 */
public class Gasto {
    
    private int idGasto;
    private String nombreGasto;
    private int idTipoGasto;

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
     * @return the nombreGasto
     */
    public String getNombreGasto() {
        return nombreGasto;
    }

    /**
     * @param nombreGasto the nombreGasto to set
     */
    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    /**
     * @return the idTipoGasto
     */
    public int getIdTipoGasto() {
        return idTipoGasto;
    }

    /**
     * @param idTipoGasto the idTipoGasto to set
     */
    public void setIdTipoGasto(int idTipoGasto) {
        this.idTipoGasto = idTipoGasto;
    }
    
    
    
}
