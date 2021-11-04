/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author yonathan
 */
public class Clases {
    private int idclases;
    private String clase;
    private int usuarios_idusuarios;

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }

    public int getIdclases() {
        return idclases;
    }

    public void setIdclases(int idclases) {
        this.idclases = idclases;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return clase; //To change body of generated methods, choose Tools | Templates.
    }
    
}
