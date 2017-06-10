
package aula10062017_conexaobanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Aula10062017_conexaoBanco {
    private static Connection conn;
    private final static String driver = "org.postgresql.Driver"; //sempre assim para o PostgresSQL
    private final static String ip = "localhost/"; //ip do computador que contém o banco
    public static String dataBase = "Aula10062017"; //nome da base de dados no PostgreSQL
    public static String user = "postgres"; //usuário do BD
    public static String password = "postgres"; //senha para o usuário 
    
    public Aula10062017_conexaoBanco(Connection conn) { //construtor da classe
        this.conn = conn;
    }
    /*
        Estabelecendo uma conexão com o banco de dados
    */
    public static Connection getAula10062017_conexaoBanco() throws SQLException, ClassNotFoundException {

        if (conn != null) { //se já existe conexão aberta, retorna ela ao invés de criar nova
            return conn;
        }
        //se não existe conexão, cria uma nova
        Class.forName(driver); //não mexer - definindo o JDBC utilizado
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password); //não mexer - definindo os parâmetros de conexão
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        try {
            getAula10062017_conexaoBanco();
            System.out.println("Feito!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Aula10062017_conexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}