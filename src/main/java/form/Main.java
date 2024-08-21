package form;

import form.menu.Admin;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la clase Admin
        Admin ventanaAdmin = new Admin();
        // Mostrar la ventana admin
        ventanaAdmin.setVisible(true);
        
        // Ya una vez terminado el programa manda un mensajito
        System.out.println("Programa terminado.");
    }
}
