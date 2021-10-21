package controller;

import java.io.IOException;
import java.sql.ResultSet;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

/**
 * Servlet implementation class alterarUsuarioController
 */
public class alterarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public alterarUsuarioController() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		HttpSession session = request.getSession(true);
//		
//		String cpf = (String)session.getValue("usuario");
//		
//		System.out.println(cpf);
		
//		String alterar = request.getParameter("alterar");
//		
//		String nome = request.getParameter("nome");
//		String cpf = request.getParameter("cpf");
//		String senha = request.getParameter("senha");
//		
//		Usuario usuario = new Usuario();		
//		usuario.setCpf(cpf);
//		usuario.setSenha(senha);
		
//		UsuarioDAO usuario_dao = new UsuarioDAO();
//		ResultSet rsUsuario_dao = usuario_dao.consultarUsuario(usuario);
	}

}
