package happyH.servlets;

import happyH.models.Cuisine;
import happyH.tables.CuisineTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCuisineServlet  extends HttpServlet {
	
	public List<Cuisine> cuisineList = new ArrayList<Cuisine> ();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		cuisineList = CuisineTable.getAllCuisines();
		
		if(cuisineList!=null)
		{
			request.setAttribute("cuisineList", cuisineList);
			RequestDispatcher view = request.getRequestDispatcher("/viewCuisines.jsp");
			view.forward(request,response);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
