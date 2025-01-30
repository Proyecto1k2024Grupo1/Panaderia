package ClasesBase;

public class Linea_De_Ticket {
    private int numCompra;
    private int numLinea;
    private int codProducto;
    private int cantidad;


    public Linea_De_Ticket(int numCompra, int numLinea, int codProducto, int cantidad) {
        this.numCompra = numCompra;
        this.numLinea = numLinea;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
    }

    public int getNumCompra() {
        return numCompra;
    }

    public void setNumCompra(int numCompra) {
        this.numCompra = numCompra;
    }

    public int getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<LineaDeTicket>\n");
        xml.append("\t<NumCompra>").append(numCompra).append("</NumCompra>\n");
        xml.append("\t<NumLinea>").append(numLinea).append("</NumLinea>\n");
        xml.append("\t<CodProducto>").append(codProducto).append("</CodProducto>\n");
        xml.append("\t<Cantidad>").append(cantidad).append("</Cantidad>\n");
        xml.append("</LineaDeTicket>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"numCompra\": ").append(numCompra).append(",\n");
        json.append("\t\"numLinea\": ").append(numLinea).append(",\n");
        json.append("\t\"codProducto\": ").append(codProducto).append(",\n");
        json.append("\t\"cantidad\": ").append(cantidad).append("\n");
        json.append("}");
        return json.toString();
    }
}
