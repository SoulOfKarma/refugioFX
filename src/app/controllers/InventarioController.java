/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOInventario;
import app.negocio.Departamento;
import app.negocio.DepartamentoListado;
import app.negocio.Inventario;
import app.negocio.InventarioListado;
import app.negocio.Region;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
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
public class InventarioController implements Initializable {

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

    //Declaracion de botones
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnCargarTodo;
    @FXML
    private Button btnLimpiar;

    //Declaracion de textfields
    @FXML
    private TextField txtNInventario;
    @FXML
    private TextField txtDInventario;
    @FXML
    private TextField txtVInventario;

    //Declaracion del Combobox
    @FXML
    private ComboBox<DepartamentoListado> cbDepartamento;
    @FXML
    private ComboBox<DepartamentoListado> cbFiltroDep;

    //Declaracion de la tabla y sus columnas
    @FXML
    private TableView<InventarioListado> tablaInventario;
    @FXML
    private TableColumn idInventario;
    @FXML
    private TableColumn nomInventario;
    @FXML
    private TableColumn desInventario;
    @FXML
    private TableColumn valInventario;
    @FXML
    private TableColumn desAsociado;

    ObservableList<InventarioListado> inventario;

    //Declaracion de otros parametros para uso de modificacion y eliminacion de datos
    @FXML
    private Label idInv;
    @FXML
    private Label lblvalortotal;
    private int posicionDepartamentoEnTabla;

    //Metodos
    @FXML
    private void btnAgregar() {
        try {
            DAOInventario dao = new DAOInventario();
            Inventario inv = new Inventario();

            if (cbDepartamento.getValue() == null || txtNInventario.getText().isEmpty()
                    || txtDInventario.getText().isEmpty() || txtVInventario.getText().isEmpty()) {

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
                inv.setId_dep(cbDepartamento.getValue().getId());
                inv.setNombre_inv(txtNInventario.getText());
                inv.setDesc_inv(txtDInventario.getText());
                inv.setValor_inv(Integer.parseInt(txtVInventario.getText()));
                dao.agregarInventario(inv);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Inventario agregado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                inicializarTablaInventario();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    private void btnModificar() {
        try {
            DAOInventario dao = new DAOInventario();
            Inventario inv = new Inventario();

            if (cbDepartamento.getValue() == null || txtNInventario.getText().isEmpty()
                    || txtDInventario.getText().isEmpty() || txtVInventario.getText().isEmpty()
                    || idInv.getText().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe seleccionar y modificar algun dato de la lista de inventarios");
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
                inv.setIdInv(Integer.parseInt(idInv.getText()));
                inv.setId_dep(cbDepartamento.getValue().getId());
                inv.setNombre_inv(txtNInventario.getText());
                inv.setDesc_inv(txtDInventario.getText());
                inv.setValor_inv(Integer.parseInt(txtVInventario.getText()));
                dao.modificarInventario(inv);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Inventario modificado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                inicializarTablaInventario();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    private void btnEliminar() {

        try {
            DAOInventario dao = new DAOInventario();

            if (idInv.getText().isEmpty()) {

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
                int id = Integer.parseInt(idInv.getText());

                dao.eliminarInventario(id);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Inventario eliminado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                inicializarTablaInventario();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    @FXML
    private void btnLimpiar() {
        limpiar();
    }

    @FXML
    private void filtroDep() {
        try {
            if (cbFiltroDep.getValue().getId() != 0) {
                int id = cbFiltroDep.getValue().getId();
                idInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, Integer>("idInv"));
                nomInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("nombre_inv"));
                desInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("desc_inv"));
                valInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, Integer>("valor_inv"));
                desAsociado.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("nomPro"));

                inventario = FXCollections.observableArrayList(filtroTablaDep(id));
                List<InventarioListado> lista = filtroTablaDep(id);
                int cargarvalor = 0;
                for (InventarioListado var : lista) {
                    cargarvalor = cargarvalor + var.getValor_inv();
                }
                String val = "$ " + Integer.toString(cargarvalor);
                lblvalortotal.setText(val);
                tablaInventario.setItems(inventario);
            }

        } catch (Exception e) {
            System.out.println("Cargando Data Error: " + e);
        }

    }

    @FXML
    private void btnCargarTodo() {
        inicializarTablaInventario();
    }

    private List listaI() {
        ArrayList<InventarioListado> lista = new ArrayList<>();
        try {
            DAOInventario dao = new DAOInventario();
            lista = dao.listarInventario();
            return lista;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }

    }

    private List listaD() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<DepartamentoListado> listaR = dao.listarDepartamentos();

        return listaR;
    }

    private List filtroTablaDep(int id) {
        ArrayList<InventarioListado> lista = new ArrayList<>();
        try {
            DAOInventario dao = new DAOInventario();
            lista = dao.listarInventarioFiltro(id);
            return lista;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return lista;
        }
    }

    private void inicializarTablaInventario() {
        idInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, Integer>("idInv"));
        nomInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("nombre_inv"));
        desInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("desc_inv"));
        valInventario.setCellValueFactory(new PropertyValueFactory<InventarioListado, Integer>("valor_inv"));
        desAsociado.setCellValueFactory(new PropertyValueFactory<InventarioListado, String>("nomPro"));

        inventario = FXCollections.observableArrayList(listaI());
        tablaInventario.setItems(inventario);
    }

    ObservableList<DepartamentoListado> listD = FXCollections.observableArrayList(listaD());

    private void cargarDepartamentos() {
        cbDepartamento.setItems(listD);
        List<InventarioListado> lista = listaI();
        int cargarvalor = 0;
        for (InventarioListado var : lista) {
            cargarvalor = cargarvalor + var.getValor_inv();
        }
        String val = "$ " + Integer.toString(cargarvalor);
        lblvalortotal.setText(val);
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
        cbFiltroDep.setItems(listD);

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

        cbFiltroDep.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbFiltroDep.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFiltroDep.getValue().getNombre_propiedad());
        });

    }

    private final ListChangeListener<InventarioListado> selectorTablaInventario = new ListChangeListener<InventarioListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends InventarioListado> c) {
            ponerDepartamentoSeleccionado();
        }
    };

    public InventarioListado getTablaInventarioSeleccionado() {
        if (tablaInventario != null) {
            List<InventarioListado> tabla = tablaInventario.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final InventarioListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }

    public void ponerDepartamentoSeleccionado() {
        final InventarioListado inv = getTablaInventarioSeleccionado();
        posicionDepartamentoEnTabla = inventario.indexOf(inv);
        if (inv != null) {
            idInv.setText(Integer.toString(inv.getIdInv()));
            txtDInventario.setText(inv.getDesc_inv());
            txtNInventario.setText(inv.getNombre_inv());
            txtVInventario.setText(Integer.toString(inv.getValor_inv()));

        }
    }

    public void limpiar() {
        txtDInventario.setText("");
        txtNInventario.setText("");
        txtVInventario.setText("");
        cargarDepartamentos();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDepartamentos();
        cargarFiltroDepartamentos();
        this.inicializarTablaInventario();
        final ObservableList<InventarioListado> tablaInvSel = tablaInventario.getSelectionModel().getSelectedItems();
        tablaInvSel.addListener(selectorTablaInventario);
    }

}
