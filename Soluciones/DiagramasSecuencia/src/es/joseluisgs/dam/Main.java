package es.joseluisgs.dam;

import es.joseluisgs.dam.controllers.UsuariosController;
import es.joseluisgs.dam.controllers.VentasController;
import es.joseluisgs.dam.models.Persona;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Diagramas de Secuencia");
        System.out.println("======================");
        System.out.println("");

        secuenciaCRUD();
        secuenciaVentas();

    }

    private static void secuenciaVentas() {
        var userController = UsuariosController.getInstance();
        var ventasController = VentasController.getInstance();

        System.out.println();
        System.out.println("Secuencia de Ventas");
        System.out.println("==================");
        System.out.println("");

        // Creamos o buscamos el cliente
        var cliente = userController.crearUsuario("joseluis", 20);

        Map<Integer,Integer> datosLinea = new HashMap<>();
        datosLinea.put(1,1);
        datosLinea.put(2,1);
        datosLinea.put(3,2);
        datosLinea.put(4,1);

        try {
            var res = ventasController.realizarVenta(cliente, datosLinea);
            System.out.println("Venta realizada: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void secuenciaCRUD() {
        var userController = UsuariosController.getInstance();

        System.out.println();
        System.out.println("Secuencia de CRUD");
        System.out.println("================");
        System.out.println("");
        System.out.println("1. Create: Crear usuario");

        var sal = userController.crearUsuario("joseluis", 20);
        if (sal!=null) {
            System.out.println("Usuario creado: " + sal);
        } else {
            System.out.println("Usuario no creado");
        }

        System.out.println("");
        System.out.println("2. Read: Buscar usuario");
        var sal2 = userController.buscarPorNombre("joseluis");
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }

        System.out.println("");
        System.out.println("3. Update: Actualizar usuario");
        var nuevosDatos = new Persona("pepe",22);
        var sal3 = userController.actualizarUsuarioPorNombre("joseluis", nuevosDatos);
        if (sal3 != null) {
            System.out.println("Usuario actualizado: " + sal3);
        } else {
            System.out.println("Usuario no actualizado");
        }

        sal2 = userController.buscarPorNombre("pepe");
        if (sal2 != null) {
            System.out.println("Usuario encontrado: " + sal2);
        } else {
            System.out.println("Usuario no encontrado");
        }

        System.out.println("");
        System.out.println("4. Delete: Eliminar usuario");
        var sal4 = userController.eliminarPorPorNombre("pepe");
        if (sal4!=null) {
            System.out.println("Usuario eliminado: " + sal4);
        } else {

            System.out.println("Usuario no eliminado");
        }

        System.out.println("");
        System.out.println("5. ReadAll: Obtener todos");
        userController.crearUsuario("persona 1", 20);
        userController.crearUsuario("persona 2", 30);
        userController.crearUsuario("persona 3", 50);
        userController.crearUsuario("persona 4", 25);
        var res = userController.obtenerTodos();
        if (res != null) {
            System.out.println("Usuarios encontrados: " + res);
        }


    }
}
