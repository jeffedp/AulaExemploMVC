/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Klaus Boeing
 */
public class JDBCInsere {

    public static void main(String[] args) throws SQLException {

        String sql = "insert into agenda.contatos"
                + " (id,nome,email,endereco)"
                + " values (?,?,?,?)";

        try (Connection conn = new ConnectionFactory().getConnection()) {
            try (PreparedStatement stm = conn.prepareStatement(sql)) {
                stm.setLong(1, 5);
                stm.setString(2, "Marcio");
                stm.setString(3, "marcio@gmail.com");
                stm.setString(4, "rua blalbla");

                stm.execute();
            }
        }
    }
}
