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
public class Inventario {
    
    private int idInv;
    private String nombre_inv;
    private String desc_inv;
    private int valor_inv;
    private int id_dep;

    /**
     * @return the idInv
     */
    public int getIdInv() {
        return idInv;
    }

    /**
     * @param idInv the idInv to set
     */
    public void setIdInv(int idInv) {
        this.idInv = idInv;
    }

    /**
     * @return the nombre_inv
     */
    public String getNombre_inv() {
        return nombre_inv;
    }

    /**
     * @param nombre_inv the nombre_inv to set
     */
    public void setNombre_inv(String nombre_inv) {
        this.nombre_inv = nombre_inv;
    }

    /**
     * @return the desc_inv
     */
    public String getDesc_inv() {
        return desc_inv;
    }

    /**
     * @param desc_inv the desc_inv to set
     */
    public void setDesc_inv(String desc_inv) {
        this.desc_inv = desc_inv;
    }

    /**
     * @return the valor_inv
     */
    public int getValor_inv() {
        return valor_inv;
    }

    /**
     * @param valor_inv the valor_inv to set
     */
    public void setValor_inv(int valor_inv) {
        this.valor_inv = valor_inv;
    }

    /**
     * @return the id_dep
     */
    public int getId_dep() {
        return id_dep;
    }

    /**
     * @param id_dep the id_dep to set
     */
    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }
    
    
    
}
