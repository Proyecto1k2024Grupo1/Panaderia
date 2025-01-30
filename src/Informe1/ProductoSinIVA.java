package Informe1;

public class ProductoSinIVA {

    private String nombre;
    private double precio;
    private double precioSinIVA;

    // Constructor
    public ProductoSinIVA(String nombre, double precio, double precioSinIVA) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioSinIVA = precioSinIVA;
    }

    // Getters y Setters
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

    public double getPrecioSinIVA() {
        return precioSinIVA;
    }

    public void setPrecioSinIVA(double precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
    }

    // Método para convertir a XML
    public String toXML() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("<producto>");
        resultado.append("<nombre>").append(nombre).append("</nombre>");
        resultado.append("<precio>").append(precio).append("</precio>");
        resultado.append("<precioSinIVA>").append(precioSinIVA).append("</precioSinIVA>");
        resultado.append("</producto>");
        return resultado.toString();
    }

    // Método para convertir a JSON
    public String toJSON() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("{");
        resultado.append("\"producto\": {");
        resultado.append("\"nombre\": \"").append(nombre).append("\", ");
        resultado.append("\"precio\": ").append(precio).append(", ");
        resultado.append("\"precioSinIVA\": ").append(precioSinIVA);
        resultado.append("}");
        resultado.append("}");
        return resultado.toString();
    }
}
