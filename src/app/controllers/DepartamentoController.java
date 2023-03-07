/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.negocio.Comuna;
import app.negocio.Departamento;
import app.negocio.DepartamentoListado;
import app.negocio.EstadoDepartamento;
import app.negocio.Provincia;
import app.negocio.Region;
import com.jfoenix.controls.JFXDatePicker;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
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
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class DepartamentoController implements Initializable {

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
    private TextField txtNPropiedad;
    @FXML
    private TextField txtDirPropiedad;
    @FXML
    private TextField txtRolPropiedad;
    @FXML
    private TextField txtNPiso;
    @FXML
    private TextField txtNDep;
    @FXML
    private TextField txtNBanos;
    @FXML
    private TextField txtNCamas;
    @FXML
    private TextField txtNHab;
    @FXML
    private TextField txtMCuadrado;
    @FXML
    private TextField txtValDep;
    @FXML
    private TextField txtValArr;
    @FXML
    private TextField txtDesArriendo;
    @FXML
    private TextField txtPoliza;
    @FXML
    private TextField txtInfoCom;
    @FXML
    private TextField txtNHuespedes;

    //Declaracion de combobox
    @FXML
    ComboBox<Region> cbRegion;
    @FXML
    ComboBox<Provincia> cbProvincia;
    @FXML
    ComboBox<Comuna> cbComuna;
    @FXML
    ComboBox<EstadoDepartamento> cbEstado;
    @FXML
    ComboBox<DepartamentoListado> cbFiltroDep;

    //Declaracion de RadioButton
    @FXML
    private RadioButton rbbtnSi;
    @FXML
    private RadioButton rbbtnno;

    //Declaracion de fechas
    @FXML
    private JFXDatePicker dateFechaCon;

    //Declaracion de la lista
    @FXML
    private TableView<DepartamentoListado> tablaDepartamento;
    @FXML
    private TableColumn idPropiedad;
    @FXML
    private TableColumn nomPropiedad;
    @FXML
    private TableColumn rolPropiedad;
    @FXML
    private TableColumn dirPropiedad;
    @FXML
    private TableColumn valCompra;
    @FXML
    private TableColumn valArriendo;
    @FXML
    private TableColumn dateFCon;
    @FXML
    private TableColumn metroCua;
    @FXML
    private TableColumn estDep;
    @FXML
    private TableColumn usadoDep;
    @FXML
    private TableColumn desDep;
    @FXML
    private TableColumn politicaInf;
    @FXML
    private TableColumn infCom;
    
    
    ObservableList<DepartamentoListado> departamento;

    //Declaracion de otros parametros para uso de modificacion y eliminacion de datos
    @FXML
    private Label idDep;
    private int posicionDepartamentoEnTabla;

    //Metodos
    @FXML
    private void btnAgregar(ActionEvent event) {
        DAODepartamento dao = new DAODepartamento();
        Departamento departamentos = new Departamento();
        try {
            if (txtNPropiedad.getText().isEmpty() || txtRolPropiedad.getText().isEmpty() || txtNPiso.getText().isEmpty()
                    || txtNBanos.getText().isEmpty() || txtNCamas.getText().isEmpty() || txtNDep.getText().isEmpty() || txtNDep.getText().isEmpty()
                    || txtNHuespedes.getText().isEmpty() || cbEstado.getValue() == null || dateFechaCon.getValue() == null
                    || txtDirPropiedad.getText().isEmpty() || txtValArr.getText().isEmpty() || txtValDep.getText().isEmpty()
                    || cbComuna.getValue() == null || txtMCuadrado.getText().isEmpty() || txtDesArriendo.getText().isEmpty()
                    || txtPoliza.getText().isEmpty()) {
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

                departamentos.setNombre_propiedad(txtNPropiedad.getText());
                departamentos.setRol_dep(Integer.parseInt(txtRolPropiedad.getText()));
                departamentos.setNum_piso(Integer.parseInt(txtNPiso.getText()));
                departamentos.setNum_banios(Integer.parseInt(txtNBanos.getText()));
                departamentos.setNum_camas(Integer.parseInt(txtNCamas.getText()));
                departamentos.setNum_dep(txtNDep.getText());
                departamentos.setNum_habitaciones(Integer.parseInt(txtNHab.getText()));
                departamentos.setNum_huspedes(Integer.parseInt(txtNHuespedes.getText()));
                departamentos.setEstado_dep(cbEstado.getValue().getIdEstado());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date fecha = formatter.parse((String) dateFechaCon.getValue().toString());
                    departamentos.setFecha_construccion(fecha);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                departamentos.setDir_departamento(txtDirPropiedad.getText());
                departamentos.setValor_arriendo(Integer.parseInt(txtValArr.getText()));
                departamentos.setValor_compra_dep(Integer.parseInt(txtValDep.getText()));
                departamentos.setValorizacion(0);
                departamentos.setFecha_registro(new Date());
                departamentos.setId_comuna(cbComuna.getValue().getIdC());
                departamentos.setMetros_cuadrados(Integer.parseInt(txtMCuadrado.getText()));
                departamentos.setDesc_arriendo(txtDesArriendo.getText());
                departamentos.setInfo_compl(txtInfoCom.getText());
                departamentos.setPoliza_arriendo(txtPoliza.getText());
                if (rbbtnSi.isSelected()) {
                    departamentos.setUsado(1);
                } else {
                    departamentos.setUsado(0);
                }

                //   departamento.add(departamentos);
                dao.agregarDepartamento(departamentos);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Departamento Agregado Correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaDep();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    @FXML
    private void btnModificar(ActionEvent event) {

        DAODepartamento dao = new DAODepartamento();
        Departamento departamentos = new Departamento();
        try {
            if (txtNPropiedad.getText().isEmpty() || txtRolPropiedad.getText().isEmpty() || txtNPiso.getText().isEmpty()
                    || txtNBanos.getText().isEmpty() || txtNCamas.getText().isEmpty() || txtNDep.getText().isEmpty() || txtNDep.getText().isEmpty()
                    || txtNHuespedes.getText().isEmpty() || cbEstado.getValue() == null || dateFechaCon.getValue() == null
                    || txtDirPropiedad.getText().isEmpty() || txtValArr.getText().isEmpty() || txtValDep.getText().isEmpty()
                    || cbComuna.getValue() == null || txtMCuadrado.getText().isEmpty() || txtDesArriendo.getText().isEmpty()
                    || txtPoliza.getText().isEmpty()) {
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

                departamentos.setId(Integer.parseInt(idDep.getText()));
                departamentos.setNombre_propiedad(txtNPropiedad.getText());
                departamentos.setRol_dep(Integer.parseInt(txtRolPropiedad.getText()));
                departamentos.setNum_piso(Integer.parseInt(txtNPiso.getText()));
                departamentos.setNum_banios(Integer.parseInt(txtNBanos.getText()));
                departamentos.setNum_camas(Integer.parseInt(txtNCamas.getText()));
                departamentos.setNum_dep(txtNDep.getText());
                departamentos.setNum_habitaciones(Integer.parseInt(txtNHab.getText()));
                departamentos.setNum_huspedes(Integer.parseInt(txtNHuespedes.getText()));
                departamentos.setEstado_dep(cbEstado.getValue().getIdEstado());

                String fechaFormateada;
                Date fechaI;
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    java.sql.Date fecI = java.sql.Date.valueOf(dateFechaCon.getValue());
                    fechaFormateada = formatter.format(fecI);
                    fechaI = convertUtilToSql(formatter.parse(fechaFormateada));

                    //Date fecha = formatter.parse((String)dateFechaCon.getValue().toString());
                    departamentos.setFecha_construccion(fechaI);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                departamentos.setDir_departamento(txtDirPropiedad.getText());
                departamentos.setValor_arriendo(Integer.parseInt(txtValArr.getText()));
                departamentos.setValor_compra_dep(Integer.parseInt(txtValDep.getText()));
                departamentos.setValorizacion(0);
                departamentos.setFecha_registro(new Date());
                departamentos.setId_comuna(cbComuna.getValue().getIdC());
                departamentos.setMetros_cuadrados(Integer.parseInt(txtMCuadrado.getText()));
                departamentos.setDesc_arriendo(txtDesArriendo.getText());
                departamentos.setInfo_compl(txtInfoCom.getText());
                departamentos.setPoliza_arriendo(txtPoliza.getText());
                if (rbbtnSi.isSelected()) {
                    departamentos.setUsado(1);
                } else {
                    departamentos.setUsado(0);
                }

                dao.modificarDepartamento(departamentos);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Departamento Modificado Correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaDep();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @FXML
    private void btnEliminar(ActionEvent event) {

        DAODepartamento dao = new DAODepartamento();

        if (idDep.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe seleccionar un departamento del listado para desactivarlo");
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
            int valor = Integer.parseInt(idDep.getText());
            int estado = 106;
            dao.desactivarDepartamento(valor, estado);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Departamento desactivado Correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            iniciarlizarTablaDep();
        }

    }

    @FXML
    private void btnLimpiar() {
        txtNPropiedad.setText("");
        txtDirPropiedad.setText("");
        txtRolPropiedad.setText("");
        txtNPiso.setText("");
        txtNDep.setText("");
        txtNBanos.setText("");
        txtNCamas.setText("");
        txtNHab.setText("");
        txtMCuadrado.setText("");
        txtValDep.setText("");
        txtValArr.setText("");
        txtDesArriendo.setText("");
        txtPoliza.setText("");
        txtInfoCom.setText("");
        txtNHuespedes.setText("");
        cargarRegion();
    }

    @FXML
    private void filtroDep() {
        try {
            if (cbFiltroDep.getValue().getId() != 0) {
                int id = cbFiltroDep.getValue().getId();
                idPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("id"));
                nomPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("nombre_propiedad"));
                rolPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("rol_dep"));
                dirPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("dir_departamento"));
                valCompra.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("valor_compra_dep"));
                valArriendo.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("valor_arriendo"));
                dateFCon.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Date>("fecha_construccion"));
                metroCua.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("metros_cuadrados"));
                estDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("descEst"));
                usadoDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("usado"));
                desDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("desc_arriendo"));
                politicaInf.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("poliza_arriendo"));
                infCom.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("info_compl"));
                
                departamento = FXCollections.observableArrayList(filtroListaDep(id));
                tablaDepartamento.setItems(departamento);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    @FXML
    private void btnCargarTodo() {
        iniciarlizarTablaDep();
    }

    private List listaR() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<Region> listaR = dao.listarRegion();

        return listaR;
    }

    private List listaD() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<DepartamentoListado> listaR = dao.listarDepartamentos();

        return listaR;
    }

    private List filtroListaDep(int id) {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<DepartamentoListado> listaR = dao.filtroDepByID(id);

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

    private List listaE() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<EstadoDepartamento> listaC = dao.listarEstado();

        return listaC;
    }

    private List listaLimpiarComuna() {

        ArrayList<Comuna> lista = new ArrayList<Comuna>();

        return lista;
    }

    ObservableList<Region> listR = FXCollections.observableArrayList(listaR());

    ObservableList<EstadoDepartamento> listE = FXCollections.observableArrayList(listaE());

    private void iniciarlizarTablaDep() {
        idPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("id"));
        nomPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("nombre_propiedad"));
        rolPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("rol_dep"));
        dirPropiedad.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("dir_departamento"));
        valCompra.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("valor_compra_dep"));
        valArriendo.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("valor_arriendo"));
        dateFCon.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Date>("fecha_construccion"));
        metroCua.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, Integer>("metros_cuadrados"));
        estDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("descEst"));
        usadoDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("usado"));
        desDep.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("desc_arriendo"));
        politicaInf.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("poliza_arriendo"));
        infCom.setCellValueFactory(new PropertyValueFactory<DepartamentoListado, String>("info_compl"));

        departamento = FXCollections.observableArrayList(listaD());
        tablaDepartamento.setItems(departamento);

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

    private void cargarEstados() {
        cbEstado.setItems(listE);

        //Conversor de comunas
        StringConverter<EstadoDepartamento> converterE = new StringConverter<EstadoDepartamento>() {
            @Override
            public String toString(EstadoDepartamento est) {
                return est.getDesEstado();
            }

            @Override
            public EstadoDepartamento fromString(String id) {
                int ids = Integer.parseInt(id);
                return listE.stream()
                        .filter(item -> item.getIdEstado() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbEstado.setConverter(converterE);

        //Seteando lo valores al combobox de comuna
        cbEstado.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbEstado.getValue().getDesEstado());
        });

    }

    private void cargarListadoDep() {
        ObservableList<DepartamentoListado> listDL = FXCollections.observableArrayList(listaD());
        cbFiltroDep.setItems(listDL);

        StringConverter<DepartamentoListado> converterE = new StringConverter<DepartamentoListado>() {
            @Override
            public String toString(DepartamentoListado est) {
                return est.getNombre_propiedad();
            }

            @Override
            public DepartamentoListado fromString(String id) {
                int ids = Integer.parseInt(id);
                return listDL.stream()
                        .filter(item -> item.getId() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbFiltroDep.setConverter(converterE);

        //Seteando lo valores al combobox de comuna
        cbFiltroDep.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFiltroDep.getValue().getNombre_propiedad());
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

    private final ListChangeListener<DepartamentoListado> selectorTablaDepartamento = new ListChangeListener<DepartamentoListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends DepartamentoListado> c) {
            ponerDepartamentoSeleccionado();
        }
    };

    public DepartamentoListado getTablaDepartamentoSeleccionado() {
        if (tablaDepartamento != null) {
            List<DepartamentoListado> tabla = tablaDepartamento.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final DepartamentoListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }

    public void ponerDepartamentoSeleccionado() {
        final DepartamentoListado depto = getTablaDepartamentoSeleccionado();
        posicionDepartamentoEnTabla = departamento.indexOf(depto);
        if (depto != null) {
            idDep.setText(Integer.toString(depto.getId()));
            txtDesArriendo.setText(depto.getDesc_arriendo());
            txtDirPropiedad.setText(depto.getDir_departamento());
            txtInfoCom.setText(depto.getInfo_compl());
            txtMCuadrado.setText(Integer.toString(depto.getMetros_cuadrados()));
            txtNBanos.setText(Integer.toString(depto.getNum_banios()));
            txtNCamas.setText(Integer.toString(depto.getNum_camas()));
            txtNDep.setText(depto.getNum_dep());
            txtNHab.setText(Integer.toString(depto.getNum_habitaciones()));
            txtNPiso.setText(Integer.toString(depto.getNum_piso()));
            txtNPropiedad.setText(depto.getNombre_propiedad());
            txtPoliza.setText(depto.getPoliza_arriendo());
            txtRolPropiedad.setText(Integer.toString(depto.getRol_dep()));
            txtValArr.setText(Integer.toString(depto.getValor_arriendo()));
            txtValDep.setText(Integer.toString(depto.getValor_compra_dep()));
            txtNHuespedes.setText(Integer.toString(depto.getNum_huspedes()));

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cargarRegion();
        cargarEstados();
        cargarListadoDep();

        this.iniciarlizarTablaDep();
        final ObservableList<DepartamentoListado> tablaDepSel = tablaDepartamento.getSelectionModel().getSelectedItems();
        tablaDepSel.addListener(selectorTablaDepartamento);

    }

}
