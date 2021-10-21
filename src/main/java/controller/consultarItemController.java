package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item_cafeManha;

/**
 * Servlet implementation class consultarItemController
 */
public class consultarItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public consultarItemController() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String nome_item = request.getParameter("nomeItemConuslta");
		
		ArrayList<Item_cafeManha> itens = new Item_cafeManha().consultarItem(nome_item);
		
		for(Item_cafeManha item:itens) {
			System.out.println(item.getNomeItem());
		}
		
		request.setAttribute("itens", itens);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/src/main/webapp/telaUsuario.jsp");
		dispatcher.forward(request, response);
	}

}
