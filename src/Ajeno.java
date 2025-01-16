import java.io.*;
import java.util.*;

public class Ajeno extends Producto {

    private int codigo;

    public Ajeno() {
    }

    public String mostrarInfo() {
        return "Código: " + codigo;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Ajeno>\n");
        sb.append("<codigo>").append(codigo).append("</codigo>\n");
        sb.append("</Ajeno>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"codigo\": ").append(codigo).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
