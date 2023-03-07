/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Gasto;
import app.negocio.Proveedor;
import app.negocio.ServExtraListado;
import app.negocio.ServicioExtra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ricar
 */
public class DAOServicioExtra {

    public String agregarServicioExtra(ServicioExtra serExt) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_servicio_extra (NOM_SERV_EXT, PRECIO_SERV_EXT,ID_PROV) values (?,?,?)");
            ps.setString(1, serExt.getNombreServExtra());
            ps.setInt(2, serExt.getPrecioServExtra());
            ps.setInt(3, serExt.getIdProveedor());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Servicio Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String modificarServicioExtra(ServicioExtra serExt) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_servicio_extra SET NOM_SERV_EXT = ?, PRECIO_SERV_EXT = ?,ID_PROV = ? where ID_SERV_EXT = ?");
            ps.setString(1, serExt.getNombreServExtra());
            ps.setInt(2, serExt.getPrecioServExtra());
            ps.setInt(3, serExt.getIdProveedor());
            ps.setInt(4, serExt.getIdServExtra());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Servicio Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String eliminarServicioExtra(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_servicio_extra where ID_SERV_EXT = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Servicio eliminado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList<Gasto> listarGasto() {

        ArrayList<Gasto> lista = new ArrayList<Gasto>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_gastos_departamento");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Gasto gas = new Gasto();
                gas.setIdGasto(x.getInt("ID_GASTO"));
                gas.setNombreGasto(x.getString("NOMBRE_GASTO"));
                gas.setIdTipoGasto(x.getInt("ID_TIPO_GASTO"));

                lista.add(gas);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }
    }

    public ArrayList<ServExtraListado> listarServicioExtra() {

        ArrayList<ServExtraListado> lista = new ArrayList<ServExtraListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_servicio_extra.id_serv_ext,tbl_servicio_extra.nom_serv_ext,tbl_servicio_extra.precio_serv_ext,tbl_proveedor.nom_prov from tbl_servicio_extra\n"
                    + "JOIN tbl_proveedor ON tbl_servicio_extra.id_prov = tbl_proveedor.id_prov");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                ServExtraListado servExt = new ServExtraListado();
                servExt.setIdServExtra(x.getInt("ID_SERV_EXT"));
                servExt.setNombreServExtra(x.getString("NOM_SERV_EXT"));
                servExt.setPrecioServExtra(x.getInt("PRECIO_SERV_EXT"));
                servExt.setNomProv(x.getString("NOM_PROV"));
                lista.add(servExt);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }
    }

    public ArrayList<ServExtraListado> filtrolistarServicioExtra(int id) {

        ArrayList<ServExtraListado> lista = new ArrayList<ServExtraListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_servicio_extra.id_serv_ext,tbl_servicio_extra.nom_serv_ext,tbl_servicio_extra.precio_serv_ext,tbl_proveedor.nom_prov from tbl_servicio_extra\n"
                    + "JOIN tbl_proveedor ON tbl_servicio_extra.id_prov = tbl_proveedor.id_prov WHERE tbl_servicio_extra.id_serv_ext = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                ServExtraListado servExt = new ServExtraListado();
                servExt.setIdServExtra(x.getInt("ID_SERV_EXT"));
                servExt.setNombreServExtra(x.getString("NOM_SERV_EXT"));
                servExt.setPrecioServExtra(x.getInt("PRECIO_SERV_EXT"));
                servExt.setNomProv(x.getString("NOM_PROV"));
                lista.add(servExt);

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
