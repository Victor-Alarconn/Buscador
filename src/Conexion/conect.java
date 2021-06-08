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
public class conect {
    private final String base = "u523374635_organizador";
    private final String user = "u523374635_organizador";
    private final String passsword = "Organizad0R";
    private final String url = "jdbc:mysql://31.170.167.102/" + base;
    private Connection con = null;
    
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
