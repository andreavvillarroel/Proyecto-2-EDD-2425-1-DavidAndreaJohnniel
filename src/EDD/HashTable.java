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
 * Representa una tabla hash, una estructura de datos que permite almacenar y recuperar elementos de forma eficiente.
 *
 * Esta implementación utiliza listas enlazadas para manejar colisiones.
 */
public class HashTable {

    private Lista[] tabla;
    private int max;
    
    
    /**
     * Constructor que inicializa la tabla hash con el tamaño especificado.
     * @param max El tamaño máximo de la tabla hash.
     */
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
    /**
     * Calcula el índice en la tabla hash para una clave dada.
     * @param clave La clave del elemento.
     * @return El índice correspondiente en la tabla hash.
     */
    public int getIndex(String clave) {
        return Math.abs(clave.hashCode()) % max;
    }
    
    /**
     * Insertar un elemento a la tabla hash.
     * @param key
     * @param value 
     */
    public void insertar(String key, Persona value) {
        int indice = this.getIndex(key);
        Lista listaEnIndice = tabla[indice];

        if (buscar(key) == null) { // Si no existe ya la clave, insertar
            listaEnIndice.InsertarFinal(value);
        }
    }
    
    /**
     * Buscar un elemento en la tabla hash.
     * @param clave
     * @return 
     */
    public Object buscar(String clave) {
        int indice = this.getIndex(clave);
        Lista listaEnIndice = tabla[indice];

        if (listaEnIndice.getSize() > 0) {
            for (int i = 0; i < listaEnIndice.getSize(); i++) {
                Persona personaActual = (Persona) listaEnIndice.getValor(i);
                String claveStr = (String) clave;
                if (personaActual.getNameUnique().equalsIgnoreCase(claveStr)) {
                    return personaActual;
                }
            }
            
        }
        return null;
    }
    
    /**
     * Buscar un elemento por nombre en la tabla hash.
     * @param nombre
     * @return 
     */
    public Lista buscarNombre(String nombre) {
        String nombreN = nombre.toLowerCase();
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getMote() != null) {
                        if (personaActual.getMote().toLowerCase().contains(nombreN)) {
                            resultado.InsertarFinal(personaActual);
                        } else if (personaActual.getNombre().toLowerCase().contains(nombreN)) {
                            resultado.InsertarFinal(personaActual);
                        }
                    } else {
                        if (personaActual.getNombre().toLowerCase().contains(nombreN)) {
                            resultado.InsertarFinal(personaActual);
                        }
                    }
                }
            }
        }

        return resultado;
    }
    
    /**
     * Buscar por título en la tabla hash.
     * @param titulo
     * @return 
     */
    public Lista buscarTitulo(String titulo) {
        Lista resultado = new Lista();
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if (personaActual.getTitulo() != null) {
                        if (personaActual.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                            resultado.InsertarFinal(personaActual.getNameUnique());
                        }
                    }
                }
            }
        }

        return resultado;
    }
    /**
     * Elimina todos los elementos de la tabla hash.
     */
    public void destruir() {
        for (int i = 0; i < max; i++) {
            tabla[i].destruir();
        }
    }
    /**
     * Muestra el contenido de la tabla hash
     */
    public void mostrarTabla() {
        String tablaStr = "HashTable:\n";
        for (int i = 0; i < max; i++) {
            if (!tabla[i].isEmpty()) {
                tablaStr += "Indice " + i + ": ";
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona persona = (Persona) tabla[i].getValor(j);
                    tablaStr += persona.getNameUnique()+ "-> ";
                }

                tablaStr += "null" + "\n";
            }
        }

        System.out.println(tablaStr);
    }
    
    public Lista titulos(){
        Lista titulos = new Lista();
        for (int i = 0; i < max; i++) {
            if(!tabla[i].isEmpty()){
                for (int j = 0; j < tabla[i].getSize(); j++) {
                    Persona personaActual = (Persona) tabla[i].getValor(j);
                    if(personaActual.getTitulo() != null){
                        titulos.InsertarFinal(personaActual.getTitulo());
                    }   
                }
            }
        }
        
        return titulos;
    }

}
