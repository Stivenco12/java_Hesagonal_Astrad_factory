package java_hexagonal_abstract.Domain.Entity;

public class Product {
    private int id;
    private String Nombre;
    private int Stock;

    public Product(int id, String Nombre, int Stock){
        this.id = id;
        this.Nombre = Nombre;
        this.Stock = Stock;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setName(String Nombre){
        this.Nombre = Nombre;
    }

    public int getStock(){
        return Stock;
    }
    
    public void setStock(int Stock){
        this.Stock = Stock;
    }
}
