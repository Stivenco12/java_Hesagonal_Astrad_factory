package java_hexagonal_abstract;

import java_hexagonal_abstract.Application.Usecase.Client.ClientUseCase;
import java_hexagonal_abstract.Domain.Repository.ClientRespository;
import java_hexagonal_abstract.infrastructure.Database.ConnectionFactory;
import java_hexagonal_abstract.infrastructure.persistence.Client.ClientRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
    }
}