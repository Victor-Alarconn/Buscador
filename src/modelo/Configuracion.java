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
public class Configuracion {
    private int idconfiguracion;
    private String directorio;
    private int usuarios_idusuario;
    private int modulos_idmodulos;
    private String modulo;
    private int macs_idmacs;

    public int getMacs_idmacs() {
        return macs_idmacs;
    }

    public void setMacs_idmacs(int macs_idmacs) {
        this.macs_idmacs = macs_idmacs;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public int getModulos_idmodulos() {
        return modulos_idmodulos;
    }

    public void setModulos_idmodulos(int modulos_idmodulos) {
        this.modulos_idmodulos = modulos_idmodulos;
    }

    public int getUsuarios_idusuario() {
        return usuarios_idusuario;
    }

    public void setUsuarios_idusuario(int usuarios_idusuario) {
        this.usuarios_idusuario = usuarios_idusuario;
    }
    
    public int getIdconfiguracion() {
        return idconfiguracion;
    }

    public void setIdconfiguracion(int idconfiguracion) {
        this.idconfiguracion = idconfiguracion;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }
    
}
