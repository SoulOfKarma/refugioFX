/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.DetalleGasto;
import app.negocio.DetalleGastoListado;
import app.negocio.Region;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ricar
 */
public class DAODetalleGasto {
    
    public ArrayList<DetalleGasto> listarDetalleGasto() {
        
        ArrayList<DetalleGasto> lista = new ArrayList<DetalleGasto>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_detalle_gastos_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                DetalleGasto detGas = new DetalleGasto();
                detGas.setIdDep(x.getInt("ID_DEP"));                
                detGas.setIdGasto(x.getInt("ID_GASTO"));
                detGas.setPrecio(x.getInt("PRECIO_GASTO"));
                detGas.setFecha(x.getDate("FECHA_GASTO"));
                
                lista.add(detGas);
                
            }
            ps.close();
        conn = Conexion.cerrar();
            return lista;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public ArrayList<DetalleGastoListado> listarDetalleGastoTabla() {
        
        ArrayList<DetalleGastoListado> lista = new ArrayList<DetalleGastoListado>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT tbl_detalle_gastos_dep.id_dep,tbl_detalle_gastos_dep.id_gasto,tbl_departamento.nombre_edificio,tbl_gastos_departamento.nombre_gasto,tbl_detalle_gastos_dep.precio_gasto,tbl_detalle_gastos_dep.fecha_gasto FROM tbl_detalle_gastos_dep\n" +
"JOIN tbl_departamento ON tbl_detalle_gastos_dep.id_dep = tbl_departamento.id_dep\n" +
"JOIN tbl_gastos_departamento ON tbl_detalle_gastos_dep.id_gasto = tbl_gastos_departamento.id_gasto\n" +
"ORDER BY tbl_detalle_gastos_dep.id_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                DetalleGastoListado detGas = new DetalleGastoListado();
                detGas.setIddep(x.getInt("ID_DEP"));                
                detGas.setIdgas(x.getInt("ID_GASTO"));
                detGas.setNomDep(x.getString("nombre_edificio"));
                detGas.setNomGas(x.getString("nombre_gasto"));
                detGas.setPrecio(x.getInt("PRECIO_GASTO"));
                detGas.setFecha(x.getDate("FECHA_GASTO"));
                
                lista.add(detGas);
                
            }
            ps.close();
         conn = Conexion.cerrar();
            return lista;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public ArrayList<DetalleGastoListado> listarFiltroDetalleGastoTabla(int id) {
        
        ArrayList<DetalleGastoListado> lista = new ArrayList<DetalleGastoListado>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT tbl_detalle_gastos_dep.id_dep,tbl_detalle_gastos_dep.id_gasto,tbl_departamento.nombre_edificio,tbl_gastos_departamento.nombre_gasto,tbl_detalle_gastos_dep.precio_gasto,tbl_detalle_gastos_dep.fecha_gasto FROM tbl_detalle_gastos_dep\n" +
"JOIN tbl_departamento ON tbl_detalle_gastos_dep.id_dep = tbl_departamento.id_dep\n" +
"JOIN tbl_gastos_departamento ON tbl_detalle_gastos_dep.id_gasto = tbl_gastos_departamento.id_gasto\n" +
"WHERE tbl_detalle_gastos_dep.id_dep = ? ORDER BY tbl_detalle_gastos_dep.id_dep");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                DetalleGastoListado detGas = new DetalleGastoListado();
                detGas.setIddep(x.getInt("ID_DEP"));                
                detGas.setIdgas(x.getInt("ID_GASTO"));
                detGas.setNomDep(x.getString("nombre_edificio"));
                detGas.setNomGas(x.getString("nombre_gasto"));
                detGas.setPrecio(x.getInt("PRECIO_GASTO"));
                detGas.setFecha(x.getDate("FECHA_GASTO"));
                
                lista.add(detGas);
                
            }
            ps.close();
          conn = Conexion.cerrar();
            return lista;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public boolean agregarDetalleGasto(DetalleGasto det) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_detalle_gastos_dep(ID_DEP,ID_GASTO,PRECIO_GASTO,FECHA_GASTO) values(?,?,?,?)");
            ps.setInt(1, det.getIdDep());
            ps.setInt(2, det.getIdGasto());
            ps.setInt(3, det.getPrecio());
            ps.setDate(4, convertUtilToSql(det.getFecha()));
            ResultSet x = ps.executeQuery();
            
            ps.close();
           conn = Conexion.cerrar();
            return true;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return false;
        }
    }
    
    public boolean modificarDetalleGasto(DetalleGasto det,int iddep,int idgas,Date fecha) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_detalle_gastos_dep SET ID_DEP = ?, ID_GASTO = ?,PRECIO_GASTO = ?,FECHA_GASTO = ? WHERE fecha_gasto = ? and id_dep = ? and id_gasto = ?");
            ps.setInt(1, det.getIdDep());
            ps.setInt(2, det.getIdGasto());
            ps.setInt(3, det.getPrecio());
            ps.setDate(4, convertUtilToSql(det.getFecha()));
            ps.setDate(5, convertUtilToSql(fecha));
            ps.setInt(6, iddep);
            ps.setInt(7, idgas);
            ResultSet x = ps.executeQuery();
            
            ps.close();
          conn = Conexion.cerrar();
            return true;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return false;
        }
    }
    
    public boolean eliminarDetalleGasto(int iddep,int idgas,Date fecha) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_detalle_gastos_dep WHERE fecha_gasto = ? and id_dep = ? and id_gasto = ?");
            ps.setDate(1, convertUtilToSql(fecha));
            ps.setInt(2, iddep);
            ps.setInt(3, idgas);
            ResultSet x = ps.executeQuery();
            
            ps.close();
          conn = Conexion.cerrar();
            return true;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return false;
        }
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
}
