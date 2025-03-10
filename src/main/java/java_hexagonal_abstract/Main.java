package java_hexagonal_abstract;

import java.util.Scanner;
import java_hexagonal_abstract.Application.Usecase.Client.ClientUseCase;
import java_hexagonal_abstract.Application.Usecase.Product.ProductUseCase;
import java_hexagonal_abstract.Domain.Repository.ClientRespository;
import java_hexagonal_abstract.Domain.Repository.ProductResposity;
import java_hexagonal_abstract.infrastructure.Database.ConnectionFactory;
import java_hexagonal_abstract.infrastructure.persistence.Client.ClientRepositoryImpl;
import java_hexagonal_abstract.infrastructure.persistence.Product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
        ProductResposity repositorioProduc = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productoCasoUso = new ProductUseCase(repositorioProduc);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                String menuClientes; 
                String menuProductos; 
                System.out.println("1.) Entrar a menu de clientes");
                System.out.println("2.) Entrar a menu de Producto");
                System.out.println("3.) Salir");
                menu = sc.nextLine();
                System.out.println("");
                switch (menu) {
                    case "1":
                        do {
                            System.out.println("Menus de clientes");
                            System.out.println("1.)Registrar cliente");
                            System.out.println("2.)Buscar clientes");
                            System.out.println("3.)Actualizar datos de un cliente");
                            System.out.println("4.)Mostrar todos los clientes ");
                            System.out.println("5.)Eliminar cliente");
                            System.out.println("6.)Salir");
                            menuClientes = sc.nextLine();
                            System.out.println("");
                            switch (menuClientes) {
                                case "1":
                                    int id = 0;
                                    System.out.print("Ingrese Nombre: ");
                                    String nombre = sc.nextLine();
                                    System.out.print("Ingrese Email: ");
                                    String email = sc.nextLine();
                                    clienteCasoUso.registrarCliente(id, nombre, email);
                                    System.out.println("Cliente registrado exitosamente.");     
                                    System.out.println("");
                                    break;
                                case "2":
                                    System.out.print("Ingrese el Id del cliente = ");
                                    int idBuscar = sc.nextInt();
                                    sc.nextLine();
                                    clienteCasoUso.obtenerCliente(idBuscar);
                                    System.out.println("");
                                    break;
                                case "3":
                                    System.out.print("Ingrese el Id de la persona a editar = ");
                                    int idNuevo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Ingrese el nuevo nombre del cliente = ");
                                    String NombreNuevo = sc.nextLine();
                                    System.out.print("Ingrese el nuevo gmail = ");
                                    String EmailNuevo = sc.nextLine();
                                    System.out.println("");
                                    System.out.println("Datos anteriores = ");
                                    clienteCasoUso.obtenerCliente(idNuevo);
                                    clienteCasoUso.actualizarCliente(idNuevo, NombreNuevo, EmailNuevo);
                                    System.out.println("");
                                    System.out.println("Datos actualizados = ");
                                    clienteCasoUso.obtenerCliente(idNuevo);
                                    System.out.println("");
                                    break;
                                case "4":
                                    clienteCasoUso.listarClientes();
                                    System.out.println("");
                                    break;
                                case "5":
                                    System.out.print("Ingrese el Id de la persona a eliminar = ");
                                    int idEliminar = sc.nextInt();
                                    sc.nextLine();
                                    clienteCasoUso.eliminarCliente(idEliminar);
                                    System.out.println("Cliente eliminado exitosamente");
                                    System.out.println("");
                                    break;
                                case "6":
                                    System.out.println("Saliendo.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Dato seleccionado no existe, volviendo a menu........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuClientes.equals("6"));
                        break;

                    // productos

                    case "2":
                        do {
                            System.out.println("Menus de productos");
                            System.out.println("1.)Registrar Productos");
                            System.out.println("2.)Buscar producto");
                            System.out.println("3.)Actualizar datos de un producto");
                            System.out.println("4.)Mostrar todos los productos ");
                            System.out.println("5.)Eliminar producto");
                            System.out.println("6.)Salir");
                            menuProductos = sc.nextLine();
                            System.out.println("");
                            switch (menuProductos) {
                                case "1":
                                    int id = 0;
                                    System.out.print("Ingrese Nombre: ");
                                    String nombre = sc.nextLine();
                                    System.out.print("Ingrese el stock: ");
                                    int stock = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.registrarProducto(id, nombre, stock);
                                    System.out.println("Producto registrado exitosamente.");     
                                    System.out.println("");
                                break;
                                case "2":
                                    System.out.print("Ingrese el Id del producto = ");
                                    int idBuscarProducto = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.obtenerProducto(idBuscarProducto);
                                    System.out.println("");
                                break;
                                case "3":
                                    System.out.print("Ingrese el Id del producto a editar = ");
                                    int idProductonuuevo = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Ingrese el nuevo nombre del Producto = ");
                                    String NuevoProducto = sc.nextLine();
                                    System.out.print("Ingrese el nuevo Stock = ");
                                    int NuevoStock = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("");
                                    System.out.println("Datos anteriores = ");
                                    productoCasoUso.obtenerProducto(idProductonuuevo);
                                    productoCasoUso.actualizarProducto(idProductonuuevo, NuevoProducto, NuevoStock);
                                    System.out.println("");
                                    System.out.println("Datos actualizados = ");
                                    productoCasoUso.obtenerProducto(idProductonuuevo);
                                    System.out.println("");
                                    break;
                                case "4":
                                    productoCasoUso.listarProducts();
                                    System.out.println("");
                                    break;
                                case "5":
                                    System.out.print("Ingrese el Id del producto a eliminar = ");
                                    int idEliminarProducto = sc.nextInt();
                                    sc.nextLine();
                                    productoCasoUso.eliminarProducto(idEliminarProducto);
                                    System.out.println("Producto eliminado exitosamente");
                                    System.out.println("");
                                    break;
                                case "6":
                                    System.out.println("Saliendo.......");
                                    System.out.println();
                                    break;
                                default:
                                    System.out.println("Dato seleccionado no existe, volviendo a menu........");
                                    System.out.println();
                                    break;
                            }
                        } while (!menuProductos.equals("6"));
                        break;
                    case "3":
                        System.out.println("Saliendo.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                    break;
                }   
            }while(!menu.equals("3"));
        }
    }
}