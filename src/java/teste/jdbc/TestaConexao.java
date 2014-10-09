/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Klaus Boeing
 */
public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
