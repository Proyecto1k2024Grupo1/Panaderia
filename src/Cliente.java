import java.io.*;
import java.util.*;

public class Cliente {

    private int idCliente;
    private String direccion;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Cliente() {
    }

    public String mostrarInfo() {
        return "Cliente: " + nombre + " " + apellido1 + " " + apellido2 + ", Dirección: " + direccion;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Cliente>\n");
        sb.append("<idCliente>").append(idCliente).append("</idCliente>\n");
        sb.append("<direccion>").append(direccion).append("</direccion>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<apellido1>").append(apellido1).append("</apellido1>\n");
        sb.append("<apellido2>").append(apellido2).append("</apellido2>\n");
        sb.append("</Cliente>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"idCliente\": ").append(idCliente).append(",\n");
        sb.append("\"direccion\": \"").append(direccion).append("\",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"apellido1\": \"").append(apellido1).append("\",\n");
        sb.append("\"apellido2\": \"").append(apellido2).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
