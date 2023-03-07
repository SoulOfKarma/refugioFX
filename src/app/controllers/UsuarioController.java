/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOUsuario;
import app.negocio.Comuna;
import app.negocio.Departamento;
import app.negocio.EstadoUsuario;
import app.negocio.Provincia;
import app.negocio.Region;
import app.negocio.TipoUsuario;
import app.negocio.Empleado;
import app.negocio.Genero;
import app.negocio.Nacionalidad;
import app.negocio.Subirfotos;
import com.jfoenix.controls.JFXDatePicker;
import com.sun.javaws.Main;
import java.io.File;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class UsuarioController implements Initializable {

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

    //Declaracion de items para agregar fotos
    @FXML
    private Button btnBuscar;

    //Declaracion de combobox
    @FXML
    private ComboBox<Region> cbRegion;
    @FXML
    private ComboBox<Provincia> cbProvincia;
    @FXML
    private ComboBox<Comuna> cbComuna;
    @FXML
    private ComboBox<TipoUsuario> cbRol;
    @FXML
    private ComboBox<EstadoUsuario> cbEstado;
    @FXML
    private ComboBox<Genero> cbGenero;
    @FXML
    private ComboBox<Nacionalidad> cbNacionalidad;
    @FXML
    private ComboBox<TipoUsuario> cbRolTabla;

    //Declaron de TextField
    @FXML
    private TextField txtRun;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPass;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtSalario;
    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtRutTabla;

    //Declaracion de botones
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnFiltrar;
    @FXML
    private Button btnListaInicial;
    @FXML
    private Button btnLimpiar;

    //Declaracion de fecha
    @FXML
    private JFXDatePicker dateFechaNac;

    //Declaracion de FileType
    private File imgFile;

    //Declaracion de la lista
    @FXML
    private TableView<Empleado> tablaUsuario;
    @FXML
    private TableColumn idUsu;
    @FXML
    private TableColumn runUsuario;
    @FXML
    private TableColumn nomUsuario;
    @FXML
    private TableColumn apeUsuario;
    @FXML
    private TableColumn emailUsuario;
    @FXML
    private TableColumn dirUsuario;
    @FXML
    private TableColumn fechanacUsuario;
    @FXML
    private TableColumn ndocUsuario;
    @FXML
    private TableColumn ntelUsuario;
    ObservableList<Empleado> usuario;

    //Otras Variables
    @FXML
    private Label idUsua;
    private int posicionUsuarioEnTabla;
    // Metodos

    @FXML
    private void btnAgregar() {
        try {
            DAOUsuario dao = new DAOUsuario();
            Empleado usu = new Empleado();
             org.springframework.security.crypto.password.PasswordEncoder encoder
   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();

            if (txtRun.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()
                    || txtDireccion.getText().isEmpty() || txtEmail.getText().isEmpty() || cbEstado.getValue() == null
                    || dateFechaNac.getValue() == null || imgFile.getName().isEmpty() || cbComuna.getValue() == null
                    || cbGenero.getValue() == null || cbNacionalidad.getValue() == null || txtTel.getText().isEmpty()
                    || txtPass.getText().isEmpty() || txtSalario.getText().isEmpty() || cbRol.getValue() == null) {

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
                usu.setRun_Empleado(txtRun.getText());
                usu.setNombre_Empleado(txtNombre.getText());
                usu.setApellido_Empleado(txtApellido.getText());
                usu.setDireccion_Empleado(txtDireccion.getText());
                usu.setEmail_Empleado(txtEmail.getText());
                usu.setEstado_usuario(cbEstado.getValue().getIdEstadoUsuario());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fechaFormateada;
                try {
                    java.sql.Date fecI = java.sql.Date.valueOf(dateFechaNac.getValue());
                    fechaFormateada = formatter.format(fecI);
                    usu.setFecha_nacimiento(formatter.parse(fechaFormateada));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String foto = imgFile.getName();
                usu.setFoto_usuario(foto);
                usu.setId_comuna(cbComuna.getValue().getIdC());
                usu.setIdGenero(cbGenero.getValue().getIdGen());
                usu.setIdNacionalidad(cbNacionalidad.getValue().getIdNac());
                usu.setNumero_telefono(txtTel.getText());
                usu.setPass_Empleado(encoder.encode(txtPass.getText()));
                usu.setSalario_emp(Integer.parseInt(txtSalario.getText()));
                usu.setRol_usuario(cbRol.getValue().getIdTipoUsuario());
                Subirfotos sub = new Subirfotos();
                sub.fotoUsuarios(imgFile);
                dao.agregarEmpleado(usu);

                this.iniciarlizarTablaUsuario();
                final ObservableList<Empleado> tablaUsuSel = tablaUsuario.getSelectionModel().getSelectedItems();
                tablaUsuSel.addListener(selectorTablaUsuario);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Usuario agregado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaUsuario();
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    @FXML
    private void btnModificar() {
        try {
            DAOUsuario dao = new DAOUsuario();
            Empleado usu = new Empleado();

            if (txtRun.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()
                    || txtDireccion.getText().isEmpty() || txtEmail.getText().isEmpty() || cbEstado.getValue() == null
                    || dateFechaNac.getValue() == null || imgFile.getName().isEmpty() || cbComuna.getValue() == null
                    || cbGenero.getValue() == null || cbNacionalidad.getValue() == null || txtTel.getText().isEmpty()
                    || txtPass.getText().isEmpty() || txtSalario.getText().isEmpty() || cbRol.getValue() == null) {

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
                usu.setIdEmpleado(Integer.parseInt(idUsua.getText()));
                usu.setRun_Empleado(txtRun.getText());
                usu.setNombre_Empleado(txtNombre.getText());
                usu.setApellido_Empleado(txtApellido.getText());
                usu.setDireccion_Empleado(txtDireccion.getText());
                usu.setEmail_Empleado(txtEmail.getText());
                usu.setEstado_usuario(cbEstado.getValue().getIdEstadoUsuario());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fechaFormateada;
                try {
                    java.sql.Date fecI = java.sql.Date.valueOf(dateFechaNac.getValue());
                    fechaFormateada = formatter.format(fecI);
                    usu.setFecha_nacimiento(formatter.parse(fechaFormateada));

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String foto = imgFile.getName();
                usu.setFoto_usuario(foto);
                usu.setId_comuna(cbComuna.getValue().getIdC());
                usu.setIdGenero(cbGenero.getValue().getIdGen());
                usu.setIdNacionalidad(cbNacionalidad.getValue().getIdNac());
                usu.setNumero_telefono(txtTel.getText());
                usu.setPass_Empleado(txtPass.getText());
                usu.setSalario_emp(Integer.parseInt(txtSalario.getText()));
                usu.setRol_usuario(cbRol.getValue().getIdTipoUsuario());
                Subirfotos sub = new Subirfotos();
                sub.fotoUsuarios(imgFile);
                dao.ModificarEmpleado(usu);

                this.iniciarlizarTablaUsuario();
                final ObservableList<Empleado> tablaUsuSel = tablaUsuario.getSelectionModel().getSelectedItems();
                tablaUsuSel.addListener(selectorTablaUsuario);

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Usuario Modificado correctamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                iniciarlizarTablaUsuario();
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void btnEliminar() {
        DAOUsuario dao = new DAOUsuario();
        Empleado usu = new Empleado();

        if (idUsua.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Dialogo de excepcion");
            alert.setContentText("Debe seleccionar un usuario de la lista para desabilitarlo");
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
            usu.setIdEmpleado(Integer.parseInt(idUsua.getText()));
            usu.setEstado_usuario(0);
            dao.DesactivarEmpleado(usu);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Usuario desabilitado correctamente");
            Exception ex = new FileNotFoundException("Error.txt");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            //String exceptionText = sw.toString();
            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            alert.getDialogPane().setExpandableContent(expContent);
            alert.showAndWait();
            iniciarlizarTablaUsuario();
        }

    }

    @FXML
    private void btnLimpiar() {
        
        txtApellido.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtNombre.setText("");
        txtPass.setText("");
        txtRun.setText("");
        txtRutTabla.setText("");
        txtSalario.setText("");
        txtTel.setText("");

    }

    private List listaR() {
        DAODepartamento dao = new DAODepartamento();

        ArrayList<Region> listaR = dao.listarRegion();

        return listaR;
    }

    private List listaE() {

        ArrayList<EstadoUsuario> listaR = new ArrayList<EstadoUsuario>();
        EstadoUsuario est1 = new EstadoUsuario();
        EstadoUsuario est2 = new EstadoUsuario();
        est1.setIdEstadoUsuario(0);
        est1.setDesEstadoUsuario("Desactivado");
        est2.setIdEstadoUsuario(1);
        est2.setDesEstadoUsuario("Activo");
        listaR.add(est1);
        listaR.add(est2);

        return listaR;
    }

    private List listaTU() {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<TipoUsuario> listaR = dao.listarRol();

        return listaR;
    }

    private List listaFilTU() {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<TipoUsuario> listaR = dao.listarRol();

        return listaR;
    }

    private List listaU() {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<Empleado> listaR = dao.listarUsuario();

        return listaR;
    }

    private List listaFiltro(int id) {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<Empleado> listaR = dao.filtrarPorTipodeEmpleado(id);

        return listaR;
    }

    private List listaFiltroRut(String rut) {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<Empleado> listaR = dao.buscarPorRut(rut);

        return listaR;
    }

    private List listaG() {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<Genero> listaR = dao.listarGenero();

        return listaR;
    }

    private List listaN() {
        DAOUsuario dao = new DAOUsuario();

        ArrayList<Nacionalidad> listaR = dao.listarNacionalidad();

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
    ObservableList<TipoUsuario> listTU = FXCollections.observableArrayList(listaTU());
    ObservableList<EstadoUsuario> listE = FXCollections.observableArrayList(listaE());
    ObservableList<Genero> listGen = FXCollections.observableArrayList(listaG());
    ObservableList<Nacionalidad> listNac = FXCollections.observableArrayList(listaN());
    ObservableList<TipoUsuario> listFil = FXCollections.observableArrayList(listaFilTU());

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

    private void cargarEstadoUsuario() {
        cbEstado.setItems(listE);

        //Conversor de regiones
        StringConverter<EstadoUsuario> converterR = new StringConverter<EstadoUsuario>() {
            @Override
            public String toString(EstadoUsuario estUsu) {
                return estUsu.getDesEstadoUsuario();
            }

            @Override
            public EstadoUsuario fromString(String id) {
                int ids = Integer.parseInt(id);
                return listE.stream()
                        .filter(item -> item.getIdEstadoUsuario() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbEstado.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbEstado.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbEstado.getValue().getDesEstadoUsuario());
        });

    }

    private void cargarRol() {
        cbRol.setItems(listTU);

        //Conversor de regiones
        StringConverter<TipoUsuario> converterR = new StringConverter<TipoUsuario>() {
            @Override
            public String toString(TipoUsuario tipUsu) {
                return tipUsu.getDescripcionUsuario();
            }

            @Override
            public TipoUsuario fromString(String id) {
                int ids = Integer.parseInt(id);
                return listTU.stream()
                        .filter(item -> item.getIdTipoUsuario() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbRol.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbRol.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbRol.getValue().getDescripcionUsuario());
        });

    }

    private void cargarFiltroRol() {
        cbRolTabla.setItems(listFil);

        //Conversor de regiones
        StringConverter<TipoUsuario> converterR = new StringConverter<TipoUsuario>() {
            @Override
            public String toString(TipoUsuario tipUsu) {
                return tipUsu.getDescripcionUsuario();
            }

            @Override
            public TipoUsuario fromString(String id) {
                int ids = Integer.parseInt(id);
                return listFil.stream()
                        .filter(item -> item.getIdTipoUsuario() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbRolTabla.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbRolTabla.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbRolTabla.getValue().getDescripcionUsuario());
        });

    }

    private void cargarGenero() {
        cbGenero.setItems(listGen);

        //Conversor de regiones
        StringConverter<Genero> converterR = new StringConverter<Genero>() {
            @Override
            public String toString(Genero tipUsu) {
                return tipUsu.getDescripcion();
            }

            @Override
            public Genero fromString(String id) {
                int ids = Integer.parseInt(id);
                return listGen.stream()
                        .filter(item -> item.getIdGen() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbGenero.setConverter(converterR);
        //Seteando los valores al combobox de Genero
        cbGenero.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbGenero.getValue().getDescripcion());
        });

    }

    private void cargarNacionalidad() {
        cbNacionalidad.setItems(listNac);

        //Conversor de regiones
        StringConverter<Nacionalidad> converterR = new StringConverter<Nacionalidad>() {
            @Override
            public String toString(Nacionalidad tipUsu) {
                return tipUsu.getDescripcion();
            }

            @Override
            public Nacionalidad fromString(String id) {
                int ids = Integer.parseInt(id);
                return listNac.stream()
                        .filter(item -> item.getIdNac() == ids)
                        .collect(Collectors.toList()).get(0);
            }
        };

        cbNacionalidad.setConverter(converterR);
        //Seteando los valores al combobox de Genero
        cbNacionalidad.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbNacionalidad.getValue().getDescripcion());
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

    @FXML
    private void cbFiltro(Event event) {
        try {
            if (cbRolTabla.getValue().getIdTipoUsuario() != 0) {
                int id = cbRolTabla.getValue().getIdTipoUsuario();
                idUsu.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("idEmpleado"));
                runUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("run_Empleado"));
                nomUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre_Empleado"));
                apeUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido_Empleado"));
                emailUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email_Empleado"));
                dirUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("direccion_Empleado"));
                fechanacUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("fecha_nacimiento"));
                ntelUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("numero_telefono"));

                usuario = FXCollections.observableArrayList(listaFiltro(id));
                tablaUsuario.setItems(usuario);

            }
        } catch (Exception e) {
            System.out.println("Cargando Data Error: " + e);
        }
    }

    @FXML
    private void btnFiltrar() {
        DAOUsuario dao = new DAOUsuario();
        String rut = txtRutTabla.getText();
        boolean validar = validarRut(rut);
        rut = formatRut(rut);
        if (validar == true) {
            rut = formatearRut(rut);
            idUsu.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("idEmpleado"));
            runUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("run_Empleado"));
            nomUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre_Empleado"));
            apeUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido_Empleado"));
            emailUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email_Empleado"));
            dirUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("direccion_Empleado"));
            fechanacUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("fecha_nacimiento"));
            ntelUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("numero_telefono"));

            usuario = FXCollections.observableArrayList(listaFiltroRut(rut));
            tablaUsuario.setItems(usuario);
        }
    }

    @FXML
    private void btnListaInicial() {
        iniciarlizarTablaUsuario();
    }

    private String formatearRut(String rut) {
        String sRut1 = rut;      //contador de para saber cuando insertar el . o la -
        int nPos = 0; //Guarda el rut invertido con los puntos y el guión agregado
        int npunto = 0;
        int nguion = 0;
        String sInvertido = ""; //Guarda el resultado final del rut como debe ser
        String sRut = "";

        if (sRut1.length() == 9) {
            for (int i = 0; i <= sRut1.length() - 1; i++) {
                sInvertido += sRut1.charAt(i);
                if (i == 1) {
                    sInvertido += ".";
                    npunto = 0;

                } else if (npunto == 3) {
                    sInvertido += ".";

                } else if (nguion == 7) {
                    sInvertido += "-";
                    nguion = 0;
                }

                nPos++;
                npunto++;
                nguion++;
            }
        } else if (sRut1.length() == 8) {
            for (int i = 0; i <= sRut1.length() - 1; i++) {
                sInvertido += sRut1.charAt(i);
                if (i == 0) {
                    sInvertido += ".";
                    npunto = 0;

                } else if (npunto == 3) {
                    sInvertido += ".";

                } else if (nguion == 6) {
                    sInvertido += "-";
                    nguion = 0;
                }

                nPos++;
                npunto++;
                nguion++;
            }
        }

        //Pasamos al campo el valor formateado
        rut = sInvertido.toUpperCase();
        return rut;
    }

    private boolean validarRut(String rut) {
        boolean ret = false;

        if (rut != null && rut.trim().length() > 0) {
            try {
                rut = rut.replaceAll("[.]", "").replaceAll("-", "").trim().toUpperCase();
                char dv = rut.charAt(rut.length() - 1);
                String mantisa = rut.substring(0, rut.length() - 1);
                if (isInteger(mantisa)) {
                    int mantisaInt = Integer.parseInt(mantisa);
                    ret = validarRut(mantisaInt, dv);

                    if (ret == false) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Control de errores");
                        alert.setHeaderText("Dialogo de excepcion");
                        alert.setContentText("Rut no valido");
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
                }

            } catch (Throwable e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Rut no valido");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                e.getMessage();
            }
        }
        return ret;
    }

    private String formatRut(String rut) {
        boolean ret = false;
        String rutVali = " ";
        if (rut != null && rut.trim().length() > 0) {
            try {
                rut = rut.replaceAll("[.]", "").replaceAll("-", "").trim().toUpperCase();
                char dv = rut.charAt(rut.length() - 1);
                String mantisa = rut.substring(0, rut.length() - 1);
                if (isInteger(mantisa)) {
                    int mantisaInt = Integer.parseInt(mantisa);
                    ret = validarRut(mantisaInt, dv);
                    rutVali = mantisa + dv;
                    if (ret == false) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Control de errores");
                        alert.setHeaderText("Dialogo de excepcion");
                        alert.setContentText("Rut no valido");
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
                }

            } catch (Throwable e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Rut no valido");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
                e.getMessage();
            }
        }
        return rutVali;
    }

    private boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;

        }
        return Character.toUpperCase(dv) == (char) (s != 0 ? s + 47 : 75);
    }

    public boolean isInteger(String cad) {
        for (int i = 0; i < cad.length(); i++) {
            if (!Character.isDigit(cad.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    private void iniciarlizarTablaUsuario() {
        idUsu.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("idEmpleado"));
        runUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("run_Empleado"));
        nomUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre_Empleado"));
        apeUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido_Empleado"));
        emailUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, String>("email_Empleado"));
        dirUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("direccion_Empleado"));
        fechanacUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("fecha_nacimiento"));
        ntelUsuario.setCellValueFactory(new PropertyValueFactory<Empleado, Integer>("numero_telefono"));

        usuario = FXCollections.observableArrayList(listaU());
        tablaUsuario.setItems(usuario);

    }

    private final ListChangeListener<Empleado> selectorTablaUsuario = new ListChangeListener<Empleado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends Empleado> c) {
            ponerUsuarioSeleccionado();
        }
    };

    public Empleado getTablaUsuarioSeleccionado() {
        if (tablaUsuario != null) {
            List<Empleado> tabla = tablaUsuario.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Empleado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }

    public void ponerUsuarioSeleccionado() {
        final Empleado usu = getTablaUsuarioSeleccionado();
        posicionUsuarioEnTabla = usuario.indexOf(usu);
        if (usu != null) {
            idUsua.setText(Integer.toString(usu.getIdEmpleado()));
            txtRun.setText(usu.getRun_Empleado());
            txtNombre.setText(usu.getNombre_Empleado());
            txtApellido.setText(usu.getApellido_Empleado());
            txtDireccion.setText(usu.getDireccion_Empleado());
            txtEmail.setText(usu.getEmail_Empleado());
            txtPass.setText(usu.getPass_Empleado());
            txtTel.setText(usu.getNumero_telefono());

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cargarRegion();
            cargarRol();
            cargarEstadoUsuario();
            cargarGenero();
            cargarNacionalidad();
            cargarFiltroRol();
            this.iniciarlizarTablaUsuario();
            final ObservableList<Empleado> tablaUsuSel = tablaUsuario.getSelectionModel().getSelectedItems();
            tablaUsuSel.addListener(selectorTablaUsuario);
            btnBuscar.setOnAction(event -> {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");

                // Agregar filtros para facilitar la busqueda
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );

                // Obtener la imagen seleccionada
                imgFile = fileChooser.showOpenDialog(null);
                Object ex = null;

                /*
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            ivImagen.setImage(image);
        }*/
                Logger.getLogger(Main.class.getName()).log(Level.INFO, null, ex);

            });

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
