package java_hexagonal_abstract.infrastructure.Database;

public class ConnectionFactory {
    public static ConnectionDb crearConexion(){
        return new ConnMySql();
        
    }
}
