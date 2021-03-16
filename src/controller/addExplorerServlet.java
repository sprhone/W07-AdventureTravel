package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Explorers;
import model.Gear;

/**
 * Servlet implementation class addExplorerServlet
 */
@WebServlet("/addExplorerServlet")
public class addExplorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addExplorerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String explorer = request.getParameter("explorer");
		//String gear = "";
		//Gear add = new Gear(gear);
		
		Explorers exp = new Explorers(explorer);
		ExplorerHelper eh = new ExplorerHelper();
		eh.insertExplorers(exp);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
