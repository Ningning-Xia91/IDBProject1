package happyH.servlets;

import happyH.models.Restaurant;
import happyH.models.User;
import happyH.tables.RecommendTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

public class RecommendationServlet  extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if (request.getSession().getAttribute("user")==null){
			RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
			view.forward(request,response);
		}
		List<Restaurant> restList = new ArrayList<Restaurant> ();
		restList = RecommendTable.RecommendByLocation(user);
		
		if(restList!= null){
			try {
				request.setAttribute("restList",restList);
				RequestDispatcher view = request.getRequestDispatcher("/viewRecommends.jsp");
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
