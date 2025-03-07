package java_hexagonal_abstract.Domain.Repository;

import java.util.List;

import java_hexagonal_abstract.Domain.Entity.Client;
import java_hexagonal_abstract.Domain.Entity.Product;

public interface ProductResposity {
    void guardar(Product producto);
    Client buscarPorId(int id);
    List<Client> listarTodos();
    void actualizar(Product producto);
    void eliminar(int id);
}
