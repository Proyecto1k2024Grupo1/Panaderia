package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    int numCompra;
    LocalDate fecha;
    Cliente cliente;
    Dependiente dependiente;
    double descuentoDependiente;
    LocalDate fechaDependiente;
    Repartidor repartidor;
    LocalDate fechaRepartidor;
    LocalTime horaRepartidor;
    List<LineaDeTicket> lineas = new ArrayList<>();

    void registrarLinea(LineaDeTicket linea) {
        lineas.add(linea);
    }

    double calcularTotal() {
        return 0;
    }

    void asociarCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Compra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Dependiente getDependiente() {
        return dependiente;
    }

    public void setDependiente(Dependiente dependiente) {
        this.dependiente = dependiente;
    }

    public double getDescuentoDependiente() {
        return descuentoDependiente;
    }

    public void setDescuentoDependiente(double descuentoDependiente) {
        this.descuentoDependiente = descuentoDependiente;
    }

    public LocalDate getFechaDependiente() {
        return fechaDependiente;
    }

    public void setFechaDependiente(LocalDate fechaDependiente) {
        this.fechaDependiente = fechaDependiente;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public LocalDate getFechaRepartidor() {
        return fechaRepartidor;
    }

    public void setFechaRepartidor(LocalDate fechaRepartidor) {
        this.fechaRepartidor = fechaRepartidor;
    }

    public LocalTime getHoraRepartidor() {
        return horaRepartidor;
    }

    public void setHoraRepartidor(LocalTime horaRepartidor) {
        this.horaRepartidor = horaRepartidor;
    }

    public List<LineaDeTicket> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaDeTicket> lineas) {
        this.lineas = lineas;
    }
}
