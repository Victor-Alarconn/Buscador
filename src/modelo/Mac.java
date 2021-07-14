/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import static java.time.Clock.system;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    public String conseguirMAC() {
        String firstInterface = null;
        Map<String, String> addressByNetwork = new HashMap<>();
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
                        addressByNetwork.put(network.getName(), sb.toString());
                    }

                    if (sb.toString().isEmpty() == false && firstInterface == null) {
                        firstInterface = network.getName();
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }

        if (firstInterface != null) {
            String MACAddress = addressByNetwork.get(firstInterface);
            return MACAddress;
        }
        return null;
    }

}
