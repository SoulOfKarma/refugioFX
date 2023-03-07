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
public class Departamento {

    /**
     * @return the num_huspedes
     */
    public int getNum_huspedes() {
        return num_huspedes;
    }

    /**
     * @param num_huspedes the num_huspedes to set
     */
    public void setNum_huspedes(int num_huspedes) {
        this.num_huspedes = num_huspedes;
    }
    private int id;
    private int rol_dep;
    private String dir_departamento;
    private int id_comuna;
    private int num_piso;
    private int valor_compra_dep;
    private String num_dep;
    private int num_habitaciones;
    private int num_camas;
    private int num_banios;
    private int num_huspedes;
    private Date fecha_construccion;
    private int metros_cuadrados;
    private int valor_arriendo;
    private int valorizacion;
    private String nombre_propiedad;
    private String desc_arriendo;
    private String poliza_arriendo;
    private String info_compl;
    private int estado_dep;
    private Date fecha_registro;
    private int usado;
    

    /**
     * @return the id
     */
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the rol_dep
     */
    public int getRol_dep() {
        return rol_dep;
    }

    /**
     * @param rol_dep the rol_dep to set
     */
    public void setRol_dep(int rol_dep) {
        this.rol_dep = rol_dep;
    }

    /**
     * @return the dir_departamento
     */
    public String getDir_departamento() {
        return dir_departamento;
    }

    /**
     * @param dir_departamento the dir_departamento to set
     */
    public void setDir_departamento(String dir_departamento) {
        this.dir_departamento = dir_departamento;
    }

    /**
     * @return the id_comuna
     */
    public int getId_comuna() {
        return id_comuna;
    }

    /**
     * @param id_comuna the id_comuna to set
     */
    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    /**
     * @return the num_piso
     */
    public int getNum_piso() {
        return num_piso;
    }

    /**
     * @param num_piso the num_piso to set
     */
    public void setNum_piso(int num_piso) {
        this.num_piso = num_piso;
    }

    /**
     * @return the valor_compra_dep
     */
    public int getValor_compra_dep() {
        return valor_compra_dep;
    }

    /**
     * @param valor_compra_dep the valor_compra_dep to set
     */
    public void setValor_compra_dep(int valor_compra_dep) {
        this.valor_compra_dep = valor_compra_dep;
    }

    /**
     * @return the num_dep
     */
    public String getNum_dep() {
        return num_dep;
    }

    /**
     * @param num_dep the num_dep to set
     */
    public void setNum_dep(String num_dep) {
        this.num_dep = num_dep;
    }

    /**
     * @return the num_habitaciones
     */
    public int getNum_habitaciones() {
        return num_habitaciones;
    }

    /**
     * @param num_habitaciones the num_habitaciones to set
     */
    public void setNum_habitaciones(int num_habitaciones) {
        this.num_habitaciones = num_habitaciones;
    }

    /**
     * @return the num_camas
     */
    public int getNum_camas() {
        return num_camas;
    }

    /**
     * @param num_camas the num_camas to set
     */
    public void setNum_camas(int num_camas) {
        this.num_camas = num_camas;
    }

    /**
     * @return the num_banios
     */
    public int getNum_banios() {
        return num_banios;
    }

    /**
     * @param num_banios the num_banios to set
     */
    public void setNum_banios(int num_banios) {
        this.num_banios = num_banios;
    }

    /**
     * @return the fecha_construccion
     */
    public Date getFecha_construccion() {
        return fecha_construccion;
    }

    /**
     * @param fecha_construccion the fecha_construccion to set
     */
    public void setFecha_construccion(Date fecha_construccion) {
        this.fecha_construccion = fecha_construccion;
    }

    /**
     * @return the metros_cuadrados
     */
    public int getMetros_cuadrados() {
        return metros_cuadrados;
    }

    /**
     * @param metros_cuadrados the metros_cuadrados to set
     */
    public void setMetros_cuadrados(int metros_cuadrados) {
        this.metros_cuadrados = metros_cuadrados;
    }

    /**
     * @return the valor_arriendo
     */
    public int getValor_arriendo() {
        return valor_arriendo;
    }

    /**
     * @param valor_arriendo the valor_arriendo to set
     */
    public void setValor_arriendo(int valor_arriendo) {
        this.valor_arriendo = valor_arriendo;
    }

    /**
     * @return the valorizacion
     */
    public int getValorizacion() {
        return valorizacion;
    }

    /**
     * @param valorizacion the valorizacion to set
     */
    public void setValorizacion(int valorizacion) {
        this.valorizacion = valorizacion;
    }

    /**
     * @return the nombre_propiedad
     */
    public String getNombre_propiedad() {
        return nombre_propiedad;
    }

    /**
     * @param nombre_propiedad the nombre_propiedad to set
     */
    public void setNombre_propiedad(String nombre_propiedad) {
        this.nombre_propiedad = nombre_propiedad;
    }

    /**
     * @return the desc_arriendo
     */
    public String getDesc_arriendo() {
        return desc_arriendo;
    }

    /**
     * @param desc_arriendo the desc_arriendo to set
     */
    public void setDesc_arriendo(String desc_arriendo) {
        this.desc_arriendo = desc_arriendo;
    }

    /**
     * @return the poliza_arriendo
     */
    public String getPoliza_arriendo() {
        return poliza_arriendo;
    }

    /**
     * @param poliza_arriendo the poliza_arriendo to set
     */
    public void setPoliza_arriendo(String poliza_arriendo) {
        this.poliza_arriendo = poliza_arriendo;
    }

    /**
     * @return the info_compl
     */
    public String getInfo_compl() {
        return info_compl;
    }

    /**
     * @param info_compl the info_compl to set
     */
    public void setInfo_compl(String info_compl) {
        this.info_compl = info_compl;
    }

    /**
     * @return the estado_dep
     */
    public int getEstado_dep() {
        return estado_dep;
    }

    /**
     * @param estado_dep the estado_dep to set
     */
    public void setEstado_dep(int estado_dep) {
        this.estado_dep = estado_dep;
    }

    /**
     * @return the fecha_registro
     */
    public Date getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    /**
     * @return the usado
     */
    public int getUsado() {
        return usado;
    }

    /**
     * @param usado the usado to set
     */
    public void setUsado(int usado) {
        this.usado = usado;
    }
    
    
    
    
}
