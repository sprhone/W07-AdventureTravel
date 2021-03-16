package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Explorers;

/**
 * Servlet implementation class explorerNavigationServlet
 */
@WebServlet("/explorerNavigationServlet")
public class explorerNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public explorerNavigationServlet() {
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
		
		String act = request.getParameter("doThisToItem");
		
		ExplorerHelper eh = new ExplorerHelper();
		String path = "/viewAllExplorersServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("explorerId"));
				Explorers explorerToDelete = eh.searchForExplorerById(tempId);
				eh.deleteExplorer(explorerToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
			
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("explorerId"));
				Explorers explorerToEdit = eh.searchForExplorerById(tempId);
				request.setAttribute("explorerToEdit", explorerToEdit);
				path = "/edit-explorer.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
			
		} else if (act.equals("add")) {
		path = "/index.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
