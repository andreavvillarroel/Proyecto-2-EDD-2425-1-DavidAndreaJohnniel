/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;

/**
 *
 * @author Moises Liota
 */
public class Arbol {
    private NodoA root;

    public Arbol() {
        this.root = null;
    }

    public NodoA getRoot() {
        return root;
    }

    public void setRoot(NodoA root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public void asignarRaiz(Persona persona){
        NodoA newRoot = new NodoA(persona);
        this.setRoot(newRoot);
    }
    
    public void insertar(NodoA padre, Persona persona){
        NodoA hijoNuevo = new NodoA(persona);
        hijoNuevo.setPadre(padre);
        padre.insertarHijo(hijoNuevo);
    }
    
    public NodoA buscar(String nombreUnico){
        return null;
    }
    
    public void mostrarNiveles(NodoA inicial){
        
    }
    
    public int nivelMax(){
        return 0;
    }
    
    public void mostrarGeneracion(int nivel){
        
    }
}
