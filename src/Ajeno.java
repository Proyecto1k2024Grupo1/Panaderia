public class Ajeno extends Producto{

    public Ajeno(int codigo, String nombre, Producto.tipo tipo, double precio) {
        super(codigo, nombre, tipo, precio);
    }
    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Ajeno>\n");
        xmlBuilder.append("    <codigo>").append(getCodigo()).append("</codigo>\n");
        xmlBuilder.append("    <nombre>").append(getNombre()).append("</nombre>\n");
        xmlBuilder.append("    <tipo>").append(getTipo()).append("</tipo>\n");
        xmlBuilder.append("    <precio>").append(getPrecio()).append("</precio>\n");
        xmlBuilder.append("</Ajeno>");
        return xmlBuilder.toString();
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"codigo\": ").append(getCodigo()).append(", ");
        jsonBuilder.append("\"nombre\": \"").append(getNombre()).append("\", ");
        jsonBuilder.append("\"tipo\": \"").append(getTipo()).append("\", ");
        jsonBuilder.append("\"precio\": ").append(getPrecio());
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }


}
