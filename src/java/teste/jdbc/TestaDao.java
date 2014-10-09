/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.jdbc;

import java.sql.SQLException;

/**
 *
 * @author Klaus Boeing
 */
public class TestaDao {

    public static void main(String[] args) throws SQLException {
          ContatoDao dao = new ContatoDao();
          
          Contato contato = new Contato();
          contato.setId(6L);
          contato.setNome("José Silva");
          contato.setEmail("jose@gmai.com");
          contato.setEndereco("Rua...");
          
          dao.deleta(contato);
          
          dao.close();
    }
    
}
