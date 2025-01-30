package ClasesBase;

import java.time.LocalDate;
import java.time.LocalTime;

public class Compra {
    private int numCompra;
    private LocalDate fecha;
    private int idCliente;
    private String dniDependiente;
    private double descuentoDependiente;
    private LocalDate fechaDependiente;
    private String dniRepartidor;
    private LocalDate fechaRepartidor;
    private LocalTime horaRepartidor;

    public Compra(int numCompra, LocalDate fecha, int idCliente, String dniDependiente, double descuentoDependiente, LocalDate fechaDependiente, String dniRepartidor, LocalDate fechaRepartidor, LocalTime horaRepartidor) {
        this.numCompra = numCompra;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.dniDependiente = dniDependiente;
        this.descuentoDependiente = descuentoDependiente;
        this.fechaDependiente = fechaDependiente;
        this.dniRepartidor = dniRepartidor;
        this.fechaRepartidor = fechaRepartidor;
        this.horaRepartidor = horaRepartidor;
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDniDependiente() {
        return dniDependiente;
    }

    public void setDniDependiente(String dniDependiente) {
        this.dniDependiente = dniDependiente;
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

    public String getDniRepartidor() {
        return dniRepartidor;
    }

    public void setDniRepartidor(String dniRepartidor) {
        this.dniRepartidor = dniRepartidor;
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
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<BAse.Compra>\n");
        xmlBuilder.append("    <numCompra>").append(getNumCompra()).append("</numCompra>\n");
        xmlBuilder.append("    <fecha>").append(getFecha()).append("</fecha>\n");
        xmlBuilder.append("    <idCliente>").append(getIdCliente()).append("</idCliente>\n");
        xmlBuilder.append("    <dniDependiente>").append(getDniDependiente()).append("</dniDependiente>\n");
        xmlBuilder.append("    <descuentoDependiente>").append(getDescuentoDependiente()).append("</descuentoDependiente>\n");
        xmlBuilder.append("    <fechaDependiente>").append(getFechaDependiente()).append("</fechaDependiente>\n");
        xmlBuilder.append("    <dniRepartidor>").append(getDniRepartidor()).append("</dniRepartidor>\n");
        xmlBuilder.append("    <fechaRepartidor>").append(getFechaRepartidor()).append("</fechaRepartidor>\n");
        xmlBuilder.append("    <horaRepartidor>").append(getHoraRepartidor()).append("</horaRepartidor>\n");
        xmlBuilder.append("</BAse.Compra>");
        return xmlBuilder.toString();
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"numCompra\": ").append(getNumCompra()).append(", ");
        jsonBuilder.append("\"fecha\": \"").append(getFecha()).append("\", ");
        jsonBuilder.append("\"idCliente\": ").append(getIdCliente()).append(", ");
        jsonBuilder.append("\"dniDependiente\": \"").append(getDniDependiente()).append("\", ");
        jsonBuilder.append("\"descuentoDependiente\": ").append(getDescuentoDependiente()).append(", ");
        jsonBuilder.append("\"fechaDependiente\": \"").append(getFechaDependiente()).append("\", ");
        jsonBuilder.append("\"dniRepartidor\": \"").append(getDniRepartidor()).append("\", ");
        jsonBuilder.append("\"fechaRepartidor\": \"").append(getFechaRepartidor()).append("\", ");
        jsonBuilder.append("\"horaRepartidor\": \"").append(getHoraRepartidor()).append("\"");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
