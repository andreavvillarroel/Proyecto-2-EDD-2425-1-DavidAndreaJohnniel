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
    
    public void insertarHijo(NodoA hijo){
        if(!this.buscar(hijo)){
            this.hijos.InsertarFinal(hijo);
        }
    }
    
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
    
    public boolean esHoja(){
        return this.hijos.isEmpty();
    }
    
}
