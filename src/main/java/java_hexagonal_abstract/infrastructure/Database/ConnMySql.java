package java_hexagonal_abstract.infrastructure.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java_hexagonal_abstract.Config.HexaSingleton;

public class ConnMySql implements ConnectionDb {
    
    @Override
    public Connection getConexion() throws SQLException{
        HexaSingleton config = HexaSingleton.INSTANCIA;
        String url = config.get("db.url");
        String usuario = config.get("db.user");
        String password = config.get("db.pasword");
        return DriverManager.getConnection(url,usuario,password);
    }
}
