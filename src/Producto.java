public class Producto {

    private int idProducto;
    private String nombre;
    private double precio;
    private String tipo;

    public Producto() {
    }

    public String mostrarInfo() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Tipo: " + tipo;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Producto>\n");
        sb.append("<idProducto>").append(idProducto).append("</idProducto>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<precio>").append(precio).append("</precio>\n");
        sb.append("<tipo>").append(tipo).append("</tipo>\n");
        sb.append("</Producto>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"idProducto\": ").append(idProducto).append(",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"precio\": ").append(precio).append(",\n");
        sb.append("\"tipo\": \"").append(tipo).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
