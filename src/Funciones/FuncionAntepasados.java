/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Arbol;
import EDD.Lista;
import EDD.NodoA;

/**
 *
 * @author Moises Liota
 */


import EDD.Arbol;
import EDD.NodoA;
import EDD.Lista;

/**
 * Función para listar los antepasados de un nodo especificado.
 */
public class FuncionAntepasados {
    /**
     * Lista los antepasados de un nodo especificado.
     *
     * @param arbol El árbol genealógico en el que buscar.
     * @param nombre El nombre o clave única del nodo objetivo.
     * @return Una lista con los nombres de los antepasados en orden (de hijo a raíz).
     */
    public Lista listarAntepasados(Arbol arbol, String nombre) {
        Lista antepasados = new Lista(); // Crear lista para almacenar antepasados
        NodoA nodoActual = arbol.buscarPorNombreClave(nombre); // Buscar el nodo inicial

        if (nodoActual == null) {
            System.out.println("No se encontró el integrante en el árbol.");
            return antepasados; // Retorna una lista vacía si el nodo no se encuentra
        }

        // Recorrer hacia arriba utilizando la referencia al padre
        while (nodoActual != null) {
            antepasados.InsertarFinal(nodoActual.getPersona().getNameUnique()); // Suponiendo que "NameUnique" retorna una cadena única del nombre
            nodoActual = nodoActual.getPadre();
        }

        return antepasados;
    }
}