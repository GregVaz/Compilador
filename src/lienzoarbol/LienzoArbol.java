/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lienzoarbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import logica.Arbol;

/**
 *
 * @author daniel
 */
public class LienzoArbol {
    private String expresion;
    LinkedList<String> pos = new LinkedList<>();
    private Stack<Character> pila = new Stack<Character>();
    /**
     * @param args the command line arguments
     */
    
    public LienzoArbol(String exp){
        this.expresion = exp;
    }
    
    public void postfija() {
        String[] fija = this.expresion.split(" ");
        for(String f : fija){
            System.out.println(f);

        }
    }
    
    private void evaluar(){
        String infija = this.expresion;   
        
        //Validamos que la emprecion tecleada no este en blanco.
        if(infija.equals("")){
            return;
        }
        
        //Validamos que los parentesis esten correctamente anidados
        if(validarParentesis(infija)){
            System.out.println("Los parentesis estan escritos de forma correcta");
        }
        else{
            System.out.println("Los parentesis no estan escritos de forma correcta");
            return;
        }
        
        
        //Validamos que la emprecion no inicie con un operador
        if(empiesaConOperador(infija)){
            System.out.println("La expresion no puede iniciar con un operador");
            return;
        }
        else{
            System.out.println("La expresion es correcta, no inicia con un operador");
        }
        
        
        //Validamos que la emprecion no termine con un operador
        if(terminaConOperador(infija)){
            System.out.println("La expresionno puede terminar con un operador");
            return;
        }
        else{
            System.out.println("La expresion es correcta, no termina con un operador");
        }
        
        
        
        //Evaluamos que la exprecion este correctamente alternada
        if(evaluarAlternaciones(infija)){
            System.out.println("La expresion esta correctamente alternada");
        }
        else{
            System.out.println("La expresion no esta correctamente alternada");
            return;
        }
        
        
        //Evaluamos transformamos la exprecion a posfijo
        String posfija = toPosfijo(infija);
        if(posfija==null){
            return;
        }
        else{
            System.out.println(posfija);
        }
        
        int operacion = evaluarPosfijo(posfija);
        System.out.println(operacion);
        
    }
    
    /**
     * Metodo que evalua la exprecion posfija y devuelve el valor real de la evaluacion
     * @param posfijo es la exprecon en posfijo
     * @return  devuleve la evaluacion de la exprecion
     */
    public int evaluarPosfijo(String posfijo){              
        ArrayList<String> token = new ArrayList<String>();
        
        
        StringTokenizer st = new StringTokenizer(posfijo," ");
        while(st.hasMoreTokens()){
            token.add(st.nextToken());
        }
        
        if(token.size()==1){
            return Integer.parseInt(token.get(0));                
        }
        int c=0;
        System.out.println(token.toString()+"\n");
        while(token.size()!=1){
            
            String operador = token.get(c);
            if(operador.equals("+")||operador.equals("-")||operador.equals("*")||operador.equals("/")||operador.equals("^")){
                String operando1=token.get(c-1);
                String operando2 =token.get(c-2);
                
                token.remove(c);
                token.remove(c-1);
                token.remove(c-2);
                if(operador.equals("+")){
                    try {
                        String suma = (Integer.parseInt(operando2)+Integer.parseInt(operando1))+"";
                        token.add(c-2,suma);
                        c=0;
                    } catch (Exception e) {
                        System.out.println("Error al comvertir un operando\n"+e);
                        return 0;
                    }                    
                }
                else if(operador.equals("-")){
                    try {
                        String resta = (Integer.parseInt(operando2)-Integer.parseInt(operando1))+"";
                        token.add(c-2,resta);
                        c=0;
                    } catch (Exception e) {
                        System.out.println("Error al comvertir un operando\n"+e);
                        return 0;
                    }    
                }
                else if(operador.equals("*")){
                    try {
                        String multiplicacion = (Integer.parseInt(operando2)*Integer.parseInt(operando1))+"";
                        token.add(c-2,multiplicacion);
                        c=0;
                    } catch (Exception e) {
                        System.out.println("Error al comvertir un operando\n"+e);
                        return 0;
                    }    
                }
                else if(operador.equals("/")){
                    try {
                        String divicion = (Integer.parseInt(operando2)/Integer.parseInt(operando1))+"";
                        token.add(c-2,divicion);
                        c=0;
                    } catch (Exception e) {
                        System.out.println("Error al comvertir un operando\n"+e);
                        return 0;
                    }    
                }
                else{
                    try {
                        String potencia = (Integer.parseInt(operando2)^Integer.parseInt(operando1))+"";
                        token.add(c-2,potencia);
                        c=0;
                    } catch (Exception e) {
                        System.out.println("Error al comvertir un operando\n"+e);
                        return 0;
                    }   
                }
                System.out.println(token.toString()+"\n");
            }
            else{
                c++;
            }
        }
        
        
        try {            
            return Integer.parseInt(token.get(0));            
        } catch (Exception e) {
            System.out.println("Error al parsear el resultado\n"+e);
            return 0;
        }
        
    }
    
    
    /**
     * Metodo que se asegura que este correctamente planteda la exprecion
     * @param infijo es la exprecion matematica a evaluar
     * @return devuleve un true si la exprecion esta alternada correctamente, false de lo contrario
     */
    public boolean evaluarAlternaciones(String infijo){
        char[] cadena = infijo.toCharArray();
        char ultimoElemento=cadena[0];
        
        //Se da por entendido que todas las expreciones son correctas hasta que se encuentre un error
        boolean validacion=true;
    
        for(int c =1;c<cadena.length;c++){
            char caracter = cadena[c];
            if(Character.isDigit(caracter)){
                if(ultimoElemento==')'){
                    String salida = generarError(infijo,c);
                    salida+="No se puede poner un numero despues de un ')'\n";
                    System.out.println(salida);
                    validacion=false;                    
                }                                       
                else{
                    ultimoElemento=caracter;
                }
            }
            else if(caracter=='('){
                if(ultimoElemento=='('){
                    ultimoElemento=caracter;
                }
                else if(ultimoElemento=='+' || ultimoElemento=='-' || ultimoElemento=='*' || ultimoElemento=='/' || ultimoElemento=='^'){
                    ultimoElemento=caracter;
                }
                else{
                    String salida = generarError(infijo,c);
                    salida+="Despues de un '"+ultimoElemento+"' no puede venir un '('\n";
                    System.out.println(salida);
                    validacion=false;                         
                }                                    
            }
            else if(caracter==')'){
                if(ultimoElemento==')'){
                    ultimoElemento=caracter;
                }
                else if(Character.isDigit(ultimoElemento)){
                    ultimoElemento=caracter;
                }
                else{
                    String salida = generarError(infijo,c);
                    salida+="Despues de un '"+ultimoElemento+"' no puede venir un ')'\n";
                    System.out.println(salida);
                    validacion=false;                     
                }                                   
            }
            else if(caracter=='+' || caracter =='-' || caracter=='*' || caracter=='/' || caracter=='^'){
                if(ultimoElemento==')'){
                    ultimoElemento=caracter;
                }
                else if(Character.isDigit(ultimoElemento)){
                    ultimoElemento=caracter;
                }
                else{
                    String salida = generarError(infijo,c);
                    salida+="Despues de un '"+ultimoElemento+"' no puede venir un Operador '"+caracter+"'\n";
                    System.out.println(salida);
                    validacion=false;                   
                }                                       
            }            
        }       
        
        return validacion;
    }
    
    
    
