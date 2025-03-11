package java_hexagonal_abstract.infrastructure.persistence.baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java_hexagonal_abstract.Domain.Entity.BaseDeDatos;
import java_hexagonal_abstract.Domain.Repository.basedatos;
import java_hexagonal_abstract.infrastructure.Database.ConnectionDb;
import java_hexagonal_abstract.infrastructure.Database.ConnMySql.Main;

public class BaseDeDatosRepositoryimpl implements basedatos{
     private final ConnectionDb connection;
    
    public BaseDeDatosRepositoryimpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void crearbase(BaseDeDatos BaseDeDatos) {

        String sql = "CREATE DATABASE main; ";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.executeUpdate();
            System.out.println("Creada exitosamente");
            System.out.println();
            Main.main = "main";
        }catch(SQLException e){
            System.out.println("la database main, ya existe no es necesario volverlas a crear.....");
            System.out.println("");
        }

        String sql2 = "CREATE TABLE clientes(Id INT AUTO_INCREMENT PRIMARY KEY, Nombre VARCHAR(50), Email VARCHAR(50));";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql2)){
            stmt.executeUpdate();
            System.out.println("Creada exitosamente la tabla Clientes");
            System.out.println("");
        }catch(SQLException e){
            System.out.println("la tabla clientes ya existe, no es necesario volverlas a crear.....");
            System.out.println("");
        }

        String sql3 = "CREATE TABLE product(Id INT AUTO_INCREMENT PRIMARY KEY, NombreProducto VARCHAR(50), Stock INT);";
        try(Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql3)){
            stmt.executeUpdate();
            System.out.println("Creada exitosamente la tabla product");
            System.out.println("");
        }catch(SQLException e){
            System.out.println("La tabla product ya existe, no es necesario volverlas a crear......");
            System.out.println("");
        }
        return;
    }
    @Override
    public void crearTabla(basedatos basedatos) {

        return;
    }

}