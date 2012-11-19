package happyH.servlets;

import happyH.models.Cuisine;
import happyH.models.Event;
import happyH.models.Location;
import happyH.models.Restaurant;
import happyH.tables.CuisineTable;
import happyH.tables.EventTable;
import happyH.tables.LocationTable;
import happyH.tables.RestaurantTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String select = request.getParameter("SearchSelect");
		String content = request.getParameter("searchBox");

		if ((select != null) && (content != null)) {
			if (select.equals("1")) {
				try {
					List<Restaurant> restList = new ArrayList<Restaurant> ();
					restList = RestaurantTable.searchRestaurantByName(content);
					request.setAttribute("restList", restList);

					RequestDispatcher view = request.getRequestDispatcher("/viewRestaurants.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (select.equals("2")) {
				try {
					List<Event> eventList = new ArrayList<Event> ();
					eventList = EventTable.searchEventByTitle(content);
					request.setAttribute("eventList", eventList);

					RequestDispatcher view = request.getRequestDispatcher("/viewEvents.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (select.equals("3")) {
				try {
					List<Location> locList = new ArrayList<Location> ();
					List<Restaurant> restList = new ArrayList<Restaurant> ();
					locList = LocationTable.searchLocationByStreet(content);
					request.setAttribute("locList", locList);
					String rid;
					Location loc;
					Restaurant rest;
					for(int i = 0; i<locList.size(); i++){
						loc=locList.get(i);
						rid = loc.getR_id();
						rest = RestaurantTable.getRestaurantById(rid);
						restList.add(rest);
					}
					request.setAttribute("restList", restList);

					RequestDispatcher view = request.getRequestDispatcher("/viewRestaurants.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					List<Cuisine> cuisineList = new ArrayList<Cuisine> ();
					List<Restaurant> restList = new ArrayList<Restaurant> ();
					cuisineList = CuisineTable.searchCuisineByName(content);
					//request.setAttribute("cuisineList", cuisineList);
					String cid;
					Cuisine cuisine;
					Restaurant rest;
					for(int i = 0; i<cuisineList.size(); i++){
						cuisine=cuisineList.get(i);
						cid = cuisine.getCt_id();
						List<Restaurant> temprestList = new ArrayList<Restaurant> ();
						temprestList = RestaurantTable.getRestaurantByCuisine(cid);
						for(int j=0 ; j<temprestList.size();j++){
							rest=temprestList.get(j);
							restList.add(rest);
						}
					}
					request.setAttribute("restList", restList);

					RequestDispatcher view = request.getRequestDispatcher("/viewRestaurants.jsp");
					view.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} else {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/search.jsp");
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}