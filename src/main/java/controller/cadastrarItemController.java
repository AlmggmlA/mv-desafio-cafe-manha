package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item_cafeManha;

/**
 * Servlet implementation class cadastrarItemController
 */
public class cadastrarItemController extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public cadastrarItemController() {
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
				
		String nomeItem = request.getParameter("nomeItem");
		String mensagem;
		Item_cafeManha itemCafeManha = new Item_cafeManha();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./telaUsuario.jsp");
		
		if(nomeItem != null && !nomeItem.isEmpty()){			
			itemCafeManha.setNomeItem(nomeItem);
			itemCafeManha.salvar();
			mensagem = "Item cadastrado com sucesso!";
		}
		else {
			mensagem = "Informe um item para o café da manhã!";
		}
		request.setAttribute("mensagem", mensagem);			
		dispatcher.forward(request, response);
	}

}
