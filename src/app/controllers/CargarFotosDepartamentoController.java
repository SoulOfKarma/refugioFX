/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAODepartamento;
import app.DAO.DAOFotosDepartamento;
import app.negocio.DepartamentoListado;
import app.negocio.Empleado;
import app.negocio.FotosDepListado;
import app.negocio.FotosDepartamento;
import app.negocio.Region;
import app.negocio.Subirfotos;
import com.sun.javaws.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Ricar
 */
public class CargarFotosDepartamentoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //Declaracion de items para agregar fotos
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
    private void cargarFotosDep(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.cargarFotosDep(event);
            
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
    
    @FXML
    private void detalleGastoMenu(Event event) throws IOException {
        try {
            System.out.println("You clicked me!");
            refu.detalleGastoMenu(event);
            
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    // Boton para buscar las imagenes
    @FXML
    private Button btnBuscar;
    //Boton para guardar y copiar la foto
    @FXML
    private Button btnSubir;
    //Filtro para cargar todo
    @FXML
    private Button btnCargarTodo;
    //Eliminar fotos
    @FXML
    private Button btnEliminar;

    //Combobox Para obtener id del departamento
    @FXML
    private ComboBox<DepartamentoListado> cbDepartamento;
    //Para filtro
    @FXML
    private ComboBox<DepartamentoListado> cbFilDep;

    //Tabla y columnas
    @FXML
    private TableView<FotosDepListado> tableFotosDep;
    @FXML
    private TableColumn IDDep;
    @FXML
    private TableColumn IDFotos;
    @FXML
    private TableColumn nomFoto;
    @FXML
    private TableColumn tableDep;
    
    ObservableList<FotosDepListado> fotosDep;

    //Otras Variables
    @FXML
    private Label lbIdDep;
    @FXML
    private Label idFotDep;
    private int posicionFotosDepEnTabla;

    //Declaracion de FileType
    private File imgFile;
    
    @FXML
    private void btnSubir() throws MalformedURLException, IOException {
        Subirfotos sub = new Subirfotos();
        FotosDepartamento fot = new FotosDepartamento();
        fot.setIdDep(cbDepartamento.getValue().getId());
        fot.setNomFoto(imgFile.getName());
        DAOFotosDepartamento dao = new DAOFotosDepartamento();
        dao.agregarFotoDepartamento(fot);
        sub.foto(imgFile);
        iniciarlizarTablaDep();
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Control de errores");
            alert.setHeaderText("Mensaje");
            alert.setContentText("Imagen subida correctamente");
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
    
    @FXML
    private void btnCargarTodo()  {
        iniciarlizarTablaDep();      
    }
    
    @FXML
    private void btnEliminar()  {
        int id = Integer.parseInt(lbIdDep.getText());
        int idfot = Integer.parseInt(idFotDep.getText());
        
        if(id == 0)
        {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Debe seleccionar alguna imagen de la tabla para poder eliminarla");
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
        else
        {
                DAOFotosDepartamento dao = new DAOFotosDepartamento();
                dao.eliminarFoto(id, idfot);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Mensaje");
                alert.setContentText("Foto eliminada correctamente");
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

    //Listados para cargas de datos
    private List listaD() {
        DAODepartamento dao = new DAODepartamento();
        
        ArrayList<DepartamentoListado> listaR = dao.listarDepartamentos();
        
        return listaR;
    }
    
    private List listaTabla() {
        DAOFotosDepartamento dao = new DAOFotosDepartamento();
        
        ArrayList<FotosDepListado> listaR = dao.listaTabla();
        
        return listaR;
    }
    
    private List listaTablaFiltrada(int id) {
        DAOFotosDepartamento dao = new DAOFotosDepartamento();
        
        ArrayList<FotosDepListado> listaR = dao.listaTablaFiltrada(id);
        
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
        cbFilDep.setItems(listD);

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
        
        cbFilDep.setConverter(converterR);
        //Seteando los valores al combobox de region
        cbFilDep.getSelectionModel().selectedItemProperty().addListener((o, ol, nw) -> {
            System.out.println(cbFilDep.getValue().getNombre_propiedad());
        });
        
    }
    
    @FXML
    private void filtroDepartamento() {
        try {
            if (cbFilDep.getValue().getId() != 0) {
                int id = cbFilDep.getValue().getId();
                IDDep.setCellValueFactory(new PropertyValueFactory<FotosDepListado, Integer>("idDep"));
                IDFotos.setCellValueFactory(new PropertyValueFactory<FotosDepListado, Integer>("idFoto"));
                tableDep.setCellValueFactory(new PropertyValueFactory<FotosDepListado, String>("departamentoNom"));
                nomFoto.setCellValueFactory(new PropertyValueFactory<FotosDepListado, String>("nomFoto"));
                
                fotosDep = FXCollections.observableArrayList(listaTablaFiltrada(id));
                tableFotosDep.setItems(fotosDep);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    private void iniciarlizarTablaDep() {
        IDDep.setCellValueFactory(new PropertyValueFactory<FotosDepListado, Integer>("idDep"));
        IDFotos.setCellValueFactory(new PropertyValueFactory<FotosDepListado, Integer>("idFoto"));
        tableDep.setCellValueFactory(new PropertyValueFactory<FotosDepListado, String>("departamentoNom"));
        nomFoto.setCellValueFactory(new PropertyValueFactory<FotosDepListado, String>("nomFoto"));
        
        fotosDep = FXCollections.observableArrayList(listaTabla());
        tableFotosDep.setItems(fotosDep);
        
    }
    
    private final ListChangeListener<FotosDepListado> selectorTablaFotosDep = new ListChangeListener<FotosDepListado>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends FotosDepListado> c) {
            ponerDepartamentoSeleccionado();
        }
    };
    
    public FotosDepListado getTablaDepartamentoSeleccionado() {
        if (tableFotosDep != null) {
            List<FotosDepListado> tabla = tableFotosDep.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final FotosDepListado seleccion = tabla.get(0);
                return seleccion;
            }
        }
        return null;
    }
    
    public void ponerDepartamentoSeleccionado() {
        final FotosDepListado depto = getTablaDepartamentoSeleccionado();
        posicionFotosDepEnTabla = fotosDep.indexOf(depto);
        if (depto != null) {
            lbIdDep.setText(Integer.toString(depto.getIdDep()));
            idFotDep.setText(Integer.toString(depto.getIdFoto()));
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarDepartamentos();
        iniciarlizarTablaDep();
        cargarFiltroDepartamentos();
        
        final ObservableList<FotosDepListado> tablaDepSel = tableFotosDep.getSelectionModel().getSelectedItems();
        tablaDepSel.addListener(selectorTablaFotosDep);
        
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
    }
    
}
