/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

/**
 *
 * @author Grego
 */
public class EvaluadorExpresiones {
    private int counterTemp;
    /*******************************************************************
    ********************Evaluacion de expresiones***********************
    ********************************************************************/
    
    public EvaluadorExpresiones(int counter){
        this.counterTemp = counter;
    }
    
    public int getCounter() {
        return this.counterTemp;
    }
    
    public LinkedList<String> evalExpresion(LinkedList<String> expresion) {
        int t = expresion.indexOf("(");
        int counter= this.counterTemp;
        int vueltas = 0;
        int opcion = 0;
        int izq = 0;
        int drc = 0;
        int tamano = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<String> temp = new LinkedList<String>();
        LinkedList<String> renglones = new LinkedList<String>();
        Stack<Integer> pila = new Stack<Integer>();
        
        for(int i=0; i<expresion.size(); i++){
            if(expresion.get(i).equals("^"))
                vueltas++;
            if(expresion.get(i).equals("*"))
                vueltas++;
            if(expresion.get(i).equals("/"))
                vueltas++;
            if(expresion.get(i).equals("+"))
                vueltas++;
            if(expresion.get(i).equals("-"))
                vueltas++;
            if(expresion.get(i).equals("="))
                vueltas++;
        }
        

        
        while(vueltas>0){
            pila.clear();
            for(int i=0; i<expresion.size(); i++){
                if(expresion.get(i).equals("("))
                    list.add(i);
                if(expresion.get(i).equals(")"))
                    list.add(i);
            }
            
            if(!list.isEmpty()){
                if(list.size()%2 != 0)
                    System.out.println("Revisa los parentesis la expresion no puede resolverse.");

                if(!list.isEmpty())
                    for(int i=0; i<=list.size()/2; i++){
                        pila.add(list.pollLast());
                        pila.add(list.pollFirst());
                    }
            
                //System.out.println("Pila: " + pila.toString());

                izq = pila.pop();
                drc = pila.pop();

                temp = new LinkedList<String>(expresion.subList(izq+1, drc)){};
                tamano = 1+temp.size()/2;
                
                for(int i=0; i<tamano;i++){
                //System.out.println(temp.toString());
                int p = -1;
                if(temp.indexOf("^") != -1){
                    p = temp.indexOf("^");
                    opcion = 1;
                } else if(temp.indexOf("*") != -1){
                    p = temp.indexOf("*");
                    opcion = 2;
                } else if(temp.indexOf("/") != -1){
                    p = temp.indexOf("/");
                    opcion = 3;
                } else if(temp.indexOf("+") != -1){
                    p = temp.indexOf("+");
                    opcion = 4;
                } else if(temp.indexOf("-") != -1){
                    p = temp.indexOf("-");
                    opcion = 5;
                } 

                if(p != -1){

                    switch(opcion){
                        case 1:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " ^ " + temp.get(p+1));
                            break;
                        case 2:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " * " + temp.get(p+1));
                            break;
                        case 3:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " / " + temp.get(p+1));
                            break;
                        case 4:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " + " + temp.get(p+1));
                            break;
                        case 5:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " - " + temp.get(p+1));
                            break;
                    }

