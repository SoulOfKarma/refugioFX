/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.reportes.ReporteGanancias;
import app.reportes.ReporteIngresos;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class ReportesIngresosController implements Initializable {

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
    
     //Declaracion de button
    @FXML
    private Button generarRep;
    
    //Declaracion de Datepicker
    @FXML
    private DatePicker dateInicio;
    @FXML
    private DatePicker dateTermino;
    
    //Variables
    @FXML 
    private void btnGenerarRep() throws ParseException
    {
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     Date fechaI;
     Date fechaT;
     String fechaInicio;
     String fechaTermino;
          try{
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
            rep.reporteIngresos(fechaInicio,fechaTermino);
            
            String val = "";
          }
          catch(Exception e)
          {
              System.out.println(""+e);
          }
          
       
    }
    
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
