/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAOUsuario;
import app.negocio.Arrendabilidad;
import app.negocio.IngresosEst;
import app.negocio.ProxReservas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.lang.Number;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class MenuPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stagePrincipal;
    private Refugio refu = new Refugio();

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML
    private void depMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.depMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
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
    private void invMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.invMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void menuPrincipal(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.menuPrincipal(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void usuariosMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.usuariosMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
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
    private void servExtraMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.servExtraMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void proveedoresMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.proveedoresMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void gastosMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.gastosMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void detalleGastoMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.detalleGastoMenu(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void cerrarSesion(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.cerrarSesion(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
// Declaracion de reservas label
    @FXML
    private Label proxRes1;
    @FXML
    private Label proxRes2;
    @FXML
    private Label proxRes3;
    @FXML
    private Label proxRes4;
    @FXML
    private Label proxRes5;

// Declaracion de barras
    @FXML
    private BarChart barReservas;
    @FXML
    private LineChart<String, Number> lineReserva;
    @FXML
    private BarChart barIngresos;

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    public void cargar() {

//        XYChart.Series<Number, Number> series = new XYChart.Series<>();
//        series.setName("No of schools in an year");
//
//        series.getData().add(new XYChart.Data<>(15, 1970));
//        series.getData().add(new XYChart.Data<>(30, 1980));
//        series.getData().add(new XYChart.Data<>(60, 1990));
//        series.getData().add(new XYChart.Data<>(120, 2000));
//        series.getData().add(new XYChart.Data<>(240, 2013));
//        series.getData().add(new XYChart.Data<>(300, 2014));
//        
//        lineReserva.getData().add(series);
//        DAOUsuario dao = new DAOUsuario();
//        ArrayList<ProxReservas> listaC = dao.listaProxReservas();
//        XYChart.Series<String, Number> series = new XYChart.Series<>();
//        series.setName("Proximas reservas");
        
        DAOUsuario dao = new DAOUsuario();
        ArrayList<Arrendabilidad> listaC = dao.listaPorcentajeArrendabilidad();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Porcentaje de Arrendabilidad");
        
        for(Arrendabilidad var : listaC)
        {
         series.getData().add(new XYChart.Data<>(var.getFecha(), var.getValorArrendabilidad()));
        }
        lineReserva.getData().add(series);
        
    }

    public void cargarEstadisticoProxRes() {
        DAOUsuario dao = new DAOUsuario();
        ArrayList<ProxReservas> listaC = dao.listaProxReservas();
        proxRes1.setText("");
        proxRes2.setText("");
        proxRes3.setText("");
        proxRes4.setText("");
        proxRes5.setText("");
        int count = 0;
        for (ProxReservas var : listaC) {
            count++;
            if (count == 1) {
                if(var.getFecha()!=null)
                {
                  proxRes1.setText("La proxima reserva es el: " + var.getFecha().toString());
                }
            } else if (count == 2) {
                if(var.getFecha()!=null)
                {
                  proxRes2.setText("La proxima reserva es el: " + var.getFecha().toString());
                }
            } else if (count == 3) {
                if(var.getFecha()!=null)
                {
                  proxRes3.setText("La proxima reserva es el: " + var.getFecha().toString());
                }
            } else if (count == 4) {
                if(var.getFecha()!=null)
                {
                  proxRes4.setText("La proxima reserva es el: " + var.getFecha().toString());
                }
            } else if (count == 5) {
                if(var.getFecha()!=null)
                {
                  proxRes5.setText("La proxima reserva es el: " + var.getFecha().toString());
                }
                
            }

        }

    }

    public void cargarEstadistico() {
        DAOUsuario dao = new DAOUsuario();
        ArrayList<IngresosEst> listaC = dao.listaIngresosPorAnio();

        XYChart.Series<String, Number> computadores = new XYChart.Series<>();
        computadores.setName("Ingresos");
//        computadores.getData().addAll(
//                new XYChart.Data<>("Enero", 1017),
//                new XYChart.Data<>("Marzo", 172),
//                new XYChart.Data<>("Mayo", 59),
//                new XYChart.Data<>("Julio", 285));

        for (IngresosEst var : listaC) {
            String mes = "";

            switch (var.getMeses()) {
                case 1:
                    mes = "Enero";
                    break;
                case 2:
                    mes = "Febrero";
                    break;
                case 3:
                    mes = "Marzo";
                    break;
                case 4:
                    mes = "Abril";
                    break;
                case 5:
                    mes = "Mayo";
                    break;
                case 6:
                    mes = "Junio";
                    break;
                case 7:
                    mes = "Julio";
                    break;
                case 8:
                    mes = "Agosto";
                    break;
                case 9:
                    mes = "Septiembre";
                    break;
                case 10:
                    mes = "Octubre";
                    break;
                case 11:
                    mes = "Noviembre";
                    break;
                case 12:
                    mes = "Diciembre";
                    break;
            }
            computadores.getData().add(new XYChart.Data<>(mes, var.getTotal()));
        }

        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        data.addAll(computadores);

        barIngresos.setData(data);

    }

    public void cargarEstadisticoR() {

        DAOUsuario dao = new DAOUsuario();
        ArrayList<IngresosEst> listaC = dao.ReservasPorAnio();

        XYChart.Series<String, Number> autos = new XYChart.Series<>();
        autos.setName("Reservas");
//        autos.getData().addAll(
//                new XYChart.Data<>("Enero", 358),
//                new XYChart.Data<>("Marzo", 54),
//                new XYChart.Data<>("Mayo", 50),
//                new XYChart.Data<>("Julio", 158));
        for (IngresosEst var : listaC) {
            String mes = "";

            switch (var.getMeses()) {
                case 1:
                    mes = "Enero";
                    break;
                case 2:
                    mes = "Febrero";
                    break;
                case 3:
                    mes = "Marzo";
                    break;
                case 4:
                    mes = "Abril";
                    break;
                case 5:
                    mes = "Mayo";
                    break;
                case 6:
                    mes = "Junio";
                    break;
                case 7:
                    mes = "Julio";
                    break;
                case 8:
                    mes = "Agosto";
                    break;
                case 9:
                    mes = "Septiembre";
                    break;
                case 10:
                    mes = "Octubre";
                    break;
                case 11:
                    mes = "Noviembre";
                    break;
                case 12:
                    mes = "Diciembre";
                    break;
            }
            autos.getData().add(new XYChart.Data<>(mes, var.getTotal()));
        }
        ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
        data.addAll(autos);

        barReservas.setData(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        cargarEstadistico();
        cargarEstadisticoProxRes();
        cargarEstadisticoR();
        cargar();
    }

}
