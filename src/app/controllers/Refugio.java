/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Ricar
 */
public class Refugio extends Application {
    private double xOffset = 0; 
private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception {
        try
        {
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/FXMLDocument.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
    }
      
    public void login(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/MenuPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
            
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void reporteGastos(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ReportesGasto.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void reporteDepto(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ReportesDeptoMasArrendado.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void reporteGanancia(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ReportesGanancia.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void reporteCliente(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ReportesClientes.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void reporteIngresos(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ReportesIngresos.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();

        
       
    }
    
    public void depMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Departamento.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        appStage.centerOnScreen();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    public void detalleGastoMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/DetalleGasto.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        appStage.centerOnScreen();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    public void menuPrincipal(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/MenuPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    public void cargarFotosDep(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/CargarFotosDepartamento.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    
    public void cerrarSesion(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }

    public void invMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Inventario.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    public void usuariosMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Usuario.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
    public void reportesMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Reportes.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
    
     public void servExtraMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/ServicioExtra.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
     
      public void proveedoresMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Proveedores.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
      
      public void gastosMenu(Event event) throws IOException {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/Gastos.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                appStage.setX(event.getScreenX() - xOffset);
                appStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();
        }
        catch(Exception e)
        {
            System.out.println("Error "+e);
        }
        
       
    }
      
      public void cerrarAplicacion(Event event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/appviews/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.close();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
