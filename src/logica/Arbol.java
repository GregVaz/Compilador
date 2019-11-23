/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author daniel
 * @param <T>
 */
public class Arbol<T> {
    private Nodo raiz;
    
    public void insertar(T elemento) {
        if (raiz == null)
            raiz = new Nodo(elemento);
        else
            raiz = raiz.insertar(raiz, elemento);
    }

    public Nodo getRaiz() {
        return raiz;
    }
}
