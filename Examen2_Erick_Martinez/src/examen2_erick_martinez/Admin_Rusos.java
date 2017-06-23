/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2_erick_martinez;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Admin_Rusos {
    private ArrayList<Rusos> listaRusos = new ArrayList();
    private File archivo = null;

    public Admin_Rusos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Rusos> getListaRusos() {
        return listaRusos;
    }

    public void setListaRusos(ArrayList<Rusos> listaRusos) {
        this.listaRusos = listaRusos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setRuso(Rusos p) {
        this.listaRusos.add(p);
    }

    public void cargarArchivo() {
        try {
            listaRusos = new ArrayList();
            Rusos temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Rusos) objeto.readObject()) != null) {
                        listaRusos.add(temp);
                    }
                } catch (EOFException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void escribirArchivo(){
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Rusos t : listaRusos) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        }
        finally{
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
            }
        }
    }
}
