public class Ingrediente {
    private int codIngrediente;
    private String nombre;
    private String descripcion;

    public Ingrediente(int codIngrediente, String nombre, String descripcion) {
        this.codIngrediente = codIngrediente;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Ingrediente>\n");
        xml.append("\t<CodIngrediente>").append(codIngrediente).append("</CodIngrediente>\n");
        xml.append("\t<Nombre>").append(nombre).append("</Nombre>\n");
        xml.append("\t<Descripcion>").append(descripcion).append("</Descripcion>\n");
        xml.append("</Ingrediente>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"codIngrediente\": ").append(codIngrediente).append(",\n");
        json.append("\t\"nombre\": \"").append(nombre).append("\",\n");
        json.append("\t\"descripcion\": \"").append(descripcion).append("\"\n");
        json.append("}");
        return json.toString();
    }
}
