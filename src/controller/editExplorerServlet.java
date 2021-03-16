package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Explorers;
import model.Gear;

/**
 * Servlet implementation class editExplorerServlet
 */
@WebServlet("/editExplorerServlet")
public class editExplorerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editExplorerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ExplorerHelper eh = new ExplorerHelper();
		GearHelper gh = new GearHelper();
		
		String explorerName = request.getParameter("explorerName");
		Integer tempId = Integer.parseInt(request.getParameter("explorerId"));
		
		Explorers explorerToUpdate = eh.searchForExplorerById(tempId);
		explorerToUpdate.setExplorerName(explorerName);
		
		try {
			//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allGearToAdd");
			List<Gear> selectedItemsInList = new ArrayList<Gear>();
			
			for (int i = 0; i < selectedItems.length; i++) {
				System.out .println(selectedItems[i]);
				Gear c = gh.searchForGearById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
				}
		
				explorerToUpdate.setListOfGear(selectedItemsInList);
			
			} catch (NullPointerException ex) {
				// no items selected in list - set to an empty list
				List<Gear> selectedItemsInList = new ArrayList<Gear>();
			explorerToUpdate.setListOfGear(selectedItemsInList);
			}		
		
		eh.updateExplorer(explorerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllExplorersServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
