/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Yonathan Carvajal
 */
public class Documentos {
    private int iddocumentos;
    private String documento;
    private String fecha_inicio;
    private String fecha_vencimiento;
    private int clientes_potenciales_idclientes_potenciales;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIddocumentos() {
        return iddocumentos;
    }

    public void setIddocumentos(int iddocumentos) {
        this.iddocumentos = iddocumentos;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getClientes_potenciales_idclientes_potenciales() {
        return clientes_potenciales_idclientes_potenciales;
    }

    public void setClientes_potenciales_idclientes_potenciales(int clientes_potenciales_idclientes_potenciales) {
        this.clientes_potenciales_idclientes_potenciales = clientes_potenciales_idclientes_potenciales;
    }
    
}
