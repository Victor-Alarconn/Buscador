/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Yonathan Carvajal
 */
public class Usuario {
    
    private int idusuario;
    private String nombre;
    private String apellido; 
    private String numero_documento;
    private int rol;
    private  String sobrerol;
    private String contrasena;
    private int configuraciones;
    private int crearcliente;
    private int carpetas;
    private int servicios;
    private int otros;
    private int crearusuarios;
    private int editarcliente;
    private int estado; 
    private String sobreestado;
    private int modalidad;
    private int buscar;
    private int backups;
    private int cotizaciones;

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public int getBuscar() {
        return buscar;
    }

    public void setBuscar(int buscar) {
        this.buscar = buscar;
    }

    public int getBackups() {
        return backups;
    }

    public void setBackups(int backups) {
        this.backups = backups;
    }

    public int getCotizaciones() {
        return cotizaciones;
    }

    public void setCotizaciones(int cotizaciones) {
        this.cotizaciones = cotizaciones;
    }
    
    

    public String getSobreestado() {
        return sobreestado;
    }

    public void setSobreestado(String sobreestado) {
        this.sobreestado = sobreestado;
    }

    public String getSobrerol() {
        return sobrerol;
    }

    public void setSobrerol(String sobrerol) {
        this.sobrerol = sobrerol;
    }
    

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    

    public int getEditarcliente() {
        return editarcliente;
    }

    public void setEditarcliente(int editarcliente) {
        this.editarcliente = editarcliente;
    }
    
    public int getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(int configuraciones) {
        this.configuraciones = configuraciones;
    }

   

    public int getCrearcliente() {
        return crearcliente;
    }

    public void setCrearcliente(int crearcliente) {
        this.crearcliente = crearcliente;
    }

    public int getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(int carpetas) {
        this.carpetas = carpetas;
    }

    public int getServicios() {
        return servicios;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public int getOtros() {
        return otros;
    }

    public void setOtros(int otros) {
        this.otros = otros;
    }

    public int getCrearusuarios() {
        return crearusuarios;
    }

    public void setCrearusuarios(int crearusuarios) {
        this.crearusuarios = crearusuarios;
    }
    
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
