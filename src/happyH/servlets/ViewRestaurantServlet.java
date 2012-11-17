package happyH.servlets;

import happyH.models.Restaurant;
import happyH.tables.RestaurantTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewRestaurantServlet  extends HttpServlet {
	
	public List<Restaurant> RestList = new ArrayList<Restaurant> ();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RestList = RestaurantTable.getAllRestaurants();
		
		if(RestList!=null)
		{
			request.setAttribute("restList", RestList);
			RequestDispatcher view = request.getRequestDispatcher("/viewRestaurants.jsp");
			view.forward(request,response);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
