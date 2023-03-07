/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.DAO.DAOUsuario;
import app.negocio.Empleado;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ricar
 */
public class FXMLDocumentController implements Initializable {

    private Stage stagePrincipal;
    private Refugio refu = new Refugio();

    @FXML
    private Label label;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    Stage prevStage;

    public void setPrevStage(Stage stage) {
        this.prevStage = stage;
    }

    // Declaracion del FontAwesome
    @FXML
    private FontAwesomeIcon btnCerrarApp;

    //Declaracion de los JFXField y password
    @FXML
    private JFXTextField txtCorreo;
    @FXML
    private JFXPasswordField txtPass;

    @FXML
    private void login(Event event) throws IOException {
        try {
            DAOUsuario dao = new DAOUsuario();
            org.springframework.security.crypto.password.PasswordEncoder encoder
             = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
            String a = txtPass.getText();
            String pass = encoder.encode(txtPass.getText());
            List<Empleado> val = dao.validacionLogin(txtCorreo.getText());
            Empleado emp = new Empleado();
            boolean validar = false;
            for (Empleado temp : val) {
                
                if(val != null){
                 emp.setRol_usuario(temp.getRol_usuario());
                 boolean pa = encoder.matches(a, temp.getPass_Empleado());
                 if(pa == true)
                 {
                  validar = true;
                 }
                 
                }
            }
            if (validar == false) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Error de usuario o contraseña, Intentelo nuevamente");
                Exception ex = new FileNotFoundException("Error.txt");
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                //String exceptionText = sw.toString();
                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            } else if (emp.getRol_usuario() != 100) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Control de errores");
                alert.setHeaderText("Dialogo de excepcion");
                alert.setContentText("Rol de usuario no permitido para ingresar");
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

                refu.login(event);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @FXML
    private void cerrarAplicacion(Event event) throws IOException {
        try {
            refu.cerrarAplicacion(event);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
