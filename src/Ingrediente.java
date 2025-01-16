public class Ingrediente {

    private int codIngrediente;
    private String nombre;
    private String descripcion;

    public Ingrediente() {
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Ingrediente>\n");
        sb.append("<codIngrediente>").append(codIngrediente).append("</codIngrediente>\n");
        sb.append("<nombre>").append(nombre).append("</nombre>\n");
        sb.append("<descripcion>").append(descripcion).append("</descripcion>\n");
        sb.append("</Ingrediente>");
        return sb.toString();
    }

    public String toJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"codIngrediente\": ").append(codIngrediente).append(",\n");
        sb.append("\"nombre\": \"").append(nombre).append("\",\n");
        sb.append("\"descripcion\": \"").append(descripcion).append("\"\n");
        sb.append("}");
        return sb.toString();
    }
}
