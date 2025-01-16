public class Dependiente extends Empleado {

    private String dni;

    public Dependiente() {
    }

    public String mostrarInfo() {
        return "Dependiente: " + dni;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Dependiente>\n");
        sb.append("<dni>").append(dni).append("</dni>\n");
        sb.append("</Dependiente>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"dni\": \"").append(dni).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
