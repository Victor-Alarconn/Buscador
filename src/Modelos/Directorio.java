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
public class Directorio {

    private int iddirectorios;
    private String carpeta;
    private int usuarios_idusuarios;
    private int directorios_iddirectorios;
    private int nodo_level;

    public int getNodo_level() {
        return nodo_level;
    }

    public void setNodo_level(int nodo_level) {
        this.nodo_level = nodo_level;
    }
    
    public int getDirectorios_iddirectorios() {
        return directorios_iddirectorios;
    }

    public void setDirectorios_iddirectorios(int directorios_iddirectorios) {
        this.directorios_iddirectorios = directorios_iddirectorios;
    }

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

    //se sobre escribe elmetodo par que no retorne el modelo
    @Override
    public String toString() {
        return carpeta; //To change body of generated methods, choose Tools | Templates.
    }
}
