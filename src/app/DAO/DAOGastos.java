/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Departamento;
import app.negocio.Gasto;
import app.negocio.GastoListado;
import app.negocio.Region;
import app.negocio.TipoGasto;
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
public class DAOGastos {

    public ArrayList<TipoGasto> listarTipoGastos() {

        ArrayList<TipoGasto> lista = new ArrayList<TipoGasto>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_tipo_gasto");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                TipoGasto tipGas = new TipoGasto();

                tipGas.setIdTipoGasto(x.getInt("ID_TIPO_GASTO"));
                tipGas.setNombreTipoGasto(x.getString("NOMB_TIPO_GASTO"));

                lista.add(tipGas);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<GastoListado> listarGastos() {

        ArrayList<GastoListado> lista = new ArrayList<GastoListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_gastos_departamento.id_gasto,tbl_gastos_departamento.nombre_gasto,tbl_tipo_gasto.nomb_tipo_gasto from tbl_gastos_departamento \n"
                    + "JOIN tbl_tipo_gasto ON tbl_gastos_departamento.id_tipo_gasto = tbl_tipo_gasto.id_tipo_gasto");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                GastoListado gas = new GastoListado();

                gas.setIdGasto(x.getInt("ID_GASTO"));
                gas.setNombreGasto(x.getString("NOMBRE_GASTO"));
                gas.setNombreTipoGasto(x.getString("nomb_tipo_gasto"));

                lista.add(gas);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<GastoListado> filtrarlistarGastos(int id) {

        ArrayList<GastoListado> lista = new ArrayList<GastoListado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select tbl_gastos_departamento.id_gasto,tbl_gastos_departamento.nombre_gasto,tbl_tipo_gasto.nomb_tipo_gasto from tbl_gastos_departamento \n"
                    + "JOIN tbl_tipo_gasto ON tbl_gastos_departamento.id_tipo_gasto = tbl_tipo_gasto.id_tipo_gasto WHERE tbl_gastos_departamento.id_tipo_gasto = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                GastoListado gas = new GastoListado();

                gas.setIdGasto(x.getInt("ID_GASTO"));
                gas.setNombreGasto(x.getString("NOMBRE_GASTO"));
                gas.setNombreTipoGasto(x.getString("nomb_tipo_gasto"));

                lista.add(gas);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public String agregarGasto(Gasto gas) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_gastos_departamento (NOMBRE_GASTO, ID_TIPO_GASTO) values (?,?)");
            ps.setString(1, gas.getNombreGasto());
            ps.setInt(2, gas.getIdTipoGasto());

            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Gasto Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String modificarGasto(Gasto gas) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("update tbl_gastos_departamento SET NOMBRE_GASTO = ?, ID_TIPO_GASTO = ? where ID_GASTO = ?");
            ps.setString(1, gas.getNombreGasto());
            ps.setInt(2, gas.getIdTipoGasto());
            ps.setInt(3, gas.getIdGasto());

            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Gasto Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String eliminarGasto(int id) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM tbl_gastos_departamento where ID_GASTO = ?");
            ps.setInt(1, id);

            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Gasto Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
