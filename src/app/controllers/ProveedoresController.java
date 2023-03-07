/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOProveedor;
import app.negocio.Comuna;
import app.negocio.Departamento;
import app.negocio.Proveedor;
import app.negocio.Provincia;
import app.negocio.Region;
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
public class ProveedoresController implements Initializable {

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

    //Declaracion TextField
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRazonSocial;
    @FXML
    private TextField txtSucursal;
    @FXML
    private TextField txtRutEmpresa;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtConProveedor;
    @FXML
    private TextField txtFono;
    @FXML
    private TextField txtEmailProveedor;

    // Declaracion General
    @FXML
    private Label lbIDProveedor;
    private int posicionProveedorEnTabla;

    //Declaracion tabla y columnas
    @FXML
    private TableView<Proveedor> tablaProveedor;
    @FXML
    private TableColumn idPro;
    @FXML
    private TableColumn nomPro;
    @FXML
    private TableColumn razonSocialPro;
    @FXML
    private TableColumn sucursalPro;
    @FXML
    private TableColumn rutEmpresa;
    @FXML
    private TableColumn direccionPro;
    @FXML
    private TableColumn conPro;
    @FXML
    private TableColumn telPro;
    @FXML
    private TableColumn emailPro;
    ObservableList<Proveedor> proveedor;

    //Declaracion de combobox
    @FXML
    ComboBox<Region> cbRegion;
    @FXML
    ComboBox<Provincia> cbProvincia;
    @FXML
    ComboBox<Comuna> cbComuna;
    @FXML
    ComboBox<Proveedor> cbFiltrarPro;

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
    
    @FXML
    private void btnAgregar() {
        DAOProveedor dao = new DAOProveedor();
        Proveedor pro = new Proveedor();
        
        if (txtNombre.getText().isEmpty() || txtRazonSocial.getText().isEmpty()
                || txtRutEmpresa.getText().isEmpty() || txtRutEmpresa.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || cbComuna.getValue() == null
                || txtConProveedor.getText().isEmpty() || txtFono.getText().isEmpty()
                || txtEmailProveedor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe ingresar todos los campos");
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
            pro.setNombreProveedor(txtNombre.getText());
            pro.setRazonSocialProveedor(txtRazonSocial.getText());
            pro.setRutProveedor(txtRutEmpresa.getText());
            pro.setSucursalProveedor(txtRutEmpresa.getText());
            pro.setDireccionProveedor(txtDireccion.getText());
            pro.setIdComunaProveedor(cbComuna.getValue().getIdC());
            pro.setNomContactoProveedor(txtConProveedor.getText());
            pro.setTelefonoProveedor(txtFono.getText());
            pro.setEmailProveedor(txtEmailProveedor.getText());
            dao.agregarProveedor(pro);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Proveedor Agregado Correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            iniciarlizarTablaInv();
        }
        
    }
    
    @FXML
    private void btnModificar() {
        DAOProveedor dao = new DAOProveedor();
        Proveedor pro = new Proveedor();
        if (txtNombre.getText().isEmpty() || txtRazonSocial.getText().isEmpty()
                || txtRutEmpresa.getText().isEmpty() || txtRutEmpresa.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || cbComuna.getValue() == null
                || txtConProveedor.getText().isEmpty() || txtFono.getText().isEmpty()
                || txtEmailProveedor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe ingresar todos los campos");
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
            
            pro.setIdProveedor(Integer.parseInt(lbIDProveedor.getText()));
            pro.setNombreProveedor(txtNombre.getText());
            pro.setRazonSocialProveedor(txtRazonSocial.getText());
            pro.setRutProveedor(txtRutEmpresa.getText());
            pro.setSucursalProveedor(txtRutEmpresa.getText());
            pro.setDireccionProveedor(txtDireccion.getText());
            pro.setIdComunaProveedor(cbComuna.getValue().getIdC());
            pro.setNomContactoProveedor(txtConProveedor.getText());
            pro.setTelefonoProveedor(txtFono.getText());
            pro.setEmailProveedor(txtEmailProveedor.getText());
            dao.modificarProveedor(pro);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Proveedor Modificado Correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            iniciarlizarTablaInv();
        }
        
    }
    
