package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class Usuario_DAO {
	
	// CONSULTA
    public List<Usuario> consultarUsuario(){

        
        List<Usuario> listaUsuarios = new ArrayList<>();

        try(Connection conexaoUsuarioDAO = ConnectionJDBC_Factory.getConnection()){

            
            String sqlConsulta = "SELECT * FROM usuario";

            PreparedStatement statementValoresTabelaUsuario = conexaoUsuarioDAO.prepareStatement(sqlConsulta);

            ResultSet valorRetornadoConsulta = statementValoresTabelaUsuario.executeQuery();

            
            while (valorRetornadoConsulta.next()){
                int cpf = valorRetornadoConsulta.getInt("cpf");
                String nome = valorRetornadoConsulta.getString("nome");
                String item_cafeManha = valorRetornadoConsulta.getString("item_cafeManha");
                
                listaUsuarios.add(new Usuario(cpf,nome,item_cafeManha));
            }
        }catch(SQLException e){
            System.out.println("Listagem de usuários FALHOU!");
            e.printStackTrace();
        }
        return listaUsuarios;
    }
    
    public Usuario consultarUsuario_Cpf(int cpf){

        Usuario usuarioCPF = new Usuario();

        try(Connection conexaoUsuarioDAO = ConnectionJDBC_Factory.getConnection()){

            
            String sqlConsulta_CPF = "SELECT * FROM usuario WHERE cpf = ?";

            
            PreparedStatement statementValorConsulta_CPF = conexaoUsuarioDAO.prepareStatement(sqlConsulta_CPF);
            statementValorConsulta_CPF.setInt(1,cpf);

            
            ResultSet valorRetornoConsulta_CPF = statementValorConsulta_CPF.executeQuery();

            
            if(valorRetornoConsulta_CPF.next()){
            	usuarioCPF.setCpf(valorRetornoConsulta_CPF.getInt("cpf"));
            	usuarioCPF.setNome(valorRetornoConsulta_CPF.getString("nome"));
            	usuarioCPF.setItem(valorRetornoConsulta_CPF.getString("item_cafeManha"));            	
            }

        }catch (SQLException e){
            System.out.println("Listagem de usuários FALHOU!");
            e.printStackTrace();
        }
        return usuarioCPF;
    }
    
    //INSERIR
    public void inserirUsuario(Usuario usuarioInserir){
        try(Connection conexaoUsuarioDAO = ConnectionJDBC_Factory.getConnection()){

            
            String sqlInserirDadosUsuario = "INSERT INTO usuario(cpf,nome) VALUES (?,?)";

            
            PreparedStatement statementValorInserir = conexaoUsuarioDAO.prepareStatement(sqlInserirDadosUsuario);
            statementValorInserir.setInt(1,usuarioInserir.getCpf());
            statementValorInserir.setString(2,usuarioInserir.getNome());
            
            
            int linhasAfetadas = statementValorInserir.executeUpdate();

            System.out.println("Inserção BEM SUCEDIDAD! Foram adicionada(s) "+ linhasAfetadas + " linha(s)");

        }catch(SQLException e){
            System.out.println("Inserção FALHOU!");
            e.printStackTrace();
        }
    }
    
  //DELETAR
    public void deletarUsuario(int cpf){
        try(Connection conexaoUsuarioDAO = ConnectionJDBC_Factory.getConnection()){

            
            String sqlDeletarUsuario = "DELETE FROM usuario WHERE cpf= ?";

            
            PreparedStatement statementValorDeletar = conexaoUsuarioDAO.prepareStatement(sqlDeletarUsuario);
            statementValorDeletar.setInt(1,cpf);

            
            int linhasAfetadas = statementValorDeletar.executeUpdate();

            System.out.println("Delete BEM SUCEDIDO! Foram deletada(s) "+ linhasAfetadas + " linha(s)");

        }catch(SQLException e){
            System.out.println("Delete FALHOU!");
            e.printStackTrace();
        }
    }
    
  //ATUALIZAR
    public void atualizarUsuario(Usuario usuarioAtualizar){
        try(Connection conexaoUsuarioDAO = ConnectionJDBC_Factory.getConnection()){

            
            String sqlAtualizar = "UPDATE usuario SET nome=? WHERE cpf= ?";

            
            PreparedStatement statementValorAtualizar = conexaoUsuarioDAO.prepareStatement(sqlAtualizar);
            statementValorAtualizar.setString(1,usuarioAtualizar.getNome());
                        
            
            int linhasAfetadas = statementValorAtualizar.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDO! Foram atualizada(s) "+ linhasAfetadas + " linha(s)");

        }catch(SQLException e){
            System.out.println("Atualização FALHOU!");
            e.printStackTrace();
        }
    }

}
