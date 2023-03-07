/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

/**
 *
 * @author Ricar
 */

import app.negocio.FotosDepListado;
import app.negocio.FotosDepartamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class DAOFotosDepartamento {
    
    public String agregarFotoDepartamento(FotosDepartamento fot) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_fotos_departamento (RUTA_FOTO,ID_DEP) values (?,?)");
            ps.setString(1, fot.getNomFoto());
            ps.setInt(2, fot.getIdDep());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Foto Agregada correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public ArrayList<FotosDepartamento> listarDetalleGasto() {
        
        ArrayList<FotosDepartamento> lista = new ArrayList<FotosDepartamento>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_detalle_gastos_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                FotosDepartamento detGas = new FotosDepartamento();
                detGas.setIdDep(x.getInt("ID_DEP"));                
                
                
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
    
    public ArrayList<FotosDepListado> listaTabla() {
        
        ArrayList<FotosDepListado> lista = new ArrayList<FotosDepListado>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_fotos_departamento.id_dep,tbl_fotos_departamento.id_foto,tbl_departamento.nombre_edificio,tbl_fotos_departamento.ruta_foto from tbl_fotos_departamento \n" +
"JOIN tbl_departamento ON tbl_fotos_departamento.id_dep = tbl_departamento.id_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                FotosDepListado fotList = new FotosDepListado();
                fotList.setIdDep(x.getInt("ID_DEP"));                
                fotList.setIdFoto(x.getInt("id_foto"));
                fotList.setDepartamentoNom(x.getString("nombre_edificio"));
                fotList.setNomFoto(x.getString("ruta_foto"));
                lista.add(fotList);
                
            }
            ps.close();
           conn = Conexion.cerrar();
            return lista;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public ArrayList<FotosDepListado> listaTablaFiltrada(int id) {
        
        ArrayList<FotosDepListado> lista = new ArrayList<FotosDepListado>();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_fotos_departamento.id_dep,tbl_fotos_departamento.id_foto,tbl_departamento.nombre_edificio,tbl_fotos_departamento.ruta_foto from tbl_fotos_departamento \n" +
"JOIN tbl_departamento ON tbl_fotos_departamento.id_dep = tbl_departamento.id_dep WHERE tbl_fotos_departamento.id_dep = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                FotosDepListado fotList = new FotosDepListado();
                fotList.setIdDep(x.getInt("ID_DEP"));                
                fotList.setIdFoto(x.getInt("id_foto"));
                fotList.setDepartamentoNom(x.getString("nombre_edificio"));
                fotList.setNomFoto(x.getString("ruta_foto"));
                lista.add(fotList);
                
            }
            ps.close();
           conn = Conexion.cerrar();
            return lista;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public boolean eliminarFoto(int id,int idfoto) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE from tbl_fotos_departamento where id_dep = ? and id_foto = ?");
            ps.setInt(1, id);
            ps.setInt(2, idfoto);
            ResultSet x = ps.executeQuery();
          
            ps.close();
           conn = Conexion.cerrar();
            return true;
            
        } catch (Exception e) {
            String men = e.getMessage();
            return false;
        }
    }
    
}
