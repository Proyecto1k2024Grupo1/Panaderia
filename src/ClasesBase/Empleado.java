package ClasesBase;

import java.time.LocalDate;

public class Empleado {
    private String dni;
    private double salario;
    private LocalDate fnac;
    private String nombre;
    private String encargado;

    public Empleado(String dni, double salario, LocalDate fnac, String nombre, String encargado) {
        this.dni = dni;
        this.salario = salario;
        this.fnac = fnac;
        this.nombre = nombre;
        this.encargado = encargado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<BAse.Empleado>\n");
        xml.append("\t<Dni>").append(dni).append("</Dni>\n");
        xml.append("\t<Salario>").append(salario).append("</Salario>\n");
        xml.append("\t<Fnac>").append(fnac.toString()).append("</Fnac>\n");
        xml.append("\t<Nombre>").append(nombre).append("</Nombre>\n");
        xml.append("\t<Encargado>").append(encargado).append("</Encargado>\n");
        xml.append("</BAse.Empleado>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"dni\": \"").append(dni).append("\",\n");
        json.append("\t\"salario\": ").append(salario).append(",\n");
        json.append("\t\"fnac\": \"").append(fnac.toString()).append("\",\n");
        json.append("\t\"nombre\": \"").append(nombre).append("\",\n");
        json.append("\t\"encargado\": \"").append(encargado).append("\"\n");
        json.append("}");
        return json.toString();
    }
}
