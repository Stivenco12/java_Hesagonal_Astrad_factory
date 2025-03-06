package java_hexagonal_abstract.Domain.Repository;

import java.util.List;
import java_hexagonal_abstract.Domain.Entity.Client;

public interface ClientRespository {
    void guardar(Client cliente);
    Client buscarPorId(int id);
    List<Client> listarTodos();
    void actualizar(Client cliente);
    void eliminar(int id);
}
