package java_hexagonal_abstract.infrastructure.persistence.baseDatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import java_hexagonal_abstract.Domain.Entity.BaseDeDatos;
import java_hexagonal_abstract.Domain.Repository.basedatos;
import java_hexagonal_abstract.infrastructure.Database.ConnectionDb;

public class BaseDeDatosRepositoryimpl implements basedatos{
     private final ConnectionDb connection;
     private final String configFilePath = "src/main/resources/config.properties";
    public BaseDeDatosRepositoryimpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void crearbase(BaseDeDatos BaseDeDatos) {
 try (Connection conexion = connection.getConexion()) {
            
            String sqlCrearDB = "CREATE DATABASE IF NOT EXISTS main;";
            try (PreparedStatement stmt = conexion.prepareStatement(sqlCrearDB)) {
                stmt.executeUpdate();
            }

       
            String sqlUsarDB = "USE main;";
            try (PreparedStatement stmt = conexion.prepareStatement(sqlUsarDB)) {
                stmt.executeUpdate();
            }

     
            String sqlClientes = """
                CREATE TABLE IF NOT EXISTS clientes (
                    Id INT AUTO_INCREMENT PRIMARY KEY, 
                    Nombre VARCHAR(50), 
                    Email VARCHAR(50)
                );
                """;
            try (PreparedStatement stmt = conexion.prepareStatement(sqlClientes)) {
                stmt.executeUpdate();
            }

            String sqlProductos = """
                CREATE TABLE IF NOT EXISTS productos (
                    Id INT AUTO_INCREMENT PRIMARY KEY, 
                    NombreProducto VARCHAR(50), 
                    Stock INT
                );
                """;
            try (PreparedStatement stmt = conexion.prepareStatement(sqlProductos)) {
                stmt.executeUpdate();
            }

    
            actualizarConfigDB("main");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarConfigDB(String dbName) {
        Properties properties = new Properties();
        try (OutputStream output = new FileOutputStream(configFilePath)) {
         
            
            properties.setProperty("db.user", "root");
            properties.setProperty("db.password", "campus2023");
            properties.setProperty("db.url", "jdbc:mysql://localhost:3306/" + dbName);
           
            properties.store(output, "Configuración actualizada con la nueva base de datos");
            System.out.println("Archivo config.properties actualizado correctamente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void crearTabla(basedatos basedatos) {

        return;
    }

}
