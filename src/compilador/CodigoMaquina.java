/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
    private String nombredePrograma = "";
    ProcessBuilder processBuilder = new ProcessBuilder();
    String path = "C:\\Users\\juven\\OneDrive\\Documentos\\GitHub\\Compilador\\cli\\";
    String pathBase = "C:\\Users\\juven\\OneDrive\\Documentos\\GitHub\\Compilador\\src\\build\\base.ino";
    HashMap<String, String> dict = new HashMap<>();
    
    CodigoMaquinaPantalla cmp;
    
    public CodigoMaquina(LinkedList<String> codigo){
        try {
            base = (new Archivo().abrirArchivo(pathBase));
        }catch (Exception e) {
            showMessageDialog(null ,"No se encontro el archivo base","Advertencia!", JOptionPane.WARNING_MESSAGE);
        }
            
        for(String obj: codigo){
            String[] s = obj.replace("\t", "").split("~");
            code.add(s);
        }
        
        cmp = new CodigoMaquinaPantalla();
        cmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cmp.setLocationRelativeTo(null);
    }
    
    /*
    Codigo para detenerse y avanzar
    //detener(); 
    //delay(2000);
    //avanzar();
    
    Codigo para avanzar
   //avanzar(); 
    
    Codigo para girar
    //detener(); 
    //delay(800);
    //giro(); 
    //detener(); 
    
    Codigo para 
    
    */
    
    public String getNombredePrograma(){
        return this.nombredePrograma;
    }
    
    
    public void ensamblador(){
        String delay = "";
        String avanzar = "camaraAbajo();\ndelay(1000);\navanzar();";
        String esperar = "detener();\ndelay(dealy);\navanzar();";
        String detener = "detener();";
        String retorno = "detener();\ndelay(800);\nretorno();\ndetener();";
        String siRojo = "if (red < blue && red < green && red < 20)";
        String siAzul = "if (blue < red && blue < green)";
        String siVerde = "if (green < red )";
        String siNegro = "if (red > 40 && green >53 && blue >30 )";
        String decisionColor = "";
        String valor = "";
        String tempColor = "";
        String cuerpo="";
        
        Boolean cuerpoCic = false;
        Boolean cuerpoSi = false;
         
        for(String[] inter : code){
            String tipo = inter[0];
            String obj = inter[1];
            if(tipo.equals("ini") && !obj.equals("fin")){
                String[] titulo = obj.split(" ");
                this.nombredePrograma = titulo[1];
            }
            System.out.println(tipo + " " + obj);
            if(obj.contains("=")){
                String[] tem = obj.replace(" ", "").replace("==", "&&").replace("!=", "!&").replace("<=", "<&").replace(">=", ">&").split("=");
                
                try{
                    System.out.println(tem[0] + " " + tem[1]);
                } catch(Exception e){
                    //System.out.println("Error de lectura de datos");
                }

                try{
                    if(tem[0].matches("[t][e][m][p][0-9]{1,3}")){
                        String[] opcion = tem[1].split("&&");
                        if(opcion.length==1){
                            opcion = tem[1].split("!&");
                        } else if(opcion.length==1){
                            opcion = tem[1].split("<&");
                        } else if(opcion.length==1){
                            opcion = tem[1].split(">&");
                        } else if(opcion.length==1){
                            opcion = tem[1].split(">");
                        } else if(opcion.length==1){
                            opcion = tem[1].split("<");
                        }
                        dict.put(tem[0], opcion[1]);
                        continue;
                    }
                    
                } catch (Exception arr){
                    //arr.printStackTrace();
                }
            }
            switch(tipo){
                case "vel":
                    base = base.replaceFirst("//&&", "int " + obj  + ";\n//&&\n");
                    //System.out.println("Velocidad: " + obj);
                    String[] objeto = obj.split("=");
                    dict.put(objeto[0], objeto[1]);
                    break;
                case "col":
                    String color = obj.substring(obj.length()-1,obj.length());
                    switch(color){
                        case "r":
                            obj = obj.replace("=r", "=\"red\"");
                            break;
                        case "g":
                            obj = obj.replace("=g", "=\"green\"");
                            break;  
                        case "b":
                            obj = obj.replace("=b", "=\"blue\"");
                            break;
                        case "n":
                            obj = obj.replace("=n", "=\"black\"");
                            break;
                    }
                    String[] colo = obj.split("=");
                    dict.put(colo[0], colo[1].replace("\"", ""));
                    base = base.replaceFirst("//&&", "String " + obj  + ";\n//&&\n");
                    break;
                case "tim":
                    System.out.println("Tiempo: " + obj);
                    String[] tiempo = obj.split("=");
                    String[] temporal = tiempo[1].split(":");
                    int tam = Integer.parseInt(temporal[0])*10 + Integer.parseInt(temporal[1])*1;
                    if(tam>255)
                        tam = 250;
                    base = base.replaceFirst("//&&", "int " + tiempo[0] + " = " + tam  + ";\n//&&\n");
                    dict.put(tiempo[0], tam + "");
                    break;
                case "alt":
                    base = base.replaceFirst("//&&", "String " + obj  + ";\n//&&");
                    break;
                case "des":
                    if(obj.contains("si")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        //System.out.println("Cuerpo del temporal: " + dict.get(cuerpo));
                        decisionColor = dict.get(cuerpo);
                        cuerpoSi = true;
                    }
                    if(obj.contains("avanzar")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        //System.out.println("Color por el que se movera el auto: " + dict.get(decisionColor));
                        base = base.replaceFirst("//&&velocidad", "int velocidad = " + dict.get(cuerpo) + ";\n");
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", avanzar + "\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", avanzar + "\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", avanzar + "\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", avanzar + "\n//&&green");
                                break;
                        }
                    } else
                    if(obj.contains("esperar")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        System.out.println("Tiempo parametro: " + cuerpo);
                        System.out.println("Tiempo de espera del auto: " + dict.get(cuerpo));
                        base = base.replaceFirst("//&&dealy", "int dealy = " + dict.get(cuerpo) + ";\n");
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", esperar + ";\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", esperar + ";\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", esperar + ";\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", esperar + ";\n//&&green");
                                break;
                        }
                    } else
                    if(obj.contains("detener")){
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", detener + ";\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", detener + ";\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", detener + ";\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", detener + ";\n//&&green");
                                break;
                        }
                    }
                    break;
                case "cic":
                    if(obj.contains("mientras")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        //System.out.println("Cuerpo del temporal: "  + dict.get(cuerpo));
                        decisionColor = dict.get(cuerpo);
                    }
                    if(obj.contains("avanzar")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        //System.out.println("Color por el que se movera el auto: " + dict.get(decisionColor));
                        int velocidad = 0;
                        if(Integer.parseInt(dict.get(cuerpo))*10>255)
                            velocidad = 250;
                        else 
                            velocidad = Integer.parseInt(dict.get(cuerpo))*10;
                        base = base.replaceFirst("//&&velocidad", "int velocidad = " + velocidad + ";\n");
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", avanzar + "\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", avanzar + "\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", avanzar + "\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", avanzar + "\n//&&green");
                                break;
                        }
                    } else
                    if(obj.contains("esperar")){
                        cuerpo = obj.substring(obj.indexOf("(")+1, obj.indexOf(")"));
                        System.out.println("Tiempo parametro: " + cuerpo);
                        System.out.println("Tiempo de espera del auto: " + dict.get(cuerpo));
                        base = base.replaceFirst("//&&dealy", "int dealy = " + dict.get(cuerpo) + ";\n");
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", esperar + "\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", esperar + "\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", esperar + "\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", esperar + "\n//&&green");
                                break;
                        }
                    } else
                    if(obj.contains("detener")){
                        switch(dict.get(decisionColor)){
                            case "black":
                                base = base.replaceFirst("//&&black", detener + ";\n//&&black");
                                break;
                            case "red":
                                base = base.replaceFirst("//&&red", detener + ";\n//&&red");
                                break;
                            case "blue":
                                base = base.replaceFirst("//&&blue", detener + ";\n//&&blue");
                                break;
                            case "green":
                                base = base.replaceFirst("//&&green", detener + ";\n//&&green");
                                break;
                        }
                    }
            }
            if(base.contains("//&&dealy")){
                base = base.replaceFirst("//&&dealy", "int dealy = " + 2000 + ";\n");
            }
            
        }
        dict.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        
        cmp.setCodigoMaquina(base);
        cmp.setVisible(true);
    }
    
   
    
    public Boolean creador(String nombre) {
        if(nombre.isEmpty()){
            while(nombreArchivo.isEmpty()){
                nombreArchivo = JOptionPane.showInputDialog("Ingresa el nombre del archivo: ");
                if(!nombreArchivo.matches("^[\\w]\\w+\\d*")){
                    System.out.println("Ingresa un nombre valido, letras seguido de mas letras o digitos");
                    nombreArchivo = "";
                } 
            }
        } else 
            nombreArchivo = nombre;
        
        try {
            compilar(nombreArchivo);
        } catch(Exception e) {
            return true;
        }
        
        if(guardarArchivo(base)){
            System.out.println("Error al guardar documento, por favor vuelva a intentarlo");
            return true;
        }
        return false;
    }
    
    public boolean guardarArchivo(String machine){
        try{
            File fichero = new File(path + nombreArchivo + "\\" + nombreArchivo + ".ino");
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
            
            /*
            try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
            bw.write("");
            
            bw.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
            */
            
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
        compilarMensajes(processBuilder.command("cmd.exe", "/c", path + "arduino-cli.exe sketch new " + path + nombreDirectorio));

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
        for(String[] c : code){
            System.out.println();
            for(Object s: c)
                System.out.print(s.toString() + " ");
        }
    }
}
