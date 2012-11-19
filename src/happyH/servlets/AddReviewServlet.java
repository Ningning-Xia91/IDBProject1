package happyH.servlets;

import happyH.models.Evaluation;
import happyH.models.Restaurant;
import happyH.tables.EvaluationTable;
import happyH.tables.RestaurantTable;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReviewServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rid = request.getParameter("rid");
		String uid = request.getParameter("uid");
		double rating = (Double.parseDouble(request.getParameter("rating")));
		String review = request.getParameter("review");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String etime = dateFormat.format(date);
		
		if(EvaluationTable.getEvaluationByRidUid(uid, rid)!=null)
		{
			EvaluationTable.deleteEvaluationByRidUid(uid,rid);
		}
		
		Evaluation eval = new Evaluation();
		eval.setR_id(rid);
		eval.setU_id(uid);
		eval.setRating(rating);
		eval.setReview(review);
		eval.setE_time(etime);
		
		try {
			if (eval != null) {
				System.out.println(eval.getU_id());
				EvaluationTable.insertOneEvaluation(eval);
				System.out.println("insert an evaluation!");
			}
		} catch (Exception e) {

		}
	
		request.setAttribute("id", rid);
		Restaurant rest = RestaurantTable.getRestaurantById(rid);
		ArrayList<Restaurant> restList = new ArrayList<Restaurant>();
		restList.add(rest);
		request.setAttribute("restList", restList);
		RequestDispatcher view = request.getRequestDispatcher("/viewRestaurants.jsp");
		view.forward(request,response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}

}
