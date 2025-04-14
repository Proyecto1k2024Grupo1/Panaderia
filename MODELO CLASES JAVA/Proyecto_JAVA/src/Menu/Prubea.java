package Menu;

import DAO.LineaDeTicketDAO;
import Model.LineaDeTicket;

import java.sql.SQLException;
import java.util.List;

public class Prubea {
    public static void main(String[] args) throws SQLException {
        List<LineaDeTicket> l = LineaDeTicketDAO.getInstance().getAllLineasDeTicketByNumCompra(15);
        System.out.println(l);
    }
}
