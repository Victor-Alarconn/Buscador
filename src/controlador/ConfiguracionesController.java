/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Configuracion;
import modelo.Usuario;
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

    Consultas_usuario cu = new Consultas_usuario();
    Usuario u = new Usuario();

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
            if (cconfiguraciones.modificar(mconfiguraciones)) {
                JOptionPane.showMessageDialog(vconfiguraciones, "registro guardado");
                if (!vconfiguraciones.usuariodefecto.isSelected()) {
                    u.setEstado(1);
                    u.setNombre("admin");
                    cu.modificar(u);
                } else {
                    u.setEstado(0);
                    u.setNombre("admin");
                    cu.modificar(u);
                }
                this.config();
            } else {
                JOptionPane.showMessageDialog(vconfiguraciones, "error al guardar");
            }

        }
    }

    public void config() {
        if (cconfiguraciones.cargar(mconfiguraciones)) {
            vconfiguraciones.txtdirectorio.setText(mconfiguraciones.getDirectorio());
        } else {
            mconfiguraciones.setIdconfiguracion(1);
            mconfiguraciones.setDirectorio("c:\\");
            if (cconfiguraciones.registrar(mconfiguraciones)) {
                config();
            }
        }

        u.setNombre("admin");
        if (cu.buscarusueriodefault(u)) {
            if (u.getEstado() == 0) {
                vconfiguraciones.usuariodefecto.setSelected(true);
            }
        }

    }
}
