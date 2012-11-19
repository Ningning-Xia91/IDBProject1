package happyH.servlets;

import happyH.models.Restaurant;
import happyH.models.Special;
import happyH.tables.RestaurantTable;
import happyH.tables.SpecialTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewSpecialServlet  extends HttpServlet {
	
	public List<Special> specialList = new ArrayList<Special> ();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		Restaurant rest = RestaurantTable.getRestaurantById(rid);
		String rname = rest.getR_name();
		request.setAttribute("rname", rname);
		
		specialList = SpecialTable.getSpecialsByRid(rid);
		
		if(specialList!=null)
		{
			request.setAttribute("specialList", specialList);
			RequestDispatcher view = request.getRequestDispatcher("/viewSpecials.jsp");
			view.forward(request,response);
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
