public class Cliente {
    private  int idCliente;
    private String direccion;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Cliente(int idCliente, String direccion, String nombre, String apellido1, String apellido2) {
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String toXML() {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<Cliente>\n");
        xmlBuilder.append("    <idCliente>").append(getIdCliente()).append("</idCliente>\n");
        xmlBuilder.append("    <direccion>").append(getDireccion()).append("</direccion>\n");
        xmlBuilder.append("    <nombre>").append(getNombre()).append("</nombre>\n");
        xmlBuilder.append("    <apellido1>").append(getApellido1()).append("</apellido1>\n");
        xmlBuilder.append("    <apellido2>").append(getApellido2()).append("</apellido2>\n");
        xmlBuilder.append("</Cliente>");
        return xmlBuilder.toString();
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"idCliente\": ").append(getIdCliente()).append(", ");
        jsonBuilder.append("\"direccion\": \"").append(getDireccion()).append("\", ");
        jsonBuilder.append("\"nombre\": \"").append(getNombre()).append("\", ");
        jsonBuilder.append("\"apellido1\": \"").append(getApellido1()).append("\", ");
        jsonBuilder.append("\"apellido2\": \"").append(getApellido2()).append("\"");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
