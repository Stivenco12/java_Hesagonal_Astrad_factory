package java_hexagonal_abstract.infrastructure.Database;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionDb {
    Connection getConexion() throws SQLException;
}
