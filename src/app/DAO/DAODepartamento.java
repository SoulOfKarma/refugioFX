/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Comuna;
import app.negocio.Departamento;
import app.negocio.DepartamentoListado;
import app.negocio.EstadoDepartamento;
import app.negocio.Provincia;
import app.negocio.Region;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Ricar
 */
public class DAODepartamento {

    public ArrayList<Region> listarRegion() {

        ArrayList<Region> lista = new ArrayList<Region>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_region");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Region reg = new Region();

                reg.setId(x.getInt("ID_REGION"));
                reg.setNom_region(x.getString("NOMBRE_REGION"));

                lista.add(reg);

            }
            ps.close();
          conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Provincia> listarProvincia(int id) {

        ArrayList<Provincia> lista = new ArrayList<Provincia>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_provincia where id_region = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Provincia pro = new Provincia();

                pro.setIdP(x.getInt("ID_PROVINCIA"));
                pro.setNom_provincia(x.getString("NOMBRE_PROVINCIA"));

                lista.add(pro);

            }
            ps.close();
          conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Comuna> listarComuna(int id) {

        ArrayList<Comuna> lista = new ArrayList<Comuna>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_comuna where ID_PROVINCIA = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Comuna com = new Comuna();

                com.setIdC(x.getInt("ID_COMUNA"));
                com.setNom_Comuna(x.getString("NOMBRE_COMUNA"));

                lista.add(com);

            }
            ps.close();
        conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<EstadoDepartamento> listarEstado() {

        ArrayList<EstadoDepartamento> lista = new ArrayList<EstadoDepartamento>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@li2100-58.members.linode.com:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_estado_departamento");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                String val = x.getString("DESC_EST_DEP");
                if(val.equals("Desactivado"))
                {
                 
                }
                else
                {
                 EstadoDepartamento est = new EstadoDepartamento();
                 est.setIdEstado(x.getInt("ID_EST_DEP"));
                 est.setDesEstado(x.getString("DESC_EST_DEP"));

                lista.add(est);
                }

            }
            ps.close();
         conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public String agregarDepartamento(Departamento dep) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_departamento (ROL_DEP, DIREC_DEP, ID_COMUNA,NUM_PISO_DEP,VALOR_COMPRA_DEP,NUM_DEP,CANT_HABITACIONES,CANT_CAMAS,CANT_HUESPEDES,CANT_BANIOS,FEC_CONST,METROS_CUADRADOS,VALOR_ARRIENDO,VALORIZACION,NOMBRE_EDIFICIO,DESC_ARRIENDO,POL_ARRIENDO,INFO_COMPL,ID_EST_DEP,FEC_REGISTRO,USADO) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, dep.getRol_dep());
            ps.setString(2, dep.getDir_departamento());
            ps.setInt(3, dep.getId_comuna());
            ps.setInt(4, dep.getNum_piso());
            ps.setInt(5, dep.getValor_compra_dep());
            ps.setString(6, dep.getNum_dep());
            ps.setInt(7, dep.getNum_habitaciones());
            ps.setInt(8, dep.getNum_camas());
            ps.setInt(9, dep.getNum_huspedes());
            ps.setInt(10, dep.getNum_banios());
            Date fecha = convertUtilToSql(dep.getFecha_construccion());
            ps.setDate(11, fecha);
            ps.setInt(12, dep.getMetros_cuadrados());
            ps.setInt(13, dep.getValor_arriendo());
            ps.setInt(14, dep.getValorizacion());
            ps.setString(15, dep.getNombre_propiedad());
            ps.setString(16, dep.getDesc_arriendo());
            ps.setString(17, dep.getPoliza_arriendo());
            ps.setString(18, dep.getInfo_compl());
            ps.setInt(19, dep.getEstado_dep());
            Date fechaR = convertUtilToSql(dep.getFecha_registro());
            ps.setDate(20, fechaR);
            ps.setInt(21, dep.getUsado());
            ResultSet x = ps.executeQuery();
            ps.close();
           conn = Conexion.cerrar();
            String mensaje = "Departamento Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public ArrayList<DepartamentoListado> listarDepartamentos() {
        ArrayList<DepartamentoListado> lista = new ArrayList<DepartamentoListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select * from tbl_departamento JOIN tbl_estado_departamento ON tbl_departamento.id_est_dep = tbl_estado_departamento.id_est_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
               
                DepartamentoListado dep = new DepartamentoListado();

                dep.setId(x.getInt("ID_DEP"));
                dep.setRol_dep(x.getInt("ROL_DEP"));
                dep.setDir_departamento(x.getString("DIREC_DEP"));
                dep.setId_comuna(x.getInt("ID_COMUNA"));
                dep.setNum_piso(x.getInt("NUM_PISO_DEP"));
                dep.setValor_compra_dep(x.getInt("VALOR_COMPRA_DEP"));
                dep.setNum_dep(x.getString("NUM_DEP"));
                dep.setNum_habitaciones(x.getInt("CANT_HABITACIONES"));
                dep.setNum_camas(x.getInt("CANT_CAMAS"));
                dep.setNum_banios(x.getInt("CANT_BANIOS"));
                dep.setNum_huspedes(x.getInt("CANT_HUESPEDES"));
                dep.setFecha_construccion(x.getDate("FEC_CONST"));
                dep.setMetros_cuadrados(x.getInt("METROS_CUADRADOS"));
                dep.setValor_arriendo(x.getInt("VALOR_ARRIENDO"));
                dep.setValorizacion(x.getInt("VALORIZACION"));
                dep.setNombre_propiedad(x.getString("NOMBRE_EDIFICIO"));
                dep.setDesc_arriendo(x.getString("DESC_ARRIENDO"));
                dep.setPoliza_arriendo(x.getString("POL_ARRIENDO"));
                dep.setInfo_compl(x.getString("INFO_COMPL"));
                dep.setEstado_dep(x.getInt("ID_EST_DEP"));
                dep.setFecha_registro(x.getDate("FEC_REGISTRO"));
                
                if(x.getInt("USADO")==1)
                {
                   dep.setUsado("Si");
                }
                else
                {
                   dep.setUsado("No");
                }
                
                dep.setIdEst(x.getInt("ID_EST_DEP"));
                dep.setDescEst(x.getString("DESC_EST_DEP"));
                lista.add(dep);
            }
            ps.close();
           conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public ArrayList<DepartamentoListado> filtroDepByID(int id) {
        ArrayList<DepartamentoListado> lista = new ArrayList<DepartamentoListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select * from tbl_departamento JOIN tbl_estado_departamento ON tbl_departamento.id_est_dep = tbl_estado_departamento.id_est_dep WHERE tbl_departamento.ID_DEP = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
               
                DepartamentoListado dep = new DepartamentoListado();

                dep.setId(x.getInt("ID_DEP"));
                dep.setRol_dep(x.getInt("ROL_DEP"));
                dep.setDir_departamento(x.getString("DIREC_DEP"));
                dep.setId_comuna(x.getInt("ID_COMUNA"));
                dep.setNum_piso(x.getInt("NUM_PISO_DEP"));
                dep.setValor_compra_dep(x.getInt("VALOR_COMPRA_DEP"));
                dep.setNum_dep(x.getString("NUM_DEP"));
                dep.setNum_habitaciones(x.getInt("CANT_HABITACIONES"));
                dep.setNum_camas(x.getInt("CANT_CAMAS"));
                dep.setNum_banios(x.getInt("CANT_BANIOS"));
                dep.setNum_huspedes(x.getInt("CANT_HUESPEDES"));
                dep.setFecha_construccion(x.getDate("FEC_CONST"));
                dep.setMetros_cuadrados(x.getInt("METROS_CUADRADOS"));
                dep.setValor_arriendo(x.getInt("VALOR_ARRIENDO"));
                dep.setValorizacion(x.getInt("VALORIZACION"));
                dep.setNombre_propiedad(x.getString("NOMBRE_EDIFICIO"));
                dep.setDesc_arriendo(x.getString("DESC_ARRIENDO"));
                dep.setPoliza_arriendo(x.getString("POL_ARRIENDO"));
                dep.setInfo_compl(x.getString("INFO_COMPL"));
                dep.setEstado_dep(x.getInt("ID_EST_DEP"));
                dep.setFecha_registro(x.getDate("FEC_REGISTRO"));
                
                if(x.getInt("USADO")==1)
                {
                   dep.setUsado("Si");
                }
                else
                {
                   dep.setUsado("No");
                }
                
                dep.setIdEst(x.getInt("ID_EST_DEP"));
                dep.setDescEst(x.getString("DESC_EST_DEP"));
                lista.add(dep);
                
                
                

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    
    
     public String modificarDepartamento(Departamento dep) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_departamento SET ROL_DEP = ?, DIREC_DEP = ?, ID_COMUNA = ?,NUM_PISO_DEP = ?,VALOR_COMPRA_DEP = ?,NUM_DEP = ?,CANT_HABITACIONES = ?,CANT_CAMAS = ?,CANT_HUESPEDES = ?,CANT_BANIOS = ?,FEC_CONST = ?,METROS_CUADRADOS = ?,VALOR_ARRIENDO = ?,VALORIZACION = ?,NOMBRE_EDIFICIO = ?,DESC_ARRIENDO = ?,POL_ARRIENDO = ?,INFO_COMPL = ?,ID_EST_DEP = ?,FEC_REGISTRO = ?,USADO = ? where ID_DEP = ?");
            ps.setInt(1, dep.getRol_dep());
            ps.setString(2, dep.getDir_departamento());
            ps.setInt(3, dep.getId_comuna());
            ps.setInt(4, dep.getNum_piso());
            ps.setInt(5, dep.getValor_compra_dep());
            ps.setString(6, dep.getNum_dep());
            ps.setInt(7, dep.getNum_habitaciones());
            ps.setInt(8, dep.getNum_camas());
            ps.setInt(9, dep.getNum_huspedes());
            ps.setInt(10, dep.getNum_banios());
            Date fecha = convertUtilToSql(dep.getFecha_construccion());
            ps.setDate(11, fecha);
            ps.setInt(12, dep.getMetros_cuadrados());
            ps.setInt(13, dep.getValor_arriendo());
            ps.setInt(14, dep.getValorizacion());
            ps.setString(15, dep.getNombre_propiedad());
            ps.setString(16, dep.getDesc_arriendo());
            ps.setString(17, dep.getPoliza_arriendo());
            ps.setString(18, dep.getInfo_compl());
            ps.setInt(19, dep.getEstado_dep());
            Date fechaR = convertUtilToSql(dep.getFecha_registro());
            ps.setDate(20, fechaR);
            ps.setInt(21, dep.getUsado());
            ps.setInt(22, dep.getId());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Departamento Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
     
     public String desactivarDepartamento(int dep,int estado) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_departamento SET ID_EST_DEP = ? where ID_DEP = ?");     
            ps.setInt(1, estado);
            ps.setInt(2, dep);
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Departamento desactivado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
