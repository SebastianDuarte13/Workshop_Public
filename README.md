# TRABAJO FORMULARO

#### Este Workshop consiste en realizar una encuesta para las personas que la realicen con preguntas muy sencillas pero con interfaz dirigida para administradores y usuarios, contando con un sistema de login el cual si eres un administrador podras realizar cualquier pregunta y realizar los Crud's de todas las tablas y el usuario solo podra realizar la encuesta

## acontinuacion la imagen de la base de datos

![es la base de datos del proyecto](/base_de_datos.png)


## Esta es la conección de la base de datos para que la pueda realizar en el localhost:

```java
public class DatabaseConfig {
private static final String URL = "jdbc:mysql://localhost:3306/public";
    private static final String USER = "usuario del localhost (si tienes el preterminado es root)";
    private static final String PASSWORD = "contaseña de tu localhost";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
} 
```