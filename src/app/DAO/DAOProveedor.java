/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Departamento;
import app.negocio.Gasto;
import app.negocio.Proveedor;
import app.negocio.ServicioExtra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricar
 */
public class DAOProveedor {

    public String agregarProveedor(Proveedor pro) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_proveedor (NOM_PROV, RAZON_SOCIAL, SUCURSAL_PROV,RUT_PROV,DIREC_PROV,ID_COMUNA,CONTACTO_PROV,FONO_PROV,EMAIL_PROV) values (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, pro.getNombreProveedor());
            ps.setString(2, pro.getRazonSocialProveedor());
            ps.setString(3, pro.getSucursalProveedor());
            ps.setString(4, pro.getRutProveedor());
            ps.setString(5, pro.getDireccionProveedor());
            ps.setInt(6, pro.getIdComunaProveedor());
            ps.setString(7, pro.getNomContactoProveedor());
            ps.setString(8, pro.getTelefonoProveedor());
            ps.setString(9, pro.getEmailProveedor());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Proveedor Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String modificarProveedor(Proveedor pro) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_proveedor SET NOM_PROV = ?, RAZON_SOCIAL = ?, SUCURSAL_PROV = ?,RUT_PROV = ?,DIREC_PROV = ?,ID_COMUNA = ?,CONTACTO_PROV = ?,FONO_PROV = ?,EMAIL_PROV = ? where ID_PROV = ?");
            ps.setString(1, pro.getNombreProveedor());
            ps.setString(2, pro.getRazonSocialProveedor());
            ps.setString(3, pro.getSucursalProveedor());
            ps.setString(4, pro.getRutProveedor());
            ps.setString(5, pro.getDireccionProveedor());
            ps.setInt(6, pro.getIdComunaProveedor());
            ps.setString(7, pro.getNomContactoProveedor());
            ps.setString(8, pro.getTelefonoProveedor());
            ps.setString(9, pro.getEmailProveedor());
            ps.setInt(10, pro.getIdProveedor());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Proveedor Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String eliminarProveedor(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_proveedor where ID_PROV = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Proveedor Eliminado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList<Proveedor> listarProveedor() {

        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_proveedor");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(x.getInt("ID_PROV"));
                pro.setNombreProveedor(x.getString("NOM_PROV"));
                pro.setRazonSocialProveedor(x.getString("RAZON_SOCIAL"));
                pro.setSucursalProveedor(x.getString("SUCURSAL_PROV"));
                pro.setRutProveedor(x.getString("RUT_PROV"));
                pro.setDireccionProveedor(x.getString("DIREC_PROV"));
                pro.setIdComunaProveedor(x.getInt("ID_COMUNA"));
                pro.setNomContactoProveedor(x.getString("CONTACTO_PROV"));
                pro.setTelefonoProveedor(x.getString("FONO_PROV"));
                pro.setEmailProveedor(x.getString("EMAIL_PROV"));

                lista.add(pro);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }
    }

    public ArrayList<Proveedor> filtrolistarProveedor(int id) {

        ArrayList<Proveedor> lista = new ArrayList<Proveedor>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_proveedor WHERE ID_PROV = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(x.getInt("ID_PROV"));
                pro.setNombreProveedor(x.getString("NOM_PROV"));
                pro.setRazonSocialProveedor(x.getString("RAZON_SOCIAL"));
                pro.setSucursalProveedor(x.getString("SUCURSAL_PROV"));
                pro.setRutProveedor(x.getString("RUT_PROV"));
                pro.setDireccionProveedor(x.getString("DIREC_PROV"));
                pro.setIdComunaProveedor(x.getInt("ID_COMUNA"));
                pro.setNomContactoProveedor(x.getString("CONTACTO_PROV"));
                pro.setTelefonoProveedor(x.getString("FONO_PROV"));
                pro.setEmailProveedor(x.getString("EMAIL_PROV"));

                lista.add(pro);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }
    }

}
