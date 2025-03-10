package java_hexagonal_abstract.Application.Usecase.Basedatos;

import java_hexagonal_abstract.Domain.Repository.basedatos;

public class BasedatosUseCase {
    private final basedatos repository;

    public BasedatosUseCase(basedatos basedatos) {
        this.repository =  basedatos;
    }

    public void creardatos (){
        repository.crearbase(null);
    }
}
