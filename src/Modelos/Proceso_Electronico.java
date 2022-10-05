/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author programacion01
 */
public class Proceso_Electronico {
    private int idp_electronicos;
    private String proceso;
    private int usuarios_idusuarios;

    public int getIdp_electronicos() {
        return idp_electronicos;
    }

    public void setIdp_electronicos(int idp_electronicos) {
        this.idp_electronicos = idp_electronicos;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    } 
     @Override
    public String toString() {
        return proceso; //To change body of generated methods, choose Tools | Templates.
    }
    
}
