/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.reportes.ClienteFrecuente;
import app.reportes.DepartamentoMasArrendado;
import app.reportes.ReporteGanancias;
import app.reportes.ReporteIngresos;
import app.reportes.ReportesGastos;
import com.jfoenix.controls.JFXDatePicker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class ReportesController implements Initializable {

    private Stage stagePrincipal;
    private Refugio refu = new Refugio();
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }
    
    

    
      @FXML
    private void depMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.depMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
    @FXML
    private void cargarFotosDep(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.cargarFotosDep(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    
    @FXML
    private void invMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.invMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
    @FXML
    private void menuPrincipal(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.menuPrincipal(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
     @FXML
    private void usuariosMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.usuariosMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
    @FXML
    private void reportesMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.reportesMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
    
    @FXML
    private void servExtraMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.servExtraMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
     @FXML
    private void proveedoresMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.proveedoresMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
     @FXML
    private void gastosMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.gastosMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
    @FXML
    private void detalleGastoMenu(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.detalleGastoMenu(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
    
    @FXML
    private void cerrarSesion(Event event) throws IOException{
        try{
            System.out.println("You clicked me!");
         refu.cerrarSesion(event);

        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }

    //Declaracion de botones
    @FXML
    private Button btnGanancias;
    @FXML
    private Button btnGastos;
    @FXML
    private Button btnIngresos;
    @FXML
    private Button btnDeptoArrendado;
    @FXML
    private Button btnClientes;

    //Declaracion de datepicker
    @FXML
    private JFXDatePicker dateInicio;
    @FXML
    private JFXDatePicker dateTermino;

    //Metodos
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @FXML
    private void btnGanancias(Event event) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI;
        Date fechaT;
        String fechaInicio;
        String fechaTermino;

        try {
            if (dateInicio.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha inicial");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (dateTermino.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha de Termino.");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else {
                java.sql.Date fecI = java.sql.Date.valueOf(dateInicio.getValue());

                fechaInicio = formatter.format(fecI);
                fechaI = convertUtilToSql(formatter.parse(fechaInicio));
                //fechaI = formatter.parse(fechaFormateada);
                // fechaI = convertUtilToSql(fechaI);
                java.sql.Date fecT = java.sql.Date.valueOf(dateTermino.getValue());
                //fechaT = new java.util.Date(fecT.getTime());
                fechaTermino = formatter.format(fecT);
                fechaT = convertUtilToSql(formatter.parse(fechaTermino));
                ReporteGanancias rep = new ReporteGanancias();
                rep.reporteUtilidades(fechaI, fechaT);
            }

            String val = "";
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    private void btnGastos(Event event) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI;
        Date fechaT;
        String fechaInicio;
        String fechaTermino;
        try {
            if (dateInicio.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha inicial");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (dateTermino.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha de Termino.");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            }
            java.sql.Date fecI = java.sql.Date.valueOf(dateInicio.getValue());
            fechaInicio = formatter.format(fecI);
            fechaI = convertUtilToSql(formatter.parse(fechaInicio));
            //fechaI = formatter.parse(fechaFormateada);
            // fechaI = convertUtilToSql(fechaI);
            java.sql.Date fecT = java.sql.Date.valueOf(dateTermino.getValue());
            //fechaT = new java.util.Date(fecT.getTime());
            fechaTermino = formatter.format(fecT);
            fechaT = convertUtilToSql(formatter.parse(fechaTermino));
            ReportesGastos rep = new ReportesGastos();
            rep.reporteGastos(fechaInicio, fechaTermino);

            String val = "";
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    private void btnIngresos(Event event) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI;
        Date fechaT;
        String fechaInicio;
        String fechaTermino;
        try {
            if (dateInicio.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha inicial");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (dateTermino.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha de Termino.");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            }
            java.sql.Date fecI = java.sql.Date.valueOf(dateInicio.getValue());
            fechaInicio = formatter.format(fecI);
            fechaI = convertUtilToSql(formatter.parse(fechaInicio));
            //fechaI = formatter.parse(fechaFormateada);
            // fechaI = convertUtilToSql(fechaI);
            java.sql.Date fecT = java.sql.Date.valueOf(dateTermino.getValue());
            //fechaT = new java.util.Date(fecT.getTime());
            fechaTermino = formatter.format(fecT);
            fechaT = convertUtilToSql(formatter.parse(fechaTermino));
            ReporteIngresos rep = new ReporteIngresos();
            rep.reporteIngresos(fechaInicio, fechaTermino);

            String val = "";
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    private void btnDeptoArrendado(Event event) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI;
        Date fechaT;
        String fechaInicio;
        String fechaTermino;
        try {
            if (dateInicio.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha inicial");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (dateTermino.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha de Termino.");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            }
            java.sql.Date fecI = java.sql.Date.valueOf(dateInicio.getValue());
            fechaInicio = formatter.format(fecI);
            fechaI = convertUtilToSql(formatter.parse(fechaInicio));
            //fechaI = formatter.parse(fechaFormateada);
            // fechaI = convertUtilToSql(fechaI);
            java.sql.Date fecT = java.sql.Date.valueOf(dateTermino.getValue());
            //fechaT = new java.util.Date(fecT.getTime());
            fechaTermino = formatter.format(fecT);
            fechaT = convertUtilToSql(formatter.parse(fechaTermino));
            DepartamentoMasArrendado rep = new DepartamentoMasArrendado();
            rep.reporteDepArrendado(fechaI,fechaT);

            String val = "";
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    private void btnClientes(Event event) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaI;
        Date fechaT;
        String fechaInicio;
        String fechaTermino;
        try {
            if (dateInicio.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha inicial");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (dateTermino.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Seleccione la fecha de Termino.");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            }
            java.sql.Date fecI = java.sql.Date.valueOf(dateInicio.getValue());
            fechaInicio = formatter.format(fecI);
            fechaI = convertUtilToSql(formatter.parse(fechaInicio));
            //fechaI = formatter.parse(fechaFormateada);
            // fechaI = convertUtilToSql(fechaI);
            java.sql.Date fecT = java.sql.Date.valueOf(dateTermino.getValue());
            //fechaT = new java.util.Date(fecT.getTime());
            fechaTermino = formatter.format(fecT);
            fechaT = convertUtilToSql(formatter.parse(fechaTermino));
            ClienteFrecuente rep = new ClienteFrecuente();
            rep.reporteClientes(fechaI,fechaT);

            String val = "";
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
