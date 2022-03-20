package es.joseluisgs.dam.models;

import es.joseluisgs.dam.models.LineaVenta;
import es.joseluisgs.dam.models.Persona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private LocalDateTime createdAt;
    private Persona persona;
    List<LineaVenta> lineasVenta;
    private double total;

    public Venta(Persona persona) {
        this.persona = persona;
        this.createdAt = LocalDateTime.now();
        this.lineasVenta = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Persona getPersona() {
        return persona;
    }


    public List<LineaVenta> getLineasVenta() {
        return lineasVenta;
    }

    public void setLineasVenta(List<LineaVenta> lineasVenta) {
        this.lineasVenta = lineasVenta;
    }

    public void insertarLinea(LineaVenta lineaVenta) {
        this.lineasVenta.add(lineaVenta);
    }

    public double getTotal() {
        calcularTotal();
        return total;
    }

    public void calcularTotal() {
        double total = 0;
        for (LineaVenta lineaVenta : lineasVenta) {
            total += lineaVenta.getTotal();
        }
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", persona=" + persona +
                ", lineasVenta=" + lineasVenta +
                ", total=" + total +
                '}';
    }
}
