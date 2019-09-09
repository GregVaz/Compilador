/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author Grego
 */
public class Principal {
    public static void main(String[]args) throws Exception{
        String ruta1 = "C:/Compilador/src/compilador/lexer.flex";
        String ruta2 = "C:/Compilador/src/compilador/lexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Compilador/src/compilador/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Compilador/src/compilador/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Compilador/sym.java"), 
                Paths.get("C:/Compilador/src/compilador/sym.java")
        );
        Path rutaSin = Paths.get("C:/Compilador/src/compilador/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Compilador/Sintax.java"), 
                Paths.get("C:/Compilador/Sintax.java")
        );
    }
}
