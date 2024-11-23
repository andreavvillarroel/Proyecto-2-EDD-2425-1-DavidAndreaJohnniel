/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Andrea
 */
/**
 * Esta clase se encarga de abrir un cuadro de diálogo para seleccionar un archivo JSON.
 */
public class FileChooser {
    private JFrame ventana;
    
    /**
     * Constructor que recibe una referencia a la ventana principal.
     *
     * @param ventana La ventana principal.
     */
    public FileChooser(JFrame ventana) {
        this.ventana = ventana;
    }
       
    /**
     * Abre un cuadro de diálogo para seleccionar un archivo JSON.
     *
     * @return La ruta absoluta del archivo seleccionado, o `null` si no se seleccionó ningún archivo.
     */
    public String abrirArchivo(){
        JFileChooser fc = new JFileChooser();

        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");

        
        fc.setFileFilter(filtro);

        
        int seleccion = fc.showOpenDialog(ventana);

        
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            
            File fichero = fc.getSelectedFile();
            return fichero.getAbsolutePath();

        } else {
            
            JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ningún archivo.");
            return null;
        }
    }
    
    
}
