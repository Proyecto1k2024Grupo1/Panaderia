import java.util.ArrayList;
import java.util.List;

class Cliente {
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
}
