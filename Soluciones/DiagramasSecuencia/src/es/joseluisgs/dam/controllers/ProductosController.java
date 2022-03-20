package es.joseluisgs.dam.controllers;

import es.joseluisgs.dam.models.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de productos
 */
public class ProductosController {
    private static ProductosController instance;
    // Repositorio de la información
    List<Producto> productosRepository = new ArrayList<>();

    private ProductosController() {
        productosRepository.add(new Producto("Producto 1", 10, 10));
        productosRepository.add(new Producto(" Productpo 2", 15.5, 5));
        productosRepository.add(new Producto("Producto 3",  24, 7));
        productosRepository.add(new Producto("Producto 4", 23.5, 67));
    }

    public static ProductosController getInstance() {
        if (instance == null) {
            instance = new ProductosController();
        }
        return instance;
    }

    /**
     * Obtiene un producto dado su id
     * @param id id del producto
     * @return producto con el id dado o null si no existe
     */
    public Producto getProducto(int id) {
        for (Producto producto : productosRepository) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Actualiza el stock de un producto dado un id
     * @param id id del producto
     * @param cantidad a retirar del stock del producto
     */
    public void actualizarExistencias(int id, int cantidad) {
        for (Producto producto : productosRepository) {
            if (producto.getId() == producto.getId()) {
                producto.setStock(producto.getStock()-cantidad);
            }
        }
    }
}
