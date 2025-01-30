package ClasesBase;

import java.time.LocalDate;

public class Panadero extends Empleado{
    public Panadero(String dni, double salario, LocalDate fnac, String nombre, String encargado) {
        super(dni, salario, fnac, nombre, encargado);
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<BAse.Panadero>\n");
        xml.append("\t<Dni>").append(getDni()).append("</Dni>\n");
        xml.append("\t<Salario>").append(getSalario()).append("</Salario>\n");
        xml.append("\t<Fnac>").append(getFnac()).append("</Fnac>\n");
        xml.append("\t<Nombre>").append(getNombre()).append("</Nombre>\n");
        xml.append("\t<Encargado>").append(getEncargado()).append("</Encargado>\n");
        xml.append("</BAse.Panadero>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"dni\": \"").append(getDni()).append("\",\n");
        json.append("\t\"salario\": ").append(getSalario()).append(",\n");
        json.append("\t\"fnac\": \"").append(getFnac()).append("\",\n");
        json.append("\t\"nombre\": \"").append(getNombre()).append("\",\n");
        json.append("\t\"encargado\": \"").append(getEncargado()).append("\"\n");
        json.append("}");
        return json.toString();
    }
}
