/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Grego
 */
public class CodigoMaquina {
    LinkedList<String[]> code = new LinkedList<>();
    String maquina = "";
    String nombreArchivo = "";
    String base = "";
    ProcessBuilder processBuilder = new ProcessBuilder();
    String path = "C:\\Users\\Grego\\Documents\\9noSemestre\\LENG_Y_AUTOM_II\\Compilador\\cli\\";
    String pathBase = "C:\\Users\\Grego\\Documents\\9noSemestre\\LENG_Y_AUTOM_II\\Compilador\\src\\build\\base.ino";
    
    public CodigoMaquina(LinkedList<String> codigo){
        try {
            base = (new Archivo().abrirArchivo(pathBase));
        }catch (Exception e) {
            showMessageDialog(null ,"No se encontro el archivo base","Advertencia!", JOptionPane.WARNING_MESSAGE);
        }
            
        for(String obj: codigo){
            String[] s = obj.split(":");
            code.add(s);
        }
    }
    
    public void ensamblador(){
        for(String[] inter : code){
            switch(inter[0]){
                case "vel":
                    break;
            }
        }
    }
    
    public String creador() {
        while(nombreArchivo.isEmpty()){
            nombreArchivo = JOptionPane.showInputDialog("Ingresa el nombre del archivo: ");
            if(!nombreArchivo.matches("^[\\w]\\w+\\d*")){
                showMessageDialog(null, "Ingresa un nombre valido, letras seguido de mas letras o digitos");
                nombreArchivo = "";
            } 
        }
        
        if(guardarArchivo(base)){
            showMessageDialog(null, "Error al guardar documento, por favor vuelva a intentarlo");
        }
        
        compilar(nombreArchivo);
        
        return nombreArchivo;
    }
    
    public boolean guardarArchivo(String machine){
        try{
            File fichero = new File(path + nombreArchivo + "\\" + nombreArchivo + ".ino");
            
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            
            PrintWriter writer;
            try{
                writer = new PrintWriter(fichero);
                writer.print(machine);
                writer.close();
            }catch(FileNotFoundException e){
                System.out.println(e);
                return true;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
            return true;
        }   
            
        return false;
    }//Fin guardarArchivo
    
    public void compilar(String nombreDirectorio){
        //El archivo .ino debe de encontrarse en una carpeta
        //Primero compilamos el archivo .ino, esto creara los archivos .elf y .hex 
        compilarMensajes(processBuilder.command("cmd.exe", "/c", path + "mkdir " + nombreDirectorio));

        //Para mas informacion: https://github.com/arduino/arduino-cli
    }
    
    public void compilarMensajes(ProcessBuilder pb){
        try {

		Process process = pb.start();

		StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}

		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			System.exit(0);
		} else {
			//abnormal...
		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
    
    public void getCode(){
        for(String[] c : code)
            for(Object s: c)
                System.out.println(s.toString());
    }
}
