package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginController() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String mensagem;
		
		
		Usuario usuario = new Usuario();
		usuario.setCpf(cpf);
		usuario.setSenha(senha);
		
		UsuarioDAO usuario_dao = new UsuarioDAO();
		ResultSet rsUsuario_dao = usuario_dao.consultarUsuario(usuario);
		
		System.out.println(rsUsuario_dao);
		
		try {
			if(rsUsuario_dao.next()) {
				response.sendRedirect("/src/main/webapp/telaUsuario.jsp");				
			}
			else {				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/src/main/webapp/login.jsp");
				dispatcher.forward(request, response);
				mensagem = "Informe um CPF e/ou Senha válido!";				
			}

		} catch (SQLException e) {			
			e.printStackTrace();
		}					
		
	}

}
