/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOGastos;
import app.negocio.Departamento;
import app.negocio.Gasto;
import app.negocio.GastoListado;
import app.negocio.Region;
import app.negocio.TipoGasto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class GastosController implements Initializable {
    
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
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnCargarTodo;

    //Declaracion de combobox
    @FXML
    private ComboBox<TipoGasto> cbTipoGasto;
    @FXML
    private ComboBox<TipoGasto> cbFiltroTipoG;

    //Declaracion de TextBox
    @FXML
    private TextField txtGasto;

    //Declaracion de tabla y columnas
    @FXML
    private TableView<GastoListado> tableGasto;
    @FXML
    private TableColumn idGasto;
    @FXML
    private TableColumn nomGasto;
    @FXML
    private TableColumn tipoGasto;
    ObservableList<GastoListado> gasto;

    //Declaracion de label para ID
    @FXML
    private Label lbIdGasto;
    private int posicionDepartamentoEnTabla;
    //Metodos

    @FXML
    private void btnAgregar() {
        DAOGastos dao = new DAOGastos();
        Gasto gas = new Gasto();
        
        if (txtGasto.getText().isEmpty() || cbTipoGasto.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe llenar todos lo campos");
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
            gas.setNombreGasto(txtGasto.getText());
            gas.setIdTipoGasto(cbTipoGasto.getValue().getIdTipoGasto());
            
            dao.agregarGasto(gas);
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerta");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Gasto ingresado correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            cargarTipoGasto();
            cargarfiltroGasto();
            iniciarlizarTablaGasto();
        }
        
    }
    
    @FXML
    private void btnModificar() {
        DAOGastos dao = new DAOGastos();
        Gasto gas = new Gasto();
        
        if (txtGasto.getText().isEmpty() || cbTipoGasto.getValue() == null || lbIdGasto.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe selecionar un dato de la tabla para poder modificar sus datos");
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
            gas.setIdGasto(Integer.parseInt(lbIdGasto.getText()));
            gas.setNombreGasto(txtGasto.getText());
            gas.setIdTipoGasto(cbTipoGasto.getValue().getIdTipoGasto());
            
            dao.modificarGasto(gas);
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerta");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Gasto modificado correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            cargarTipoGasto();
            cargarfiltroGasto();
            iniciarlizarTablaGasto();
        }
    }
    
    @FXML
    private void btnEliminar() {
        
        DAOGastos dao = new DAOGastos();
        
        if (lbIdGasto.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe seleccionar algun dato de la tabla para poder eliminarla");
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
            int id = Integer.parseInt(lbIdGasto.getText());
            
            dao.eliminarGasto(id);
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alerta");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Gasto eliminado correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            cargarTipoGasto();
            cargarfiltroGasto();
            iniciarlizarTablaGasto();
        }
        
    }
    
    @FXML
    private void btnLimpiar() {
        
        txtGasto.setText("");
        lbIdGasto.setText("");
        cargarTipoGasto();
    }
    
    @FXML
    private void btnCargarTodo() {
        iniciarlizarTablaGasto();
    }
    
    @FXML
    private void filtroTipoG() {
        try {
            
            if (cbFiltroTipoG.getValue().getIdTipoGasto()!= 0) {
                int id = cbFiltroTipoG.getValue().getIdTipoGasto();
                idGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, Integer>("idGasto"));
                nomGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, String>("nombreGasto"));
                tipoGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, String>("nombreTipoGasto"));
                
                gasto = FXCollections.observableArrayList(fitrolistaG(id));
                tableGasto.setItems(gasto);
            }
            
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    private List listaTG() {
        DAOGastos dao = new DAOGastos();
        
        ArrayList<TipoGasto> listaR = dao.listarTipoGastos();
        
        return listaR;
    }
    
    private List listaG() {
        DAOGastos dao = new DAOGastos();
        
        ArrayList<GastoListado> listaR = dao.listarGastos();
        
        return listaR;
    }
    
    private List fitrolistaG(int id) {
        DAOGastos dao = new DAOGastos();
        
        ArrayList<GastoListado> listaR = dao.filtrarlistarGastos(id);
        
        return listaR;
    }
    
    ObservableList<TipoGasto> listTG = FXCollections.observableArrayList(listaTG());
    
    private void iniciarlizarTablaGasto() {
        idGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, Integer>("idGasto"));
        nomGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, String>("nombreGasto"));
        tipoGasto.setCellValueFactory(new PropertyValueFactory<GastoListado, String>("nombreTipoGasto"));
        
        gasto = FXCollections.observableArrayList(listaG());
        tableGasto.setItems(gasto);
        
    }
    
    private void cargarTipoGasto() {
        cbTipoGasto.setItems(listTG);

        //Conversor de regiones
        StringConverter<TipoGasto> converterR = new StringConverter<TipoGasto>() {
            @Override
            public String toString(TipoGasto reg) {
                return reg.getNombreTipoGasto();
            }
            
            @Override
            public TipoGasto fromString(String id) {
                int ids = Integer.parseInt(id);
                return listTG.stream()
                        .filter(item -> item.getIdTipoGasto() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbTipoGasto.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbTipoGasto.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbTipoGasto.getValue().getNombreTipoGasto());
        });
        
    }
    
    private void cargarfiltroGasto() {
        
        cbFiltroTipoG.setItems(listTG);

        //Conversor de regiones
        StringConverter<TipoGasto> converterR = new StringConverter<TipoGasto>() {
            @Override
            public String toString(TipoGasto reg) {
                return reg.getNombreTipoGasto();
            }
            
            @Override
            public TipoGasto fromString(String id) {
                int ids = Integer.parseInt(id);
                return listTG.stream()
                        .filter(item -> item.getIdTipoGasto() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbFiltroTipoG.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbFiltroTipoG.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFiltroTipoG.getValue().getNombreTipoGasto());
        });
    }
    
    private final ListChangeListener<GastoListado> selectorTablaGasto = new ListChangeListener<GastoListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends GastoListado> c) {
            ponerGastoSeleccionado();
        }
    };
    
    public GastoListado getTablaGastoSeleccionado() {
        if (tableGasto != null) {
            List<GastoListado> tabla = tableGasto.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final GastoListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }
    
    public void ponerGastoSeleccionado() {
        final GastoListado gas = getTablaGastoSeleccionado();
        posicionDepartamentoEnTabla = gasto.indexOf(gas);
        if (gas != null) {
            txtGasto.setText(gas.getNombreGasto());
            lbIdGasto.setText(Integer.toString(gas.getIdGasto()));
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTipoGasto();
        cargarfiltroGasto();
        this.iniciarlizarTablaGasto();
        final ObservableList<GastoListado> tablaGasSel = tableGasto.getSelectionModel().getSelectedItems();
        tablaGasSel.addListener(selectorTablaGasto);
    }
    
}
