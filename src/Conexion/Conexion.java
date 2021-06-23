/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yonathan Carvajal
 */

//Organizad0R contraseña de turis
public class Conexion {
    private final String base = "organizador";
    private final String user = "root";
    private final String passsword = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
//    private final String base = "organizadorprueba";
//    private final String user = "Facturar";
//    private final String passsword = "Facturar123";
//    private final String url = "jdbc:mysql://192.168.1.129/" + base;
//    private Connection con = null;
    
    public Connection getConexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(this.url, this.user, this.passsword);
        } catch (SQLException e) {
            System.err.print(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