                    temp.set(p-1, "temp"+counter);
                    temp.remove(p);
                    temp.remove(p);
                    counter++;
                    //System.out.println(renglones.toString());
                }
                }
                for(int e=izq; e<drc; e++){
                    expresion.remove(izq);
                }

                expresion.set(izq, temp.pop());
            } else {
                //System.out.println("Pila: " + pila.toString());
                
                int p = -1;
                if(expresion.indexOf("^") != -1){
                    p = expresion.indexOf("^");
                    opcion = 1;
                } else if(expresion.indexOf("*") != -1){
                    p = expresion.indexOf("*");
                    opcion = 2;
                } else if(expresion.indexOf("/") != -1){
                    p = expresion.indexOf("/");
                    opcion = 3;
                } else if(expresion.indexOf("+") != -1){
                    p = expresion.indexOf("+");
                    opcion = 4;
                } else if(expresion.indexOf("-") != -1){
                    p = expresion.indexOf("-");
                    opcion = 5;
                } else if(expresion.indexOf("=") != -1){
                    p = expresion.indexOf("=");
                    opcion = 6;
                } else 
                    break;
                
                
                izq = p-1;
                drc = p+2;

                temp = new LinkedList<String>(expresion.subList(izq, drc)){};
                
                
                izq = 0;
                drc = temp.size()-1;
                
                
                if(p != -1){

                    switch(opcion){
                        case 1:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " ^ " + temp.get(drc));
                            break;
                        case 2:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " * " + temp.get(drc));
                            break;
                        case 3:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " / " + temp.get(drc));
                            break;
                        case 4:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " + " + temp.get(drc));
                            break;
                        case 5:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " - " + temp.get(drc));
                            break;
                        case 6:
                            renglones.add(temp.get(izq) + " = " + temp.get(drc));
                            break;
                    }

                    temp.set(izq, "temp"+counter);
                    temp.remove(izq+1);
                    temp.remove(izq+1);
                    counter++;
                    //System.out.println("Renglon: " + renglones.toString());
                }
                for(int e=p; e<p+2; e++){
                    expresion.remove(p);
                }

                expresion.set(p-1, temp.pop());
            }

            vueltas--;
            //System.out.println("Expresion: " + expresion.toString());
        }
        //System.out.println(renglones.toString());
        this.counterTemp = counter;
        return renglones;
    }
    
    /*******************************************************************
    ********************Evaluacion de relaciones************************
    ********************************************************************/
    
    public LinkedList<String> evalRelacion(LinkedList<String> expresion){
        int t = expresion.indexOf("(");
        int counter= this.counterTemp;
        int vueltas = 0;
        int opcion = 0;
        int izq = 0;
        int drc = 0;
        int tamano = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        LinkedList<String> temp = new LinkedList<String>();
        LinkedList<String> renglones = new LinkedList<String>();
        Stack<Integer> pila = new Stack<Integer>();
        
        for(int i=0; i<expresion.size(); i++){
            if(expresion.get(i).equals("=="))
                vueltas++;
            if(expresion.get(i).equals(">"))
                vueltas++;
            if(expresion.get(i).equals("<"))
                vueltas++;
            if(expresion.get(i).equals(">="))
                vueltas++;
            if(expresion.get(i).equals("<="))
                vueltas++;
            if(expresion.get(i).equals("!="))
                vueltas++;
        }
        

        
        while(vueltas>0){
            pila.clear();
            for(int i=0; i<expresion.size(); i++){
                if(expresion.get(i).equals("("))
                    list.add(i);
                if(expresion.get(i).equals(")"))
                    list.add(i);
            }
            
            if(!list.isEmpty()){
                if(list.size()%2 != 0)
                    System.out.println("Revisa los parentesis la expresion no puede resolverse.");

                if(!list.isEmpty())
                    for(int i=0; i<=list.size()/2; i++){
                        pila.add(list.pollLast());
                        pila.add(list.pollFirst());
                    }
            
                //System.out.println("Pila: " + pila.toString());

                izq = pila.pop();
                drc = pila.pop();

                temp = new LinkedList<String>(expresion.subList(izq+1, drc)){};
                tamano = 1+temp.size()/2;
                
                for(int i=0; i<tamano;i++){
                //System.out.println(temp.toString());
                int p = -1;
                if(temp.indexOf("==") != -1){
                    p = temp.indexOf("==");
                    opcion = 1;
                } else if(temp.indexOf(">") != -1){
                    p = temp.indexOf(">");
                    opcion = 2;
                } else if(temp.indexOf("<") != -1){
                    p = temp.indexOf("<");
                    opcion = 3;
                } else if(temp.indexOf(">=") != -1){
                    p = temp.indexOf(">=");
                    opcion = 4;
                } else if(temp.indexOf("<=") != -1){
                    p = temp.indexOf("<=");
                    opcion = 5;
                } else if(expresion.indexOf("!=") != -1){
                    p = expresion.indexOf("!=");
                    opcion = 6;
                }

                if(p != -1){

                    switch(opcion){
                        case 1:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " == " + temp.get(p+1));
                            break;
                        case 2:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " > " + temp.get(p+1));
                            break;
                        case 3:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " < " + temp.get(p+1));
                            break;
                        case 4:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " >= " + temp.get(p+1));
                            break;
                        case 5:
                            renglones.add("temp" + counter + " = " + temp.get(p-1) + " <= " + temp.get(p+1));
                            break;
                    }

                    temp.set(p-1, "temp"+counter);
                    temp.remove(p);
                    temp.remove(p);
                    counter++;
                    //System.out.println(renglones.toString());
                }
                }
                for(int e=izq; e<drc; e++){
                    expresion.remove(izq);
                }

                expresion.set(izq, temp.pop());
            } else {
                //System.out.println("Pila: " + pila.toString()); 
                
                int p = -1;
                if(expresion.indexOf("==") != -1){
                    p = expresion.indexOf("==");
                    opcion = 1;
                } else if(expresion.indexOf(">") != -1){
                    p = expresion.indexOf(">");
                    opcion = 2;
                } else if(expresion.indexOf("<") != -1){
                    p = expresion.indexOf("<");
                    opcion = 3;
                } else if(expresion.indexOf(">=") != -1){
                    p = expresion.indexOf(">=");
                    opcion = 4;
                } else if(expresion.indexOf("<=") != -1){
                    p = expresion.indexOf("<=");
                    opcion = 5;
                } else if(expresion.indexOf("!=") != -1){
                    p = expresion.indexOf("!=");
                    opcion = 6;
                } else 
                    break;
                
                
                izq = p-1;
                drc = p+2;

                temp = new LinkedList<String>(expresion.subList(izq, drc)){};
                
                
                izq = 0;
                drc = temp.size()-1;
                
                
                if(p != -1){

                    switch(opcion){
                        case 1:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " == " + temp.get(drc));
                            break;
                        case 2:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " > " + temp.get(drc));
                            break;
                        case 3:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " < " + temp.get(drc));
                            break;
                        case 4:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " >= " + temp.get(drc));
                            break;
                        case 5:
                            renglones.add("temp" + counter + " = " + temp.get(izq) + " <= " + temp.get(drc));
                            break;
                        case 6:
                            renglones.add(temp.get(izq) + " != " + temp.get(drc));
                            break;
                    }

                    temp.set(izq, "temp"+counter);
                    temp.remove(izq+1);
                    temp.remove(izq+1);
                    counter++;
                    //System.out.println("Renglon: " + renglones.toString());
                }
                for(int e=p; e<p+2; e++){
                    expresion.remove(p);
                }

                expresion.set(p-1, temp.pop());
            }

            vueltas--;
            //System.out.println("Expresion: " + expresion.toString());
            if(expresion.size()==2)
                renglones.add(expresion.getFirst() + "(" + expresion.getLast() + ")");
        }
        //System.out.println(renglones.toString());
        this.counterTemp = counter;
        return renglones;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EvaluadorExpresiones eval = new EvaluadorExpresiones(1);
        LinkedList<String> l = new LinkedList<>();
        /*
        l.add("id");
        l.add("=");
        l.add("(");
        l.add("vel");
        l.add("+");
        l.add("(");
        l.add("ava");
        l.add("-");
        l.add("10");
        l.add("*");
        l.add("2");
        l.add(")");
        l.add(")");
        l.add("-");
        l.add("10");
        l.add("*");
        l.add("100");
        */
        
        
        l.add("normal");
        l.add("=");
        l.add("normal");
        l.add("+");
        l.add("5");
        
        eval.evalExpresion(l);
    }
    
}
