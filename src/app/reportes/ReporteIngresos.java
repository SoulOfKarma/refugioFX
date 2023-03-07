/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ricar
 */
public class ReporteIngresos {
    
     public void reporteIngresos(String fechaI, String fechaT)
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@172.105.148.58:1521/dbrefugio", "refugio", "refugio");
            //JasperReport reporte =  (JasperReport) JRLoader.loadObject("src/app/reportes/bin/Leaf_Green.jasper");
            Map parametro = new HashMap();
            parametro.put("fechaInicio", fechaI);
            parametro.put("fechaTermino", fechaT);
            JasperPrint j = JasperFillManager.fillReport(ClassLoader.getSystemResourceAsStream("app/reportes/IngresosEmp.jasper"), parametro, conn);
            JasperViewer jv = new JasperViewer(j,false);
            jv.setTitle("Reporte Ganancias");
            jv.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar el reporte "+e);
        }
    }
    
}
