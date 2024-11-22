/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author David
 */
/**
 * Representa un nodo en una lista enlazada simple.
 * * Cada nodo contiene un dato y una referencia al siguiente nodo en la lista.
 */
public class Nodo {
    private Object dato; 
     private Nodo pnext; 
    
     /**
     * Constructor por defecto.
     * Inicializa el dato y el siguiente nodo a `null`.
     */
    public Nodo(){
       this.dato = null;
       this.pnext = null; 
    }
    
    /**
     * Constructor que inicializa el nodo con un dato específico.
     * @param dato El dato a almacenar en el nodo.
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }
    

    /**Getters y setters para los atributos
     */
    
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
}
