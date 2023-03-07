/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Departamento;
import app.negocio.Inventario;
import app.negocio.InventarioListado;
import app.negocio.Region;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ricar
 */
public class DAOInventario {
    
    public String agregarInventario(Inventario inv) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
           // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_inventario (NOMBRE_OBJETO, DESC_OBJETO,VALOR_OBJETO,ID_DEP) values (?,?,?,?)");
            ps.setString(1, inv.getNombre_inv());
            ps.setString(2, inv.getDesc_inv());
            ps.setInt(3, inv.getValor_inv());
            ps.setInt(4, inv.getId_dep());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Inventario Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String modificarInventario(Inventario inv) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_inventario SET NOMBRE_OBJETO = ?, DESC_OBJETO = ?,VALOR_OBJETO = ?,ID_DEP = ? where id_inventario = ?");
            ps.setString(1, inv.getNombre_inv());
            ps.setString(2, inv.getDesc_inv());
            ps.setInt(3, inv.getValor_inv());
            ps.setInt(4, inv.getId_dep());
            ps.setInt(5, inv.getIdInv());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Inventario Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String eliminarInventario(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_inventario WHETE ID_INVENTARIO = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Inventario Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public ArrayList<InventarioListado> listarInventario() {

        ArrayList<InventarioListado> lista = new ArrayList<InventarioListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_inventario.id_inventario,tbl_inventario.nombre_objeto,tbl_inventario.desc_objeto,tbl_inventario.valor_objeto,tbl_inventario.id_dep,tbl_departamento.nombre_edificio from tbl_inventario \n" +
"JOIN tbl_departamento ON tbl_inventario.id_dep = tbl_departamento.id_dep");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                InventarioListado inv = new InventarioListado();

                inv.setIdInv(x.getInt("ID_INVENTARIO"));
                inv.setId_dep(x.getInt("ID_DEP"));
                inv.setNombre_inv(x.getString("NOMBRE_OBJETO"));
                inv.setDesc_inv(x.getString("DESC_OBJETO"));
                inv.setValor_inv(x.getInt("VALOR_OBJETO"));
                inv.setNomPro(x.getString("NOMBRE_EDIFICIO"));

                lista.add(inv);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    public ArrayList<InventarioListado> listarInventarioFiltro(int id) {

        ArrayList<InventarioListado> lista = new ArrayList<InventarioListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_inventario.id_inventario,tbl_inventario.nombre_objeto,tbl_inventario.desc_objeto,tbl_inventario.valor_objeto,tbl_inventario.id_dep,tbl_departamento.nombre_edificio from tbl_inventario \n" +
"JOIN tbl_departamento ON tbl_inventario.id_dep = tbl_departamento.id_dep WHERE tbl_inventario.id_dep = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                InventarioListado inv = new InventarioListado();

                inv.setIdInv(x.getInt("ID_INVENTARIO"));
                inv.setId_dep(x.getInt("ID_DEP"));
                inv.setNombre_inv(x.getString("NOMBRE_OBJETO"));
                inv.setDesc_inv(x.getString("DESC_OBJETO"));
                inv.setValor_inv(x.getInt("VALOR_OBJETO"));
                inv.setNomPro(x.getString("NOMBRE_EDIFICIO"));

                lista.add(inv);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }
    
    
}
