package java_hexagonal_abstract.infrastructure.persistence.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java_hexagonal_abstract.Domain.Entity.Client;
import java_hexagonal_abstract.Domain.Repository.ClientRespository;
import java_hexagonal_abstract.infrastructure.Database.ConnectionDb;


public class ClientRepositoryImpl implements ClientRespository {
    private final ConnectionDb connection;
    
    public ClientRepositoryImpl(ConnectionDb connection) {
        this.connection = connection;
    }
    @Override
    public void guardar(Client cliente) {
        String sql = "INSERT INTO clientes (id, nombre, email) VALUES (?, ?, ?)";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getName());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Los datos han sido editados correctamente");
            System.out.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Client buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.print("Id del cliente = ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nombre del cliente = ");
                System.out.println(rs.getString("nombre"));
                System.out.print("Email del cliente = ");
                System.out.println(rs.getString("email"));
                
            }else{
                System.out.println("error ese id no existe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return null;
    }

    @Override
    public List<Client> listarTodos() {
        List<Client> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conexion = connection.getConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.print("Id del cliente = ");
                System.out.println(rs.getInt("id"));
                System.out.print("Nombre del cliente = ");
                System.out.println(rs.getString("nombre"));
                System.out.print("Email del cliente = ");
                System.out.println(rs.getString("email"));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void actualizar(Client cliente) {
        String sql = "UPDATE clientes SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getName());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql0 = "SELECT * FROM clientes WHERE id = ?";
        try (Connection conexion = connection.getConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql0)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String sql = "DELETE FROM clientes WHERE id = ?";
                    try (Connection conexion1 = connection.getConexion();
                        PreparedStatement stmt1 = conexion1.prepareStatement(sql)) {
                        stmt1.setInt(1, id);
                        stmt1.executeUpdate();
                        System.out.println("producto elimnado exitosamente");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("error ese id no existe");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error");
        }
    }
}
