/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import ClasesPrincipales.Persona;

/**
 *
 * @author David
 */

/**
 * Representa un nodo en una estructura de datos jerárquica, como un árbol.
 * Cada nodo contiene información sobre una persona y sus relaciones parentales.
 */
public class NodoA {
    private Persona persona;
    private NodoA padre;
    private Lista hijos;

    public NodoA(Persona persona) {
        this.persona = persona;
        this.padre = null;
        this.hijos = new Lista();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public NodoA getPadre() {
        return padre;
    }

    public void setPadre(NodoA padre) {
        this.padre = padre;
    }

    public Lista getHijos() {
        return hijos;
    }

    public void setHijos(Lista hijos) {
        this.hijos = hijos;
    }
    
    /**
     * Inserta un nuevo hijo al final de la lista de hijos, si no existe previamente.
     * @param hijo El nodo hijo a insertar.
     */
    public void insertarHijo(NodoA hijo){
        if(!this.buscar(hijo)){
            this.hijos.InsertarFinal(hijo);
        }
    }
    
    /**
     * Busca un hijo en la lista de hijos comparando el atributo 'nameUnique' de la persona.
     * @param hijo El nodo hijo a buscar.
     * @return true si el hijo se encuentra, false en caso contrario.
     */
    public boolean buscar(NodoA hijo){
        Persona personHijo = hijo.getPersona();
        if(!this.esHoja()){
            for (int i = 0; i < this.hijos.getSize(); i++) {
                NodoA hijoActual = (NodoA) this.hijos.getValor(i);
                if(hijoActual.getPersona().getNameUnique().equalsIgnoreCase(personHijo.getNameUnique())){
                    return true;
                }
            }
        }
       
        return false;
    }
    
    /**
     * Determina si el nodo es una hoja (no tiene hijos).
     * @return true si el nodo es una hoja, false en caso contrario.
     */
    public boolean esHoja(){
        return this.hijos.isEmpty();
    }
    
}
