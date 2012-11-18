package happyH.servlets;

import happyH.models.Event;
import happyH.models.Location;
import happyH.models.Restaurant;
import happyH.tables.EventTable;
import happyH.tables.LocationTable;
import happyH.tables.RestaurantTable;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventHomeServlet  extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String e_id = request.getParameter("id");
		Event event = null;
		Restaurant rest = null;
		
		event = EventTable.getEventByEid(e_id);
		if(event != null){
			try {
				String r_id = event.getR_id();
				rest = RestaurantTable.getRestaurantById(r_id);
				if(rest!=null)
				{
					request.setAttribute("event", event);
					request.setAttribute("rest", rest);
				}
				RequestDispatcher view = request.getRequestDispatcher("/eventHome.jsp");
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
