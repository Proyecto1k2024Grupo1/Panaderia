import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Compra {
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
}
