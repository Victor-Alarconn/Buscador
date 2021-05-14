/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vistas.Registro_Usuario;


/**
 *
 * @author Yonathan Carvajal
 */
public class UsuarioController implements ActionListener {

    private final Usuario modelo;
    private final Consultas_usuario consulta;
    private final Registro_Usuario vista;

    public UsuarioController(Usuario modelo, Consultas_usuario consulta, Registro_Usuario vista) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.vista = vista;
        this.vista.guardar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Registrar");
        vista.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == vista.guardar) {
            modelo.setNombre(vista.txtnombre.getText());
            modelo.setApellido(vista.txtapellido.getText());
            modelo.setNumero_documento(vista.txtdocumento.getText());
            if (consulta.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "registro guardado");
                this.limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error guardado");
            }
        }
        
        
        
        
        
        
        
    }
    public void limpiar(){
        vista.txtnombre.setText("");
        vista.txtapellido.setText("");
        vista.txtdocumento.setText("");
    }
}
