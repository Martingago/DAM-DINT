
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alumno
 */
public class Conexion {
   Connection con; 
   
   public Conexion  (){
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","martin1997");

        }catch (Exception e){
            System.err.println("Error, no se pudo conectar con la base de datos. Error: "+ e);
        }
   }
   
   public Connection getConexion(){
       return con;
    }
}


