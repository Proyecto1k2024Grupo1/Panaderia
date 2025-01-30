package ClasesBase;

import java.time.LocalDate;

public class Dependiente extends Empleado{
    public Dependiente(String dni, double salario, LocalDate fnac, String nombre, String encargado) {
        super(dni, salario, fnac, nombre, encargado);
    }
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<BAse.Dependiente>\n");
        xmlBuilder.append("    <dni>").append(getDni()).append("</dni>\n");
        xmlBuilder.append("    <salario>").append(getSalario()).append("</salario>\n");
        xmlBuilder.append("    <fechaNacimiento>").append(getFnac()).append("</fechaNacimiento>\n");
        xmlBuilder.append("    <nombre>").append(getNombre()).append("</nombre>\n");
        xmlBuilder.append("    <encargado>").append(getEncargado()).append("</encargado>\n");
        xmlBuilder.append("</BAse.Dependiente>");
        return xmlBuilder.toString();
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"dni\": \"").append(getDni()).append("\", ");
        jsonBuilder.append("\"salario\": ").append(getSalario()).append(", ");
        jsonBuilder.append("\"fechaNacimiento\": \"").append(getFnac()).append("\", ");
        jsonBuilder.append("\"nombre\": \"").append(getNombre()).append("\", ");
        jsonBuilder.append("\"encargado\": \"").append(getEncargado()).append("\"");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
