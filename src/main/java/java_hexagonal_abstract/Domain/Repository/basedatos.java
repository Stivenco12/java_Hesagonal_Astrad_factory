package java_hexagonal_abstract.Domain.Repository;

import java_hexagonal_abstract.Domain.Entity.BaseDeDatos;

public interface basedatos {
    void crearbase(BaseDeDatos BaseDeDatos);
    void crearTabla(basedatos basedatos);
}
