package Classe;

import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Agua {

    private String nome;
    private int codigo;
    private double agua;
    private double media;

    public Agua() {
    }

    public Agua(String nome, double nota1, double nota2, double media) {
        this.nome = nome;
        this.agua = nota1;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return agua;
    }

    public void setNota1(double nota1) {
        this.agua = nota1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getMedia() {

        media = agua*35*0.001;

        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void inserir() {
//1: Definir o comando SQL
        String sql = "INSERT INTO tb_aluno(nome, nota1, nota2) VALUES (?, ?, ?)";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
            ps.setString(1, nome);
            ps.setDouble(2, agua);
//5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void apagar() {
//1: Definir o comando SQL
        String sql = "DELETE FROM tb_aluno WHERE codigo = ?";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
            ps.setInt(1, codigo);
//5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void listar() {
//1: Definir o comando SQL
        String sql = "SELECT * FROM tb_aluno";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Executa o comando e guarda
//o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
//5: itera sobre o resultado
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                Double agua = rs.getDouble("nota1");
                String aux = "Código: " + codigo + " Nome: " + nome + " agua " 
                        + agua;
                
                JOptionPane.showMessageDialog(null, aux);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
