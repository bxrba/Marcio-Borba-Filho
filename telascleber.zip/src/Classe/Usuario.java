package Classe;
    
import Banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Usuario {
    private String usuario;
    private String senha;
    private String email; 
   
    public Usuario() {
       
     
    }

    public Usuario(String usuario, String senha, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean validarUsuario(String usuarioP, String senhaP){
        boolean resp = false;
        
        if(usuario.equalsIgnoreCase(usuarioP) &&
                senha.equalsIgnoreCase(senhaP)){
                resp = true;
        }
        
        return resp;
    }

   public void inserir() {
//1: Definir o comando SQL
        String sql = "INSERT INTO tb_usuario(nome, email, senha) VALUES (?, ?, ?)";
//2: Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection c = factory.obtemConexao()) {
//3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
//4: Preenche os dados faltantes
            ps.setString(1, usuario);
            ps.setString(2, email);
            ps.setString(3, senha);
//5: Executa o comando
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}