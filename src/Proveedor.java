public class Proveedor {

    private int idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;

    public Proveedor() {
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Proveedor>\n");
        sb.append("<idProveedor>").append(idProveedor).append("</idProveedor>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<direccion>").append(direccion).append("</direccion>\n");
        sb.append("<telefono>").append(telefono).append("</telefono>\n");
        sb.append("</Proveedor>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"idProveedor\": ").append(idProveedor).append(",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"direccion\": \"").append(direccion).append("\",\n");
        sb.append("\"telefono\": \"").append(telefono).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
