package happyH.servlets;

import happyH.models.Cuisine;
import happyH.models.Location;
import happyH.models.Restaurant;
import happyH.tables.CuisineTable;
import happyH.tables.LocationTable;
import happyH.tables.RestaurantTable;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RestaurtantHomeServlet  extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String r_id = request.getParameter("id");
		Restaurant rest = null;
		ArrayList<Location> locList = new ArrayList<Location>();
		Cuisine cuisine = null;
		
		rest = RestaurantTable.getRestaurantById(r_id);
		locList = LocationTable.getlocationByRID(r_id);
		cuisine = CuisineTable.getCuisineByCid(rest.getCt_id());
		if(rest!= null){
			try {
				request.setAttribute("rest",rest);
				if(locList !=null){
					request.setAttribute("locList", locList);
				}
				if(cuisine!=null){
					request.setAttribute("cuisine", cuisine);
				}
				RequestDispatcher view = request.getRequestDispatcher("/restaurantHome.jsp");
				view.forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
				view.forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
