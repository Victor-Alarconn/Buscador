/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Consultas.Consultas_Cliente;
import Consultas.Consultas_Configuraciones;
import Consultas.Consultas_Mac;
import Organizador.Recursos;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.Cliente;
import Modelos.Configuracion;
import Modelos.Mac;
import Modelos.Usuario;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Yonathan Carvajal
 */
public class BackupController  {

    private final Consultas_Cliente ccliente;
    private final Cliente mcliente;
    private final Usuario user;
    Recursos dialogo = new Recursos();

    ArrayList<Configuracion> mconfig;
    Consultas_Configuraciones cconfiguraciones = new Consultas_Configuraciones();
    private String directorio = null;
    private boolean cliente;

    Consultas_Mac cmac = new Consultas_Mac();
    Mac mmac = new Mac();

    public BackupController(Consultas_Cliente ccliente, Cliente mcliente, Usuario user) {
        this.ccliente = ccliente;
        this.mcliente = mcliente;
        this.user = user;
    }

    public void iniciar() throws IOException, ParseException {       
        mmac.setMacs(mmac.conseguirMACi());
        mconfig = cconfiguraciones.cargar();
        for (int i = 0; i < mconfig.size(); i++) {
            if (mconfig.get(i).getModulo().toLowerCase().equals("backups")) {
                directorio = mconfig.get(i).getDirectorio();
            }
        }
        buscar();
    }


    public File Crear_archivo(String path, String nombre) {
        File file = new File(path, nombre);
        return file;
    }

    // funcion para abrir un archivo desde la tabla 
    public void abrirarchivo(String archivo) {
        try {
            File objetofile = new File(archivo);
            Desktop.getDesktop().open(objetofile);
//            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }   

    public void buscar() {
        if (ccliente.buscarcoodigocliente(mcliente)) {
//            System.out.println(mcliente.getBackupruta());
            if (mcliente.getBackupruta() == null || mcliente.getBackupruta().equals("")) {
                int respuesta = dialogo.j();
                if (respuesta == 0) {
                    String nombre = mcliente.getNombre().toUpperCase();
                    File file = Crear_archivo(directorio, mcliente.getCodigo() + "_" + nombre);
                    file.mkdir();
                    String ruta = File.separator + mcliente.getCodigo() + "_" + nombre;
                    mcliente.setIdclientes_potenciales(mcliente.getIdclientes_potenciales());
                    mcliente.setBackupruta(ruta);
                    try {
                        ccliente.modificarruta(mcliente);
                    } catch (IOException ex) {
                        Logger.getLogger(BackupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    abrirarchivo(directorio + ruta);                  
                }
            }else{
                abrirarchivo(directorio + mcliente.getBackupruta()); 
            }
        }
    }   

}
