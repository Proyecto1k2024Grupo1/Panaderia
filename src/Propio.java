public class Propio extends Producto{
    public Propio(int codigo, String nombre, Producto.tipo tipo, double precio) {
        super(codigo, nombre, tipo, precio);
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Propio>\n");
        xml.append("\t<Codigo>").append(getCodigo()).append("</Codigo>\n");
        xml.append("\t<Nombre>").append(getNombre()).append("</Nombre>\n");
        xml.append("\t<Tipo>").append(getTipo()).append("</Tipo>\n");
        xml.append("\t<Precio>").append(getPrecio()).append("</Precio>\n");
        xml.append("</Propio>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"codigo\": ").append(getCodigo()).append(",\n");
        json.append("\t\"nombre\": \"").append(getNombre()).append("\",\n");
        json.append("\t\"tipo\": \"").append(getTipo()).append("\",\n");
        json.append("\t\"precio\": ").append(getPrecio()).append("\n");
        json.append("}");
        return json.toString();
    }
}
