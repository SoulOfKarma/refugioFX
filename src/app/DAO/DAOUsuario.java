/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.DAO;

import app.negocio.Arrendabilidad;
import app.negocio.Inventario;
import app.negocio.Region;
import app.negocio.TipoUsuario;
import app.negocio.Empleado;
import app.negocio.Genero;
import app.negocio.IngresosEst;
import app.negocio.Nacionalidad;
import app.negocio.ProxReservas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Ricar
 */
public class DAOUsuario {

    Conexion con = new Conexion();

    public String agregarEmpleado(Empleado emp) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("insert into tbl_empleado (RUN_EMP, NOMBRE_EMP,APELLIDO_EMP,ID_GENERO,ID_NACIONALIDAD,EMAIL_EMP,PASS_EMP,DIREC_EMP,ID_COMUNA,FECHA_NAC_EMP,TEL_EMP,ESTADO_EMP,FOTO_PERFIL_EMP,SALARIO,ID_TIPO_EMP) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, emp.getRun_Empleado());
            ps.setString(2, emp.getNombre_Empleado());
            ps.setString(3, emp.getApellido_Empleado());
            ps.setInt(4, emp.getIdGenero());
            ps.setInt(5, emp.getIdNacionalidad());
            ps.setString(6, emp.getEmail_Empleado());
            ps.setString(7, emp.getPass_Empleado());
            ps.setString(8, emp.getDireccion_Empleado());
            ps.setInt(9, emp.getId_comuna());
            Date fecha = convertUtilToSql(emp.getFecha_nacimiento());
            ps.setDate(10, fecha);
            ps.setString(11, emp.getNumero_telefono());
            ps.setInt(12, emp.getEstado_usuario());
            ps.setString(13, emp.getFoto_usuario());
            ps.setInt(14, emp.getSalario_emp());
            ps.setInt(15, emp.getRol_usuario());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Empleado Agregado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String ModificarEmpleado(Empleado emp) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("UPDATE tbl_empleado SET RUN_EMP = ?, NOMBRE_EMP = ?,APELLIDO_EMP = ?,ID_GENERO = ?,ID_NACIONALIDAD = ?,EMAIL_EMP = ?,PASS_EMP = ?,DIREC_EMP = ?,ID_COMUNA = ?,FECHA_NAC_EMP = ?,TEL_EMP = ?,ESTADO_EMP = ?,FOTO_PERFIL_EMP = ?,SALARIO = ?,ID_TIPO_EMP = ? WHERE ID_EMPLEADO = ?");
            ps.setString(1, emp.getRun_Empleado());
            ps.setString(2, emp.getNombre_Empleado());
            ps.setString(3, emp.getApellido_Empleado());
            ps.setInt(4, emp.getIdGenero());
            ps.setInt(5, emp.getIdNacionalidad());
            ps.setString(6, emp.getEmail_Empleado());
            ps.setString(7, emp.getPass_Empleado());
            ps.setString(8, emp.getDireccion_Empleado());
            ps.setInt(9, emp.getId_comuna());
            Date fecha = convertUtilToSql(emp.getFecha_nacimiento());
            ps.setDate(10, fecha);
            ps.setString(11, emp.getNumero_telefono());
            ps.setInt(12, emp.getEstado_usuario());
            ps.setString(13, emp.getFoto_usuario());
            ps.setInt(14, emp.getSalario_emp());
            ps.setInt(15, emp.getRol_usuario());
            ps.setInt(16, emp.getIdEmpleado());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Empleado Modificado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String DesactivarEmpleado(Empleado emp) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("UPDATE tbl_empleado SET ESTADO_EMP = ? WHERE ID_EMPLEADO = ?");
            ps.setInt(1, emp.getEstado_usuario());
            ps.setInt(2, emp.getIdEmpleado());
            ResultSet x = ps.executeQuery();
            ps.close();
            conn = Conexion.cerrar();
            String mensaje = "Empleado Desactivado correctamente";
            return mensaje;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList<TipoUsuario> listarRol() {

        ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_tipo_empleado");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                TipoUsuario tipUsu = new TipoUsuario();
                int valor = x.getInt("ID_TIPO_EMP");
                if (valor != 102) {
                    tipUsu.setIdTipoUsuario(x.getInt("ID_TIPO_EMP"));
                    tipUsu.setDescripcionUsuario(x.getString("CARGO_TIPO_EMP"));

                    lista.add(tipUsu);
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

    public ArrayList<Genero> listarGenero() {

        ArrayList<Genero> lista = new ArrayList<Genero>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TBL_GENERO");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Genero gen = new Genero();

                gen.setIdGen(x.getInt("ID_GENERO"));
                gen.setDescripcion(x.getString("DESCRIPCION_GENERO"));

                lista.add(gen);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Nacionalidad> listarNacionalidad() {

        ArrayList<Nacionalidad> lista = new ArrayList<Nacionalidad>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TBL_NACIONALIDAD");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Nacionalidad nac = new Nacionalidad();

                nac.setIdNac(x.getInt("ID_NACIONALIDAD"));
                nac.setDescripcion(x.getString("NOMBRE_NACIONALIDAD"));

                lista.add(nac);

            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Empleado> listarUsuario() {

        ArrayList<Empleado> lista = new ArrayList<Empleado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_empleado");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                if (x.getInt("ESTADO_EMP") != 0) {
                    Empleado emp = new Empleado();
                    emp.setIdEmpleado(x.getInt("ID_EMPLEADO"));
                    emp.setRun_Empleado(x.getString("RUN_EMP"));
                    emp.setNombre_Empleado(x.getString("NOMBRE_EMP"));
                    emp.setApellido_Empleado(x.getString("APELLIDO_EMP"));
                    emp.setIdGenero(x.getInt("ID_GENERO"));
                    emp.setIdNacionalidad(x.getInt("ID_NACIONALIDAD"));
                    emp.setEmail_Empleado(x.getString("EMAIL_EMP"));
                    emp.setPass_Empleado(x.getString("PASS_EMP"));
                    emp.setDireccion_Empleado(x.getString("DIREC_EMP"));
                    emp.setId_comuna(x.getInt("ID_COMUNA"));
                    emp.setFecha_nacimiento(x.getDate("FECHA_NAC_EMP"));
                    emp.setNumero_telefono(x.getString("TEL_EMP"));
                    emp.setEstado_usuario(x.getInt("ESTADO_EMP"));
                    emp.setFoto_usuario(x.getString("FOTO_PERFIL_EMP"));
                    emp.setSalario_emp(x.getInt("SALARIO"));
                    emp.setRol_usuario(x.getInt("ID_TIPO_EMP"));
                    lista.add(emp);
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

    public ArrayList<Empleado> buscarPorRut(String emps) {

        ArrayList<Empleado> lista = new ArrayList<Empleado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_empleado where RUN_EMP = ?");
            ps.setString(1, emps);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(x.getInt("ID_EMPLEADO"));
                emp.setRun_Empleado(x.getString("RUN_EMP"));
                emp.setNombre_Empleado(x.getString("NOMBRE_EMP"));
                emp.setApellido_Empleado(x.getString("APELLIDO_EMP"));
                emp.setIdGenero(x.getInt("ID_GENERO"));
                emp.setIdNacionalidad(x.getInt("ID_NACIONALIDAD"));
                emp.setEmail_Empleado(x.getString("EMAIL_EMP"));
                emp.setPass_Empleado(x.getString("PASS_EMP"));
                emp.setDireccion_Empleado(x.getString("DIREC_EMP"));
                emp.setId_comuna(x.getInt("ID_COMUNA"));
                emp.setFecha_nacimiento(x.getDate("FECHA_NAC_EMP"));
                emp.setNumero_telefono(x.getString("TEL_EMP"));
                emp.setEstado_usuario(x.getInt("ESTADO_EMP"));
                emp.setFoto_usuario(x.getString("FOTO_PERFIL_EMP"));
                emp.setSalario_emp(x.getInt("SALARIO"));
                emp.setRol_usuario(x.getInt("ID_TIPO_EMP"));
                lista.add(emp);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Empleado> filtrarPorTipodeEmpleado(int id) {

        ArrayList<Empleado> lista = new ArrayList<Empleado>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = Conexion.obtener();
            // Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_empleado where ID_TIPO_EMP = ?");
            ps.setInt(1, id);
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(x.getInt("ID_EMPLEADO"));
                emp.setRun_Empleado(x.getString("RUN_EMP"));
                emp.setNombre_Empleado(x.getString("NOMBRE_EMP"));
                emp.setApellido_Empleado(x.getString("APELLIDO_EMP"));
                emp.setIdGenero(x.getInt("ID_GENERO"));
                emp.setIdNacionalidad(x.getInt("ID_NACIONALIDAD"));
                emp.setEmail_Empleado(x.getString("EMAIL_EMP"));
                emp.setPass_Empleado(x.getString("PASS_EMP"));
                emp.setDireccion_Empleado(x.getString("DIREC_EMP"));
                emp.setId_comuna(x.getInt("ID_COMUNA"));
                emp.setFecha_nacimiento(x.getDate("FECHA_NAC_EMP"));
                emp.setNumero_telefono(x.getString("TEL_EMP"));
                emp.setEstado_usuario(x.getInt("ESTADO_EMP"));
                emp.setFoto_usuario(x.getString("FOTO_PERFIL_EMP"));
                emp.setSalario_emp(x.getInt("SALARIO"));
                emp.setRol_usuario(x.getInt("ID_TIPO_EMP"));
                lista.add(emp);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<IngresosEst> listaIngresosPorAnio() {

        ArrayList<IngresosEst> lista = new ArrayList<IngresosEst>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = con.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select to_number(to_char(trunc(tbl_boleta.fecha_boleta), 'mm')) as mes,sum(tbl_boleta.total_boleta) AS TOTALMES from tbl_boleta \n"
                    + "JOIN tbl_tipo_pago ON tbl_boleta.id_tipo_pago=tbl_tipo_pago.id_tipo_pago\n"
                    + "WHERE tbl_boleta.fecha_boleta >= ADD_MONTHS(SYSDATE, -12)\n"
                    + "GROUP BY to_number(to_char(trunc(tbl_boleta.fecha_boleta), 'mm'))");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                IngresosEst ingE = new IngresosEst();
                ingE.setMeses(x.getInt("mes"));
                ingE.setTotal(x.getInt("TOTALMES"));

                lista.add(ingE);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<ProxReservas> listaProxReservas() {

        ArrayList<ProxReservas> lista = new ArrayList<ProxReservas>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = con.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT to_number(to_char(trunc(FECHA_RESERVA), 'mm')) as mes,FECHA_RESERVA FROM TBL_RESERVA WHERE FECHA_RESERVA > SYSDATE");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                ProxReservas proxR = new ProxReservas();
                proxR.setMes(x.getInt("mes"));
                proxR.setFecha(x.getDate("FECHA_RESERVA"));
                lista.add(proxR);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<IngresosEst> ReservasPorAnio() {

        ArrayList<IngresosEst> lista = new ArrayList<IngresosEst>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = con.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select to_number(to_char(trunc(fecha_reserva), 'mm')) as mes,count(to_number(to_char(trunc(fecha_reserva), 'mm'))) as reserva\n"
                    + "from tbl_reserva\n"
                    + "WHERE fecha_reserva >= ADD_MONTHS(SYSDATE, -12)\n"
                    + "GROUP BY to_number(to_char(trunc(fecha_reserva), 'mm'))");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                IngresosEst ingE = new IngresosEst();
                ingE.setMeses(x.getInt("mes"));
                ingE.setTotal(x.getInt("reserva"));

                lista.add(ingE);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Empleado> validacionLogin(String correo) {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = con.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tbl_empleado where EMAIL_EMP = ?");
            ps.setString(1, correo);

            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(x.getInt("ID_EMPLEADO"));
                emp.setRun_Empleado(x.getString("RUN_EMP"));
                emp.setNombre_Empleado(x.getString("NOMBRE_EMP"));
                emp.setApellido_Empleado(x.getString("APELLIDO_EMP"));
                emp.setIdGenero(x.getInt("ID_GENERO"));
                emp.setIdNacionalidad(x.getInt("ID_NACIONALIDAD"));
                emp.setEmail_Empleado(x.getString("EMAIL_EMP"));
                emp.setPass_Empleado(x.getString("PASS_EMP"));
                emp.setDireccion_Empleado(x.getString("DIREC_EMP"));
                emp.setId_comuna(x.getInt("ID_COMUNA"));
                emp.setFecha_nacimiento(x.getDate("FECHA_NAC_EMP"));
                emp.setNumero_telefono(x.getString("TEL_EMP"));
                emp.setEstado_usuario(x.getInt("ESTADO_EMP"));
                emp.setFoto_usuario(x.getString("FOTO_PERFIL_EMP"));
                emp.setSalario_emp(x.getInt("SALARIO"));
                emp.setRol_usuario(x.getInt("ID_TIPO_EMP"));
                lista.add(emp);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    public ArrayList<Arrendabilidad> listaPorcentajeArrendabilidad() {

        ArrayList<Arrendabilidad> lista = new ArrayList<Arrendabilidad>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = con.obtener();
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            PreparedStatement ps = conn.prepareStatement("select to_char(tbl_reserva.fec_ini_res,'DAY') as DIASEMANA,round((COUNT(to_number(to_char(trunc(tbl_reserva.fec_ini_res), 'mm')))/(Select count(id_dep) as a from tbl_departamento))*100) as Arrendabilidad from tbl_reserva JOIN tbl_departamento\n"
                    + "ON tbl_reserva.id_dep = tbl_departamento.id_dep\n"
                    + "WHERE tbl_reserva.fec_ini_res between trunc(sysdate) AND trunc(sysdate +7)\n"
                    + "GROUP BY tbl_reserva.fec_ini_res ORDER BY tbl_reserva.fec_ini_res");
            ResultSet x = ps.executeQuery();
            while (x.next()) {
                Arrendabilidad arre = new Arrendabilidad();
                arre.setFecha(x.getString("DIASEMANA"));
                arre.setValorArrendabilidad(x.getInt("Arrendabilidad"));

                lista.add(arre);
            }
            ps.close();
            conn = Conexion.cerrar();
            return lista;

        } catch (Exception e) {
            String men = e.getMessage();
            return lista;
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
