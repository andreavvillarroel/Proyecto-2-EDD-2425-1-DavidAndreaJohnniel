/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import ClasesPrincipales.Persona;
import EDD.Arbol;
import EDD.NodoA;
import Interfaces.BuscarPorNombre;
import Interfaces.Menu;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

public class MostrarDesc extends JFrame {

    private Arbol arbol;
    private Viewer visor;
    private ViewPanel panelVista;
    private BuscarPorNombre buscarN;

    public MostrarDesc(Arbol arbol, BuscarPorNombre buscarN) {
        this.arbol = arbol;
        this.buscarN = buscarN;
        this.buscarN.setVisible(false);
        configurarInterfaz();
        inicializarVisor();
        agregarBotonRegresar();
    }

    private void configurarInterfaz() {
        setTitle("Visualizador de Árbol");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void inicializarVisor() {
        Graph arbolVisual = new SingleGraph("Árbol");
        construirArbol(arbolVisual);

        // Mostrar el árbol sin crear una nueva ventana
        visor = arbolVisual.display(false);
        visor.enableAutoLayout();

        // Crear el panel de visualización si no existe ya
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();
            add(panelVista, BorderLayout.CENTER);
        }
    }

    private void construirArbol(Graph arbolVisual) {
        if (arbol.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El árbol está vacío.");
            return;
        }

        // Añadir nodos al grafo
        agregarNodoYSubarbol(arbol.getRoot(), null, arbolVisual);

        // Estilo general del árbol
        arbolVisual.setAttribute("ui.stylesheet",
                "node { text-size: 14px; size: 30px; text-alignment: center; fill-color: gray; }"
                + "edge { size: 2px; }"
        );
    }

    private void agregarNodoYSubarbol(NodoA nodoActual, String padreId, Graph arbolVisual) {
        Persona persona = nodoActual.getPersona();
        String nodoId = persona.getNameUnique();

        // Verificar si el nodo ya existe
        if (arbolVisual.getNode(nodoId) == null) {
            Node node = arbolVisual.addNode(nodoId);
            node.setAttribute("ui.label", persona.getNameUnique());
            node.setAttribute("persona", persona); // Asociar el objeto Persona
        }

        // Conectar con el padre si existe
        if (padreId != null && arbolVisual.getEdge(padreId + "-" + nodoId) == null) {
            arbolVisual.addEdge(padreId + "-" + nodoId, padreId, nodoId);
        }

        // Recursivamente añadir los hijos
        for (int i = 0; i < nodoActual.getHijos().getSize(); i++) {
            NodoA hijo = (NodoA) nodoActual.getHijos().getValor(i);
            agregarNodoYSubarbol(hijo, nodoId, arbolVisual);
        }
    }

    private void agregarBotonRegresar() {
        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(e -> {
            cerrarVisor();
            dispose();
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

    private void cerrarVisor() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }

        this.buscarN.setVisible(true);
    }
}