    @FXML
    private void btnEliminar() {
        
        DAOProveedor dao = new DAOProveedor();
        
        if (lbIDProveedor.getText().isEmpty()) {
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
            int id = Integer.parseInt(lbIDProveedor.getText());
            dao.eliminarProveedor(id);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Proveedor eliminado Correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            iniciarlizarTablaInv();
        }
        
    }
    
    @FXML
    private void btnLimpiar() {
        
        txtConProveedor.setText("");
        txtDireccion.setText("");
        txtEmailProveedor.setText("");
        txtFono.setText("");
        txtNombre.setText("");
        txtRazonSocial.setText("");
        txtRutEmpresa.setText("");
        txtSucursal.setText("");
        lbIDProveedor.setText("");
        cargarRegion();
        
    }
    
    @FXML
    private void filtrarPro() {
        try {
            
            if (cbFiltrarPro.getValue().getIdProveedor() != 0) {
                int id = cbFiltrarPro.getValue().getIdProveedor();
                idPro.setCellValueFactory(new PropertyValueFactory<Proveedor, Integer>("idProveedor"));
                nomPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombreProveedor"));
                razonSocialPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("razonSocialProveedor"));
                sucursalPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("sucursalProveedor"));
                rutEmpresa.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("rutProveedor"));
                direccionPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("direccionProveedor"));
                conPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nomContactoProveedor"));
                telPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefonoProveedor"));
                emailPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("emailProveedor"));
                
                proveedor = FXCollections.observableArrayList(filtroProveedor(id));
                tablaProveedor.setItems(proveedor);
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @FXML
    private void btnCargarTodo()
    {
      iniciarlizarTablaInv();
    }
    
    private List listaR() {
        DAODepartamento dao = new DAODepartamento();
        
        ArrayList<Region> listaR = dao.listarRegion();
        
        return listaR;
    }
    
    private List listaPro() {
        DAOProveedor dao = new DAOProveedor();
        
        ArrayList<Proveedor> listaR = dao.listarProveedor();
        
        return listaR;
    }
    
    private List filtroProveedor(int id) {
        DAOProveedor dao = new DAOProveedor();
        
        ArrayList<Proveedor> listaR = dao.filtrolistarProveedor(id);
        
        return listaR;
    }
    
    private List listaP(int id) {
        DAODepartamento dao = new DAODepartamento();
        
        ArrayList<Provincia> listaP = dao.listarProvincia(id);
        
        return listaP;
    }
    
    private List listaC(int id) {
        DAODepartamento dao = new DAODepartamento();
        
        ArrayList<Comuna> listaC = dao.listarComuna(id);
        
        return listaC;
    }
    
    private List listaLimpiarComuna() {
        
        ArrayList<Comuna> lista = new ArrayList<Comuna>();
        
        return lista;
    }
    
    ObservableList<Region> listR = FXCollections.observableArrayList(listaR());
    
    private void iniciarlizarTablaInv() {
        idPro.setCellValueFactory(new PropertyValueFactory<Proveedor, Integer>("idProveedor"));
        nomPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombreProveedor"));
        razonSocialPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("razonSocialProveedor"));
        sucursalPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("sucursalProveedor"));
        rutEmpresa.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("rutProveedor"));
        direccionPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("direccionProveedor"));
        conPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nomContactoProveedor"));
        telPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefonoProveedor"));
        emailPro.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("emailProveedor"));
        
        proveedor = FXCollections.observableArrayList(listaPro());
        tablaProveedor.setItems(proveedor);
        
    }
    
    private void cargarRegion() {
        cbRegion.setItems(listR);

        //Conversor de regiones
        StringConverter<Region> converterR = new StringConverter<Region>() {
            @Override
            public String toString(Region reg) {
                return reg.getNom_region();
            }
            
            @Override
            public Region fromString(String id) {
                int ids = Integer.parseInt(id);
                return listR.stream()
                        .filter(item -> item.getId() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbRegion.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbRegion.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbRegion.getValue().getNom_region());
        });
        
    }
    
    private void cargarProvincia(int id) {
        ObservableList<Provincia> listP = FXCollections.observableArrayList(listaP(id));
        cbProvincia.setItems(listP);

        //Conversor de provincias
        StringConverter<Provincia> converterP = new StringConverter<Provincia>() {
            @Override
            public String toString(Provincia pro) {
                return pro.getNom_provincia();
            }
            
            @Override
            public Provincia fromString(String id) {
                int ids = Integer.parseInt(id);
                return listP.stream()
                        .filter(item -> item.getIdP() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbProvincia.setConverter(converterP);

        //Seteando los valores al combobox de provincia
        cbProvincia.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbProvincia.getValue().getNom_provincia());
        });
        
    }
    
    private void cargarComuna(int id) {
        ObservableList<Comuna> listC = FXCollections.observableArrayList(listaC(id));
        cbComuna.setItems(listC);

        //Conversor de comunas
        StringConverter<Comuna> converterC = new StringConverter<Comuna>() {
            @Override
            public String toString(Comuna com) {
                return com.getNom_Comuna();
            }
            
            @Override
            public Comuna fromString(String id) {
                int ids = Integer.parseInt(id);
                return listC.stream()
                        .filter(item -> item.getIdC() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbComuna.setConverter(converterC);

        //Seteando lo valores al combobox de comuna
        cbComuna.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbComuna.getValue().getNom_Comuna());
        });
        
    }
    
    private void cargarProveedorList() {
        ObservableList<Proveedor> listPRO = FXCollections.observableArrayList(listaPro());
        cbFiltrarPro.setItems(listPRO);

        //Conversor de comunas
        StringConverter<Proveedor> converterC = new StringConverter<Proveedor>() {
            @Override
            public String toString(Proveedor com) {
                return com.getNombreProveedor();
            }
            
            @Override
            public Proveedor fromString(String id) {
                int ids = Integer.parseInt(id);
                return listPRO.stream()
                        .filter(item -> item.getIdProveedor() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };
        
        cbFiltrarPro.setConverter(converterC);

        //Seteando lo valores al combobox de comuna
        cbFiltrarPro.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFiltrarPro.getValue().getNombreProveedor());
        });
        
    }
    
    @FXML
    public void regionMP(Event event) {
        try {
            if (cbRegion.getValue().getId() != 0) {
                int id = cbRegion.getValue().getId();
                System.out.println("Region :" + id);
                ObservableList<Comuna> listC = FXCollections.observableArrayList(listaLimpiarComuna());
                cbComuna.setItems(listC);
                cargarProvincia(id);
            }
        } catch (Exception e) {
            System.out.println("Cargando Data Error: " + e);
        }
    }
    
    @FXML
    public void provinciaMP(Event event) {
        try {
            if (cbProvincia.getValue().getIdP() != 0) {
                int id = cbProvincia.getValue().getIdP();
                System.out.println("Provincia :" + id);
                cargarComuna(id);
            }
        } catch (Exception e) {
            System.out.println("Cargando Data Error: " + e);
        }
    }
    
    private final ListChangeListener<Proveedor> selectorTablaProveedor = new ListChangeListener<Proveedor>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Proveedor> c) {
            ponerProveedorSeleccionado();
        }
    };
    
    public Proveedor getTablaProveedorSeleccionado() {
        if (tablaProveedor != null) {
            List<Proveedor> tabla = tablaProveedor.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Proveedor seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }
    
    public void ponerProveedorSeleccionado() {
        final Proveedor pro = getTablaProveedorSeleccionado();
        posicionProveedorEnTabla = proveedor.indexOf(pro);
        if (pro != null) {
            lbIDProveedor.setText(Integer.toString(pro.getIdProveedor()));
            txtNombre.setText(pro.getNombreProveedor());
            txtRazonSocial.setText(pro.getRazonSocialProveedor());
            txtSucursal.setText(pro.getSucursalProveedor());
            txtRutEmpresa.setText(pro.getRutProveedor());
            txtDireccion.setText(pro.getDireccionProveedor());
            txtConProveedor.setText(pro.getNomContactoProveedor());
            txtFono.setText(pro.getTelefonoProveedor());
            txtEmailProveedor.setText(pro.getEmailProveedor());
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarRegion();
        cargarProveedorList();
        this.iniciarlizarTablaInv();
        final ObservableList<Proveedor> tablaInvSel = tablaProveedor.getSelectionModel().getSelectedItems();
        tablaInvSel.addListener(selectorTablaProveedor);
        
    }
    
}
