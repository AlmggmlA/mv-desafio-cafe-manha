package JDBC;

import java.util.List;

import model.Usuario;

public class QueriesExecution {
    public static void main(String[] args) {

    		Usuario_DAO usuarioDAO = new Usuario_DAO();

            //CONSULTAR
            List<Usuario> listaUsuarios = usuarioDAO.consultarUsuario();
            listaUsuarios.stream().forEach(System.out::println);

            //CONSULTAR COM FILTRO
            Usuario UsuarioConsultar = usuarioDAO.consultarUsuario_Cpf(2);
            System.out.println(UsuarioConsultar);

            //INSERIR
            Usuario UsuarioInserir = new Usuario(123,"Matheus","abacate");
            usuarioDAO.inserirUsuario(UsuarioInserir);

            //DELETAR
            usuarioDAO.deletarUsuario(6);
            usuarioDAO.consultarUsuario().stream().forEach(System.out::println);

            //ATUALIZAR
            Usuario Usuario_Atualizar = usuarioDAO.consultarUsuario_Cpf(5);
            Usuario_Atualizar.setNome("Joaquim");
            

            usuarioDAO.atualizarUsuario(Usuario_Atualizar);
        }
}
