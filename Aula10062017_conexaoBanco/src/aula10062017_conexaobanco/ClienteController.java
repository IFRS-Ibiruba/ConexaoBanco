
package aula10062017_conexaobanco;

import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;


public class ClienteController {
    public boolean inserir(int codigo, String nome){
        String sql = "INSERT INTO cliente(nome, codigo) VALUES (?, ?)"; //define instrução SQL
        PreparedStatement ps;
        try{
            ps = Aula10062017_conexaoBanco.getAula10062017_conexaoBanco().prepareStatement(sql); //prepara instrução SQL
            ps.setString(1, nome); //primeiro parâmetro indica a ? que eu quero definir e o segundo é a variável que substituirá a ?
            ps.setInt(2, codigo);  //primeiro parâmetro indica a ? que eu quero definir e o segundo é a variável que substituirá a ?
            ps.execute(); //executa SQL preparada
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
        obj1.inserir(11, "Pietra");
        obj1.inserir(12, "Maila");
        obj1.inserir(13, "Patricia");
        //executar e conferir no BD
    }
}
