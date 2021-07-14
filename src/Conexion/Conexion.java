/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mysql.jdbc.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yonathan Carvajal
 */
//Organizad0R contraseña de turis
public class Conexion {
//    private final String base = "organizador";
//    private final String user = "root";
//    private final String passsword = "";
//    private final String url = "jdbc:mysql://localhost:3306/" + base;
//    private Connection con = null;

    private String base;
    private String user;
    private String password;
    private String url;
    private Connection con = null;

    public Connection getConexion() {

        File fichero = new File("env.txt");
        try {
            BufferedReader fil = new BufferedReader(new FileReader(fichero));
            String linea;
            boolean encontrado = false;
            while ((linea = fil.readLine()) != null) {
                if (linea.contains("base")) {
                    base = linea.replace("base: ", "");
                    continue;
                }
                if (linea.contains("user")) {
                    user = linea.replace("user: ", "");
                    continue;
                }
                if (linea.contains("password")) {
                    password = linea.replace("password: ", "");
                    continue;
                }
                if (linea.contains("url")) {
                    url = linea.replace("url: ", "");
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un Error" + e);
            JOptionPane.showMessageDialog(null, "Se ha producido un error", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            System.err.print(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
