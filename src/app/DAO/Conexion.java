/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ricar
 */
public class Conexion {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        
        if (cnx == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                cnx = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.176:32118/XE", "Portafolio", "Gonan");
                //cnx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "urefugio", "urefugio");
                //cnx = DriverManager.getConnection("jdbc:oracle:thin:@192.168.43.159:1521:xe", "urefugio", "urefugio");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public static Connection cerrar() throws SQLException {

        try {
            if (cnx != null) {
                
                cnx.close();
                cnx = null;
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return null;
    }
}
