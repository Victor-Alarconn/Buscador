/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author yonat
 */
public class Modalidad {
    private int idmodalidad;
    private String modalidad;
    private int usuarios_idusuario;

    public int getIdmodalidad() {
        return idmodalidad;
    }

    public void setIdmodalidad(int idmodalidad) {
        this.idmodalidad = idmodalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getUsuarios_idusuario() {
        return usuarios_idusuario;
    }

    public void setUsuarios_idusuario(int usuarios_idusuario) {
        this.usuarios_idusuario = usuarios_idusuario;
    }
    
    @Override
    public String toString() {
        return modalidad; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
