import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {

    private int numCompra;
    private LocalDate fecha;
    private int idCliente;
    private String dniDependiente;
    private double descuentoDependiente;
    private String fechaDependiente;
    private String dniRepartidor;
    private String fechaRepartidor;
    private LocalTime horaRepartidor;

    public Compra() {
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Compra>\n");
        sb.append("<numCompra>").append(numCompra).append("</numCompra>\n");
        sb.append("<fecha>").append(fecha).append("</fecha>\n");
        sb.append("<idCliente>").append(idCliente).append("</idCliente>\n");
        sb.append("<dniDependiente>").append(dniDependiente).append("</dniDependiente>\n");
        sb.append("<descuentoDependiente>").append(descuentoDependiente).append("</descuentoDependiente>\n");
        sb.append("<fechaDependiente>").append(fechaDependiente).append("</fechaDependiente>\n");
        sb.append("<dniRepartidor>").append(dniRepartidor).append("</dniRepartidor>\n");
        sb.append("<fechaRepartidor>").append(fechaRepartidor).append("</fechaRepartidor>\n");
        sb.append("<horaRepartidor>").append(horaRepartidor).append("</horaRepartidor>\n");
        sb.append("</Compra>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"numCompra\": ").append(numCompra).append(",\n");
        sb.append("\"fecha\": \"").append(fecha).append("\",\n");
        sb.append("\"idCliente\": ").append(idCliente).append(",\n");
        sb.append("\"dniDependiente\": \"").append(dniDependiente).append("\",\n");
        sb.append("\"descuentoDependiente\": ").append(descuentoDependiente).append(",\n");
        sb.append("\"fechaDependiente\": \"").append(fechaDependiente).append("\",\n");
        sb.append("\"dniRepartidor\": \"").append(dniRepartidor).append("\",\n");
        sb.append("\"fechaRepartidor\": \"").append(fechaRepartidor).append("\",\n");
        sb.append("\"horaRepartidor\": \"").append(horaRepartidor).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}

