/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yonat
 */
public class Mac {

    private int idmacs;
    private String macs;

    public int getIdmacs() {
        return idmacs;
    }

    public void setIdmacs(int idmacs) {
        this.idmacs = idmacs;
    }

    public String getMacs() {
        return macs;
    }

    public void setMacs(String macs) {
        this.macs = macs;
    }

    //metodo para traer la mac del equipo
    public String conseguirMAC() throws IOException {
        File fichero = new File("temp/mac.json");
        BufferedReader fil;
        try {
            fil = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = fil.readLine()) != null) {
                fil.close();
                return linea;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Mac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void almacenarmac() throws IOException {
        String firstInterface = null;
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface network = networkInterfaces.nextElement();
                byte[] bmac = network.getHardwareAddress();
                if (bmac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < bmac.length; i++) {
                        sb.append(String.format("%02X%s", bmac[i], (i < bmac.length - 1) ? "-" : ""));
                    }
                    if (sb.toString().isEmpty() == false) {
                        try {
                            File archivo = new File("temp" + File.separator + "mac.json");
                            archivo.deleteOnExit();
                            FileWriter fw = new FileWriter(archivo);
                            fw.write(sb.toString());
                            fw.close();
                            break;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }
    }

   

}
