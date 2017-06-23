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
public class Admin_Alumnos {
    private ArrayList<Alumnos> listaAlumnos = new ArrayList();
    private File archivo = null;

    public Admin_Alumnos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Alumnos> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumnos> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setAlumno(Alumnos p) {
        this.listaAlumnos.add(p);
    }

    public void cargarArchivo() {
        try {
            listaAlumnos = new ArrayList();
            Alumnos temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Alumnos) objeto.readObject()) != null) {
                        listaAlumnos.add(temp);
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
            for (Alumnos t : listaAlumnos) {
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
