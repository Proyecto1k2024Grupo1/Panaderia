public class Producto {
    private int codigo;
    private String nombre;
    public enum tipo{
        SALADO,DULCE,AGRIDULCE
    }
    private tipo tipo;
    private double precio;

    public Producto(int codigo, String nombre, Producto.tipo tipo, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Producto>\n");
        xml.append("\t<Codigo>").append(getCodigo()).append("</Codigo>\n");
        xml.append("\t<Nombre>").append(getNombre()).append("</Nombre>\n");
        xml.append("\t<Tipo>").append(getTipo()).append("</Tipo>\n");
        xml.append("\t<Precio>").append(getPrecio()).append("</Precio>\n");
        xml.append("</Producto>");
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
