package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destinations;

/**
 * Servlet implementation class destinationNavigationServlet
 */
@WebServlet("/destinationNavigationServlet")
public class destinationNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public destinationNavigationServlet() {
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
		
		DestinationsHelper dh = new DestinationsHelper();
		String path = "/viewAllDestinationsServlet";
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("tripId"));
				Destinations destinationToDelete = dh.searchForDestinationById(tempId);
				dh.deleteDestination(destinationToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
			
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("tripId"));
				Destinations destinationToEdit = dh.searchForDestinationById(tempId);
				request.setAttribute("destinationToEdit", destinationToEdit);
				
				ExplorerHelper listOfExplorers = new ExplorerHelper();
				request.setAttribute("allExplorers", listOfExplorers.showAllExplorers());
				
				path = "/edit-destination.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
			
			
		} else if (act.equals("add")) {
		path = "/index.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
