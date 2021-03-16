package controller;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destinations;
import model.Explorers;
import model.Gear;

/**
 * Servlet implementation class editDestinationServlet
 */
@WebServlet("/editDestinationServlet")
public class editDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		GearHelper gh = new GearHelper();
		
		String destinationName = request.getParameter("destinationName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String explorerName = request.getParameter("explorerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
	
		String[] selectedGear = request.getParameterValues("allGearToAdd");
		List<Gear> selectedGearInList = new ArrayList<Gear>();
		
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedGear != null && selectedGear.length > 0) {
			for(int i = 0; i < selectedGear.length; i++) {
				System.out.println(selectedGear[i]);
				Gear c = gh.searchForGearById(Integer.parseInt(selectedGear[i]));
				selectedGearInList.add(c);
			}
		}
		
		Explorers explorer = new Explorers(explorerName);
		Destinations des = new Destinations(destinationName, ld, explorer);
		//des.setListOfExplorers(selectedGearInList);
		DestinationsHelper dh = new DestinationsHelper();
		dh.insertNewDestinations(des);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
