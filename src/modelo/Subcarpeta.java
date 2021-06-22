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
public class Subcarpeta {
    
    private int idsubcarpetas;
    private String subcarpeta;
    private int directorios_iddirectorios;
    private int usuario_idusurio;

    public int getUsuario_idusurio() {
        return usuario_idusurio;
    }

    public void setUsuario_idusurio(int usuario_idusurio) {
        this.usuario_idusurio = usuario_idusurio;
    } 
    
    public int getIdsubcarpetas() {
        return idsubcarpetas;
    }

    public void setIdsubcarpetas(int idsubcarpetas) {
        this.idsubcarpetas = idsubcarpetas;
    }

    public String getSubcarpeta() {
        return subcarpeta;
    }

    public void setSubcarpeta(String subcarpeta) {
        this.subcarpeta = subcarpeta;
    }

    public int getDirectorios_iddirectorios() {
        return directorios_iddirectorios;
    }

    public void setDirectorios_iddirectorios(int directorios_iddirectorios) {
        this.directorios_iddirectorios = directorios_iddirectorios;
    }
    
    
    
}
