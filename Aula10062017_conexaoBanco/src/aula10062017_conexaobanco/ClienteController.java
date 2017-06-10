
package aula10062017_conexaobanco;

import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;


public class ClienteController {
    public boolean inserir(){
        String sql = "INSERT INTO cliente(nome, codigo) VALUES ('Jole', 7)";
        PreparedStatement ps;
        try{
            ps = Aula10062017_conexaoBanco.getAula10062017_conexaoBanco().prepareStatement(sql);
            ps.execute();
            return true;
        }catch(SQLException | ClassNotFoundException ex){
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static void main(String[] args){
        //crie um objeto da classe ClienteController
        ClienteController obj1 = new ClienteController();
        //chamar o método inserir desse objeto
        obj1.inserir();
        //executar e conferir no BD
    }
}
