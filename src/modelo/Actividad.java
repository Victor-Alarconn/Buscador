/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author programacion01
 */
public class Actividad {
    
    private int idactividades;  
    private String fecha;
    private String codigo;
    private String empresa;
    private String reporto;
    private String informe;
    private String del;
    private String agregar;
    private String swp;
    private String macin;
    private String macout;
    private String hecho;
   

    public String getHecho() {
        return hecho;
    }

    public void setHecho(String hecho) {
        this.hecho = hecho;
    }
    

    public String getAgregar() {
        return agregar;
    }

    public void setAgregar(String agregar) {
        this.agregar = agregar;
    }
        
     public int getIdactividades() {
        return idactividades;
    }

    public void setIdactividades(int idactividades) {
        this.idactividades = idactividades;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getReporto() {
        return reporto;
    }

    public void setReporto(String reporto) {
        this.reporto = reporto;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }


    public String getSwp() {
        return swp;
    }

    public void setSwp(String swp) {
        this.swp = swp;
    }

    public String getMacin() {
        return macin;
    }

    public void setMacin(String macin) {
        this.macin = macin;
    }

    public String getMacout() {
        return macout;
    }

    public void setMacout(String macout) {
        this.macout = macout;
    }
       
}
