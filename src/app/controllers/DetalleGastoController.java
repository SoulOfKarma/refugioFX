/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAODetalleGasto;
import app.DAO.DAOGastos;
import app.negocio.DepartamentoListado;
import app.negocio.DetalleGasto;
import app.negocio.DetalleGastoListado;
import app.negocio.Gasto;
import app.negocio.GastoListado;
import app.negocio.InventarioListado;
import app.negocio.Provincia;
import app.negocio.Region;
import com.jfoenix.controls.JFXDatePicker;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DetalleGastoController implements Initializable {

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

    //Declaracion de textfields
    @FXML
    private TextField txtPrecio;

    //Declaracion de combobox
    @FXML
    ComboBox<DepartamentoListado> cbDepartamento;
    @FXML
    ComboBox<GastoListado> cbGasto;
    @FXML
    ComboBox<DepartamentoListado> cbFiltroDepartamento;

    //Declaracion de fechas
    @FXML
    private JFXDatePicker dateFecha;

    //Declaracion de la lista
    @FXML
    private TableView<DetalleGastoListado> tablaDetGasto;
    @FXML
    private TableColumn tableNomDep;
    @FXML
    private TableColumn tableGasto;
    @FXML
    private TableColumn tablePrecio;
    @FXML
    private TableColumn tableFecha;
    @FXML
    private TableColumn tableIdDepartamento;
    @FXML
    private TableColumn tableIdGasto;

    ObservableList<DetalleGastoListado> detallegasto;

    @FXML
    private Label lbidDep;
    @FXML
    private Label lbGasto;
    @FXML
    private Label lbFecha;

    private int posiciondetalleEnTabla;

    //Metodos
    @FXML
    private void btnAgregar() {
        try {

            DAODetalleGasto dao = new DAODetalleGasto();
            DetalleGasto det = new DetalleGasto();
            if (txtPrecio.getText().isEmpty() || cbDepartamento.getValue() == null
                    || dateFecha.getValue() == null || cbGasto.getValue() == null) {
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
                det.setIdDep(cbDepartamento.getValue().getId());
                det.setIdGasto(cbGasto.getValue().getIdGasto());
                String fechaFormateada;
                Date fechaI;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    java.sql.Date fecI = java.sql.Date.valueOf(dateFecha.getValue());
                    fechaFormateada = formatter.format(fecI);
                    fechaI = convertUtilToSql(formatter.parse(fechaFormateada));

                    //Date fecha = formatter.parse((String)dateFechaCon.getValue().toString());
                    det.setFecha(fechaI);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                det.setPrecio(Integer.parseInt(txtPrecio.getText()));
                dao.agregarDetalleGasto(det);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
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
                inicializarTablaDetalleGastos();
            }
        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @FXML
    private void btnModificar() {

        try {

            DAODetalleGasto dao = new DAODetalleGasto();
            DetalleGasto det = new DetalleGasto();
            if (txtPrecio.getText().isEmpty() || cbDepartamento.getValue() == null
                    || cbGasto.getValue() == null
                    || lbidDep.getText().isEmpty() || lbFecha.getText().isEmpty() || lbGasto.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe seleccionar el dato de la tabla y llenar los campos para poder modificarlos");
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
                det.setIdDep(cbDepartamento.getValue().getId());
                det.setIdGasto(cbGasto.getValue().getIdGasto());
                String fechaFormateada;
                Date fechaI;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    java.sql.Date fecI = java.sql.Date.valueOf(dateFecha.getValue());
                    fechaFormateada = formatter.format(fecI);
                    fechaI = convertUtilToSql(formatter.parse(fechaFormateada));

                    //Date fecha = formatter.parse((String)dateFechaCon.getValue().toString());
                    det.setFecha(fechaI);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                det.setPrecio(Integer.parseInt(txtPrecio.getText()));
                int iddep = Integer.parseInt(lbidDep.getText());
                int idGas = Integer.parseInt(lbGasto.getText());
                java.sql.Date fecT = java.sql.Date.valueOf(lbFecha.getText());
                fechaFormateada = formatter.format(fecT);
                Date fecha = convertUtilToSql(formatter.parse(fechaFormateada));
                dao.modificarDetalleGasto(det, iddep, idGas, fecha);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
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
                inicializarTablaDetalleGastos();
            }
        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }

    }

    @FXML
    private void btnEliminar() {

        try {
            String fechaFormateada;
            DAODetalleGasto dao = new DAODetalleGasto();
            if (lbGasto.getText().isEmpty() || lbidDep.getText().isEmpty() || lbFecha.getText().isEmpty() || lbFecha.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe seleccionar algun campo de la tabla para poder eliminarlo");
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

                int iddep = Integer.parseInt(lbidDep.getText());
                int idGas = Integer.parseInt(lbGasto.getText());
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date fecT = java.sql.Date.valueOf(lbFecha.getText());
                fechaFormateada = formatter.format(fecT);
                Date fecha = convertUtilToSql(formatter.parse(fechaFormateada));
                dao.eliminarDetalleGasto(iddep, idGas, fecha);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
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
                inicializarTablaDetalleGastos();
            }
        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());

        }

    }

    @FXML
    private void btnLimpiar() {
        txtPrecio.setText("");
        cargarDepartamentos();
        cargarGastos();
    }

    @FXML
    private void btnCargarTodo() {
        inicializarTablaDetalleGastos();
    }

    @FXML
    private void filtroDepartamento() {

        try {
            if (cbFiltroDepartamento.getValue().getId() != 0) {
                int id = cbFiltroDepartamento.getValue().getId();
                tableIdDepartamento.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("iddep"));
                tableIdGasto.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("idgas"));
                tableNomDep.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("nomDep"));
                tableGasto.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("nomGas"));
                tablePrecio.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, Integer>("precio"));
                tableFecha.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, Date>("fecha"));

                detallegasto = FXCollections.observableArrayList(listaFiltroDetalleGasto(id));
                tablaDetGasto.setItems(detallegasto);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    //Listados para cargas de datos
    private List listaD() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<DepartamentoListado> listaR = dao.listarDepartamentos();

        return listaR;
    }

    private List listaG() {
        DAOGastos dao = new DAOGastos();

        ArrayList<GastoListado> listaR = dao.listarGastos();

        return listaR;
    }

    private List listaDetalleGasto() {
        DAODetalleGasto dao = new DAODetalleGasto();

        ArrayList<DetalleGastoListado> listaR = dao.listarDetalleGastoTabla();

        return listaR;
    }

    private List listaFiltroDetalleGasto(int id) {
        DAODetalleGasto dao = new DAODetalleGasto();

        ArrayList<DetalleGastoListado> listaR = dao.listarFiltroDetalleGastoTabla(id);

        return listaR;
    }

    private void cargarDepartamentos() {
        ObservableList<DepartamentoListado> listD = FXCollections.observableArrayList(listaD());
        cbDepartamento.setItems(listD);

        //Conversor de regiones
        StringConverter<DepartamentoListado> converterR = new StringConverter<DepartamentoListado>() {
            @Override
            public String toString(DepartamentoListado reg) {
                return reg.getNombre_propiedad();
            }

            @Override
            public DepartamentoListado fromString(String id) {
                int ids = Integer.parseInt(id);
                return listD.stream()
                        .filter(item -> item.getId() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbDepartamento.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbDepartamento.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbDepartamento.getValue().getNombre_propiedad());
        });

    }

    private void cargarFiltroDepartamentos() {
        ObservableList<DepartamentoListado> listD = FXCollections.observableArrayList(listaD());
        cbFiltroDepartamento.setItems(listD);

        //Conversor de regiones
        StringConverter<DepartamentoListado> converterR = new StringConverter<DepartamentoListado>() {
            @Override
            public String toString(DepartamentoListado reg) {
                return reg.getNombre_propiedad();
            }

            @Override
            public DepartamentoListado fromString(String id) {
                int ids = Integer.parseInt(id);
                return listD.stream()
                        .filter(item -> item.getId() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbFiltroDepartamento.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbFiltroDepartamento.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFiltroDepartamento.getValue().getNombre_propiedad());
        });

    }

    private void cargarGastos() {
        ObservableList<GastoListado> listD = FXCollections.observableArrayList(listaG());
        cbGasto.setItems(listD);

        //Conversor de regiones
        StringConverter<GastoListado> converterR = new StringConverter<GastoListado>() {
            @Override
            public String toString(GastoListado reg) {
                return reg.getNombreGasto();
            }

            @Override
            public GastoListado fromString(String id) {
                int ids = Integer.parseInt(id);
                return listD.stream()
                        .filter(item -> item.getIdGasto() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbGasto.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbGasto.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbGasto.getValue().getNombreGasto());
        });

    }

    private void inicializarTablaDetalleGastos() {
        tableIdDepartamento.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("iddep"));
        tableIdGasto.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("idgas"));
        tableNomDep.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("nomDep"));
        tableGasto.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, String>("nomGas"));
        tablePrecio.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, Integer>("precio"));
        tableFecha.setCellValueFactory(new PropertyValueFactory<DetalleGastoListado, Date>("fecha"));

        detallegasto = FXCollections.observableArrayList(listaDetalleGasto());
        tablaDetGasto.setItems(detallegasto);
    }

    private final ListChangeListener<DetalleGastoListado> selectorTablaDetalleG = new ListChangeListener<DetalleGastoListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends DetalleGastoListado> c) {
            ponerGastoSeleccionado();
        }
    };

    public DetalleGastoListado getTablaDetalleGSeleccionado() {
        if (detallegasto != null) {
            List<DetalleGastoListado> tabla = tablaDetGasto.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final DetalleGastoListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }

    public void ponerGastoSeleccionado() {
        final DetalleGastoListado gas = getTablaDetalleGSeleccionado();
        posiciondetalleEnTabla = detallegasto.indexOf(gas);
        if (gas != null) {
            txtPrecio.setText(Integer.toString(gas.getPrecio()));
            lbidDep.setText(Integer.toString(gas.getIddep()));
            lbGasto.setText(Integer.toString(gas.getIdgas()));
            lbFecha.setText(gas.getFecha().toString());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarDepartamentos();
        cargarGastos();
        cargarFiltroDepartamentos();
        inicializarTablaDetalleGastos();
        final ObservableList<DetalleGastoListado> tablaGasSel = tablaDetGasto.getSelectionModel().getSelectedItems();
        tablaGasSel.addListener(selectorTablaDetalleG);
    }

}
