package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private String usuario = "root";
    private String senha = "admin@12345";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_saude";
   // private String email ="binhoodoido@gmail.com";
    
    public Connection obtemConexao (){
    
        try{
            Connection c = DriverManager.getConnection(
            "jdbc:mysql://" + host + ":" + porta + "/" + bd
            + "?serverTimezone=UTC",          
            usuario,
            senha);
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado!!");
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("ERRO. NÃO CONECTOU!!!");
            return null;
        }
    }
    public static void main(String[] args) {
       ConnectionFactory c = new ConnectionFactory();
       c.obtemConexao();
    }
}
