/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author yonathan
 */
public class Directorio {
    private int iddirectorios;
    private String carpeta;
    private int usuarios_idusuarios;

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }
    
    public int getIddirectorios() {
        return iddirectorios;
    }

    public void setIddirectorios(int iddirectorios) {
        this.iddirectorios = iddirectorios;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }
}
