package java_hexagonal_abstract.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum HexaSingleton {
    INSTANCIA;

    private final Properties propiedades = new Properties();

    HexaSingleton(){
        cargarConfiguraciones("config.prorties");
    }

    private void cargarConfiguraciones(String rutaArchivo){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try(FileInputStream archivo = new FileInputStream(classLoader.getResource(rutaArchivo).getFile())){
            propiedades.load(archivo);
        }catch(IOException e){
            System.out.println("Error cargando configuracion: "+ e.getMessage());
        }
    }

    public String get(String clave){
        return propiedades.getProperty(clave, "No encontrado");
    }
}
