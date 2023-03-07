/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOProveedor;
import app.DAO.DAOServicioExtra;
import app.negocio.Departamento;
import app.negocio.Gasto;
import app.negocio.Proveedor;
import app.negocio.Region;
import app.negocio.ServExtraListado;
import app.negocio.ServicioExtra;
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
public class ServicioExtraController implements Initializable {

    /**
     * Initializes the controller class.
     */
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

    //Declaracion de TextField
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;

    //Declaracion de ComboBox
    @FXML
    private ComboBox<Proveedor> cbProveedor;
    @FXML
    private ComboBox<ServExtraListado> cbServicioExtra;

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

    //Declaracion de tabla y columnas
    @FXML
    private TableView<ServExtraListado> tablaServicio;
    @FXML
    private TableColumn idServ;
    @FXML
    private TableColumn nomServ;
    @FXML
    private TableColumn preServ;
    @FXML
    private TableColumn idPro;
    ObservableList<ServExtraListado> servicioExtra;

    //Declaracion de Label y adicionales
    @FXML
    private Label lbServExtra;
    private int posicionServicioExtraTabla;

    @FXML
    private void btnAgregar() {
        DAOServicioExtra dao = new DAOServicioExtra();
        ServicioExtra servExt = new ServicioExtra();

        try {
            if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || cbProveedor.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe llenar todos los campos");
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
                servExt.setNombreServExtra(txtNombre.getText());
                servExt.setPrecioServExtra(Integer.parseInt(txtPrecio.getText()));
                servExt.setIdProveedor(cbProveedor.getValue().getIdProveedor());
                dao.agregarServicioExtra(servExt);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Servicio Extra ingresado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaServicioExtra();
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    @FXML
    private void btnModificar() {
        DAOServicioExtra dao = new DAOServicioExtra();
        ServicioExtra servExt = new ServicioExtra();

        try {
            if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()
                    || cbProveedor.getValue() == null || lbServExtra.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe seleccionar algun dato de la tabla a modificar y llenar los campos requeridos");
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
                servExt.setNombreServExtra(txtNombre.getText());
                servExt.setPrecioServExtra(Integer.parseInt(txtPrecio.getText()));
                servExt.setIdProveedor(cbProveedor.getValue().getIdProveedor());
                servExt.setIdServExtra(Integer.parseInt(lbServExtra.getText()));
                dao.modificarServicioExtra(servExt);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Servicio Extra modificado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaServicioExtra();
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    @FXML
    private void btnEliminar() {

        DAOServicioExtra dao = new DAOServicioExtra();

        try {
            if (lbServExtra.getText().isEmpty()) {
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
                int id = Integer.parseInt(lbServExtra.getText());
                dao.eliminarServicioExtra(id);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Servicio Extra eliminado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaServicioExtra();
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

    }

    @FXML
    private void btnLimpiar() {

        txtNombre.setText("");
        txtPrecio.setText("");
        lbServExtra.setText("");
        cargarProveedores();
        

    }

    @FXML
    private void filtroServExt() {
        try {
            if (cbServicioExtra.getValue().getIdServExtra() != 0) {
                int id = cbServicioExtra.getValue().getIdServExtra();
                idServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, Integer>("idServExtra"));
                nomServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, String>("nombreServExtra"));
                preServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, Integer>("precioServExtra"));
                idPro.setCellValueFactory(new PropertyValueFactory<ServExtraListado, String>("nomProv"));

                servicioExtra = FXCollections.observableArrayList(filtrolistaSE(id));
                tablaServicio.setItems(servicioExtra);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @FXML
    private void btnCargarTodo() {
        iniciarlizarTablaServicioExtra();
    }

    private List listaSE() {
        DAOServicioExtra dao = new DAOServicioExtra();

        ArrayList<ServExtraListado> listaR = dao.listarServicioExtra();

        return listaR;
    }
    
    private List filtrolistaSE(int id) {
        DAOServicioExtra dao = new DAOServicioExtra();

        ArrayList<ServExtraListado> listaR = dao.filtrolistarServicioExtra(id);

        return listaR;
    }

    private List listaP() {
        DAOProveedor dao = new DAOProveedor();

        ArrayList<Proveedor> listaR = dao.listarProveedor();

        return listaR;
    }

    ObservableList<Proveedor> listP = FXCollections.observableArrayList(listaP());
    ObservableList<ServicioExtra> listSE = FXCollections.observableArrayList(listaSE());

    private void iniciarlizarTablaServicioExtra() {
        idServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, Integer>("idServExtra"));
        nomServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, String>("nombreServExtra"));
        preServ.setCellValueFactory(new PropertyValueFactory<ServExtraListado, Integer>("precioServExtra"));
        idPro.setCellValueFactory(new PropertyValueFactory<ServExtraListado, String>("nomProv"));

        servicioExtra = FXCollections.observableArrayList(listaSE());
        tablaServicio.setItems(servicioExtra);

    }

    private void cargarProveedores() {
        cbProveedor.setItems(listP);

        //Conversor de regiones
        StringConverter<Proveedor> converterR = new StringConverter<Proveedor>() {
            @Override
            public String toString(Proveedor pro) {
                return pro.getNombreProveedor();
            }

            @Override
            public Proveedor fromString(String id) {
                int ids = Integer.parseInt(id);
                return listP.stream()
                        .filter(item -> item.getIdProveedor() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbProveedor.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbProveedor.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbProveedor.getValue().getNombreProveedor());
        });

    }

    private void cargarServExtra() {
        ObservableList<ServExtraListado> listSEL = FXCollections.observableArrayList(listaSE());
        cbServicioExtra.setItems(listSEL);

        //Conversor de regiones
        StringConverter<ServExtraListado> converterR = new StringConverter<ServExtraListado>() {
            @Override
            public String toString(ServExtraListado pro) {
                return pro.getNombreServExtra();
            }

            @Override
            public ServExtraListado fromString(String id) {
                int ids = Integer.parseInt(id);
                return listSEL.stream()
                        .filter(item -> item.getIdServExtra() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbServicioExtra.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbServicioExtra.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbServicioExtra.getValue().getNombreServExtra());
        });

    }

    private final ListChangeListener<ServExtraListado> selectorTablaServExtra = new ListChangeListener<ServExtraListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends ServExtraListado> c) {
            ponerServExtraSeleccionado();
        }
    };

    public ServExtraListado getTablaServicioExtraSeleccionado() {
        if (tablaServicio != null) {
            List<ServExtraListado> tabla = tablaServicio.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final ServExtraListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }

    public void ponerServExtraSeleccionado() {
        final ServExtraListado serExtra = getTablaServicioExtraSeleccionado();
        posicionServicioExtraTabla = servicioExtra.indexOf(serExtra);
        if (serExtra != null) {
            lbServExtra.setText(Integer.toString(serExtra.getIdServExtra()));
            txtNombre.setText(serExtra.getNombreServExtra());
            txtPrecio.setText(Integer.toString(serExtra.getPrecioServExtra()));

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarProveedores();
        cargarServExtra();
        this.iniciarlizarTablaServicioExtra();
        final ObservableList<ServExtraListado> tablaServExtSel = tablaServicio.getSelectionModel().getSelectedItems();
        tablaServExtSel.addListener(selectorTablaServExtra);
    }

}
