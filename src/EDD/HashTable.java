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
public class HashTable {
    private Lista[] tabla;
    private int max;

    public HashTable(int max) {
        this.max = max;
        this.tabla = new Lista[max];
        for (int i = 0; i < max; i++) {
            tabla[i] = new Lista();
        }
    }

    public Lista[] getTabla() {
        return tabla;
    }

    public void setTabla(Lista[] tabla) {
        this.tabla = tabla;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public int getIndex(String clave){
       return Math.abs(clave.hashCode()) % max;
    }
    
    public void insertar(String clave, Persona persona){
    
    }
    
    public Persona buscar(String clave){
        return null;
    }
    
    public void mostrar(){
    
    }
    
    public void destruir(){
    
    }
}
