package pantallas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author titab
 */
public class Archivo {
    public String abrirArchivo(String direccionPath){
         String total = "";    
        
            File archivo = new File(direccionPath);
            try{
                BufferedReader leer = new BufferedReader(new FileReader(archivo));
                String linea = leer.readLine();
            
                while(linea != null){
                    total += linea + "\n";
                    linea = leer.readLine();
                }
                return total;
            }catch(Exception e){
                System.out.println(e);
            }
            return total;
    }//Fin de abrir archivo
    
    public boolean guardarArchivo(){
        return false;
    }//Fin guardarArchivo
}//Fin clase
