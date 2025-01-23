public class Proveedor {
    private int codProveedor;
    private String nombre;

    public Proveedor(int codProveedor, String nombre) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Proveedor>\n");
        xml.append("\t<CodProveedor>").append(getCodProveedor()).append("</CodProveedor>\n");
        xml.append("\t<Nombre>").append(getNombre()).append("</Nombre>\n");
        xml.append("</Proveedor>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"codProveedor\": ").append(getCodProveedor()).append(",\n");
        json.append("\t\"nombre\": \"").append(getNombre()).append("\"\n");
        json.append("}");
        return json.toString();
    }
}
