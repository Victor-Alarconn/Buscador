/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.InetAddress;
import java.net.NetworkInterface;

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
    //metodo para traer la mac de l equipo
    public String conseguirMAC() {
        NetworkInterface a;
        String linea;
        try {
            a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            byte[] mac = a.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
