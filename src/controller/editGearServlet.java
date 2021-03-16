package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gear;

/**
 * Servlet implementation class editGearServlet
 */
@WebServlet("/editGearServlet")
public class editGearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editGearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GearHelper gh = new GearHelper();
		
		String gearName = request.getParameter("gearName");
		Integer tempId = Integer.parseInt(request.getParameter("gearId"));
		
		Gear gearToUpdate = gh.searchForGearById(tempId);
		gearToUpdate.setGearName(gearName);
		
		gh.updateGear(gearToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGearServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
