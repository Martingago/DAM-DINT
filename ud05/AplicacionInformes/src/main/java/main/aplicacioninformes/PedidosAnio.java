package main.aplicacioninformes;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class PedidosAnio {

    public static Connection conexion = null;
    String baseDatos = "jdbc:mysql://localhost/fabrica";
    String usuario = "root"; //Aquí cada uno debe poner su usuario de mysql 
    String clave = "martin1997"; //Aquí cada uno debe poner su contraseña de mysql 

    public PedidosAnio() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conexion = DriverManager.getConnection(baseDatos, usuario, clave);
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Fallo al cargar JDBC");
            System.exit(1);
        } catch (SQLException sqle) {
            System.err.println("No se pudo conectar a BD");
            System.exit(1);
        } catch (java.lang.InstantiationException sqlex) {
            System.err.println("Imposible Conectar");
            System.exit(1);
        } catch (Exception ex) {
            System.err.println("Imposible Conectar");
            System.exit(1);
        }
    }
    //El método ejecutar recibe el parametro del informe 

    public void ejecutar(int año) {
        //Ruta del informe respecto del proyecto NetBeans 
        String archivojasper = "src/main/java/main/aplicacionInformes/PedidosCiudadParametro.jasper";
        try {
            Map parametros = new HashMap();
            parametros.put("año", año);
            //Generamos el informe en memoria 
            JasperPrint print = JasperFillManager.fillReport(archivojasper, parametros, conexion);
            // Exporta el informe a PDF  
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");
            //Abre el archivo PDF generado 
            File path = new File("informe.pdf");
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
