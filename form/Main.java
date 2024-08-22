package form;

import form.menu.Login;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la clase Login
        Login login = new Login();
        // Mostrar la ventana login
        login.setVisible(true);


        
        // Ya una vez terminado el programa manda un mensajito
        System.out.println("Programa terminado.");
    }
}
