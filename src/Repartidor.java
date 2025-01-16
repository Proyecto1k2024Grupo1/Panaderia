public class Repartidor {

    private String dni;
    private String nombre;
    private String vehiculo;

    public Repartidor() {
    }

    public String mostrarInfo() {
        return "Repartidor: " + nombre + ", Vehículo: " + vehiculo;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Repartidor>\n");
        sb.append("<dni>").append(dni).append("</dni>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<vehiculo>").append(vehiculo).append("</vehiculo>\n");
        sb.append("</Repartidor>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"dni\": \"").append(dni).append("\",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"vehiculo\": \"").append(vehiculo).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
