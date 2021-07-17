/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organizador;

import Consultas.Consultas_Clase;
import Consultas.Consultas_Cliente;
import Consultas.Consultas_Llego;
import Consultas.Consultas_Mac;
import Consultas.Consultas_Modalidad;
import Consultas.Consultas_Modulos;
import Consultas.Consultas_Servicios;
import Consultas.Consultas_roles;
import Consultas.Consultas_usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.ArrayList;

import modelo.Mac;
import modelo.Modulo;
import modelo.Rol;
import modelo.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import vistas.login;

/**
 *
 * @author Yonathan Carvajal
 */
public class Buscador {

    /**
     * @param args the command line arguments
     */
    static Consultas_roles cr = new Consultas_roles();

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, Exception {

        Consultas_usuario cu = new Consultas_usuario();
        Buscador b = new Buscador();
        Consultas_Modulos cm = new Consultas_Modulos();
        Consultas_Mac cmac = new Consultas_Mac();
        
        Mac mmac = new Mac();
        Rol rol = new Rol();

        //consulta mac
        String mac = mmac.conseguirMAC();
        cmac.jsonmacs();
        mmac.setMacs(mac);
        if (!cmac.buscar(mmac)) {
            cmac.registrar(mmac);
        }
        
        //registro de usuario por default
        Usuario u = new Usuario();
        u.setNombre("admin");
        u.setContrasena("123");
        u.setConfiguraciones(1);
        u.setCrearcliente(1);
        u.setCarpetas(1);
        u.setServicios(1);
        u.setOtros(1);
        u.setCrearusuarios(1);
        u.setEditarcliente(1);
        u.setRol(1);

        //funcion para agregar los roles cuando se instala la app
        rol.setRol("admin");
        rol.setIdroles(1);
        if (!cr.consulta(rol)) {
            if (b.agregarrol(rol)) {
                rol.setRol("user");
                rol.setIdroles(2);
                b.agregarrol(rol);
            }
        }

        //condicional para saber si existe el usuario por default
        if (!cu.logindefault(u)) {
            // si el usuario no existe crea uno nuevo
            cu.registrar(u);
        }
        login login = new login();
        login.setVisible(true);
        
        Modulo mm = new Modulo();
        //llamda al metodo que crea el archivo modulos.json
        cm.jsonmodulos();
        
        Consultas_Clase cc = new Consultas_Clase();
        //llamda al metodo que crea el archivo clases.json
        cc.jsonclases();
        
        Consultas_Llego llego = new Consultas_Llego();
        //llamda al metodo que crea el archivo llego.json
        llego.jsonllego();
        
        Consultas_Modalidad modalidad = new Consultas_Modalidad();
        //llamda al metodo que crea el archivo modalidad.json 
        modalidad.jsonmodalidad();
        
        Consultas_Servicios servicios = new Consultas_Servicios();
        //llamda al metodo que crea el archivo servicios.json 
        servicios.jsonservicios();
        //llamda al metodo que crea el archivo clientes.json 
        Consultas_Cliente cliente = new Consultas_Cliente();
        cliente.jsonclientes();
        
        
        
        //metodo para crear los modulos
        ArrayList<Modulo> md = cm.llenar();

        ArrayList<String> lista = new ArrayList<>();
        lista.add("Clientes");
        lista.add("Cotizaciones");
        lista.add("Backups");
        boolean estado = true;
        if (md.isEmpty()) {
            for (int j = 0; j < lista.size(); j++) {
                mm.setModulo(lista.get(j));
                mm.setUsuarios_idusuario(u.getIdusuario());
                cm.registrar(mm);
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {

                for (int j = 0; j < md.size(); j++) {

                    if (md.get(j).getModulo().equals(lista.get(i))) {
                        estado = false;
                        break;
                    } else {
                        estado = true;
                    }
                }
                if (estado) {
                    mm.setModulo(lista.get(i));
                    mm.setUsuarios_idusuario(u.getIdusuario());
                    cm.registrar(mm);
                }
            }

        }
        

    }

    public boolean agregarrol(Rol rol) {

        return cr.registrar(rol);
    }

}
