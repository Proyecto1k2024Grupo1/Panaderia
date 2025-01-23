public class Telefono {
    private String numTelefono;
    private int idCliente;

    public Telefono(String numTelefono, int idCliente) {
        this.numTelefono = numTelefono;
        this.idCliente = idCliente;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String toXML() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Telefono>\n");
        xml.append("\t<NumTelefono>").append(getNumTelefono()).append("</NumTelefono>\n");
        xml.append("\t<IdCliente>").append(getIdCliente()).append("</IdCliente>\n");
        xml.append("</Telefono>");
        return xml.toString();
    }

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("\t\"numTelefono\": \"").append(getNumTelefono()).append("\",\n");
        json.append("\t\"idCliente\": ").append(getIdCliente()).append("\n");
        json.append("}");
        return json.toString();
    }
}
