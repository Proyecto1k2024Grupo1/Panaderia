package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    int idCliente;
    String direccion;
    String nombre;
    String apellido1;
    String apellido2;
    List<String> telefonos = new ArrayList<>();

    void registrarCompra(Compra compra) {
    }

    void actualizarDireccion(String nuevaDireccion) {
    }

    String obtenerNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<String> telefonos) {
        this.telefonos = telefonos;
    }

    public Cliente(int idCliente, String direccion, String nombre, String apellido1, String apellido2) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
}
