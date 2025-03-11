package java_hexagonal_abstract;

import java.util.Scanner;
import java_hexagonal_abstract.Application.Usecase.Basedatos.BasedatosUseCase;
import java_hexagonal_abstract.Application.Usecase.Client.ClientUseCase;
import java_hexagonal_abstract.Application.Usecase.Product.ProductUseCase;
import java_hexagonal_abstract.Domain.Repository.ClientRespository;
import java_hexagonal_abstract.Domain.Repository.ProductResposity;
import java_hexagonal_abstract.Domain.Repository.basedatos;
import java_hexagonal_abstract.infrastructure.Database.ConnectionFactory;
import java_hexagonal_abstract.infrastructure.persistence.Client.ClientRepositoryImpl;
import java_hexagonal_abstract.infrastructure.persistence.Product.ProductRepositoryImpl;
import java_hexagonal_abstract.infrastructure.persistence.baseDatos.BaseDeDatosRepositoryimpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository repositorio = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ClientUseCase clienteCasoUso = new ClientUseCase(repositorio);
        ProductResposity repositorioProduc = new ProductRepositoryImpl(ConnectionFactory.crearConexion());
        ProductUseCase productoCasoUso = new ProductUseCase(repositorioProduc);
        basedatos basedatos = new BaseDeDatosRepositoryimpl(ConnectionFactory.crearConexion());
        BasedatosUseCase basedatosUseCase = new BasedatosUseCase(basedatos);
        try (Scanner sc = new Scanner(System.in)){
            String menu;
            do {
                String menuClientes; 
                String menuProductos; 
                System.out.println("1.) Entrar a menu de clientes");
                System.out.println("2.) Entrar a menu de Producto");
                System.out.println("3.) Crear base de datos ");
                System.out.println("4.) salir....");
                System.out.print("Elige una opcion = ");
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
                            System.out.print("Elige una opcion = ");
                            menuClientes = sc.nextLine();
                            System.out.println("");
                            switch (menuClientes) {
                                case "1":
                                    try {
                                        int id = 0;
                                        System.out.print("Ingrese Nombre: ");
                                        String nombre = sc.nextLine();
                                        System.out.print("Ingrese Email: ");
                                        String email = sc.nextLine();
                                        if (email.contains("@")) {
                                            clienteCasoUso.registrarCliente(id, nombre, email);
                                           
                                        }else{
                                            System.out.println("Error el email esta mal, es obligatorio el @");
                                            System.out.println("");
                                        }
                                        
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                    }

                                    break;
                                case "2":
                                    try {
                                        System.out.print("Ingrese el Id del cliente = ");
                                        int idBuscar = sc.nextInt();
                                        sc.nextLine();
                                        clienteCasoUso.obtenerCliente(idBuscar);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "3":
                                    try {
                                        System.out.print("Ingrese el Id de la persona a editar = ");
                                        int idNuevo = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Ingrese el nuevo nombre del cliente = ");
                                        String NombreNuevo = sc.nextLine();
                                        System.out.print("Ingrese el nuevo gmail = ");
                                        String EmailNuevo = sc.nextLine();
                                        if (EmailNuevo.contains("@")) {
                                            System.out.println("");
                                            System.out.println("Datos anteriores = ");
                                            clienteCasoUso.obtenerCliente(idNuevo);
                                            clienteCasoUso.actualizarCliente(idNuevo, NombreNuevo, EmailNuevo);
                                            System.out.println("");
                                            System.out.println("Datos actualizados = ");
                                            clienteCasoUso.obtenerCliente(idNuevo);
                                            System.out.println("");
                                           
                                        }else{
                                            System.out.println("Error el email esta mal, es obligatorio el @");
                                            System.out.println("");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "4":
                                    try {
                                        clienteCasoUso.listarClientes();
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "5":
                                    try {
                                        System.out.print("Ingrese el Id de la persona a eliminar = ");
                                        int idEliminar = sc.nextInt();
                                        sc.nextLine();
                                        clienteCasoUso.eliminarCliente(idEliminar);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
    
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
                            System.out.print("Elige una opcion = ");
                            menuProductos = sc.nextLine();
                            System.out.println("");
                            switch (menuProductos) {
                                case "1":
                                    try {
                                        int id = 0;
                                        System.out.print("Ingrese Nombre: ");
                                        String nombre = sc.nextLine();
                                        System.out.print("Ingrese el stock: ");
                                        int stock = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.registrarProducto(id, nombre, stock);
                                        System.out.println("Producto registrado exitosamente.");     
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
           
                                break;
                                case "2":
                                    try {
                                        System.out.print("Ingrese el Id del producto = ");
                                        int idBuscarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.obtenerProducto(idBuscarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                 
                                break;
                                case "3":
                                    try {
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

                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                                    break;
                                case "4":
                                    try {
                                        productoCasoUso.listarProducts();
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }

                                    break;
                                case "5":
                                    try {
                                        System.out.print("Ingrese el Id del producto a eliminar = ");
                                        int idEliminarProducto = sc.nextInt();
                                        sc.nextLine();
                                        productoCasoUso.eliminarProducto(idEliminarProducto);
                                        System.out.println("");
                                    } catch (Exception e) {
                                        System.out.println("error vuelve a intentarlo");
                                        System.out.println("");
                                    }
                         
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
                        basedatosUseCase.creardatos();
                    break;
                    case "4":
                        System.out.println("Saliendo.......");
                        System.out.println();
                        break;
                    default:
                        System.out.println("Dato seleccionado no existe, volviendo a menu........");
                        System.out.println();
                    break;
                }   
            }while(!menu.equals("4"));
        }catch(Exception e) {
            System.out.println("Error por favor vuelve a iniciar el programa");
        }
    }
}