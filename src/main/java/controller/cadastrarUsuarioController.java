package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import model.Usuario;

/**
 * Servlet implementation class cadastrarUsuarioController
 */
public class cadastrarUsuarioController extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public cadastrarUsuarioController() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {
			
			this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String senha = request.getParameter("senha");
			
			Usuario usuario = new Usuario();
			String mensagem;
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./cadastroUsuario.jsp");
			
			if(nome != null && !nome.isEmpty()){			
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setSenha(senha);
				usuario.salvar();
				mensagem = "Usuário cadastrado com sucesso!";
			}
			else {
				mensagem = "Informe um usuário!";
			}
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
		}	

}