    /**
     * Metodo que nos indica si la exprecion termina con un operador
     * @param infijo es la exprecion matematica
     * @return retorna true si empiesa con un operador, false de lo contrario
     */
    public boolean terminaConOperador(String infijo){
        char[] cadena = infijo.toCharArray();
        for(int c=cadena.length-1;c>0;c--){
            char caracter = cadena[c];
            if(Character.isDigit(caracter)){
                return false;
            }
            if(Character.isLetter(caracter)){
                return false;
            }
            else if(caracter=='+' || caracter =='-' || caracter=='*' || caracter=='/' || caracter=='^'){
                String salida = generarError(infijo,c);
                salida+="La exprecion nu puede terminar con operador";
                System.out.println(salida);
                return true;
            }
        }
        return false;
    }
    
    
    
    /**
     * Metodo que nos sirve para saber si la exprecion empiesa con un operador
     * @param infijo exprecion matematica
     * @return retorna true se empiesa con un Operador,false de lo contrario
     */
    public boolean empiesaConOperador(String infijo){
        char[] cadena = infijo.toCharArray();
        for(int c=0;c<cadena.length;c++){
            char caracter = cadena[c];
            if(Character.isDigit(caracter)){
                return false;
            }
            if(Character.isLetter(caracter)){
                return false;
            }
            else if(caracter=='+' || caracter =='-' || caracter=='*' || caracter=='/' || caracter=='^'){
                String salida = generarError(infijo,c);
                salida+="La exprecion nu puede empesar con operador";
                System.out.println(salida);
                return true;
            }
        }
        return false;
    }
    
    
    
    
    /**
     * Metodo que transforma una exprecion de infijo a posfijo
     * @param operacion es la exprecion matematica
     * @return devuelve un String con la exprecion en postfijo o devuelve un null si la exprecion no se
     * evaluo correctamente
     */
    public String toPosfijo(String infijo){             
        String salida="";
        char[] cadena = infijo.toCharArray();
        
        for(int c=0;c<cadena.length;c++){
            char caracter = cadena[c];
            if(caracter=='('){
                pila.push(caracter);
            } 
            else if(caracter==')'){                
                while(true){
                    if(pila.empty()){
                        String retorno = generarError(infijo,c);
                        retorno+="Operacion invalida numero de parentesis impares";
                        System.out.println(retorno);
                        return null;
                    }
                    char temp = pila.pop().charValue();
                    if(temp=='('){
                        break;
                    }
                    else{
                        salida+=" "+temp;
                    }
                }//fin del wile
            }
            else if(Character.isDigit(caracter)){
                salida+=" "+caracter;                
                c++;
     busqueda : for( ; c<cadena.length;c++){
                    if(Character.isDigit(cadena[c])){
                        salida+=cadena[c];
                    }
                    else{
                        c--;
                        break busqueda;
                    }                    
                }                
            }
            else if(caracter=='+'||caracter=='-'||caracter=='/'||caracter=='*'||caracter=='^'){   
                if(pila.empty()){
                    pila.push(caracter);
                }
                else{
                    while(true){                    
                        if(esDeMayorPresedencia(caracter)){                            
                            pila.push(caracter);
                            break;
                        }else{
                            salida+=" "+pila.pop();
                        }  
                    }                                 
                }               
            }
            else{
                String retorno = generarError(infijo,c);
                retorno+="caracter no valido para la exprecion : '"+caracter+"'";
                System.out.println(retorno);
                return null;
            }
        }//fin del for
        if(!pila.empty()){
            do{
                char temp = pila.pop().charValue();
                salida+=" "+temp;                
            }while(!pila.empty());
        }
        
        return salida.trim();
    }
    
    
    /**
     * Metodo utilizado para validar que los parentesis estan correctamente
     * @param operacion esta variable deve de contener la operacion matematica a efectuar
     *  Ejemplo: a+((b-c)/d)
     * @return Devuelve true si la operacion tiene correctamente los parentesis
     */
    public boolean validarParentesis(String operacion){
        Stack<Character> pila = new Stack<Character>();
        
        char[] ecuacion = operacion.toCharArray();    

        for(int c=0;c<ecuacion.length;c++){
            char caracter = ecuacion[c];
                    System.out.println(caracter);
            if(caracter=='('){
                pila.push(caracter);
            }
            else if(caracter==')'){
                if(pila.empty()){
                    String salida = generarError(operacion,c);
                    salida+="Numero de parentesis impares";
                    System.out.println(salida);
                    return false;
                }
                else{
                    pila.pop();
                }
            }
        }
        if(!pila.empty()){    
            String salida = generarError(operacion,ecuacion.length-1);
            salida+="Numero de parentesis impares,Se esperaba que se cerrara los parentesis";
            System.out.println(salida);
            return false;
            
        }        
        return true;
    }
    
    
    /**
     * Metodo que genera la posicion en la que se genero el error en tienpo de evaluar la expreción
     * @param infijo es la exprecion en infijo que se esta evaluando
     * @param indice es la pacion en que se encontro el error
     * @return devuelve el String indicando la posicion exacta del error
     */
    private String generarError(String infijo,int indice){
        String error[] = new String[infijo.length()];
        for(int c=0;c<error.length;c++){
            error[c]="  ";
        }
        error[indice]="^";
        
        String error2="";
        for(int c=0;c<error.length;c++){
            error2+=error[c];
        }
        return infijo+"\n"+error2+"\n";
    }
    
    
    /**
     * Metodo utilizado para saber si el caracter es de mayor presedencia que el que se
     * encuentra en la ultma posicion de la pila
     * @param caracter caracter que se evaluara para meterse a la pila
     * @return devuelve true si el caracter es de mayor presedencia, false de lo contrario
     */
    private boolean esDeMayorPresedencia(char caracter){
        if(pila.empty()){
            return true;
        }
        if(caracter==pila.peek().charValue()){
            return false;
        }
        if(caracter=='^'){
            return true;
        }
        if( (caracter=='*'&&pila.peek().charValue()=='/')||(caracter=='/'&&pila.peek().charValue()=='*')){
            return false;
        }
        if( (caracter=='+'&&pila.peek().charValue()=='-')||(caracter=='-'&&pila.peek().charValue()=='+')){
            return false;
        }        
        else if(caracter=='-'||caracter=='+'){
            char temp = pila.peek().charValue();
            if(temp=='*'||temp=='/'){
                return false;
            }
        }
        return true;        
    }
    
    public static void main(String[] args) {
        /*
        LienzoArbol l = new LienzoArbol("normal = data + normal ·");
        l.postfija();
        l.evaluar();
        */
        
        
        // TODO code application logic here
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //PATRON MVC
        Arbol objArbol = new Arbol(); //MODELO
        Lienzo objLienzo = new Lienzo(); //VISTA
        Controlador objControlador = new Controlador(objLienzo, objArbol); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //INSERTAR Y PINTAR ARBOL
        objArbol.insertar(10);
        objArbol.insertar(2);
        objArbol.insertar(9);
        objArbol.insertar(5);
        objArbol.insertar(0);
        objArbol.insertar(10);
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(objLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        
    }
    
}
