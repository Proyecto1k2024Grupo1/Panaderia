import java.time.LocalDate;

public class Empleado {

    private String dni;
    private double salario;
    private LocalDate fnac;
    private String nombre;
    private String encargado;

    public Empleado() {
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Empleado>\n");
        sb.append("<dni>").append(dni).append("</dni>\n");
        sb.append("<salario>").append(salario).append("</salario>\n");
        sb.append("<fnac>").append(fnac).append("</fnac>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<encargado>").append(encargado).append("</encargado>\n");
        sb.append("</Empleado>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"dni\": \"").append(dni).append("\",\n");
        sb.append("\"salario\": ").append(salario).append(",\n");
        sb.append("\"fnac\": \"").append(fnac).append("\",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"encargado\": \"").append(encargado).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
