/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Configuraciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Configuracion;
import vistas.Configuraciones;
import vistas.Principal;

/**
 *
 * @author Yonathan Carvajal
 */
public class ConfiguracionesController implements ActionListener {

    private final Configuracion mconfiguraciones;
    private final Consultas_Configuraciones cconfiguraciones;
  private final Configuraciones vconfiguraciones;

    public ConfiguracionesController(Configuracion mconfiguraciones, Consultas_Configuraciones cconfiguraciones, Configuraciones vconfiguraciones) {
        this.mconfiguraciones = mconfiguraciones;
        this.cconfiguraciones = cconfiguraciones;
        this.vconfiguraciones = vconfiguraciones;
        this.vconfiguraciones.guardarconfiguracion.addActionListener(this);
    }

    public void iniciar() {
        vconfiguraciones.setTitle("Configuraciones");
        vconfiguraciones.setLocationRelativeTo(null);
        
        this.config();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vconfiguraciones.guardarconfiguracion) {
            mconfiguraciones.setIdconfiguracion(1);
            mconfiguraciones.setDirectorio(vconfiguraciones.txtdirectorio.getText());
            mconfiguraciones.setPrefijo(vconfiguraciones.txtprefijo.getText().toUpperCase());
            if (cconfiguraciones.modificar(mconfiguraciones)) {
                JOptionPane.showMessageDialog(vconfiguraciones, "registro guardado");
                this.config();
            } else {
                JOptionPane.showMessageDialog(vconfiguraciones, "error al guardar");
            }
        } else {
        }
    }
    public void config(){
        if (cconfiguraciones.cargar(mconfiguraciones)) {
            vconfiguraciones.txtdirectorio.setText(mconfiguraciones.getDirectorio());
            vconfiguraciones.txtprefijo.setText(mconfiguraciones.getPrefijo());
        }else{
            mconfiguraciones.setIdconfiguracion(1);
            mconfiguraciones.setDirectorio("c:\\");
            if (cconfiguraciones.registrar(mconfiguraciones)) {
                config();
            } 
        }
    }
}
